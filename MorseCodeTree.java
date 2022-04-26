/**Diego Ramos
 * @auth Diego Ramos
 * CMSC204
 * Assignment#5
 * 
 * */

import java.util.ArrayList;
import java.util.LinkedList;
/**This is a MorseCodeTree which is specifically used for the conversion of morse code to english
It relies on a root (reference to root of the tree)

The root is set to null when the tree is empty.

The class uses an external generic TreeNode class which consists of a reference to the data and a 
reference to the left and right child. The TreeNode is parameterized as a String, TreeNode This class 
uses a private member root (reference to a TreeNode)

The constructor will call the buildTree


 * 
 * */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root = null;
	
	
	/**Constructor - calls the buildTree method
	 * sets root to empty string
	 * builds tree
	 * */
	public MorseCodeTree(){
		root = new TreeNode<String>("");
		buildTree();
	}
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		
		return root;
	} 
	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
		
	}
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * 
	 */
	@Override
	public void insert(String code, String result) {
		addNode(root,code,result);
		
	}
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		//System.out.print(root.data);
		
			if(code.charAt(0) == '.') {
				if(root.leftChild == null)
					root.leftChild = new TreeNode<String>(letter);
				else {
					code = code.substring(1,code.length());
					//System.out.print("TL\n");
					addNode(root.leftChild, code, letter);
					}
				
			}
			else if(code.charAt(0) == '-') {
				if(root.rightChild == null)
					root.rightChild = new TreeNode<String>(letter);
				else {
				code = code.substring(1,code.length());
				//System.out.print("TR\n");
				addNode(root.rightChild, code, letter);
				}
			}
		}
		
			
		
		
		
	
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		
		if(code.length() == 0) {
			
			return root.data;
		}
		else if(code.charAt(0) == '.') {
			code = code.substring(1,code.length());
		//System.out.print("TL\n");
		return fetchNode(root.leftChild, code);
		}
		else if(code.charAt(0) == '-') {
			code = code.substring(1,code.length());
		//System.out.print("TL\n");
		return fetchNode(root.rightChild, code);
		}
			
		else
			return " ";
		
	}
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	@Override
	public void buildTree() {
		
		String [] letters = new String[26];
		String [] codes   = new String[26];
		letters[0]  = "e";  codes [0]  = "."  ;	letters[13]  = "o"; codes [13]  = "---"  ;
		letters[1]  = "t";  codes [1]  = "-"  ; letters[14]  = "h"; codes [14]  = "...." ;
		letters[2]  = "i";  codes [2]  = ".." ;	letters[15]  = "v"; codes [15]  = "...-" ;
		letters[3]  = "a";  codes [3]  = ".-" ;	letters[16]  = "f"; codes [16]  = "..-.";
		letters[4]  = "n";  codes [4]  = "-." ;	letters[17]  = "l"; codes [17]  = ".-..";
		letters[5]  = "m";  codes [5]  = "--" ;	letters[18]  = "p"; codes [18]  = ".--.";
		letters[6]  = "s";  codes [6]  = "...";	letters[19]  = "j"; codes [19]  = ".---";
		letters[7]  = "u";  codes [7]  = "..-";	letters[20]  = "b"; codes [20]  = "-...";
		letters[8]  = "r";  codes [8]  = ".-.";	letters[21]  = "x"; codes [21]  = "-..-";
		letters[9]  = "w";  codes [9]  = ".--"; letters[22]  = "c"; codes [22]  = "-.-.";
		letters[10] = "d";  codes [10] = "-..";	letters[23]  = "y"; codes [23]  = "-.--";
		letters[11] = "k";  codes [11] = "-.-";	letters[24]  = "z"; codes [24]  = "--..";
		letters[12] = "g";  codes [12] = "--.";	letters[25]  = "q"; codes [25]  = "--.-";
		 	
		
		
		for(int i = 0; i < letters.length; i++) {
			 
			addNode(root ,codes[i],letters[i]);
		}
		
	}
	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> treeArray = new ArrayList<>();
		TreeNode<String> n = new TreeNode<String>(root);
		LNRoutputTraversal(n, treeArray);
		return treeArray;
	}
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root != null) {
			LNRoutputTraversal(root.leftChild, list);
				list.add(root.data);
			LNRoutputTraversal(root.rightChild, list);
		}
	
	}
	/**
	 * Simple inorder recursive
	 * traversal method. Used for testing purposes
	 * @param a TreeNode
	 * */
	public void inOrder(TreeNode<String> n)
	{
	    if(n != null)
	    {
	       inOrder(n.leftChild);
	       //treeArray.add(n.data);
	       System.out.print(n.data);
	       inOrder(n.rightChild);
	       
	    }
	    
	}


}
