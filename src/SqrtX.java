
public class SqrtX {
	public int sqrt(int x){
		 int start = 1, end = x/2;
		 int lastMid = 0;
		 if(x < 2) return x;
		 
		 while(start <= end){
			 int mid = (start + end)/2;
			 if(x/mid > mid){
				 start = mid + 1;
				 lastMid = mid;
			 }else if(x/mid < mid){
				 end = mid - 1;
//				 lastMid = mid;
			 }else{
				 return mid;
			 }
		 }
		 return lastMid;
	}
	
	public static void main(String[] args) {
		SqrtX sq = new SqrtX();
		System.out.print(sq.sqrt(10));
	}
}
