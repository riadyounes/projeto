package com.hotel.projeto.services;


import com.hotel.projeto.modal.Funcionario;
import com.hotel.projeto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Optional<Funcionario> show(long id) {
        return funcionarioRepository.findById(id);
    }
    public List<Funcionario> index() {
        return funcionarioRepository.findAll();
    }
    public Funcionario store(Funcionario funcionario) {

        return funcionarioRepository.save(funcionario);
    }
}
