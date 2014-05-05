import java.util.ArrayList;


public class RestoreIPAddress {
	private String result = "";
	
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> result = new ArrayList<>();
		dfs(s, 0, 0, result);
		return result;
	}
	
	public void dfs(String s, int start, int rest, ArrayList<String> R) {
		if(s.length() - start > (4 - rest)*3){
//			result = "";
			return;
		}
		
		if(s.length() - start < (4 - rest)){
//			result = "";
			return;
		}
		
		if(rest == 4 && start == s.length()){
			result = result.substring(0,result.length() - 1);
			R.add(result);
//			result = "";
			return;
		}
		
		int num = 0;
		for(int i = start; i < start + 3 && i < s.length(); ++i){
			num = num * 10 + s.charAt(i) - '0';
			if(num <= 255){
				String temp = result;
				result += Integer.toString(num) + ".";
				dfs(s, i + 1, rest + 1, R);
				result = temp;
			}
			if(num == 0)
				break;
		}
	}
	
	public static void main(String[] args) {
		RestoreIPAddress rIPA = new RestoreIPAddress();
		System.out.println(rIPA.restoreIpAddresses("25525511135"));
	}
}
