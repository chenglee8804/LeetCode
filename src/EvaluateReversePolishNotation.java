
import java.util.Stack;


public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<>();
		for(int i = 0; i < tokens.length; ++i){
			if(tokens[i].equals("+")){
				int a = s.pop();
				int b = s.pop();
				s.push(b+a);
			}else if(tokens[i].equals("-")){
				int a = s.pop();
				int b = s.pop();
				s.push(b-a);
			}else if(tokens[i].equals("*")){
				int a = s.pop();
				int b = s.pop();
				s.push(b*a);
			}else if(tokens[i].equals("/")){
				int a = s.pop();
				int b = s.pop();
				s.push(b/a);
			}else{
				s.push(Integer.parseInt(tokens[i]));
			}
		}
		return s.pop();
	}
	
	public static void main(String[] args) {
//		String test = new String("string");
//		System.out.println(test.equals("string"));
		String[] tokens = new String[]{};
		EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
		System.out.println(erpn.evalRPN(tokens));
	}
}
