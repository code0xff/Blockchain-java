import java.util.LinkedList;
import block.core.Block;
import block.core.Mining;

public class CreateBlock {
	public LinkedList<Block> chain = new LinkedList<Block>();

	public CreateBlock() {
		execute();
	}

	private void execute() {
		Mining mining = new Mining();
		Block block = new Block();

		// create genesis block
		chain.add(block.createGenesisBlock());

		// create 10 blocks
		while (chain.size() < 10) {
			Block lastBlock = chain.getLast();
			Block newBlock = mining.mining(lastBlock);

			chain.add(newBlock);
		}
	}

	public static void main(String[] args) {
		CreateBlock createBlockTest = new CreateBlock();
	}
}
