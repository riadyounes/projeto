package com.hotel.projeto.repository;


import com.hotel.projeto.modal.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
