import java.util.ArrayList;


public class GenerateParentheses {

	/**
	 * @param args
	 */
	
	static ArrayList<String> result = new ArrayList<>();
	
	public ArrayList<String> generateParenthesis(int n){
		//static ArrayList<String> result = new ArrayList<>();
		result.clear();
		String string = new String();
		this.helper(n, 0, 0, string);
		
		return result;
	}
	
	public void helper(int pNum, int left, int right, String s){
		if(pNum == right){
			result.add(s);
//			System.out.println(s);
			//System.out.println(s.length());
		}else{
			if(left > right){
				helper(pNum, left, right + 1, s + ")") ;
			}
			if(left < pNum){
				helper(pNum, left + 1, right, s +"(");
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses gpt = new GenerateParentheses();
		System.out.println(gpt.generateParenthesis(2));
		
		//System.out.println(string);
	}

}
