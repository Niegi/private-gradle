package other.blockchain;

import java.util.Date;

public class Block {
    private int index;
    private String previousHash;
    private String data;
    private long timestamp;
    private String hash;
    private int nonce; // For mining

    // Constructor
    public Block(int index, String previousHash, String data) {
        this.index = index;
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
        this.nonce = 0; // Initialize nonce to 0
    }

    // Calculate the hash for the current block using simple hash function
    public String calculateHash() {
        return StringUtil.applySHA256(
                index + previousHash + timestamp + data + nonce
        );
    }

    // Mine the block to find a hash with a specified number of leading zeros
    public void mineBlock(int difficulty) {
        String target = StringUtil.getDifficultyString(difficulty);
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block mined: " + hash);
    }

    // Get the current block's hash
    public String getHash() {
        return hash;
    }

    // Get the previous block's hash
    public String getPreviousHash() {
        return previousHash;
    }

    // Add more methods or data as per your needs
}