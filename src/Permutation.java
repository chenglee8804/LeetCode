import java.util.ArrayList;


public class Permutation {
	static int array[] = null;
	static ArrayList<ArrayList<Integer>> result = null;
	static int temp = 0;
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
	    result = new ArrayList<ArrayList<Integer>>();
	    array = num;
	    recursive(0);
	    return result;
	}
	private static void recursive(int currentIndex) {
	    if(currentIndex == array.length-1){
	        ArrayList<Integer> newList = new ArrayList<Integer>();
	        for(int i = 0;i < array.length;i++){
	            newList.add(array[i]);
	        }
	        result.add(newList);
	        return;
	    }
	    for(int i = currentIndex;i < array.length;i++){
	        swap(currentIndex,i);
	        recursive(currentIndex+1);
	        swap(currentIndex,i);
	    }
	}
	private static void swap(int currentIndex, int i) {
	    temp = array[i];
	    array[i] = array[currentIndex];
	    array[currentIndex] = temp;
	}
	
	public static void main(String[] args) {
		int[] test = new int[]{1,2,3};
		System.out.println(Permutation.permute(test));
	}
}
