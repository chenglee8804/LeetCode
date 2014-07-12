
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Pair<K, V> {

    private final K element0;
    private final V element1;

    public static <K, V> Pair<K, V> createPair(K key, V value) {
        return new Pair<K, V>(key, value);
    }

    public Pair(K element0, V element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    public K getElement0() {
        return element0;
    }

    public V getElement1() {
        return element1;
    }

}

public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if(num.length < 4){
			return result;
		}
		quickSort(num, 0, num.length - 1);
		Map<Integer, ArrayList<Pair<Integer, Integer>>> map = new HashMap<Integer, ArrayList<Pair<Integer,Integer>>>();
		for(int i = 0; i < num.length; ++i){
			for(int j = i + 1; j < num.length; ++j){
				int key = num[i] + num[j];
				if(map.containsKey(key))
					map.get(key).add(new Pair<Integer, Integer>(i, j));
				else{
					ArrayList<Pair<Integer, Integer>> temp = new ArrayList<>();
					temp.add(new Pair<Integer, Integer>(i, j));
					map.put(key, temp);
				}
			}
		}
		
		for(int i = 0; i < num.length; ++i){
			for(int j = i+1; j < num.length; ++j){
				int key = sum - num[i]- num[j];
				if(!map.containsKey(key)) continue;
				ArrayList<Pair<Integer, Integer>> temp = map.get(key);
				for(int k = 0; k < temp.size(); ++k){
//					System.out.println(temp.get(k).getElement1());
					if(i <= temp.get(k).getElement1()){
						continue;
					}
					ArrayList<Integer> r = new ArrayList<>();
					r.add(num[temp.get(k).getElement0()]);
					r.add(num[temp.get(k).getElement1()]);
					r.add(num[i]);
					r.add(num[j]);
					result.add(r);
				}
			}
		}
		//remove duplicate:
		Set<ArrayList<Integer>> removeDup = new HashSet<>(result);
		result.clear();
		result.addAll(removeDup);
		return result;
	}
	
	public void quickSort(int[] data, int start, int end){
		int i = start;
		int j = end;
		int p = (start + end)/2;
		int pivot = data[p];
		
		while(i < j){
			while(i < p && pivot >= data[i]){
				++i;
			}
			if(i < p){
				data[p] = data[i];
				p = i;
			}
			while(j > p && pivot <= data[j]){
				--j;
			}
			if(j > p){
				data[p]= data[j];
				p = j;
			}
		}
		data[p] = pivot;
		if(p - start > 1){
			quickSort(data, start, p - 1);
		}
		if(end - p > 1){
			quickSort(data, p + 1, end);
		}
	}
	
	public static void main(String[] args) {
		FourSum fs = new FourSum();
		int[] data = new int[]{1,3,4,2,2,7,4,4,8};
		fs.quickSort(data, 0, data.length - 1);
		PublicMethods.printArray(data);
		System.out.println(fs.fourSum(data, 11));
	}
}
