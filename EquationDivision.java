class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if(equations == null || values == null || queries == null){
            return new double[0];
        }
        
        Map<Stringh,List<Edge>> graph = new HashMap<>();
        double[] res = new double[queries.length];
        Arrays.fill(res,-1);
        init(graph,equations,values);
        for(int i=0;i<queries.length;i++){
            Set<String> visited = new HashSet<>();
            if(graphs.containsKey(queries[i][0]) && graph.containsKey(queries[i][1])){
                dfs(graph,res,queries[i][0],queries[i][1],visited,1.0,i);
            }
        }
        return res;
        
    }
    
    private void dfs(Map<String,List<Edge>> graph, double[] res, String s, String t,double cur,int index){
        if(s.equals(t)){
            res[index] = cur;
            return;
        }
        if(visited.contains(s)){
            return;
        }
        visited.add(s);
        List<Edge> next = graph.get(s);
        for(Edge e:next){
            dfs(graph,res,e.to,t,cur*e.val,index);
        }
    }
    
    private void init(Map<String,List<Edge>> graph,String[][] equations,double[]values){
        for(int i=0;i<equations.length;i++){
            String a = equations[i][0];
            String b = equations[i][1];
            double v = values[i];
            if(graph.containsKey(a)){
                Edge t = new Edge(b,v);
                graph.get(a).add(t);
            }else{
                List<Edge> list = new ArrayList<>();
                Edge t = new Edge(b,v);
                list.add(t);
                graph.put(a,list);
            }
            
            if(graph.containsKey(b)){
                Edge t = new Edge(a,1/v);
                graph.get(b).add(t);
            }else{
                List<Edge> list = new ArrayList<>();
                Edge t = new Edge(a,1/v);
                list.add(t);
                graph.put(b,list);
            }
        }
    }
    
    class Edge{
        String to;
        double val;
        Edge(String t, double v){
            to = t;
            val = v;
        }
    }
}