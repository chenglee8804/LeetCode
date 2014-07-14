
public class BestTimeBuySellStock {

	/**
	 * @param args
	 */
	
	public int maxProfit(int[] prices){
		int size = prices.length;
		int minium = 0;
		int diffPrice = 0;
		for(int i = 1; i< size; i++){
			if(prices[i] < prices[minium])
				minium = i;
			int diff = prices[i] - prices[minium];
			if(diff > diffPrice){
				diffPrice = diff;
			}
		}
		return diffPrice;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeBuySellStock btbss = new BestTimeBuySellStock();
		int[] prices = new int[]{1,2,5,3,7,11,0,19};
		System.out.println(btbss.maxProfit(prices));
	}

}
