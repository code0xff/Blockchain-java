package java.core;

import java.util.Date;

public class Block {
	private int version;
	private String previousblockHash;
	private String merkleHash;
	private Date time;
	private int bits;
	private int nounce;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getPreviousblockHash() {
		return previousblockHash;
	}

	public void setPreviousblockHash(String previousblockHash) {
		this.previousblockHash = previousblockHash;
	}

	public String getMerkleHash() {
		return merkleHash;
	}

	public void setMerkleHash(String merkleHash) {
		this.merkleHash = merkleHash;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getBits() {
		return bits;
	}

	public void setBits(int bits) {
		this.bits = bits;
	}

	public int getNounce() {
		return nounce;
	}

	public void setNounce(int nounce) {
		this.nounce = nounce;
	}

	@Override
	public String toString() {
		return "Block [version=" + version + ", previousblockHash=" + previousblockHash + ", merkleHash=" + merkleHash
				+ ", time=" + time + ", bits=" + bits + ", nounce=" + nounce + "]";
	}
}