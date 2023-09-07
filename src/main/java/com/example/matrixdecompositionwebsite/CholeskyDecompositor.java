package com.example.matrixdecompositionwebsite;

import java.util.List;
import static com.example.matrixdecompositionwebsite.Utils.MatrixUtils.findTransposeMatrix;


public class CholeskyDecompositor extends Decompositor {

    @Override
    protected List<Integer[][]> findFactors() {
        Integer[][] lower = new Integer[rows][rows];

        // Initialize upper elements of lower matrix to 0
        for (int i = 0; i < rows; i++)
            for (int j = i + 1; j < rows; j++)
                lower[i][j] = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                int sum = 0;
                if(j==i){
                    for (int k = 0; k < j; k++)
                        sum += (int) Math.pow(lower[j][k], 2);
                    lower[j][j] = (int) Math.sqrt(matrix[j][j] - sum);
                }
                else {
                    for (int k = 0; k < j; k++)
                        sum += (lower[i][k] * lower[j][k]);
                    lower[i][j] = (matrix[i][j] - sum) / lower[j][j];
                }
            }
        }
        Integer[][] upper = findTransposeMatrix(lower, rows, rows);
        return List.of(lower, upper);
    }
}
