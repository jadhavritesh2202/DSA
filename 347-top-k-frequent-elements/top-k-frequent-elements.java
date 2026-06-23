class Pair implements Comparable<Pair> {
    int element;
    int freq;
    Pair(int element,int freq){
        this.element=element;
        this.freq=freq;
    }
    public int compareTo(Pair that){
        //max heap
        //b-a
        return that.freq-this.freq;//decresing
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
    
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
             map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();

        //insert element into pq
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Pair number=new Pair(entry.getKey(),entry.getValue());
            pq.offer(number);
        }
        //insert into res
        int[] res=new int[k];
        int idx=0;
        while(idx<k){
            // res[idx]=pq.poll().element;//element : freq
            // or
            Pair num=pq.poll();//object
            res[idx]=num.element;
            idx++;
        }
        return res;


    }
}