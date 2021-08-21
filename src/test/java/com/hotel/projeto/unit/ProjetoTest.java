package com.hotel.projeto.unit;


import com.hotel.projeto.enums.ProjetoClassificacao;
import com.hotel.projeto.enums.ProjetoEstado;
import com.hotel.projeto.modal.Projeto;
import com.hotel.projeto.services.ProjetoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class ProjetoTest {

    @Autowired
    private ProjetoService projetoService;

    @Test
    void store() {

        Projeto projeto = new Projeto();
        projeto.setNome("teste");
        projeto.setDataInicio(LocalDate.of(2021, 8, 21));
        projeto.setDataTermino(LocalDate.of(2021, 9, 29));
        projeto.setPrevisaoTermino(LocalDate.of(2021, 9, 22));
        projeto.setEstado(ProjetoEstado.EM_ANALISE);
        projeto.setClassificacao(ProjetoClassificacao.ALTO_RISCO);
        projeto.setDescricao("projeto da X");
        projeto.setGerenteResposavel("Riad");
        projeto.setOrcarmentoTotal(124.34F);


        Projeto result = projetoService.store(projeto);
        Assertions.assertEquals(projeto, result);
    }

    @Test
    void index() {
        List<Projeto> before = projetoService.index();

        Projeto projeto = new Projeto();
        projeto.setNome("teste");
        projeto.setDataInicio(LocalDate.of(2021, 8, 21));
        projeto.setDataTermino(LocalDate.of(2021, 9, 29));
        projeto.setPrevisaoTermino(LocalDate.of(2021, 9, 22));
        projeto.setEstado(ProjetoEstado.EM_ANALISE);
        projeto.setClassificacao(ProjetoClassificacao.ALTO_RISCO);
        projeto.setDescricao("projeto da X");
        projeto.setGerenteResposavel("Riad 2222");
        projeto.setOrcarmentoTotal(124.34F);

        Projeto result = projetoService.store(projeto);

        Projeto projeto2 = new Projeto();
        projeto2.setNome("teste2");
        projeto2.setDataInicio(LocalDate.of(2021, 8, 21));
        projeto2.setDataTermino(LocalDate.of(2021, 9, 29));
        projeto2.setPrevisaoTermino(LocalDate.of(2021, 9, 22));
        projeto2.setEstado(ProjetoEstado.EM_ANALISE);
        projeto2.setClassificacao(ProjetoClassificacao.BAIXO_RISCO);
        projeto2.setDescricao("projeto da 2");
        projeto2.setGerenteResposavel("ismail 22222");
        projeto2.setOrcarmentoTotal(124.34F);

        Projeto result2 = projetoService.store(projeto2);


        List<Projeto> after = projetoService.index();
        Assertions.assertEquals(after.size(), before.size() + 2);
    }

    @Test
    void update() {


        Projeto projeto = new Projeto();
        projeto.setNome("teste2");
        projeto.setDataInicio(LocalDate.of(2021, 8, 21));
        projeto.setDataTermino(LocalDate.of(2021, 9, 29));
        projeto.setPrevisaoTermino(LocalDate.of(2021, 9, 22));
        projeto.setEstado(ProjetoEstado.EM_ANALISE);
        projeto.setClassificacao(ProjetoClassificacao.BAIXO_RISCO);
        projeto.setDescricao("projeto da 2");
        projeto.setGerenteResposavel("ismail");
        projeto.setOrcarmentoTotal(124.34F);

        Projeto result2 = projetoService.store(projeto);
        projeto.setDataTermino(LocalDate.of(2021, 10, 8));

        Projeto update = projetoService.update(result2);
        Assertions.assertEquals(result2.getDataTermino(), update.getDataTermino());
    }

    @Test
    void encerramento() {


        Projeto projeto = new Projeto();
        projeto.setNome("teste2");
        projeto.setDataInicio(LocalDate.of(2021, 8, 21));
        projeto.setDataTermino(LocalDate.of(2021, 9, 29));
        projeto.setPrevisaoTermino(LocalDate.of(2021, 9, 22));
        projeto.setEstado(ProjetoEstado.EM_ANALISE);
        projeto.setClassificacao(ProjetoClassificacao.BAIXO_RISCO);
        projeto.setDescricao("projeto da 2");
        projeto.setGerenteResposavel("ismail");
        projeto.setOrcarmentoTotal(124.34F);

        Projeto result2 = projetoService.store(projeto);
        Projeto encerrado = projetoService.encerrado(result2.getId());

        Assertions.assertNotEquals(result2.getEstado(), encerrado.getEstado());
    }
    @Test
    void destroy() {
        List<Projeto> before = projetoService.index();

        Projeto projeto = new Projeto();
        projeto.setNome("teste");
        projeto.setDataInicio(LocalDate.of(2021, 8, 21));
        projeto.setDataTermino(LocalDate.of(2021, 9, 29));
        projeto.setPrevisaoTermino(LocalDate.of(2021, 9, 22));
        projeto.setEstado(ProjetoEstado.EM_ANALISE);
        projeto.setClassificacao(ProjetoClassificacao.ALTO_RISCO);
        projeto.setDescricao("projeto da X");
        projeto.setGerenteResposavel("Riad");
        projeto.setOrcarmentoTotal(124.34F);

        Projeto result = projetoService.store(projeto);

        result.setId(result.getId());
        projetoService.destroy(result.getId());

        List<Projeto> after = projetoService.index();
        Assertions.assertEquals(after.size(), before.size());
    }

}
