import java.util.Arrays;

public class Findlength{
	public static int calApLength(int[] intAr){
		if(intAr == null){
			return 0;
		}

		Arrays.sort(intAr);
		int maxLen = intAr[intAr.length-1] - intAr[0];
		int[][] dp = new int[intAr.length][maxLen+1];
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<maxLen+1;j++){
				dp[i][j] = 1;
			}
		}

		for(int i=1;i<intAr.length;i++){
			for(int j=i-1;j>=0;j--){
				int diff= intAr[i] - intAr[j];
				dp[i][diff] = dp[j][diff] + 1;
				ans = Math.max(ans, dp[i][diff]);
			}
		}
		return ans;
	}
}