package com.example.matrixdecompositionwebsite.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CholeskyDTO implements Serializable {
    private Integer[][] matrix;
    private int rows;
    private int columns;
    private Integer[][] lowerTriangularMatrix;
    private Integer[][] upperTriangularMatrix;
    private String errorMessages;
}
