/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    TrieNode[] next;
    int end;
    
    public TrieNode() {
       next = new TrieNode[26];
       end = 0;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return ;
        }
        
        char[] arr = word.toCharArray();
        insert(arr,0,root);
        
    }
    
    private void insert(char[] arr, int index, TrieNode node){
        if(index>=arr.length){
            node.end++;
            return;
        }
        
        char cur = arr[index];
        if(node.next[cur-'a'] == null){
            node.next[cur-'a'] = new TrieNode();
            insert(arr,index+1,node.next[cur-'a']);
        }else{
            insert(arr, index+1, node.next[cur-'a']);
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length()==0){
            return true;
        }
        
        char[] arr = word.toCharArray();
        return search(arr,0,root);
        
    }
    
    private boolean search(char[] arr,int index, TrieNode node){
        if(index>=arr.length){
            if(node.end>=1){
                return true;
            }else{
                return false;
            }
        }
        
        char cur = arr[index];
        if(node.next[cur-'a']==null){
            return false;
        }else{
            return search(arr,index+1,node.next[cur-'a']);
        }
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0){
            return true;
        }
        
        char[] arr = prefix.toCharArray();
        return startsWith(arr,0, root);
    }
    
    private boolean startsWith(char[] arr, int index, TrieNode node){
        if(index>=arr.length){
            return true;
        }
        
        char cur = arr[index];
        if(node.next[cur-'a'] == null){
            return false;
        }else{
            return startsWith(arr,index+1,node.next[cur-'a']);
        }
    }
}