/**Diego Ramos
 * @auth Diego Ramos
 * CMSC204
 * Assignment#5
 * 
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	static MorseCodeTree converterTree= new MorseCodeTree(); 
	public MorseCodeConverter() {
		
	}
	/**Converts a String of Morse code into English Each letter is delimited by a space (' ').
	 * @param morse code to be converted
	 * @return a string representation of the English translation
	 * */
	public static String convertToEnglish(String code) {
		
		if(converterTree.getRoot().rightChild == null)
				converterTree.buildTree();
		
		StringBuilder buffer = new StringBuilder();
		
		StringBuilder strReturn = new StringBuilder();
		
		for(int i = 0; i < code.length(); i++) {
			
			if(code.charAt(i) == ' ') {
				strReturn.append(converterTree.fetch(buffer.toString()));
				buffer.setLength(0);
			}
			else if(i == code.length()-1){
				buffer.append(code.charAt(i));
				strReturn.append(converterTree.fetch(buffer.toString()));
				buffer.setLength(0);
			}
			//else if(code.charAt(i) == '/') {
				//buffer.append(" ");
			//}
				
			else
				buffer.append(code.charAt(i));
		}
		
		return strReturn.toString();
		
	}
	/**Converts a file of Morse code into English Each letter is delimited by a space (' ').
	 * @param morse code file.
	 * @return a string representation of the English translation
	 * */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
          StringBuffer strBuffer = new StringBuffer();
		
		Scanner myReader = new Scanner(codeFile);
	      while (myReader.hasNextLine()) {
	         strBuffer.append(myReader.nextLine());
	      }
	      myReader.close();
	      
	      return convertToEnglish(strBuffer.toString());
	}
	/**returns a string with all the data in the tree in LNR order with an space in between them
	 * @return a string with all the data in the tree separated by a space
	 * */
	public static String printTree() {
		if(converterTree.getRoot().rightChild == null)
			converterTree.buildTree();
		
		ArrayList<String> a = converterTree.toArrayList();
		String returnString = "";
		
		for(String s: a) {
			returnString += s + " ";
		}
		return returnString.trim();
	}
	
}
