class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        String res = "";
        int ones = 0;

        while (j < n) {

            if (s.charAt(j) == '1') {
                ones++;
            }

            // More than k ones → shrink
            while (ones > k) {
                if (s.charAt(i) == '1') {
                    ones--;
                }
                i++;
            }

            // Remove unnecessary leading zeros
            while (i <= j && s.charAt(i) == '0') {
                i++;
            }

            if (ones == k) {
                String temp = s.substring(i, j + 1);

                if (res.isEmpty() ||
                    temp.length() < res.length() ||
                    (temp.length() == res.length() &&
                     temp.compareTo(res) < 0)) {

                    res = temp;
                }
            }

            j++;
        }

        return res;
    }
}