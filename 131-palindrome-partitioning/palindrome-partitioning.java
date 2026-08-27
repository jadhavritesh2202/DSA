class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        helper(s, 0, res, list);
        return res;
    }

    public void helper(String s, int idx, List<List<String>> res,
            List<String> list) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(list));
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s.substring(idx, i + 1))) {
                list.add(s.substring(idx, i + 1));
                helper(s, i + 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

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