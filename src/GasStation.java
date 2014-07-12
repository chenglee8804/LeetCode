
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int pointer = 0;
		int total = 0;
		int sum = 0;
		for(int i = 0; i < gas.length; ++i){
			total += gas[i] - cost[i];
			sum += gas[i] - cost[i];
			if(sum < 0){
				pointer = i + 1;
				sum = 0;
			}
		}
		return total < 0 ? -1:pointer;
	}
	
	public static void main(String[] args) {
		int[] gas = new int[]{5};
		int[] cost = new int[]{4};
		GasStation gs = new GasStation();
		System.out.println(gs.canCompleteCircuit(gas, cost));
	}
}
