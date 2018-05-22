import java.util.LinkedList;
import block.core.Block;
import block.core.Mining;

public class CreateBlockTest1 {
	public LinkedList<Block> chain = new LinkedList<Block>();

	public CreateBlockTest1() {
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

			// ������ ���� ���� ��� ���ο� block ���� �� chain�� �߰�
			chain.add(newBlock);
		}
	}

	public static void main(String[] args) {
		CreateBlockTest1 createBlockTest = new CreateBlockTest1();
	}
}
