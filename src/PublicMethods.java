
public class PublicMethods {
	
	static public void printBoolMatrix(boolean[][] boolMatrix) {
		int size = boolMatrix.length;
		int length = boolMatrix[0].length;
		for(int i = 0; i < size; ++i){
			for(int j = 0; j < length; ++j){
				if(boolMatrix[i][j] == true)
					System.out.print("1 ");
				else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
	
	static public void printLinkedList(ListNode head) {
		ListNode ptr = head;
		while(ptr != null){
			System.out.print(ptr.val + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	static public void printMatrix(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static public void print2DArray(int[][] a){
		int height = a.length;
		int weight = a[0].length;
		for(int i = 0; i < height; ++i){
			for(int j = 0; j < weight; ++j){
				System.out.print(a[i][j] + "  " );
			}
			System.out.println();
		}
	}
	
	static public void quickSort(int[] array, int left, int right){
		int p = (left + right)/2;
		int pivot = array[p];
		int i = left;
		int j = right;
		while(i < j){
			while(i < p && pivot >= array[i]){
				++i;
			}
			if(i < p){
				array[p] = array[i];
				p = i;
			}
			while(j > p && pivot <= array[j]){
				--j;
			}
			if(j > p){
				array[p] = array[j];
				p = j;
			}
		}
		array[p] = pivot;
		if(p - left > 1){
			quickSort(array, left, p - 1);
		}
		if(right - p > 1){
			quickSort(array, p + 1, right);
		}
	}
}
