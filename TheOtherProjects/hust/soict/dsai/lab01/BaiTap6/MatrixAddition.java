package BaiTap6;

public class MatrixAddition{
    public static void main(String[] args) {
      
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrix2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int rows = matrix1.length;
        int cols = matrix1[0].length;

       
        int[][] resultMatrix = new int[rows][cols];

  
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }


        System.out.println("Matrix 1:");
        displayMatrix(matrix1);

        System.out.println("Matrix 2:");
        displayMatrix(matrix2);

        System.out.println("Result Matrix (Matrix 1 + Matrix 2):");
        displayMatrix(resultMatrix);
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
