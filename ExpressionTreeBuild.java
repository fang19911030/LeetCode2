/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        if(expression == null || expression.length==0){
            return null;
        }
        List<String> reversePolish = new ArrayList<>();
        String[] op = {"+","-","*","/","(",")"};
        Set<String> ops = new HashSet<>(Arrays.asList(op));
        Deque<String> stack = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("(",0);
        map.put("+",1);
        map.put("-",1);
        map.put("*",2);
        map.put("/",2);
        for(String cur:expression){
            if(!ops.contains(cur)){
                reversePolish.add(cur);
            }else{
                if(cur.equals(")")){
                    while(!stack.isEmpty() && !stack.peek().equals("(")){
                        reversePolish.add(stack.pop());
                    }
                    stack.pop();
                }else{
                    if(!cur.equals("(")){
                        int p = map.get(cur);
                        while(!stack.isEmpty() && map.get(stack.peek())>=p){
                            reversePolish.add(stack.pop());
                        }
                        stack.push(cur);
                    }else{
                        stack.push(cur);
                    }
                }
            }
        }
        
        while(!stack.isEmpty()){
            reversePolish.add(stack.pop());
        }
        if(reversePolish.size() == 0){
            return null;
        }
        
        Deque<ExpressionTreeNode> stack2 = new ArrayDeque<>();
        for(String str:reversePolish){
            if(!ops.contains(str)){
                ExpressionTreeNode n = new ExpressionTreeNode(str);
                stack2.push(n);
            }else{
                ExpressionTreeNode o = new ExpressionTreeNode(str);
                o.right = stack2.pop();
                o.left = stack2.pop();
                stack2.push(o);
            }
        }
        return stack2.pop();
    }
}