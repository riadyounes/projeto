package com.hotel.projeto.controller;


import com.hotel.projeto.modal.Funcionario;
import com.hotel.projeto.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;


    @Autowired
    public FuncionarioController( FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;

    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Funcionario>> show(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.show(id));
    }
    @GetMapping
    public ResponseEntity<List<Funcionario>> index() {
        return ResponseEntity.ok(funcionarioService.index());
    }

    @PostMapping
    public ResponseEntity<Funcionario> store( @RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.store(funcionario));
    }
}
