class Solution {
    public String majorityFrequencyGroup(String s) {
         // Step 1: count frequency of characters
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        Map<Integer, StringBuilder> groups = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            groups.putIfAbsent(count, new StringBuilder());
            groups.get(count).append(ch);
        }

         // Step 3: find majority frequency group
        int bestFreq = -1;
        int maxSize = -1;

        for (Map.Entry<Integer, StringBuilder> entry : groups.entrySet()) {
            int k = entry.getKey();
            int size = entry.getValue().length();

            if (size > maxSize || (size == maxSize && k > bestFreq)) {
                maxSize = size;
                bestFreq = k;
            }
        }

        // Step 4: return characters in that group
        return groups.get(bestFreq).toString();

    }
}