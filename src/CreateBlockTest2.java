import java.util.LinkedList;
import block.core.Block;
import block.core.Mining;

public class CreateBlockTest2 {
	public LinkedList<Block> chain = new LinkedList<Block>();

	public CreateBlockTest2() {
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

			// 적합한 값을 얻은 경우 새로운 block 생성 후 chain에 추가
			chain.add(newBlock);
		}
	}

	public static void main(String[] args) {
		CreateBlockTest2 createBlockTest = new CreateBlockTest2();
	}
}
