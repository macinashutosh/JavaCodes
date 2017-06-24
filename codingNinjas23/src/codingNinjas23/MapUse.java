package codingNinjas23;

public class MapUse {
	public static String maxFreqWord(String input)
	{
		Map<String, Integer> map = new Map<String, Integer>();
		int currentWordStart = 0;
		int maxFreq = 0;
		String maxWord = "";
		for(int i=0;i<input.length();++i)
		{
			if(input.charAt(i)==' '){
				String currentWord = input.substring(currentWordStart, i);
				int currFreq = 0;
				Integer currFreqInteger = map.get(currentWord);
				if(currFreqInteger!=null)
				{
					currFreq = currFreqInteger;
				}
				map.add(currentWord, currFreq + 1);
				if(maxFreq<currFreq+1)
				{
					maxFreq = currFreq+1;
					maxWord = currentWord;
				}
				currentWordStart = i+1;
			}
			
		}
		return maxWord;
	}
	public static void main(String[] args) {
		
	}

}
