class Solution {
    public String findValidPair(String s) {
        int[] freq = new int[10];

        for (char ch : s.toCharArray()) {
            freq[ch - '0']++;
        }

         StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length()-1; i++) {
            char ch1 = s.charAt(i);
            char ch2=s.charAt(i+1);

            if(ch1!=ch2 && (ch1 - '0' == freq[ch1 - '0']) &&  (ch2 - '0' == freq[ch2 - '0'])) {
               return ""+ch1+ch2;
           // str.append(ch1);str.append(ch2);
            }
        }
        return "";

    }
}