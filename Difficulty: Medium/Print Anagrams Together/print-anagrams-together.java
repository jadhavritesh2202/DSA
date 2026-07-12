

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : arr) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}