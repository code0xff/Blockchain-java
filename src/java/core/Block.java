package java.core;

public class Block {
	private int version;
	private Block previousblockHash;
	private String merkleHash;
	private long time;
	private int bits;
	private int nonce;

	private static Block genesisBlock;

	private Block() {

	}

	public static Block createGenesisBlock() {
		genesisBlock = new Block();

		genesisBlock.setVersion(1);
		genesisBlock.setPreviousblockHash(null);
		genesisBlock.setMerkleHash(null);
		genesisBlock.setTime(System.currentTimeMillis());
		genesisBlock.setBits(10);
		genesisBlock.setNonce(1);

		return genesisBlock;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Block getPreviousblockHash() {
		return previousblockHash;
	}

	public void setPreviousblockHash(Block previousblockHash) {
		this.previousblockHash = previousblockHash;
	}

	public String getMerkleHash() {
		return merkleHash;
	}

	public void setMerkleHash(String merkleHash) {
		this.merkleHash = merkleHash;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
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

	public void add(Block previousblockHash) {
		this.previousblockHash = previousblockHash;
	}
}