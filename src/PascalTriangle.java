import java.util.ArrayList;


public class PascalTriangle {

	/**
	 * @param args
	 */
	public ArrayList<ArrayList<Integer>> generate(int numRows){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if(numRows == 0)
			return result;
		ArrayList<Integer> list = new ArrayList<>();
		result.add(list);
		result.get(0).add(1);
		if(numRows == 1)
			return result;
		ArrayList<Integer> list2 = new ArrayList<>();
		result.add(list2);
		result.get(1).add(1);result.get(1).add(1);
		if(numRows == 2)
			return result;
		
		for(int i = 2; i < numRows; i++){
			ArrayList<Integer> addList = new ArrayList<>();
			result.add(addList);
			result.get(i).add(1);
			for(int j = 1; j < result.get(i-1).size(); j++){
				result.get(i).add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
			}
			result.get(i).add(1);
		}
		return result;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle pt = new PascalTriangle();
		System.out.println(pt.generate(3));
	}

}
