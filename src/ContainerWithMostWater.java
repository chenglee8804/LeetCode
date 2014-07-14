
public class ContainerWithMostWater {

	/**
	 * @param args
	 */
	public int maxArea(int[] height) {
		
		int left = 0;
		int right = height.length - 1;
		int maxVolumn = 0;
		
		while(left < right){
			maxVolumn = Math.max(maxVolumn, (right - left)*(Math.min(height[right], height[left])));
			if(height[left] >= height[right]){
				right--;
			}else{
				left++;
			}
		}
		
        return maxVolumn;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] height = new int[5];
		height[0] = 3;
		height[1] = 5;
		height[2] = 0;
		height[3] = 9;
		height[4] = 6;
		ContainerWithMostWater ctest = new ContainerWithMostWater();
		System.out.print(ctest.maxArea(height));

	}

}
