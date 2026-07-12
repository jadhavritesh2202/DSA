class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n=arr1.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        HashSet<Integer> set=new HashSet<>();
        int[] temp=new int[n];
        int k=0;
        for(int j=0;j<arr2.length;j++){
              set.add(arr2[j]);
            for(int i=0;i<map.get(arr2[j]);i++){
                  temp[k++]=arr2[j];
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!set.contains(arr1[i])){
                // temp[k++]=arr1[i];
                list.add(arr1[i]);
            }
        }
        Collections.sort(list);
        for(int num:list){
            temp[k++]=num;
        }
        return temp;


    }
}