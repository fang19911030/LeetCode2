class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        Map<Integer, Map<Integer, Integer>> matrixA = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> matrixB = new HashMap<>();
        initMatrix(matrixA, A, true);
        initMatrix(matrixB, B, false);
        for(int i=0;i< res.length;i++){
            for(int j=0;j<res[0].length;j++){
                if(matrixA.containsKey(i) && matrixB.containsKey(j)){
                    res[i][j] = multiply(matrixA.get(i), matrixB.get(j));
                }
            }
        }
        return res;
    }
    
    private void initMatrix(Map<Integer,Map<Integer, Integer>> matrix, int[][] A, boolean flag){
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j] != 0){
                    if(flag){
                        if(!matrix.containsKey(i)){
                            matrix.put(i, new HashMap<Integer, Integer>());
                        }
                        matrix.get(i).put(j,A[i][j]);
                    }else{
                        if(!matrix.containsKey(j)){
                            matrix.put(j, new HashMap<Integer, Integer>());                            
                        }
                        matrix.get(j).put(i, A[i][j]);
                    }
                }
            }
        }
    }
    
    private int multiply(Map<Integer, Integer> map1, Map<Integer, Integer> map2){
        int sum = 0;
        for(Integer i: map1.keySet()){
            if(map2.containsKey(i)){
                sum += map1.get(i) * map2.get(i);
            }
        }
        return sum;
    }
}