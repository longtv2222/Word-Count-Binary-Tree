
public class TreeList {
	/**
	 * Root is the first node of this tree list.
	 */
	private Node root;

	/**
	 * Default constructor of treeList that creating TreeList object with root is
	 * null.
	 */
	public TreeList() {
		this.root = null;
	}

	/**
	 * Get the root of this treeList
	 * 
	 * @return root is the first node of this treeList.
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * Adding node to the treeList in ordered manner.
	 * 
	 * @param word is the word that needs to be added to the treeList.
	 */
	public void addNode(String word) { // add word in ordered manner to this tree, using string compare

		if (this.root == null) {
			this.root = new Node(word); // if treeList is empty, initialize the first node
		} else {
			Node current = this.root;
			while (current != null) {
				int compare = current.getWord().compareTo(word); // Comparing parent with child
				if (compare == 0) { // If 2 words are identical, increment the frequency of this word then break.
					current.incrementFrequency();
					break;
				}
				if (compare > 0) { // If word parent is bigger then word child, keeps going to the left Node.
					if (current.getLeft() != null)
						current = current.getLeft();
					else {
						current.setLeft(new Node(word)); // If current node is equal to null, setting Node word to the
															// left.
						break;
					}
				}
				if (compare < 0) {
					if (current.getRight() != null)// If word parent is smaller then word child, keeps going to the
													// right Node.
						current = current.getRight();
					else {
						current.setRight(new Node(word)); // If current node is equal to null, setting Node word to the
															// // left.
						break;
					}
				}
			}
		}
	}

	/**
	 * Get total number of word in the contest of this treeList by using recursive
	 * method.
	 * 
	 * @param current is the starting point of the tree.
	 * @return the total number of word in this treeList.
	 */
	public int getNumberOfWord(Node current) {
		if (current == null)
			return 0;
		else
			return getNumberOfWord(current.getLeft()) + getNumberOfWord(current.getRight()) + 1;
	}

	/**
	 * Get total of unique word in this treeList by using recursive method
	 * 
	 * @param current is the starting point of the treeList.
	 * @return the total number of unique word in this treeList.
	 */
	public int getNumberOfUniqueWord(Node current) {
		if (current == null)
			return 0;
		else if (current.getFrequency() == 1)
			return getNumberOfUniqueWord(current.getLeft()) + getNumberOfUniqueWord(current.getRight()) + 1;
		else
			return getNumberOfUniqueWord(current.getLeft()) + getNumberOfUniqueWord(current.getRight());
	}

	/**
	 * Get the largest frequency of the treeList
	 * 
	 * @param current is the starting point of the treeList.
	 * @return the largest frequency in this treeList.
	 */
	public int getLargestFrequency(Node current) {
		if (current == null)
			return 1;
		int mid = current.getFrequency();
		int left = getLargestFrequency(current.getLeft());
		int right = getLargestFrequency(current.getRight());

		if (left > mid)
			mid = left;
		if (right > mid)
			mid = right;
		return mid;
	}

	/**
	 * Print the word accordingly with frequency with in order traversal order
	 * 
	 * @param current    is the starting point of the treeList.
	 * @param frequency: the word with this frequency will be printed.
	 */

	public void printFrequencyWord(Node current, int frequency) {

		if (current == null)
			return;
		if (current.getFrequency() == frequency)
			System.out.println(current.getWord() + " = " + frequency + " times");
		printFrequencyWord(current.getLeft(), frequency);
		printFrequencyWord(current.getRight(), frequency);

	}

	/**
	 * Print in preorder traversal.
	 * 
	 * @param current is the starting point of the treeList
	 */
	public void printPreOrderTraversal(Node current) {
		if (current == null)
			return;

		System.out.print(current.getWord() + " ");
		printPreOrderTraversal(current.getLeft());
		printPreOrderTraversal(current.getRight());
	}

	/**
	 * Print in inorder traversal.
	 * 
	 * @param current is the starting point of the treeList
	 */
	public void printInOrderTraversal(Node current) {
		if (current == null) {
			return;
		}
		printInOrderTraversal(current.getLeft());
		System.out.print(current.getWord() + " ");
		printInOrderTraversal(current.getRight());
	}

	/**
	 * Print in postorder traversal.
	 * 
	 * @param current is the starting point of the treeList
	 */
	public void printPostOrderTraversal(Node current) {
		if (current == null)
			return;

		printPostOrderTraversal(current.getLeft());
		printPostOrderTraversal(current.getRight());
		System.out.print(current.getWord() + " ");
	}

	/**
	 * Find the maximum depth of the tree.
	 * 
	 * @param current is the starting point of the treeList
	 * @return The maximum depth of this treeList.
	 */
	public int maxDepth(Node current) {
		if (current == null) {
			return 0;
		} else {
			int lDepth = maxDepth(current.getLeft());
			int rDepth = maxDepth(current.getRight());
			if (lDepth > rDepth)
				return lDepth + 1;
			else
				return rDepth + 1;
		}
	}

	/**
	 * 
	 * @param word    is the word that might or might not exist in the treeList.
	 * @param current is the starting point of the treeList
	 * @return positive number which is also the frequency of the word if the word
	 *         exists in the tree using binary search
	 */
	public int searchWord(String word, Node current) {
		if (current == null) {
			return 0;
		}
		int left = searchWord(word, current.getLeft());
		int right = searchWord(word, current.getRight());
		if (word.equals(current.getWord())) {
			return current.getFrequency();
		} else {
			return left + right;
		}
	}
}