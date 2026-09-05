class Solution {
    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {

        ArrayList<Integer> list = new ArrayList<>();

        int d = b * b - 4 * a * c;

        if (d < 0) {
            list.add(-1);
            return list;
        }

        int x1 = (int) Math.floor(
            (-b + Math.sqrt(d)) / (2.0 * a)
        );

        int x2 = (int) Math.floor(
            (-b - Math.sqrt(d)) / (2.0 * a)
        );

        list.add(Math.max(x1, x2));
        list.add(Math.min(x1, x2));

        return list;
    }
}