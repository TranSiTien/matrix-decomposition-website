package com.example.matrixdecompositionwebsite;

import java.util.List;

import static com.example.matrixdecompositionwebsite.Utils.MatrixUtils.findTransposeMatrix;


public class LdlDecompositor extends Decompositor {


    @Override
    protected List<Integer[][]> findFactors() {
        Integer[][] lower = new Integer[rows][rows];
        Integer[][] diagonal = new Integer[rows][rows];
        Integer[][] temp = new Integer[rows][rows];

        // Initialize upper elements of lower matrix to 0, and diagonal elements to 1
        for (int i = 0; i < rows; i++)
            for (int j = i ; j < rows; j++){
                lower[i][j] = 0;
                if(i == j)
                    lower[i][j] = 1;
            }

        // Initialize diagonal matrix to 0
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < rows; j++)
                diagonal[i][j] = 0;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                int sum = 0;
                if(j == i){
                    for (int k = 0; k < j; k++)
                        sum += (int) Math.pow(temp[j][k], 2) * temp[k][k];
                    temp[j][j] = matrix[j][j] - sum;
                }
                else {
                    for (int k = 0; k < j; k++)
                        sum += (temp[i][k] * temp[j][k] * temp[k][k]);
                    temp[i][j] = (matrix[i][j] - sum) / temp[j][j];
                }
            }
        }
        // extract diagonal elements from temp matrix
        for (int i = 0; i < rows; i++)
            diagonal[i][i] = temp[i][i];
        // extract lower elements from temp matrix
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < i; j++)
                lower[i][j] = temp[i][j];
        Integer[][] upper = findTransposeMatrix(lower, rows, rows);
        return List.of(lower, diagonal, upper);
    }
}
