class Solution {
    public int totalNumbers(int[] digit) {
        HashSet<Integer> set=new HashSet<>();
        int n=digit.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(i!=j && j!=k && k!=i){
                        if(digit[i]!=0){
                            if(digit[k]%2==0){
                                int num=100*digit[i]+10*digit[j]+1*digit[k];
                                set.add(num);
                            }
                            
                        }
                    }
                }
            }
        }
        return set.size();
    }
}