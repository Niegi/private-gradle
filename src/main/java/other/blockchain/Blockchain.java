package other.blockchain;

import java.util.ArrayList;

public class Blockchain {
    private final static int MINING_DIFFICULTY = 5;
    private ArrayList<Block> chain;

    public Blockchain() {
        this.chain = new ArrayList<>();
        // Add the genesis block (first block) to the chain
        addBlock(new Block(0, "0", "Genesis Block"));
    }

    // Add a new block to the blockchain
    public void addBlock(Block newBlock) {
        newBlock.mineBlock(MINING_DIFFICULTY); // For simplicity, we'll use a simple mining method here
        chain.add(newBlock);
    }

    // Check if the blockchain is valid
    public boolean isValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            // Check if the hash of the current block is valid
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            // Check if the previous block's hash matches the stored hash in the current block
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }

        return true;
    }

    public ArrayList<Block> getChain() {
        return chain;
    }
}
