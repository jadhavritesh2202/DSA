class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        // endWord is not in the dictionary, no transformation is possible
        if (!set.contains(endWord))
            return 0;

        while (!q.isEmpty()) {
            Pair pair = q.remove();
            String word = pair.word;
            int steps = pair.steps;

            //try chaging each character of word
            for (int i = 0; i < word.length(); i++) {
                char original = word.charAt(i);

            

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    if (ch == original)
                        continue;

                    String newWord = word.substring(0, i) + ch + word.substring(i + 1);

                    if (newWord.equals(endWord))
                        return steps + 1;

                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.offer(new Pair(newWord, steps + 1));
                    }
                }
            }
        }
        return 0;

    }
}