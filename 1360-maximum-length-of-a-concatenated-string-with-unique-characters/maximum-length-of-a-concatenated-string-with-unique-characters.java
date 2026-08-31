class Solution {
    int res = 0;

    public int maxLength(List<String> arr) {
        String temp = "";
        solve(0, arr, temp);
        return res;
    }

    public void solve(int idx, List<String> arr, String temp) {
        if (idx == arr.size()) {
            res = Math.max(res, temp.length());
            return;
        }

        if (!hasDuplicate(arr.get(idx)) && !isDuplicate(arr.get(idx), temp)) {
            solve(idx + 1, arr, temp + arr.get(idx));
        }
        solve(idx + 1, arr, temp);
    }

    public boolean isDuplicate(String str, String temp) {
        for (char ch : str.toCharArray()) {
            if (temp.indexOf(ch) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDuplicate(String s) {
        HashSet<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                return true; // duplicate found
            }
            set.add(ch);
        }

        return false; // no duplicate
    }
}