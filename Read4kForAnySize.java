public class AnysizeRead{
	private final int SIZE = 4096;

	int curr = 0;
	List<Integer> buff = new ArrayList<Integer>();
	public List<Integer> readAnySize(int size){
		List<Integer> result = new ArrayList<>();
		while(size > 0){
			if(cur + size < SIZE){
				result.addAll(buff.subList(cur, cur+size));
				curr+=size;
				size = 0;
			}else{
				result.addAll(buff.subList(cur, buff.size()));
				curr = 0;
				size -=SIZE-curr;
				buff = read4k();
			}
		}
		return result;
	}
}