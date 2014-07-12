
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if(num.length < 3) return result;
		Arrays.sort(num);
		for(int i = 0; i < num.length - 2; ++i){
			int key = 0 - num[i];
			int start = i + 1;
			int end = num.length - 1;
			while(start < end){
				if(num[start] + num[end] < key){
					start++;
				}else if(num[start] + num[end] > key){
					end--;
				}else{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(num[i]);temp.add(num[start]); temp.add(num[end]);
					result.add(temp);
					start++;
					end--;
				}
			}
		}
		Set<ArrayList<Integer>> removeDup = new HashSet<>(result);
		result.clear();
		result.addAll(removeDup);
		return result;
	}
	
	public ArrayList<ArrayList<Integer>> threeSumOverTimeLimit(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Map<Integer, ArrayList<Pair<Integer, Integer>>> map = new HashMap<Integer, ArrayList<Pair<Integer,Integer>>>();
		if(num.length < 3) return result;
		//sort num fisrt:
		Arrays.sort(num);
		for(int i = 0; i < num.length; ++i){
			for(int j = i + 1; j < num.length; ++j){
				int key = num[i] + num[j];
				if(!map.containsKey(key)){
					ArrayList<Pair<Integer, Integer>> temp = new ArrayList<>();
					temp.add(new Pair<Integer, Integer>(i, j));
					map.put(key, temp);
				}else{
					map.get(key).add(new Pair<Integer, Integer>(i, j));
				}
			}
		}
		
		for(int i = 0; i < num.length; ++i){
			int key = 0 - num[i];
			if(!map.containsKey(key)) continue;
			ArrayList<Pair<Integer, Integer>> temp = map.get(key);
			for(int k = 0; k < temp.size(); ++k){
				if(i <= temp.get(k).getElement1()) continue;
				ArrayList<Integer> r = new ArrayList<>();
				r.add(num[temp.get(k).getElement0()]);
				r.add(num[temp.get(k).getElement1()]);
				r.add(num[i]);
				result.add(r);
			}
		}
//		PublicMethods.printArray(num);
		Set<ArrayList<Integer>> removeDup = new HashSet<>(result);
		result.clear();
		result.addAll(removeDup);
		return result;
	}
	
	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		int[] num = new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		System.out.println(ts.threeSum(num));
	}
}
