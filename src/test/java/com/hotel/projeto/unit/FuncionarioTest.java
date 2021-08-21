package com.hotel.projeto.unit;



import com.hotel.projeto.modal.Funcionario;
import com.hotel.projeto.services.FuncionarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class FuncionarioTest {

    @Autowired
    private FuncionarioService funcionarioService;

    @Test
    void store() {

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Riad");
        funcionario.setCargo("adm");

        Funcionario resutdb = funcionarioService.store(funcionario);
        Assertions.assertEquals(funcionario, resutdb);
    }

    @Test
    void show() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("riad");
        funcionario.setCargo("adm");

        funcionarioService.store(funcionario);

        Optional<Funcionario> result = funcionarioService.show(funcionario.getId());
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    void index() {
        List<Funcionario> before = funcionarioService.index();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("riad");
        funcionario.setCargo("adm");

        funcionarioService.store(funcionario);

        Funcionario funcionario2 = new Funcionario();
        funcionario2.setNome("ismail");
        funcionario2.setCargo("rh");

        funcionarioService.store(funcionario2);

        List<Funcionario> after = funcionarioService.index();
        Assertions.assertEquals(after.size(), before.size() + 2);
    }
}
