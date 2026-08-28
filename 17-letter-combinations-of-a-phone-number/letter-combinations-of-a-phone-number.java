class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        solve(0, digits, res, sb,map);
        return res;

    }

    public void solve(int idx,String str,List<String> res, StringBuilder sb,Map<Character, String> map){
        //base case
        if(idx>=str.length()){
            res.add(sb.toString());
            return;
        }
        char ch=str.charAt(idx);
        String s=map.get(ch);

        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            solve(idx+1,str,res,sb,map);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}