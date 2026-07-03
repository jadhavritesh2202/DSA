class Pair{
    String gene;
    int steps;

    Pair(String gene, int steps) {
        this.gene = gene;
        this.steps = steps;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        HashSet<String> set = new HashSet<>();

        for (String gene : bank) {
            set.add(gene);
        }

          if (!set.contains(endGene))
            return -1;

        Queue<Pair> q = new LinkedList<>();
         q.offer(new Pair(startGene, 0));

          set.remove(startGene);

        char[] mutations = {'A', 'C', 'G', 'T'};

        while(!q.isEmpty()){
            Pair curr=q.remove();
            String gene=curr.gene;
            int steps=curr.steps;

             if (gene.equals(endGene))
                return steps;
            
            char[] arr=gene.toCharArray();
          
          for(int i=0;i<arr.length;i++){
            char original=arr[i];
            for(char ch:mutations){
                if(ch==original) continue;

                arr[i]=ch;

                //new String
                String newStr=new String(arr);
                if(set.contains(newStr)){
                    set.remove(newStr);
                    q.add(new Pair(newStr,steps+1));
                }
            }
            arr[i]=original;
          }

        }
        return -1;

    }
}