class Solution {
    public static ArrayList<Integer> valEqualToPos(int[] arr) {
     ArrayList<Integer> result = new ArrayList<>();
      for (int index=1; index <= arr.length; index++){
          if(index == arr[index-1]){
              result.add(index);
          }
      }
      return result;
    }
}