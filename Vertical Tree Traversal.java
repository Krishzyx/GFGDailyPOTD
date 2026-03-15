import java.util.*;

class Solution {

    static class Pair {
        Node node;
        int col;

        Pair(Node node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        int min = 0, max = 0;

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair p = q.poll();
            Node node = p.node;
            int col = p.col;

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.data);

            min = Math.min(min, col);
            max = Math.max(max, col);

            if (node.left != null)
                q.offer(new Pair(node.left, col - 1));

            if (node.right != null)
                q.offer(new Pair(node.right, col + 1));
        }

        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }

        return result;
    }
}
