class Solution {
    static ArrayList<String> findPermutation(String s) {
        // Code here
        ArrayList<String> res=new ArrayList<>();
        solve(s.toCharArray(),0,res);
        return res;
    }
    public static void solve(char[] arr,int idx, ArrayList<String> res){
        if(idx==arr.length){
            res.add(new String(arr));
            return;
        }
        
        Set<Character> set = new HashSet<>();
        for(int i=idx;i<arr.length;i++){
            if(set.contains(arr[i])){
                continue;
            }
            
            set.add(arr[i]);
            swap(i,idx,arr);
            solve(arr,idx+1,res);
            swap(i,idx,arr);
        }
    }
    public static void swap(int i,int idx,char[] arr){
        char temp=arr[i];
        arr[i]=arr[idx];
        arr[idx]=temp;
    }
}