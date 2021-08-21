package com.hotel.projeto.services;


import com.hotel.projeto.enums.ProjetoClassificacao;
import com.hotel.projeto.enums.ProjetoEstado;
import com.hotel.projeto.modal.Projeto;
import com.hotel.projeto.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public void destroy(Long id) {
        Optional<Projeto> optionalReserva = this.show(id);

        if (optionalReserva.isPresent()) {
            projetoRepository.deleteById(id);
        }
    }

    public Optional<Projeto> show(long id) {
        return projetoRepository.findById(id);
    }
    public Projeto store(Projeto projeto) {
        projeto.setEstado(ProjetoEstado.EM_ANALISE);
        return projetoRepository.save(projeto);
    }

    public Projeto update(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> index() {
        return projetoRepository.findAll();
    }

    public Projeto analiseRealizada(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrada!!!"));



        if (projeto.getEstado().equals(ProjetoEstado.EM_ANALISE)) {
            throw new RuntimeException("Projeto já em analise!!!");
        }

        projeto.setEstado(ProjetoEstado.EM_ANALISE);

        return projetoRepository.save(projeto);
    }


    public Projeto analiseAprovada(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("projeto não encontrada!!!"));


        if (projeto.getEstado().equals(ProjetoEstado.ANALISE_APROVADA)) {
            throw new RuntimeException("Projeto já esta em analise de aprovacao!!!");
        }

        projeto.setEstado(ProjetoEstado.ANALISE_REALIZADA);

        return projetoRepository.save(projeto);
    }
    public Projeto iniciado(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("projeto não encontrada!!!"));


        if (projeto.getEstado().equals(ProjetoEstado.INICIADO)) {
            throw new RuntimeException("Projeto já esta iniciado!!!");
        }

        projeto.setEstado(ProjetoEstado.ANALISE_REALIZADA);

        return projetoRepository.save(projeto);
    }
    public Projeto planejado(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("projeto não encontrada!!!"));


        if (projeto.getEstado().equals(ProjetoEstado.PLANEJADO)) {
            throw new RuntimeException("Projeto já esta planejado!!!");
        }

        projeto.setEstado(ProjetoEstado.PLANEJADO);

        return projetoRepository.save(projeto);
    }
    public Projeto emAndamento(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("projeto não encontrada!!!"));


        if (projeto.getEstado().equals(ProjetoEstado.EM_ANDAMENTO)) {
            throw new RuntimeException("Projeto já esta em andamendo!!!");
        }

        projeto.setEstado(ProjetoEstado.EM_ANDAMENTO);

        return projetoRepository.save(projeto);
    }
    public Projeto encerrado(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("projeto não encontrada!!!"));


        if (projeto.getEstado().equals(ProjetoEstado.ENCERRADO)) {
            throw new RuntimeException("Projeto já esta em encerrado!!!");
        }

        projeto.setEstado(ProjetoEstado.ENCERRADO);

        return projetoRepository.save(projeto);
    }
    public Projeto cancelado(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("projeto não encontrada!!!"));


        if (projeto.getEstado().equals(ProjetoEstado.CANCELADO)) {
            throw new RuntimeException("Projeto já esta em cancelado!!!");
        }

        projeto.setEstado(ProjetoEstado.CANCELADO);

        return projetoRepository.save(projeto);
    }

    public Projeto baixoRisco(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("projeto não encontrada!!!"));


        if (projeto.getClassificacao().equals(ProjetoClassificacao.BAIXO_RISCO)) {
            throw new RuntimeException("Projeto já esta em baixo risco!!!");
        }

        projeto.setClassificacao(ProjetoClassificacao.BAIXO_RISCO);

        return projetoRepository.save(projeto);
    }
    public Projeto medioRisco(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("projeto não encontrada!!!"));


        if (projeto.getClassificacao().equals(ProjetoClassificacao.MEDIO_RISCO)) {
            throw new RuntimeException("Projeto já esta em medio risco!!!");
        }

        projeto.setClassificacao(ProjetoClassificacao.MEDIO_RISCO);

        return projetoRepository.save(projeto);
    }
    public Projeto altoRisco(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("projeto não encontrada!!!"));


        if (projeto.getClassificacao().equals(ProjetoClassificacao.ALTO_RISCO)) {
            throw new RuntimeException("Projeto já esta em alto risco!!!");
        }

        projeto.setClassificacao(ProjetoClassificacao.ALTO_RISCO);

        return projetoRepository.save(projeto);
    }
}
