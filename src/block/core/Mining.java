package block.core;

import block.core.Block;
import block.util.CommonUtil;
import block.util.SHA256;

public class Mining {
	// block에 저장된 data를 기반으로 byte 배열을 작성
	public byte[] getBytesFromBlock(Block block) {
		CommonUtil commonUtil = new CommonUtil();

		byte[] inputSource = new byte[80];
		int inputSourceIndex = 0;

		// version data
		for (int i = 0; i < 4; i++)
			inputSource[inputSourceIndex++] = commonUtil.getByteFromInteger(block.getVersion(), i);
		// previousblockHash data
		for (int i = 0; i < 32; i++)
			inputSource[inputSourceIndex++] = block.getPreviousblockHash()[i];
		// merkleHash data
		for (int i = 0; i < 32; i++)
			inputSource[inputSourceIndex++] = block.getMerkleHash()[i];
		// time data
		for (int i = 0; i < 4; i++)
			inputSource[inputSourceIndex++] = commonUtil.getByteFromInteger(block.getTime(), i);
		// bits data
		for (int i = 0; i < 4; i++)
			inputSource[inputSourceIndex++] = commonUtil.getByteFromInteger(block.getBits(), i);
		// nonce data
		for (int i = 0; i < 4; i++)
			inputSource[inputSourceIndex++] = commonUtil.getByteFromInteger(block.getNonce(), i);

		return inputSource;
	}

	// get difficulty
	public int getDifficulty(int bits) {
		return 5;
	}

	// create new block
	public Block createBlock(Block previousBlock, String previousBlockHash) {
		Block newBlock = new Block();
		CommonUtil commonUtil = new CommonUtil();

		newBlock.setVersion(previousBlock.getVersion() + 1);
		byte[] temp = new byte[32];
		newBlock.setPreviousblockHash(commonUtil.getBytesFromReverseHex(temp, previousBlockHash));
		newBlock.setMerkleHash(new byte[32]);
		newBlock.setTime((int) (System.currentTimeMillis() / 1000));
		newBlock.setBits(previousBlock.getBits());
		newBlock.setNonce(1);

		return newBlock;
	}

	// mining block hash
	public Block mining(Block lastBlock) {
		SHA256 sha256 = new SHA256();
		CommonUtil commonUtil = new CommonUtil();

		int nonce = lastBlock.getNonce();

		L: while (true) {
			// first encoding by sha256
			String sha256First = sha256.encode(getBytesFromBlock(lastBlock));
			// second encoding by sha256
			String sha256Second = sha256.encode(commonUtil.getBytesFromHex(new byte[32], sha256First));

			// check hash
			for (int count = 0; count < getDifficulty(lastBlock.getBits()); count++) {
				if (sha256Second.charAt(sha256Second.length() - 1 - count) != '0') {
					// if not proper hash, then check next nonce
					lastBlock.setNonce(++nonce);
					continue L;
				}
			}
			System.out.println("hit nonce: " + lastBlock.getNonce() + " blockHash: " + sha256Second);

			return createBlock(lastBlock, sha256Second);
		}
	}
}
