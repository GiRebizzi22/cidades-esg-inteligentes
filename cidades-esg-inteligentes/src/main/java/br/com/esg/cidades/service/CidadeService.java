package br.com.esg.cidades.service;

import br.com.esg.cidades.model.Cidade;
import br.com.esg.cidades.repository.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {
    private final CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    public List<Cidade> listar() { return repository.findAll(); }
    public Cidade buscar(Long id) { return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cidade não encontrada")); }
    public Cidade salvar(Cidade cidade) { return repository.save(cidade); }
    public Cidade atualizar(Long id, Cidade cidade) {
        Cidade atual = buscar(id);
        atual.setNome(cidade.getNome());
        atual.setEstado(cidade.getEstado());
        atual.setIndiceSustentabilidade(cidade.getIndiceSustentabilidade());
        atual.setEmissaoCo2(cidade.getEmissaoCo2());
        atual.setEnergiaRenovavelPercentual(cidade.getEnergiaRenovavelPercentual());
        atual.setReciclagemPercentual(cidade.getReciclagemPercentual());
        return repository.save(atual);
    }
    public void excluir(Long id) { repository.deleteById(id); }
}
