import java.util.ArrayList;

public class TesterClass {

	public static void main(String[] args) {
		
		//MorseCodeConverter conv = new MorseCodeConverter();
		
		//MorseCodeTree test = new MorseCodeTree();
		
		//test.buildTree();
		
		//test.inOrder(test.getRoot());
		//System.out.print(test.getRoot().data);
		//ArrayList<String> a = test.toArrayList();
		
		//System.out.print(a.toString());
		
		//test.inOrder(test.getRoot());
		
		//System.out.print("\n"+test.fetchNode(test.getRoot(),"-"));
		
		//System.out.print("\n"+test.fetch("--.-"));

		System.out.print(MorseCodeConverter.convertToEnglish("- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --."));
	}

}
