
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

public class Traversal {
    BinaryTree bt = new BinaryTree();

    public Traversal(BinaryTree bt) {
        this.bt = bt;
    }

    public List<Integer> preOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            Node cur = s.pop();
            list.add(cur.data);
            if (cur.right != null) {
                s.push(cur.right);
            }
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
        return list;

    }

    public List<Integer> inOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        Node cur = root;

        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            list.add(cur.data);
            cur = cur.right;
        }
        return list;

    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public int check_bal(Node root) {
        if (root == null) {
            return 0;
        }
        int left = check_bal(root.left);
        if (left == -1) {
            return -1;
        }
        int right = check_bal(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) >= 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        if (check_bal(root) == -1) {
            return false;
        }
        return true;
    }

    public int diameter(Node root, int[] maxi) {
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left, maxi);
        int right = diameter(root.right, maxi);
        maxi[0] = Math.max(maxi[0], left + right);
        return Math.max(left, right) + 1;

    }

    public List<List<Integer>> zigzag(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> q = new LinkedList();
        q.offer(root);
        boolean lefttoright = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (lefttoright) {
                    l.add(cur.data);
                } else {
                    l.add(0, cur.data);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }

            }
            lefttoright = !lefttoright;
            list.add(l);
        }
        return list;
    }

    public void left_tree(Node root_l, List<Integer> list) {
        if (root_l == null || root_l.left == null && root_l.right == null) {
            return;
        }
        if (root_l != null) {
            list.add(root_l.data);
            left_tree(root_l.left, list);
        } else {
            list.add(root_l.data);
            left_tree(root_l.right, list);
        }

    }

    public void leaf_nodes(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.data);
        }
        leaf_nodes(root.left, list);

        leaf_nodes(root.right, list);

    }

    public void right_tree(Node root_r, List<Integer> list) {
        if (root_r == null || root_r.left == null && root_r.right == null) {
            return;
        }
        if (root_r != null) {
            right_tree(root_r.right, list);
            list.add(root_r.data);
        } else {
            right_tree(root_r.left, list);
            list.add(root_r.data);
        }

    }

    public List<Integer> boundary_tra(Node root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.data);
        left_tree(root.left, list);
        leaf_nodes(root, list);
        right_tree(root.right, list);

        return list;

    }

    public List<List<Integer>> reverse_level_order(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                l.add(cur.data);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }

            }
            list.add(0, l);
        }
        return list;

    }

    public List<Integer> top_view(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeMap<Integer, Integer> t = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int hd = p.hd;
                Node cur = p.node;
                if (t.get(hd) == null) {
                    t.put(hd, cur.data);
                }
                if (cur.left != null) {
                    q.offer(new Pair(cur.left, hd - 1));
                }
                if (cur.right != null) {
                    q.offer(new Pair(cur.right, hd + 1));
                }

            }
        }
        for (Integer i : t.keySet()) {
            list.add(t.get(i));

        }
        return list;

    }

    public List<Integer> bottom_view(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeMap<Integer, Integer> t = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int hd = p.hd;
                Node cur = p.node;
                t.put(hd, cur.data);
                if (cur.left != null) {
                    q.offer(new Pair(cur.left, hd - 1));
                }
                if (cur.right != null) {
                    q.offer(new Pair(cur.right, hd + 1));
                }

            }
        }
        for (Integer i : t.keySet()) {
            list.add(t.get(i));

        }
        return list;

    }

    public void solve_left(Node root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.data);
        }
        solve_left(root.left, level + 1, list);
        solve_left(root.right, level + 1, list);
    }

    public void solve_right(Node root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.data);
        }
        solve_right(root.right, level + 1, list);
        solve_right(root.left, level + 1, list);

    }

    public List<Integer> left_view(Node root) {
        List<Integer> list = new ArrayList<>();
        solve_left(root, 0, list);
        return list;
    }

    public List<Integer> right_view(Node root) {
        List<Integer> list = new ArrayList<>();
        solve_right(root, 0, list);
        return list;
    }

    public static void leaf_path(Node root, List<List<Integer>> list, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            list.add(new ArrayList<>(path));
            // Create a new copy of path
        }
        leaf_path(root.left, list, path);
        leaf_path(root.right, list, path);
        path.remove(path.size() - 1);

    }

    public int max_path(Node root, int maxi[]) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, max_path(root.left, maxi));
        int right = Math.max(0, max_path(root.right, maxi));
        maxi[0] = Math.max(left + right + root.data, maxi[0]);
        return Math.max(left, right) + root.data;

    }

    public boolean chec_identical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return chec_identical(root1.left, root2.left)
                &&
                chec_identical(root1.right, root2.right);

    }

    public boolean check_symmetry(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return check_symmetry(root1.left, root2.right)
                &&
                check_symmetry(root1.right, root2.left);

    }

    public List<List<Integer>> vertical_order_tra(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeMap<Integer, List<Integer>> t = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                Node temp = p.node;
                int hd = p.hd;
                if (!t.containsKey(hd)) {
                    t.put(hd, new ArrayList<>());
                }
                t.get(hd).add(temp.data);
                if (temp.left != null) {
                    q.offer(new Pair(temp.left, hd - 1));
                }
                if (temp.right != null) {
                    q.offer(new Pair(temp.right, hd + 1));
                }

            }
        }
        for (Integer integer : t.keySet()) {
            list.add(t.get(integer));
        }
        return list;

    }

    public void count_nodes(Node root, int cnt[]) {
        if (root == null) {
            return;
        }
        cnt[0]++;
        count_nodes(root.left, cnt);
        count_nodes(root.right, cnt);
        return;

    }

    public int LCA(Node root, Node n1, Node n2) {
        if (root == null) {
            return -1;
        }
        if (root.data == n1.data || root.data == n2.data) {
            return root.data;
        }
        int left = LCA(root.left, n1, n2);
        int right = LCA(root.right, n1, n2);
        if (left != -1 && right != -1) {
            return root.data;
        } else if (left != -1 && right == -1) {
            return left;
        } else if (left == -1 && right != -1) {
            return right;
        }
        return -1;
    }

    public int kthAnce(Node root, int k, int target) {
        if (root == null) {
            return -1;
        }
        if (root.data == target) {
            return root.data;
        }
        int left = kthAnce(root.left, k, target);
        int right = kthAnce(root.right, k, target);
        if (left != -1 && right == -1) {
            k--;
            if (k <= 0) {
                k = 1900000;
                return root.data;
            }
            return left;

        } else if (left == -1 && right != -1) {
            k--;
            if (k <= 0) {
                k = 111111;
                return root.data;
            }
            return right;
        }
        return -1;
    }

    public void sumOfMaxPath(Node root, int ans[], int sum, int height) {
        if (root == null) {
            return;
        }
        sum = sum + root.data;
        if (root.left == null && root.right == null) {
            if (height > ans[0]) {
                ans[0] = height;
                ans[1] = sum;
            }

        }
        sumOfMaxPath(root.left, ans, sum, height + 1);
        sumOfMaxPath(root.right, ans, sum, height + 1);
        return;

    }

    public void k_sum_paths(Node root, int k, int cnt[], List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        k_sum_paths(root.left, k, cnt, list);
        k_sum_paths(root.right, k, cnt, list);
        int size = list.size();
        int sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += list.get(i);
            if (sum == k) {
                cnt[0]++;
            }
        }
        list.remove(size - 1);
    }

    public int max_width(Node root) {
        int max_width = 0;
        if (root == null) {
            return max_width;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        while (!q.isEmpty()) {
            int size = q.size();
            int first = q.peek().hd;
            int last = 0;
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                Node cur = p.node;
                int hd = p.hd;
                if (i == size - 1) {
                    last = hd;
                }
                if (cur.left != null) {
                    q.offer(new Pair(cur.left, hd * 2));
                }
                if (cur.right != null) {
                    q.offer(new Pair(cur.right, hd * 2 + 1));
                }
            }
            max_width = Math.max(last - first + 1, max_width);
        }
        return max_width;
    }

    public static void child_sum(Node root) {
        if (root == null) {
            return;
        }
        int child = 0;
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }
        if (child > root.data) {
            root.data = child;
        } else {
            if (root.left != null) {
                root.left.data = root.data;
            }
            if (root.right != null) {
                root.right.data = root.data;
            }
        }
        child_sum(root.left);
        child_sum(root.right);

        int sum = 0;
        if (root.left != null) {
            sum += root.left.data;
        }
        if (root.right != null) {
            sum += root.right.data;
        }
        if (root.left != null || root.right != null) {
            root.data = sum;
        }

    }

    public static Node btFromInPre(int pre[], int in[], int s, int e, int ind[], Map<Integer, Integer> m) {
        if (s > e) {
            return null;
        }
        int cur = pre[ind[0]++];
        Node root = new Node(cur);
        int pos = m.get(cur);
        root.left = btFromInPre(pre, in, s, pos - 1, ind, m);
        root.right = btFromInPre(pre, in, pos + 1, e, ind, m);
        return root;
    }

    public static Node btFromInPost(int post[], int in[], int s, int e, int ind[], Map<Integer, Integer> m) {
        if (s > e) {
            return null;
        }
        int cur = post[ind[0]--];
        Node root = new Node(cur);
        int pos = m.get(cur);
        root.right = btFromInPost(post, in, pos + 1, e, ind, m);
        root.left = btFromInPost(post, in, s, pos - 1, ind, m);
        return root;
    }

    public static String serialize(Node root) {
        String s = "";
        if (root == null) {
            return s;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur == null) {
                s += "# ";
                continue;
            }
            s += cur.data + " ";
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return s;

    }

    public static Node deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String s[] = data.split(" ");
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(s[0]));
        q.offer(root);
        for (int i = 1; i < s.length; i++) {
            Node cur = q.poll();
            if (!s[i].equals("#")) {
                Node left = new Node(Integer.parseInt(s[i]));
                q.offer(left);
                cur.left = left;
            }
            if (!s[++i].equals("#")) {
                Node right = new Node(Integer.parseInt(s[i]));
                q.offer(right);
                cur.right = right;
            }

        }
        return root;
    }

    public static List<Integer> Morris_Pre(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Node cur = root;
        while (cur != null) {
            if (cur.left != null) {
                Node pred = cur.left;
                while (pred.right != null) {
                    pred = pred.right;
                }
                pred.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            list.add(cur.data);
            cur = cur.right;
        }
        return list;
    }

    public static List<Integer> Morris_In(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Node cur = root;
        while (cur != null) {
            if (cur.left != null) {
                Node pred = cur.left;
                while (pred.right != null) {
                    pred = pred.right;
                }
                pred.right = cur;
                Node temp = cur;
                cur = cur.left;
                temp.left = null;
            } else {
                list.add(cur.data);
                cur = cur.right;
            }

        }
        return list;
    }
    public static Node flattenLL(Node root){
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            if (cur.left != null) {
                Node pred = cur.left;
                while (pred.right != null) {
                    pred = pred.right;
                }
                pred.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }

            cur = cur.right;
        }
        return root;
    

    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node node = new Node(1);
        bt.root = node;
        Node n2 = bt.root.left = new Node(2);
        Node n3 = bt.root.right = new Node(3);
        n2.left = new Node(4);
        // n2.left.left=new Node(11);
        n2.right = new Node(5);
        n3.left = new Node(6);
        n3.right = new Node(7);
        n3.right.left = new Node(8);
        n3.right.right = new Node(9);
        int pre[] = { 4, 3, 2, 1, 5, 6, 7 };
        int in[] = { 1, 2, 3, 4, 5, 6, 7 };
        int post[] = { 1, 2, 3, 5, 6, 7, 4 };
        Traversal t = new Traversal(bt);
        Node ans=flattenLL(bt.root);
        while(ans!=null){
            System.out.println(ans.data);
            ans=ans.right;
        }
    }
}
