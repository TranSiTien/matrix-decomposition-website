package com.example.matrixdecompositionwebsite;

import java.util.List;

public class MatrixDecomposition {
    private Decompositor decompositor = new LdlDecompositor();
    private final Integer[][] matrix;
    private final int rows;
    private final int columns;

    public MatrixDecomposition(Decompositor decompositor, Integer[][] matrix, int rows, int columns) {
        this.decompositor = decompositor;
        this.matrix = matrix;
        this.rows = rows;
        this.columns = columns;
    }

    public MatrixDecomposition(Integer[][] matrix, int rows, int columns) {
        this.matrix = matrix;
        this.rows = rows;
        this.columns = columns;
    }

    public List<Integer[][]> decompose() {
        return decompositor.decompose(this);
    }

    public Decompositor getDecompositor() {
        return decompositor;
    }

    public Integer[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
