package com.barbearia.domains;


import com.barbearia.domains.dtos.LocalidadeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "localidade")
public class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cliente")
    private Integer idLocalidade;

    @NotBlank @NotNull
    private String nome;

    @NotBlank @NotNull
    private String endereco;

    @NotBlank @NotNull
    private String cidade;

    @JsonIgnore
    @OneToMany(mappedBy = "localidade")
    private List<Servico> servicos = new ArrayList<>();


    public Localidade() {
    }

    public Localidade(Integer idLocalidade, String nome, String endereco, String cidade) {
        this.idLocalidade = idLocalidade;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    public Localidade(LocalidadeDTO dto) {
        this.idLocalidade = dto.getIdLocalidade();
        this.nome = dto.getNome();
        this.endereco = dto.getEndereco();
        this.cidade = dto.getCidade();
    }

    public Integer getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Integer idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public @NotBlank @NotNull String getNome() {
        return nome;
    }

    public void setNome(@NotBlank @NotNull String nome) {
        this.nome = nome;
    }

    public @NotBlank @NotNull String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotBlank @NotNull String endereco) {
        this.endereco = endereco;
    }

    public @NotBlank @NotNull String getCidade() {
        return cidade;
    }

    public void setCidade(@NotBlank @NotNull String cidade) {
        this.cidade = cidade;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidade that = (Localidade) o;
        return Objects.equals(idLocalidade, that.idLocalidade) && Objects.equals(nome, that.nome) && Objects.equals(endereco, that.endereco) && Objects.equals(cidade, that.cidade) && Objects.equals(servicos, that.servicos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLocalidade, nome, endereco, cidade, servicos);
    }
}
