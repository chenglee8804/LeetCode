
public class SetMatrixZeros {

	/**
	 * @param args
	 */
	
	public void setZeros(int[][] matrix){
		int rowNum = matrix.length;
		int colomnNum = matrix[0].length;
		boolean hasZeroFirstRow = false;
		boolean hasZeroFirstCol = false;
		
		for(int i = 0; i < rowNum; i++){
			for(int j = 0; j < colomnNum; j++){
				if(i == 0 && matrix[i][j] == 0)
					hasZeroFirstRow = true;
				if(j == 0 && matrix[i][j] == 0 )
					hasZeroFirstCol = true;
				if(matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for(int i = 1; i < rowNum ; i++){
			for(int j = 1; j < colomnNum; j++){
				if(matrix[0][j] == 0 || matrix[i][0] == 0)
					matrix[i][j]= 0; 
			}
		}
		
		if(hasZeroFirstCol){
			//set first col zero
			for(int i = 0; i < rowNum; i++){
				matrix[i][0] = 0;
			}
		}
		
		if(hasZeroFirstRow){
			//set first row zero:
			for(int i = 0; i < colomnNum; i++){
				matrix[0][i] = 0; 
			}
		}
		
		for(int i = 0; i < rowNum; i++){
			for(int j = 0; j < colomnNum; j++){
				System.out.print(matrix[i][j]);
				System.out.print(' ');
			}
			System.out.print('\n');
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[5][];
		matrix[0] = new int[]{3,1,4,6,2};
		matrix[1] = new int[]{3,3,4,6,5};
		matrix[2] = new int[]{3,2,4,0,1};
		matrix[3] = new int[]{3,0,4,6,9};
		matrix[4] = new int[]{0,1,4,6,7};
		
		SetMatrixZeros smz = new SetMatrixZeros();
		smz.setZeros(matrix);
	}

}
