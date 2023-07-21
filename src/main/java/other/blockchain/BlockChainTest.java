package other.blockchain;

public class BlockChainTest {

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();

        // Add blocks to the blockchain
        blockchain.addBlock(new Block(1, blockchain.getChain().get(blockchain.getChain().size() - 1).getHash(), "Transaction 1"));
        blockchain.addBlock(new Block(2, blockchain.getChain().get(blockchain.getChain().size() - 1).getHash(), "Transaction 2"));

        // Check blockchain integrity
        System.out.println("Blockchain is valid: " + blockchain.isValid());
    }
}
