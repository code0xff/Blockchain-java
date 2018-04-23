package java.core;

public class CreateBlock {
	static int counter = 0;
	static Block block;

	public static void main(String[] args) {
		while (counter < 10) {
			if (block == null)
				block = Block.createGenesisBlock();
			else {
			}
		}
	}

}
