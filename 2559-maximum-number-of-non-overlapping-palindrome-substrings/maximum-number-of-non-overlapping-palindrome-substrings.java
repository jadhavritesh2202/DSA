class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int i = 0;
        int count = 0;
        while (i + k <= n) {
            if (isPalindrome(s, i, i + k - 1)) {
                count++;
                i += k;
            } else if (i + k + 1 <= n && isPalindrome(s, i, i + k)) {
                count++;
                i += k + 1;
            } else {
                i++;
            }
        }

        return count;

    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}