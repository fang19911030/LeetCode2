public class Solution {
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if(head == null){
            return null;
        }
        List<Integer> list = new LinkedList<>();
        ListNode cur = head;
        while( cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        
        TreeNode root = getTree(list, 0, list.size()-1);
        return root;
    }
    
    private TreeNode getTree(List<Integer>list, int left, int right){
        if(left == right){
            TreeNode cur = new TreeNode(list.get(left));
            return cur;
        }
        if(left> right){
            return null;
        }
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = getTree(list,left,mid-1);
        root.right = getTree(list, mid+1, right);
        return root;
    }

    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        
        int size = 0;
        ListNode runner = head;
        node = head;
        
        while(runner != null){
            runner = runner.next;
            size ++;
        }
        
        return inorderHelper(0, size - 1);
    }

    public TreeNode inorderHelper(int start, int end){
        if(start > end){
            return null;
        }
        
        int mid = start + (end - start) / 2;
        TreeNode left = inorderHelper(start, mid - 1);
        
        TreeNode treenode = new TreeNode(node.val);
        treenode.left = left;
        node = node.next;

        TreeNode right = inorderHelper(mid + 1, end);
        treenode.right = right;
        
        return treenode;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(null == head){
            return null;
        }
        
        if(null == head.next){
            return new TreeNode(head.val);
        }
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(null != fast && null != fast.next){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        
        return root;
    }
}