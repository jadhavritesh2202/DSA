import java.util.*;

class Solution {
    int maxScore;
    int n;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int[] freq = new int[26];

        for (char letter : letters) {
            freq[letter - 'a']++;
        }

        n = words.length;

        solve(0, words, score, 0, freq);

        return maxScore;
    }

    public void solve(int idx, String[] words, int[] score,
                      int currScore, int[] freq) {

        maxScore = Math.max(maxScore, currScore);

        if (idx >= n) return;

        // Take current word
        int j = 0;
        int tempScore = 0;

        int[] tempFreq = Arrays.copyOf(freq, freq.length);

        while (j < words[idx].length()) {

            char ch = words[idx].charAt(j);

            tempFreq[ch - 'a']--;
            tempScore += score[ch - 'a'];

            if (tempFreq[ch - 'a'] < 0) {
                break;
            }

            j++;
        }

        // If we have enough letters, take the word
        if (j == words[idx].length()) {
            solve(idx + 1, words, score,
                  currScore + tempScore, tempFreq);
        }

        // Don't take the word
        solve(idx + 1, words, score,
              currScore, freq);
    }
}