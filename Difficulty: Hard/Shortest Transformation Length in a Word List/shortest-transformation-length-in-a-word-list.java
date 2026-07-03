import java.util.*;

class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int wordLadder(String[] words, String s, String e) {

        HashSet<String> set = new HashSet<>();

        for (String word : words) {
            set.add(word);
        }

        if (!set.contains(e))
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(s, 1));

        set.remove(s);

        while (!q.isEmpty()) {

            Pair curr = q.poll();
            String word = curr.word;
            int steps = curr.steps;

            if (word.equals(e))
                return steps;

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    if (ch == original)
                        continue;

                    arr[i] = ch;
                    String newWord = new String(arr);

                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.offer(new Pair(newWord, steps + 1));
                    }
                }

                arr[i] = original;
            }
        }

        return 0;
    }
}