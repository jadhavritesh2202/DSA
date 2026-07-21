class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int totalOnes = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1')
                totalOnes++;
        }
        String t = "1" + s + "1";

        List<Integer> value = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        int j = 0;
        while (j < t.length()) {
            char ch = t.charAt(j);
            int cnt = 0;

            while (j < t.length() && t.charAt(j) == ch) {
                cnt++;
                j++;
            }
            value.add(ch - '0');
            size.add(cnt);
        }
        int finalAns = totalOnes;
        for (int i = 1; i < value.size() - 1; i++) {
            if (value.get(i) == 1 && value.get(i - 1) == 0 && value.get(i + 1) == 0) {
                int active = totalOnes + size.get(i - 1) + size.get(i + 1);
                finalAns = Math.max(finalAns, active);

            }
        }

        return finalAns;

    }
}