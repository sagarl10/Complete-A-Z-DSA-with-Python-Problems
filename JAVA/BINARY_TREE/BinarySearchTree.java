import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    public static boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data <= min || root.data >= max) {
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public static Node searchBST(Node root, int target) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            if (cur.data == target) {
                return cur;
            } else if (target < cur.data) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    public static int mini(Node root) {
        if (root == null) {
            return -1;
        }
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.data;
    }

    public static int maxi(Node root) {
        if (root == null) {
            return -1;
        }
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.data;
    }

    public static int ceil(Node root, int target) {
        int ceil = -1;
        if (root == null) {
            return ceil;
        }
        while (root != null) {
            if (root.data == target) {
                return target;
            } else if (target < root.data) {
                ceil = root.data;
                root = root.left;
            } else {
                root = root.right;
            }

        }
        return ceil;

    }

    public static int floor(Node root, int target) {
        int floor = -1;
        if (root == null) {
            return floor;
        }
        while (root != null) {
            if (root.data == target) {
                return target;
            } else if (target < root.data) {
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;

    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;

    }

    public static Node delete(Node root, int target) {
        if (root == null) {
            return null;
        }
        if (target < root.data) {
            root.left = delete(root.left, target);
        } else if (target > root.data) {
            root.right = delete(root.right, target);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = mini(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;

    }

    public static void findkthsmall(Node root, int k, int ans[]) {
        if (root == null || ans[1] >= k) {
            return;
        }
        findkthsmall(root.left, k, ans);
        ans[1]++;
        if (ans[1] == k) {
            ans[0] = root.data;
            return;
        }
        findkthsmall(root.right, k, ans);

    }

    public static void findkthgreater(Node root, int k, int ans[]) {
        if (root == null || ans[1] >= k) {
            return;
        }
        findkthgreater(root.right, k, ans);
        ans[1]++;
        if (ans[1] == k) {
            ans[0] = root.data;
            return;
        }
        findkthgreater(root.left, k, ans);

    }

    public static int LCA(Node root, int n1, int n2) {
        if (root == null) {
            return -1;
        }
        if (root.data == n1 || root.data == n2) {
            return root.data;
        }
        if (n1 < root.data && n2 < root.data) {
            return LCA(root.left, n1, n2);
        } else if (n1 > root.data && n2 > root.data) {
            return LCA(root.right, n1, n2);
        }
        return root.data;

    }

    public static boolean two_sum(Node root, int target) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int sum = list.get(end) + list.get(start);
            if (sum == target) {
                return true;
            }
            if (target < sum) {
                end--;
            } else {
                start++;
            }

        }
        return false;
    }
    public static Node bstFromPre(int arr[],int min,int max,int index){
        if(index>arr.length-1){
            return null;
        }
        if(arr[index]<=min || arr[index]>=max){
            return null;
        }
        Node root=new Node(arr[index++]);
        root.left=bstFromPre(arr, min,root.data, index);
        root.right=bstFromPre(arr, root.data, max, index);
        return root;
        
    }
    public static Node bstFromInorder(int arr[],int s,int e){
        if(s>=e){
            return null;
        }
        int mid=(s+e)/2;
        Node root=new Node(mid);
        root.left=bstFromInorder(arr, s, mid-1);
        root.right=bstFromInorder(arr, mid+1, e);
        return root;
    }


    public static void traversal(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traversal(root.left, list);
        list.add(root.data);
        traversal(root.right, list);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node node = new Node(7);
        bt.root = node;
        Node n2 = bt.root.left = new Node(2);
        Node n3 = bt.root.right = new Node(9);
        n2.left = new Node(1);
        n2.right = new Node(3);
        n3.left = new Node(8);
        n3.right = new Node(10);
        int arr[]=new int[]{1,2,3,4,5,6,7,8};
        Node ans=bstFromPre(arr, Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        List<Integer> list=new ArrayList<>();
        traversal(ans, list);
        System.out.println(list.toString());
        

    }

}
