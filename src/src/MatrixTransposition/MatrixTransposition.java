package MatrixTransposition;

import java.util.Arrays;

public class MatrixTransposition {

    public static Integer[][] transpose(Integer[][] matrix){
        int col = matrix[0].length;
        int row = matrix.length;
        Integer[][] transpose = new Integer[col][row];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    public static void main(String[] args) {
        Integer[][] matrix2 =
        {
            {1, 3, 5},
            {2, 4, 6},
        };
        System.out.println("\nTransposed Matrix:");
        Arrays.stream(transpose(matrix2))
                .forEach(row -> System.out.println(Arrays.toString(row)));
    }
}