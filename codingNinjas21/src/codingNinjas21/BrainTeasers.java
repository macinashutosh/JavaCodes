package codingNinjas21;

public class BrainTeasers {

	public static void main(String args[]) {
		String s = "abcdef";
		String s2 = "a1b3c3";
		System.out.println(editDistance("abcd", "bdc"));
		System.out.println(editDistanceIter("abcd", "bdc"));
		// System.out.println(lowestCommonSubsequence2(s, s2,new
		// String[s.length()+1][s2.length()+1]));
		// printAllSpecialPermutations(s,new char[s.length()],0);
		// int arr[] = {1,100,10,20,50};
		// System.out.println(maxSumOfArrayElements(arr,0,new int[arr.length]));
	}

	// TODO the function below is not complete
	public static void printAllSpecialPermutations(String data,
			char[] outputSoFar, int index) {
		if (index == data.length()) {
			System.out.println(outputSoFar);
			return;
		}
		for (int i = index; i < data.length(); ++i) {
			for (int j = 0; j < data.length(); ++j) {
				if (!Character.toString(outputSoFar[j]).equals(null)) {
				} else if (j != index) {
					outputSoFar[j] = data.charAt(i);
					printAllSpecialPermutations(data, outputSoFar, index + 1);
				}
			}
		}
	}

	// time complexity :O(n)
	public static int maxSumOfArrayElements(int arr[], int index, int[] sum) {
		if (index >= arr.length) {
			return 0;
		}
		if (sum[index] > 0) {
			return sum[index];
		}
		int sum1 = maxSumOfArrayElements(arr, index + 1, sum);
		int sum2 = maxSumOfArrayElements(arr, index + 2, sum) + arr[index];
		int ans = Math.max(sum1, sum2);
		sum[index] = ans;
		return ans;
	}

	// time complexity : exponential
	public static int maxSumOfArrayElements1(int arr[], int index) {
		if (index >= arr.length) {
			return 0;
		}

		int sum1 = maxSumOfArrayElements1(arr, index + 1);
		int sum2 = maxSumOfArrayElements1(arr, index + 2) + arr[index];
		int ans = Math.max(sum1, sum2);
		return ans;
	}

	// time commpexity : exponential
	public static String lowestCommonSubsequence(String s1, String s2) {
		if (s1.length() == 0)
			return "";
		if (s2.length() == 0)
			return "";
		if (s1.charAt(0) == s2.charAt(0)) {
			return s1.charAt(0)
					+ lowestCommonSubsequence(s1.substring(1), s2.substring(1));
		}
		String ans1 = lowestCommonSubsequence(s1.substring(1), s2);
		String ans2 = lowestCommonSubsequence(s1, s2.substring(1));
		int max = Math.max(ans1.length(), ans2.length());
		if (max == ans1.length())
			return ans1;
		return ans2;
	}

	// time complexity : O(n)
	public static String lowestCommonSubsequence2(String s1, String s2,
			String output[][]) {
		if (s1.length() == 0) {
			output[0][s2.length()] = "";
			return "";
		}
		if (s2.length() == 0) {
			output[s1.length()][0] = "";
			return "";
		}
		// if(!output[s1.length()][s2.length()].equals(""))return
		// output[s1.length()][s2.length()];
		if (s1.charAt(0) == s2.charAt(0)) {
			String answer = s1.charAt(0)
					+ lowestCommonSubsequence2(s1.substring(1),
							s2.substring(1), output);
			output[s1.length()][s2.length()] = answer;
			return answer;
		}
		String ans1 = lowestCommonSubsequence(s1.substring(1), s2);
		String ans2 = lowestCommonSubsequence(s1, s2.substring(1));
		int max = Math.max(ans1.length(), ans2.length());
		String answer = "";
		if (max == ans1.length())
			answer = ans1;
		else
			answer = ans2;
		output[s1.length()][s2.length()] = answer;
		return answer;
	}

	public static int editDistance(String s1, String s2) {
		if (s1.length() == 0)
			return s2.length();
		if (s2.length() == 0)
			return s1.length();

		if (s1.charAt(0) == s2.charAt(0))
			return editDistance(s1.substring(1), s2.substring(1));
		else {
			int a1 = 1 + editDistance(s1.substring(1), s2);
			int a2 = 1 + editDistance(s1, s2.substring(1));
			int a3 = 1 + editDistance(s1.substring(1), s2.substring(1));
			return Math.min(a1, Math.min(a2, a3));
		}
	}

	public static int editDistanceIter(String s1, String s2) {
		int[][] output = new int[s1.length() + 1][s2.length() + 2];
		for (int i = 0; i <= s2.length(); ++i) {
			output[0][i] = i;
		}
		for (int i = 0; i <= s1.length(); ++i) {
			output[i][0] = i;
		}
		for (int i = 1; i <= s1.length(); ++i) {
			for (int j = 1; j <= s2.length(); ++j) {
				if (s1.charAt(s1.length() - i) == s2.charAt(s2.length() - j)) {
					output[i][j] = output[i - 1][j - 1];
				} else {
					output[i][j] = 1 + Math.min(output[i - 1][j - 1],
							Math.min(output[i - 1][j], output[i][j - 1]));
				}
			}
		}
		return output[s1.length()][s2.length()];
	}

	public static void towerOfhanoi(int n) {
		
	}
}
