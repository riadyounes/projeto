package com.hotel.projeto.controller;

import com.hotel.projeto.modal.Projeto;
import com.hotel.projeto.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    @Autowired
    public ProjetoController( ProjetoService projetoService) {
        this.projetoService = projetoService;

    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Projeto>> show(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.show(id));
    }
    @GetMapping
    public ResponseEntity<List<Projeto>> index() {
        return ResponseEntity.ok(projetoService.index());
    }
    @PostMapping
    public ResponseEntity<Projeto> store( @RequestBody Projeto projeto) {
        return ResponseEntity.ok(projetoService.store(projeto));
    }
    @PostMapping("{id}/analiseRealizada")
    public ResponseEntity<Projeto> analiseRealizada(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.analiseRealizada(id));
    }
    @PostMapping("{id}/analiseAprovada")
    public ResponseEntity<Projeto> analiseAprovada(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.analiseAprovada(id));
    }
    @PostMapping("{id}/planejado")
    public ResponseEntity<Projeto> planejado(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.planejado(id));
    }

    @PostMapping("{id}/iniciado")
    public ResponseEntity<Projeto> iniciado(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.iniciado(id));
    }
    @PostMapping("{id}/em-andamendo")
    public ResponseEntity<Projeto> emAndamento(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.emAndamento(id));
    }

    @PostMapping("{id}/encerrado")
    public ResponseEntity<Projeto> encerrado(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.encerrado(id));
    }

    @PostMapping("{id}/cancelado")
    public ResponseEntity<Projeto> cancelado(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.cancelado(id));
    }

    @PostMapping("{id}/baixo-risco")
    public ResponseEntity<Projeto> baixoRisco(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.baixoRisco(id));
    }
    @PostMapping("{id}/medio-risco")
    public ResponseEntity<Projeto> medioRisco(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.medioRisco(id));
    }
    @PostMapping("{id}/alto-risco")
    public ResponseEntity<Projeto> altoRisco(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.altoRisco(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Projeto> update(@PathVariable Long id, @RequestBody Projeto projeto) {
        Optional<Projeto> optionalReserva = projetoService.show(id);

        if (optionalReserva.isPresent()) {
            return ResponseEntity.ok(projetoService.update(projeto));
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Projeto> destroy(@PathVariable Long id) {
        projetoService.destroy(id);
        return ResponseEntity.ok(null);
    }
}
