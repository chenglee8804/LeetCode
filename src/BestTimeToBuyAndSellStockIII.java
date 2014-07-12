
public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		if(prices.length < 2)
			return 0;
		int length = prices.length;
		int[] f = new int[length];
		int[] g = new int[length];
		
		for(int i = 1, minVal = prices[0]; i < length; ++i){
			minVal = Math.min(minVal, prices[i]);
			f[i] = Math.max(f[i - 1], prices[i] - minVal); 
		}
		
		for(int i = length - 2, maxVal = prices[length - 1]; i >= 0; --i){
			maxVal = Math.max(maxVal, prices[i]);
			g[i] = Math.max(g[i], maxVal - prices[i]);
		}
		
		int maxProfit = 0;
		for(int i = 0; i < length; ++i){
			maxProfit = Math.max(maxProfit, f[i]+ g[i]);
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII btbss3 = new BestTimeToBuyAndSellStockIII();
		System.out.println(btbss3.maxProfit(new int[]{2,4,6,3,9,8,1,7,2}));
	}
}
