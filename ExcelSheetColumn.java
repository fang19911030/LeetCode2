class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n = n-1;
            char cur = (char)(n% 26 + 'A');
            sb.append(cur);
            n = n/26;
        }
        return sb.reverse().toString();
    }
}