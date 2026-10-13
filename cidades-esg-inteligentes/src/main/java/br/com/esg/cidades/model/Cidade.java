package br.com.esg.cidades.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "cidades")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String estado;

    @DecimalMin("0.0") @DecimalMax("100.0")
    private double indiceSustentabilidade;

    @PositiveOrZero
    private double emissaoCo2;

    @DecimalMin("0.0") @DecimalMax("100.0")
    private double energiaRenovavelPercentual;

    @DecimalMin("0.0") @DecimalMax("100.0")
    private double reciclagemPercentual;

    public Cidade() {}

    public Cidade(String nome, String estado, double indiceSustentabilidade, double emissaoCo2,
                  double energiaRenovavelPercentual, double reciclagemPercentual) {
        this.nome = nome;
        this.estado = estado;
        this.indiceSustentabilidade = indiceSustentabilidade;
        this.emissaoCo2 = emissaoCo2;
        this.energiaRenovavelPercentual = energiaRenovavelPercentual;
        this.reciclagemPercentual = reciclagemPercentual;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public double getIndiceSustentabilidade() { return indiceSustentabilidade; }
    public void setIndiceSustentabilidade(double indiceSustentabilidade) { this.indiceSustentabilidade = indiceSustentabilidade; }
    public double getEmissaoCo2() { return emissaoCo2; }
    public void setEmissaoCo2(double emissaoCo2) { this.emissaoCo2 = emissaoCo2; }
    public double getEnergiaRenovavelPercentual() { return energiaRenovavelPercentual; }
    public void setEnergiaRenovavelPercentual(double energiaRenovavelPercentual) { this.energiaRenovavelPercentual = energiaRenovavelPercentual; }
    public double getReciclagemPercentual() { return reciclagemPercentual; }
    public void setReciclagemPercentual(double reciclagemPercentual) { this.reciclagemPercentual = reciclagemPercentual; }
}
