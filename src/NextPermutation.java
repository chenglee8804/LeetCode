
public class NextPermutation {
	public void nextPermutation(int[] num) {
		int indexI = -1;
		int indexJ = -1;
		for(int i = num.length -1; i > 0; --i){
			if(num[i] > num[i - 1]){
				indexI = i - 1;
				break;
			}
		}	
		if(indexI == -1){
			//reverse num:
			reverseArray(num, 0, num.length - 1);
			return;
		}
		for(int i = indexI + 1; i < num.length; ++i){
			if(num[i] > num[indexI])
				indexJ = i;
		}	
		//swap:
		int temp = num[indexJ];
		num[indexJ] = num[indexI];
		num[indexI] = temp;	
		//reverse all elements after indexI:
		reverseArray(num, indexI+1, num.length - 1);
			
	}
	
	public void reverseArray(int[] num, int start, int end) {
//		int N = num.length/2;
		int length = end - start + 1;
		int N = length/2;
		int rest = length%2;
		for(int i = 0; i < N; ++i){
			if(rest == 1){
				int temp = num[start + i];
				num[start + i] = num[start + 2*N - i];
				num[start + 2*N - i] = temp;
			}else{
				int temp = num[start + i];
				num[start + i] = num[start + 2*N - i - 1];
				num[start+ 2*N - i - 1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] num = new int[]{2,2,0,4,3,1};
		np.nextPermutation(num);
		for(int i = 0; i < num.length; ++i){
			System.out.print(num[i]);
		}
	}
}
