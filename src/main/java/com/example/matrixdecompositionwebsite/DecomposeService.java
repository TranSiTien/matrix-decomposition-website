package com.example.matrixdecompositionwebsite;
import com.example.matrixdecompositionwebsite.DTO.CholeskyDTO;
import com.example.matrixdecompositionwebsite.DTO.LdlDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecomposeService {
    public static CholeskyDTO decomposeByCholesky(CholeskyDTO choleskyDTO) {

        MatrixDecomposition matrixDecomposition = new MatrixDecomposition(new CholeskyDecompositor()
                ,choleskyDTO.getMatrix(), choleskyDTO.getRows(), choleskyDTO.getColumns());
            List<Integer[][]> factors = matrixDecomposition.decompose();
            choleskyDTO.setLowerTriangularMatrix(factors.get(0));
            choleskyDTO.setUpperTriangularMatrix(factors.get(1));
        return choleskyDTO;
    }
    public static LdlDTO decomposeByLdl(LdlDTO ldlDTO) {
        MatrixDecomposition matrixDecomposition = new MatrixDecomposition(new LdlDecompositor()
                ,ldlDTO.getMatrix(), ldlDTO.getRows(), ldlDTO.getColumns());
            List<Integer[][]> factors = matrixDecomposition.decompose();
            ldlDTO.setLowerTriangularMatrix(factors.get(0));
            ldlDTO.setDiagonalMatrix(factors.get(1));
            ldlDTO.setUpperTriangularMatrix(factors.get(2));
        return ldlDTO;
    }
}
