package com.example.matrixdecompositionwebsite.controllers;


import com.example.matrixdecompositionwebsite.DTO.CholeskyDTO;
import com.example.matrixdecompositionwebsite.DTO.LdlDTO;
import com.example.matrixdecompositionwebsite.DecomposeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {
    @GetMapping()
    public String home(Model model) {
        model.addAttribute("choleskyDTO", new CholeskyDTO());
        model.addAttribute("ldlDTO", new LdlDTO());
        return "index";
    }
    @PostMapping("/api/decompose-by-cholesky")
    public ResponseEntity<CholeskyDTO> decomposeByCholesky(@RequestBody CholeskyDTO choleskyDTO) {
        try {
            choleskyDTO = DecomposeService.decomposeByCholesky(choleskyDTO);
            return ResponseEntity.ok(choleskyDTO);
        }
        catch (IllegalArgumentException e) {
            choleskyDTO.setErrorMessages(e.getMessage());
            return ResponseEntity.ok(choleskyDTO);
        }

    }
    @PostMapping("/api/decompose-by-ldl")
    public ResponseEntity<LdlDTO> decomposeByLdl(@RequestBody LdlDTO ldlDTO) {
        try {
            ldlDTO = DecomposeService.decomposeByLdl(ldlDTO);
            return ResponseEntity.ok(ldlDTO);
        }
        catch (IllegalArgumentException e) {
            ldlDTO.setErrorMessages(e.getMessage());
            return ResponseEntity.ok(ldlDTO);
        }
    }

}
