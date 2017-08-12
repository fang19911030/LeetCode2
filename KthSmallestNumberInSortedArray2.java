public class Solution{
	public int kthSmallest(int[][] matrix, int k){
		int n = matrix.length;
		int low = matrix[0][0];
		int high = matrix[n-1][n-1];
		while(low<=high){
			int mid = low +(high-low)/2;
			int count = getLessEqual(matrix, mid);
			if(count<k) low = mid+1;
			else high = mid-1;
		}
		return low;
	}

	private int getLessEqual(int[][] matrix, int val){
		int res = 0;
		int n = matrix.length, i=n-1,j=0;
		while(i>=0 && j<=n-1){
			if(matrix[i][j]>val) i--;
			else{
				res +=i+1;
				j++;
			}
		}
		return res;
	}


}