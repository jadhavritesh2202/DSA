import java.util.*;

class Solution {

    public String findLongestWord(String s, List<String> d) {

        // Store positions of every character
        List<Integer>[] pos = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        String ans = "";

        // Check every dictionary word
        for (String word : d) {

            if (isSubsequence(word, pos)) {

                if (word.length() > ans.length() ||
                    (word.length() == ans.length()
                     && word.compareTo(ans) < 0)) {

                    ans = word;
                }
            }
        }

        return ans;
    }

    private boolean isSubsequence(String word,
                                  List<Integer>[] pos) {

        int prev = -1;

        for (char ch : word.toCharArray()) {

            List<Integer> list = pos[ch - 'a'];

            // Find first position > prev
            int index = upperBound(list, prev);

            if (index == list.size()) {
                return false;
            }

            prev = list.get(index);
        }

        return true;
    }

    private int upperBound(List<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}