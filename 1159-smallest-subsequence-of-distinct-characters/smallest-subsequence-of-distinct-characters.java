
class Solution {
    public String smallestSubsequence(String s) {
        
        int n=s.length();
        boolean[] visit=new boolean[26];
        int[] nextVisit=new int[26];
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<n;i++){
            //nextVisit[i]=s.charAt(i);
            nextVisit[s.charAt(i)-'a']=i;
        }
        stk.push(s.charAt(0));
        visit[s.charAt(0)-'a']=true;

        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            if(visit[ch-'a']){
                continue;
            }
            while(!stk.isEmpty() && stk.peek() >ch && nextVisit[stk.peek()-'a']> i){
                visit[stk.pop()-'a']=false;
            }
            stk.push(s.charAt(i));
            visit[ch-'a']=true;
        }

        StringBuilder sb=new StringBuilder();

        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
       return sb.reverse().toString();

    }
}