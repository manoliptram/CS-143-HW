package hw4.wordmaker;

public class WordMakerEngine
{
	
	public static void main(String[] args)
	{
		WordMaker maker = new WordMaker("dictionary.txt");
//		String word = maker.makeLexiographically(5);
//		String word = maker.makeRandomly(5);
		String word = maker.makeRandomlyNoRepeats(5);
		System.out.println("Word created = " + word);
	}
	
}