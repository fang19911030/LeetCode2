public class Solution {
    /*
     * @param : a list of strings
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        if(expression == null || expression.length==0){
            return 0;
        }
        List<String> polish = getReversePolish(expression);
        Set<String> operators = new HashSet<>(Arrays.asList("+","-","*","/"));
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<polish.size();i++){
            String token = polish.get(i);
            if(! operators.contains(token)){
                stack.push(Integer.valueOf(token));
            }else{
                if(token.equals("+")){
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a+b);
                }
                if(token.equals("-")){
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a-b);
                }
                if(token.equals("*")){
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a*b);
                }
                if(token.equals("/")){
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a/b);
                }
            }
        }
        if(!stack.isEmpty()){
            return stack.pop();
        }else{
            return 0;
        }

    }
    
    private List<String> getReversePolish(String[]expression){
        Deque<String> stack = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        Set<String> operators = new HashSet<String>(Arrays.asList("+","-","*","/","(",")"));
        Map<String, Integer> map = new HashMap<>();
        map.put("+",1);
        map.put("-",1);
        map.put("*",2);
        map.put("/",2);
        map.put("(",0);
        for(int i=0;i<expression.length;i++){
            String token = expression[i];
            if(operators.contains(token)){
                if(token.equals("(")){
                    stack.push(token);
                }else if (token.equals(")")){
                    while(!stack.isEmpty() && !stack.peek().equals("(")){
                        res.add(stack.pop());
                    }
                    stack.pop();
                }else{
                    while(!stack.isEmpty() && map.get(token)<= map.get(stack.peek())){
                        res.add(stack.pop());
                    }
                    stack.push(token);
                }
                
            }else{
                res.add(token);
            }
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}