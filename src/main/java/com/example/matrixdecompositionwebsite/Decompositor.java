package com.example.matrixdecompositionwebsite;


import java.util.List;
import java.util.Objects;

import static com.example.matrixdecompositionwebsite.Utils.MatrixUtils.*;


public abstract class Decompositor {
    protected Integer[][] matrix;
    protected int rows;
    protected int columns;
    public List<Integer[][]> decompose(MatrixDecomposition context) {

        this.matrix = context.getMatrix();
        this.rows = context.getRows();
        this.columns = context.getColumns();
        checkSquare(matrix, rows, columns);
        checkSymmetry(matrix, rows, columns);

        if(this.getClass().equals(CholeskyDecompositor.class) && !isMatrixPositiveDefinite(matrix, rows, columns)) {
            throw new IllegalArgumentException("Matrix is not positive definite and it cannot be decomposed by cholesky method");
        }
        return findFactors();
    }
    protected abstract List<Integer[][]> findFactors();

}
