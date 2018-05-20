package block.core;

import block.util.CommonUtil;

public class Block {
	private int version; // 4bytes
	private byte[] previousblockHash; // 32 bytes
	private byte[] merkleHash; // 32 bytes
	private int time; // 4bytes
	private int bits; // 4bytes
	private int nonce; // 4bytes

	public Block genesisBlock;

	// genesis block »ý¼º
	public Block createGenesisBlock() {
		CommonUtil hexUtil = new CommonUtil();

		genesisBlock = new Block();
		genesisBlock.setVersion(1);
		genesisBlock.setPreviousblockHash(new byte[32]);

		String genesisMerkle = "4a5e1e4baab89f3a32518a88c31bc87f618f76673e2cc77ab2127b7afdeda33b";
		genesisBlock.setMerkleHash(hexUtil.getBytesFromReverseHex(new byte[32], genesisMerkle));
		genesisBlock.setTime(1231006505);
		genesisBlock.setBits(0x1f00ffff);
		genesisBlock.setNonce(2083236893);

		return genesisBlock;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public byte[] getPreviousblockHash() {
		return previousblockHash;
	}

	public void setPreviousblockHash(byte[] previousblockHash) {
		this.previousblockHash = previousblockHash;
	}

	public byte[] getMerkleHash() {
		return merkleHash;
	}

	public void setMerkleHash(byte[] merkleHash) {
		this.merkleHash = merkleHash;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getBits() {
		return bits;
	}

	public void setBits(int bits) {
		this.bits = bits;
	}

	public int getNonce() {
		return nonce;
	}

	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	@Override
	public String toString() {
		return "Block [version=" + version + ", previousblockHash=" + previousblockHash + ", merkleHash=" + merkleHash
				+ ", time=" + time + ", bits=" + bits + ", nonce=" + nonce + "]";
	}
}