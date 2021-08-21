package com.hotel.projeto.modal;

import com.hotel.projeto.enums.ProjetoClassificacao;
import com.hotel.projeto.enums.ProjetoEstado;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  nome;

    private LocalDate dataInicio;

    private String gerenteResposavel;

    private LocalDate previsaoTermino;

    private LocalDate dataTermino;

    private Float orcarmentoTotal;

    private String descricao;

    private ProjetoEstado estado;

    private ProjetoClassificacao classificacao;

    @OneToMany
    private final List<Funcionario> funcionarioList = new ArrayList<>();


    public Projeto(Long id,String nome, LocalDate dataInicio, String gerenteResposavel, LocalDate previsaoTermino, LocalDate dataTermino, Float orcarmentoTotal, String descricao, ProjetoEstado estado, ProjetoClassificacao classificacao, Funcionario funcionario) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.gerenteResposavel = gerenteResposavel;
        this.previsaoTermino = previsaoTermino;
        this.dataTermino = dataTermino;
        this.orcarmentoTotal = orcarmentoTotal;
        this.descricao = descricao;
        this.estado = estado;
        this.classificacao = classificacao;

    }

    public Projeto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public ProjetoClassificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ProjetoClassificacao classificacao) {
        this.classificacao = classificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getGerenteResposavel() {
        return gerenteResposavel;
    }

    public void setGerenteResposavel(String gerenteResposavel) {
        this.gerenteResposavel = gerenteResposavel;
    }

    public LocalDate getPrevisaoTermino() {
        return previsaoTermino;
    }

    public void setPrevisaoTermino(LocalDate previsaoTermino) {
        this.previsaoTermino = previsaoTermino;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Float getOrcarmentoTotal() {
        return orcarmentoTotal;
    }

    public void setOrcarmentoTotal(Float orcarmentoTotal) {
        this.orcarmentoTotal = orcarmentoTotal;
    }



    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ProjetoEstado getEstado() {
        return estado;
    }

    public void setEstado(ProjetoEstado estado) {
        this.estado = estado;
    }


}
