class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] res={-1,-1};
        boolean[] prime=new boolean[right+1];
         Arrays.fill(prime,true);
         prime[0]=false;
         prime[1]=false;
        for(int i=2;i*i<=right;i++){
            if(prime[i]){
                for(int j=i*i;j<=right;j+=i){
                    prime[j]=false;
                }
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(prime[i]){
                list.add(i);
            }
        }
         int diff=Integer.MAX_VALUE;
        for(int k=1;k<list.size();k++){
          
            if(res[0]==-1 && res[1]==-1 || (list.get(k)-list.get(k-1) <diff)){
                  diff=list.get(k)-list.get(k-1);
                  res[0]=list.get(k-1);
                  res[1]=list.get(k);
            }
        }
        return res;


    }
}