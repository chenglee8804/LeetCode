
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if(nRows == 1)
			return s;
		String resultString = "";
		int counter = 0;
		boolean reverse = false;
		String[] stringsArr = new String[nRows];
		for(int i = 0; i < nRows; ++i){
			stringsArr[i] = ""; 
		}
		for(int i = 0; i < s.length(); ++i){
			if(counter == -1){
				counter = 1;
				reverse = false;
				stringsArr[counter] += s.charAt(i);
				counter++;
				continue;
			}
			if(counter == nRows){
				counter = nRows - 2;
				reverse = true;
				stringsArr[counter] += s.charAt(i);
				counter--;
				continue;
			}
			if(reverse == true){
				stringsArr[counter] += s.charAt(i);
				counter--;
				continue;
			}
			if(reverse == false){
				stringsArr[counter] += s.charAt(i);
				counter++;
				continue;
			}
		}
		for(int i = 0; i < nRows; ++i){
			resultString += stringsArr[i];
		}
		return resultString;
	}
	
	public static void main(String[] args) {
		ZigZagConversion zzc = new ZigZagConversion();
		System.out.println(zzc.convert("PAYPALISHIRING", 2));
	}
}
