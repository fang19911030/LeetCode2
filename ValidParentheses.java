public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        Deque<Character> stack = new ArrayDeque<>(s.length());
        char[] left = {'(','[','{'};
        Set<Character> set = new HashSet<>();
        for(int i=0;i<left.length;i++){
            set.add(left[i]);
        }
        
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                stack.addLast(s.charAt(i));
            }else if(s.charAt(i)==')'){
                if(stack.isEmpty() || stack.pollLast()!='('){
                    return false;
                }
            }else if(s.charAt(i)==']'){
                if(stack.isEmpty() || stack.pollLast()!='['){
                    return false;
                }
            }else if(s.charAt(i)=='}'){
                if(stack.isEmpty() || stack.pollLast()!='{'){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}