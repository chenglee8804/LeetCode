import java.util.Hashtable;


public class LongestConsecutiveSequence {

    /**
     * @param args
     */

    public int longestConsecutive(int[] num){
    	Hashtable<Integer, Boolean> table = new Hashtable<>();
    	for(int i = 0; i < num.length; i++){
    		table.put(num[i], false);
    	}
    	int counter = 1;
    	int max_length = 0;
    	for(int i = 0; i < num.length ; i++){	
    		if(table.get(num[i]) == true)
    			continue;
    		int current_number = num[i];
    		while(table.get(current_number - 1) != null){
    			table.put(current_number - 1, true);
    			current_number--;
    			counter++;
    		}
    		current_number = num[i];
    		while(table.get(current_number + 1) != null){
    			table.put(current_number + 1, true);
    			current_number++;
    			counter++;
    		}
    		max_length = Math.max(max_length, counter);
    		counter = 1;
    	}
    	return max_length;
    }
    public static void main(String[] args) {
	
	// TODO Auto-generated method stub
    	LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
    	int[] num = {100, 4, 200, 1, 3, 2 , 102, 103, 101, 99};
    	System.out.println(lcs.longestConsecutive(num));
    }
    
}
