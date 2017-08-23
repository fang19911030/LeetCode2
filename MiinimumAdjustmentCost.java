public class MinAdjustmentCost{
	public static int MinAdjustmentCost(List<Integer> A, int target){
		if(A == null || A.size()<=1){
			return 0;
		}

		ArrayList<Integer> B = new ArrayList<>(A);
		return res(A,B,target,0);
	}

	public static int res(List<Integer> A, ArrayList<Integer> B, int target, int index){
		int len = A.size();
		if(index >= len){
			return 0;
		}

		int dif = 0;
		int min = Integer.MAX_VALUE;

		for(int i=0;i<=100;i++){
			if(index!=0 && Math.abs(i-B.get(index-1)>target)){
				continue;
			}

			B.set(index, i);
			dif = Math.abs(i-A.get(index));
			dif += res(A,B,target,index+1);
			min = Math.min(min, dif);
		}
		return min;
	}


	public int MinAdjustmentCost3(List<Integer> A, int target){
		if(A == null || A.size() == 0){
			return 0;
		}

		int[][] M = new int[A.size()][100];
		for(int i=0;i<A.size();i++){
			for(int j=0;j<100;j++){
				M[i][j] = Integer.MAX_VALUE;
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=100;i++){
			min = Math.min(min,res3(A,target,0,i,M));
		}
		return min;
	}

	public int res3(List<Integer> A, int target, int index, int x, int[][] M){
		int len = A.size();
		if(index>=len){
			return 0;
		}
		if(M[index][x-1] != Integer.MAX_VALUE){
			return M[index][x-1];
		}
		int bas = Math.abs(x-A.get(index));
		int min = Integer.MAX_VALUE;

		for(int i=1;i<=100;i++){
			if(index != len-1 && Math.abs(i-x) > target){
				continue;
			}

			int dif = bas + res3(A,target,index+1,i,M);
			min = Math.min(min,dif);
		}
		M[index][x-1] = min;
		return min;
	}
}