import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		ArrayList<Integer> result = new ArrayList<>();
//		if(numbers.length < 2) return new int[0];
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < numbers.length; ++i){
			map.put(numbers[i], i);
		}
		
		for(int i = 0; i < numbers.length; ++i){
			int key = target - numbers[i];
			if(map.containsKey(key) && i < map.get(key)){
				result.add(i + 1);
				result.add(map.get(key) + 1);
//				break;
			}
		}
		
		int[] R = new int[result.size()];
		for(int i = 0; i < result.size(); ++i){
			R[i] = result.get(i);
		}
		return R;
	}
	
	public static void main(String[] args) {
		int[] num = new int[]{3,2,4};
		TwoSum ts = new TwoSum();
		PublicMethods.printArray(ts.twoSum(num, 6));
	}
}
