package com.example.matrixdecompositionwebsite.Utils;

import java.util.Objects;

public class MatrixUtils {
    private static void getCofactor(Integer[][] mat, Integer[][] temp,
                            int p, int q, int n)
    {
        int i = 0, j = 0;

        // Looping for each element
        // of the matrix
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Copying into temporary matrix
                // only those element which are
                // not in given row and column
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    // Row is filled, so increase
                    // row index and reset col index
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /* Recursive function for finding determinant
    of matrix. n is current dimension of mat[][]. */
    public static int determinantOfMatrix(Integer[][] mat, int n)
    {
        int D = 0; // Initialize result

        // Base case : if matrix
        // contains single element
        if (n == 1)
            return mat[0][0];

        // To store cofactors
        Integer[][] temp = new Integer[n][n];

        // To store sign multiplier
        int sign = 1;

        // Iterate for each element of first row
        for (int f = 0; f < n; f++) {
            // Getting Cofactor of mat[0][f]
            getCofactor(mat, temp, 0, f, n);
            D += sign * mat[0][f]
                    * determinantOfMatrix(temp, n - 1);

            // terms are to be added
            // with alternate sign
            sign = -sign;
        }

        return D;
    }
    public static Integer[][] findTransposeMatrix(Integer[][] matrix, int rows, int columns) {
        Integer[][] transposeMatrix = new Integer[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                transposeMatrix[i][j] = matrix[j][i];
            }
        }
        return transposeMatrix;
    }
    public static boolean isMatrixPositiveDefinite(Integer[][] matrix, int rows, int columns) {
        for (int i = 0; i <= rows; i++) {
            if(MatrixUtils.determinantOfMatrix(matrix,i) < 0) return false;
        }
        return true;
    }

    public static void checkSquare(Integer[][] matrix, int rows, int columns) {
        if(rows != matrix.length) {
            throw new IllegalArgumentException("Number of rows does not match");
        }
        for(int i = 0; i < rows; i++) {
            if(columns != matrix[i].length) {
                throw new IllegalArgumentException("Number of columns does not match");
            }
        }
        if(rows != columns) {
            throw new IllegalArgumentException("Matrix is not square");
        }

    }
    public static void checkNumberOfRowsAndColumns(Integer[][] matrix, int rows, int columns) {

    }
    public static void checkSymmetry(Integer[][] matrix, int rows, int columns) {
        for(int i = 0; i < rows; i++) {
            for(int j = i + 1; j < columns; j++) {
                if(!Objects.equals(matrix[i][j], matrix[j][i])) {
                    throw new IllegalArgumentException("Matrix is not symmetric");
                }
            }
        }
    }
}
