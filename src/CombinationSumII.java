
import java.util.ArrayList;


public class CombinationSumII {
	private ArrayList<Integer> tempResult;
	
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int numLength = num.length;
		quickSort(num, 0, numLength - 1);
		tempResult = new ArrayList<>();
		helper(num, 0, target,result);
		return result;
	}
	
	public void helper(int[] data, int start, int target, ArrayList<ArrayList<Integer>> result) {
		if(target == 0){
			result.add(new ArrayList<Integer>(tempResult));
			return;
		}
		
		int previous = -1;
		for(int i = start; i < data.length; ++i){
			if(previous == data[i])
				continue;
			if(data[start] > target ){
				return;
			}
			previous = data[i];
			tempResult.add(data[i]);
			helper(data, i + 1, target - data[i], result);
			tempResult.remove(tempResult.size() - 1);
		}
	}
	
	public void quickSort(int[] array, int left, int right){
		int p = (left + right)/2;
		int pivot = array[p];
		int i = left;
		int j = right;
		while(i < j){
			while(i < p && pivot >= array[i]){
				++i;
			}
			if(i < p){
				array[p] = array[i];
				p = i;
			}
			while(j > p && pivot <= array[j]){
				--j;
			}
			if(j > p){
				array[p] = array[j];
				p = j;
			}
		}
		array[p] = pivot;
		if(p - left > 1){
			quickSort(array, left, p - 1);
		}
		if(right - p > 1){
			quickSort(array, p + 1, right);
		}
	}
	
	public static void main(String[] args) {
		int[] data = new int[]{10,1,2,7,6,1,5};
		//PublicMethods.quickSort(data, 0, data.length - 1);
		CombinationSumII cbs = new CombinationSumII();
		System.out.println(cbs.combinationSum2(data, 8));
	}
}
