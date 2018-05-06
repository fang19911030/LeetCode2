class Solution {
    public List<String> readBinaryWatch(int num) {
        // List<String> res = new ArrayList<>();
        // if(num == 0) return res;
        List<String> res = new ArrayList<>();
        for(int i=0; i<=num && i < 4; i++){
            List<String> hours = constructHour(i);
            System.out.println(hours);
            List<String> minutes = constructMinute(num-i);
            List<String> combine = buildSolution(hours, minutes);
            for(String str : combine){
                res.add(str);
            }
        }
        return res;
    }
    
    private List<String> buildSolution(List<String> hours, List<String> minutes){
        List<String> solutions = new ArrayList<>();
        for(String h:hours){
            for(String m : minutes){
                String t = h+":"+m;
                solutions.add(t);
            }
        }
        return solutions;
    }
    
    private List<String> constructHour(int t){
        int[] arr = new int[4];
        return buildHour(arr, t, 0, 0);
    }
    
    private List<String> constructMinute(int t){
        int[] arr = new int[6];
        return buildMinute(arr, t, 0, 0);
    }
    
    private List<String> buildHour(int[] arr, int t, int cur, int idx){       
        if(idx == arr.length){
            List<String> res = new ArrayList<>();
            if(cur == t){
                int num = 0;
                for(int i=0;i<arr.length; i++){
                    if(arr[i]!=0){
                        num += Math.pow(2, arr.length-1-i);
                    }
                }
                if(num<=11){
                    res.add(String.valueOf(num));
                }
            }
            return res;
        }
        if(cur > t){
            return new ArrayList<String>();
        }
        
        List<String> res = new ArrayList<>();
        arr[idx] = 1;
        List<String> sub = buildHour(arr, t, cur+1, idx+1);
        for(String s : sub){
            res.add(s);
        }
        arr[idx] = 0;
        List<String> sub2 = buildHour(arr, t, cur, idx+1);
        for(String s:sub2){
            res.add(s);
        }
        return res;
    }
    
    private List<String> buildMinute(int[] arr, int t, int cur, int idx){
        if(idx == arr.length){
            List<String> res = new ArrayList<>();
            if(cur == t){
                int num = 0;
                for(int i=0;i<arr.length; i++){
                    if(arr[i]!=0){
                        num += Math.pow(2, arr.length-1-i);
                    }
                }
                if(num<=9){
                    res.add("0"+num);
                }
                if(num>=10 && num<=59){
                    res.add(String.valueOf(num));
                }
            }
            return res;
        }
        if(cur > t){
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<>();
        arr[idx] = 1;
        List<String> sub1 = buildMinute(arr, t, cur+1, idx+1);
        for(String s:sub1){
            res.add(s);
        }
        arr[idx] = 0;
        List<String> sub2 = buildMinute(arr, t, cur, idx+1);
        for(String s:sub2){
            res.add(s);
        }
        return res;
    }
    
}