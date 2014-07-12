
public class Candy {
	public int candy(int[] ratings) {
		int[] increment = new int[ratings.length];
		for(int i = 1, counter = 1; i < ratings.length; ++i){
			if(ratings[i - 1] < ratings[i])
				increment[i] = counter++;
			else
				counter = 1;
		}
		
		for(int i = ratings.length - 2, counter = 1; i >= 0; --i){
			if(ratings[i] > ratings[i + 1])
				increment[i] = Math.max(increment[i], counter++);
			else
				counter = 1;
		}
		
		int sum = ratings.length;
		
		for(int i = 0; i < ratings.length; ++i){
			sum += increment[i];
		}
		return sum;
	}
	
	public int findMin(int[] data) {
		int length = data.length;
		int min = data[0];
		int ptr = 0;
		for(int i = 1; i < length; ++i){
			if(data[i] < min){
				min = data[i];
				ptr = i;
			}
		}
		return ptr;
	}
	
	public int findMaxContinue(int[] data) {
		int length = data.length;
		int numContinue = 1;
		int maxContinue = 0;
		int currentPtr = -1;
		for(int i = 1; i < length; ++i){
			if(data[i - 1] <= data[i]){
				numContinue++;
			}else{
				if(maxContinue < numContinue){
					maxContinue = numContinue;
					currentPtr = i - 1;
				}
				numContinue = 1;
			}
		}
		if(maxContinue < numContinue){
			maxContinue = numContinue;
			currentPtr = data.length - 1;
		}
		numContinue = 1;
		for(int i = 1; i < length; ++i){
			if(data[i - 1] >= data[i]){
				numContinue++;
			}else{
				if(maxContinue < numContinue){
					maxContinue = numContinue;
					currentPtr = i - 1;
				}
				numContinue = 1;
			}
		}
		if(maxContinue < numContinue){
			maxContinue = numContinue;
			currentPtr = data.length - 1;
		}
		int startPtr = currentPtr - maxContinue + 1;
		if(data[startPtr] > data[currentPtr])
			return currentPtr;
		else {
			return startPtr;
		}
	}
	
	public static void main(String[] args) {
		int[] ratings = new int[]{10,6,3,4,8,10,1,2,7};
		Candy cndy = new Candy();
		System.out.println(cndy.candy(ratings));
	}
}
