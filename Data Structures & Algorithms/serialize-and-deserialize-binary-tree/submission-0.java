/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */



public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }

        sb.append(node.val).append(",");
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(
            Arrays.asList(data.split(","))
        );

        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String value = nodes.poll();

        if (value.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;
    }
}



