import java.util.Stack;


public class LargestRectangleInHistogram {
	public int largestRectangleAreaWithoutStack(int[] height) {
		int maxArea = 0;
		for(int i = 0; i < height.length; ++i){
			if(i + 1 < height.length && height[i] <= height[i+1])
				continue;
			int minHeight = height[i];
			for(int j = i; j >= 0; --j){
				minHeight = Math.min(minHeight, height[j]);
				int area = minHeight * (i - j + 1);
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}
	
	public int  largestRectangleArea(int[] height) {
		int area = 0;
		Stack<Integer> s = new Stack<>();
		for(int i = 0; i < height.length; ++i){
			if(s.empty() || height[s.peek()] < height[i]){
				s.push(i);
			}else{
				int start = s.pop();
				int width = s.empty()? i: i-s.peek()-1;
				area = Math.max(area, height[start] * width);
				i--;
			}
		}
		while(!s.empty()){
			int start = s.pop();
			int width = s.empty()? height.length: height.length - s.peek() - 1;
			area = Math.max(area, height[start] * width);
		}
		return area;
	}
	
	public static void main(String[] args) {
		LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
		int[] height = new int[]{2,1,5,6,2,7};
		System.out.println(lr.largestRectangleArea(height));
	}
}
