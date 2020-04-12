
public class Node {
	/**
	 * word is the content of the node.
	 */
	private String word;
	/**
	 * frequency shows the frequency of the word.
	 */
	private int frequency;
	/**
	 * left is Node to the left of this Node.
	 */
	private Node left;
	/**
	 * right is Node to the right of this Node.
	 */
	private Node right;

	/**
	 * Creating Node of the with word content.
	 * 
	 * @param word is the content of the Node.
	 */
	public Node(String word) {
		this.word = word;
		frequency = 1;
		left = null;
		right = null;
	}

	/**
	 * Get word from the Node.
	 * 
	 * @return word which is the content of the Node
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Get the node on the left.
	 * 
	 * @return left which is the node to the left of this Node.
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Set the node on the left of this node to left.
	 * 
	 * @param left is the new object of the node on the left of this node.
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * Get the node on the right.
	 * 
	 * @return left which is the node to the left of this Node.
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Set the node on the right of this node to left.
	 * 
	 * @param right is the new object of the node on the right of this node.
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * Get the frequency of this node.
	 * 
	 * @return frequency which the the number of time the word occurs.
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * Increment the frequency of this word by 1.
	 */
	public void incrementFrequency() {
		this.frequency++;
	}

}
