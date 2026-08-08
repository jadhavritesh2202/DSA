class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();

        // suffix[i] = word1[i...] se word2 ke
        // suffix ko maximum kitne characters match kar sakte hain
        int[] suffix = new int[n + 1];

        int j = m - 1;
        int match = 0;

        for (int i = n - 1; i >= 0; i--) {

            if (j >= 0 && s[i] == t[j]) {
                match++;
                j--;
            }

            suffix[i] = match;
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        // One mismatch allowed
        boolean canChange = true;

        while (i < n && j < m) {

            // Exact match
            if (s[i] == t[j]) {

                ans[j] = i;

                i++;
                j++;
            }

            // Use our one allowed change
            else if (canChange) {

                // Remaining characters of word2
                // after using current character
                int remaining = m - j - 1;

                // Can remaining characters be matched?
                if (suffix[i + 1] >= remaining) {

                    ans[j] = i;

                    i++;
                    j++;

                    canChange = false;
                }
                else {
                    // Current index cannot be used,
                    // try a later index
                    i++;
                }
            }

            // Already used the change
            else {
                i++;
            }
        }

        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}