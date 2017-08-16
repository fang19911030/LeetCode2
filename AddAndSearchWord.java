public class WordDictionary {
    class Node{
        char val;
        Node[] next;
        int end;
        public Node(char i){
            val = i;
            next = new Node[26];
            end = 0;
        }
        
        public Node(){
            val = '0';
            next = new Node[26];
            end = 0;
        }
    }
    private Node root = new Node();
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        if(word == null || word.length()==0){
            return;
        }
        char[] str = word.toCharArray();
        addWord(str,0, root);
    }
    
    private void addWord(char[] str, int index, Node root){
        if(index==str.length){
            root.end++;
            return;
        }
        int t = str[index]-'a';
        if(root.next[t]==null){
            root.next[t] = new Node(str[index]);
            addWord(str,index+1,root.next[t]);
        }else{
            addWord(str,index+1,root.next[t]);
        }
        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        char[] arr = word.toCharArray();
        return search(arr,0,root);
    }
    
    private boolean search(char[] arr, int index, Node node){
        if(index>=arr.length){
            if(node.end>=1){
                return true;
            }else{
                return false;
            }
        }
        char cur = arr[index];
        boolean res = false;
        if(cur!='.'){
            if(node.next[cur-'a'] == null){
                return false;
            }else{
                res = res || search(arr,index+1,node.next[cur-'a']);
            }
        }else{
            for(int i=0;i<node.next.length;i++){
                if(node.next[i]!= null){
                    res = res || search(arr,index+1,node.next[i]);
                    if(res == true){
                        return res;
                    }
                }
            }
        }
        
        return res;
    }
}