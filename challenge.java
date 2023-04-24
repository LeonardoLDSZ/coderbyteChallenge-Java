/* Have the function StringChallenge(str) take the str parameter being passed and return the first word with 
the greatest number of repeated letters. For example: "Today, is the greatest day ever!" should return greatest 
because it has 2 e's (and 2 t's) and it comes before ever which also has 2 e's. If there are no words with repeating 
letters return -1. Words will be separated by spaces.

Examples
Input: "Hello apple pie"
Output: Hello
Input: "No words"
Output: -1

*/


import java.util.*;

class Main {

  public static String StringChallenge(String str) {
    String[] words = str.split("\\s+");
    String maxWord = "";
    int maxCount = 0;

    for (String word : words) {
      Map<Character, Integer> freq = new HashMap<>();
      int count = 0;

      for (char c : word.toCharArray()) {
        int f = freq.getOrDefault(c, 0) + 1;
        freq.put(c, f);
        count = Math.max(count, f);
      }

      if (count > 1 && count > maxCount) {
        maxCount = count;
        maxWord = word;
      }
    }

    return maxWord.isEmpty() ? "-1" : maxWord;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print(StringChallenge(s.nextLine()));
  }
}
