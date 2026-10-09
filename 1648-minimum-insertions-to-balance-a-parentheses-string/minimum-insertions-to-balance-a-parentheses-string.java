class Solution {
    public int minInsertions(String s) {
    //     int ele=0;
    //     int open=0;
    //     int close=0;

    //     for(char ch:s.toCharArray()){
    //         if(ch=='('){
    //             open++;
    //         }else {
    //             close++;
    //         }
    //         if(close>0 && open==0){
    //             open++;
    //             ele+=1;
    //         }
    //         if(close>2 && open<close/2){
    //             ele+=(close/2)-open;
    //             open=close/2;
    //         }
    //     }
    //     if(open*2>=close){
    //         ele+=open*2-close;
    //     }else{
    //         ele+=2; 
    //     }
    //   return ele;
             
            int cnt=0;
            int res=0;
            int i=0;
            while(i<s.length()){
                char ch=s.charAt(i);

                if(ch=='('){
                    cnt++;
                    i++;
                }else {
                      if(cnt>0){
                          cnt--;
                         }else{
                          res++;
                      }
                    if(i+1 < s.length() && s.charAt(i+1)==')'){
                         i+=2;
                    }else{
                    res+=1;
                    i++;
                }
            }
               
                
         }
            return res+cnt*2;
           

    }
}