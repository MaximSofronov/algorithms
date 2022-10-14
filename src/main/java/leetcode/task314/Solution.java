package leetcode.task314;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> solution(TreeNode root) {
        Map<Integer, List<NodeMetadata>> map = new HashMap<>();
        fillNodeInfoMap(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> result.add(e.getValue().stream().sorted(Comparator.comparingInt(nm -> nm.depth)).map(nm -> nm.val).collect(Collectors.toList())));

        return result;
    }

    private void fillNodeInfoMap(TreeNode node, int column, int depth, Map<Integer, List<NodeMetadata>> nodesInfo) {
        if (node == null) {
            return;
        }
        List<NodeMetadata> set = nodesInfo.getOrDefault(column, new ArrayList<>());
        set.add(new NodeMetadata(node.val, depth));
        nodesInfo.put(column, set);
        fillNodeInfoMap(node.left, column - 1, depth + 1, nodesInfo);
        fillNodeInfoMap(node.right, column + 1, depth + 1, nodesInfo);
    }

    private static class NodeMetadata {
        int val;
        int depth;

        public NodeMetadata(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "NodeMetadata{" +
                    "val=" + val +
                    ", depth=" + depth +
                    '}';
        }
    }
}
