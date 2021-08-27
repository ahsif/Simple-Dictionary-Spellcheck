import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class Main { 
	
	public static ArrayList<String> dict = new ArrayList<String>();
	public static HashMap<Integer, String> map = new HashMap<Integer, String>();
	
	public static String spellCheck(String[] str) {
		
		ArrayList<String> newStr = new ArrayList<String>();
		
		for(String s : str) 
		{
                    if(map.containsKey(s.hashCode())) //Perfect Match
                    {	
                    newStr.add(s); // if we find the word in the dictionary add it to the spellchecked string arraylist
                    }
			
                    else //If no direct match, we will spellcheck  
                    {
                            int matches = 0;
				
				for(String x : dict) 
				{				
						int countStringDiff = 0;
            if (x.length() == s.length()) {             //compare the length of the word in the dictionary with the length of the input
						    for (int i = 0; i < s.length(); i++)
						    {
							      if (s.substring(i, i+1).compareTo(x.substring(i, i+1)) != 0)
							      {
								      countStringDiff++;    //going char by char in the string to see how far off the spelling is
							      } 
						    }	
							
						if (countStringDiff < 2) {     //if 2 or more chars off, do not recommend that word for spellcheck
							
							matches++;
							
							if (matches == 1)
							{
								newStr.add("["+ x);
							}
							
							else
							{ newStr.add("|" + x);}	}	}	
            }
				
				if (matches != 0)
				{
					newStr.add("]");	
				}
				
				if (matches == 0) //No Match
				{
					newStr.add("<"+ s +">");
				}
			}
		}
						
		String fixed = newStr.toString().replaceAll(",", ""); 
		return (fixed.substring(1, fixed.length() - 1));
	}
	
	public static void main(String[] args){
		
		Scanner scnr = new Scanner(System.in);
		String str = scnr.nextLine();
		
		Collections.addAll(dict,"a", "about", "again", "all", "an",  "and", "areas",   "at",  "be", "but", "by","can", "do" ,"down" ,"first", "for", "from", "good", "have", "he", "her", "here", "him", "his",
				"I", "if", "in", "into", "is", "it", "just", "like", "listen", "little", "make", "man", "many",  "may", "more", "most", "my", "near", "no", "not", "now",  "of", "on", "one","only", "or", "other", 
				"out", "people", "please", "program", "read", "said", "say", "see", "she", "should", "slow", "small", "so", "some", "stop", "than",  "that", "the", "then",  "there", "they",  "this",  "through", 
				"to", "tomorrow", "true", "two", "up", "use", "very", "water", "was", "way", "we", "were", "what", "when", "where", "which",  "while", "who",  "will",  "with", "would", "write",  "yes", "yesterday", "you");
		
		for(String s: dict)
			map.put(s.hashCode(), s); // we hash code the entire dictionary to check for perfect matches easily
		
		String[] userStr = str.split(" "); // split user input into an array of strings
		
		System.out.println(spellCheck(userStr)); 
			
		scnr.close();
	}
}