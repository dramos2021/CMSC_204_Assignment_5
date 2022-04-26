/**Diego Ramos
 * @auth Diego Ramos
 * CMSC204
 * Assignment#5
 * 
 * */



/**This generic class is used in the MorseCodeTree classes.  The class consists of a 
 * reference to the data and a reference to the left and right child
 * 
 * */
public class TreeNode <T> {
	TreeNode <T> leftChild;
	TreeNode <T>rightChild;
	T data;
	
	/**Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param the data for the node.
	 * */
	public TreeNode(T dataNode) {
		leftChild = null;
		rightChild = null;
		data = dataNode;
	}
	/**Create a new TreeNode copy
	 * @param a node to copy.
	 * */
	public TreeNode(TreeNode<T> node){
		leftChild = node.leftChild;
		rightChild = node.rightChild;
		data = node.data;
	}
}
