package br.com.esg.cidades.controller;

import br.com.esg.cidades.model.Cidade;
import br.com.esg.cidades.service.CidadeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidades")
@CrossOrigin(origins = "*")
public class CidadeController {
    private final CidadeService service;

    public CidadeController(CidadeService service) { this.service = service; }

    @GetMapping
    public List<Cidade> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Cidade buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade criar(@Valid @RequestBody Cidade cidade) { return service.salvar(cidade); }

    @PutMapping("/{id}")
    public Cidade atualizar(@PathVariable Long id, @Valid @RequestBody Cidade cidade) { return service.atualizar(id, cidade); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
