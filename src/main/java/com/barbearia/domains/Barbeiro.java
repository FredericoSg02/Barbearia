package com.barbearia.domains;


import com.barbearia.domains.dtos.BarbeiroDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "barbeiro")
public class Barbeiro {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_barbeiro")
    private Integer idBarbeiro;

    @NotNull @NotBlank
    private String nome;

    @NotNull @NotBlank
    private String especialidade;

    @NotNull @NotBlank
    @Column(unique = true)
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "barbeiro")
    private List<Servico> servicos = new ArrayList<>();

    public Barbeiro() {
    }

    public Barbeiro(Integer idBarbeiro, String nome, String especialidade, String cpf) {
        this.idBarbeiro = idBarbeiro;
        this.nome = nome;
        this.especialidade = especialidade;
        this.cpf = cpf;
    }

    public Barbeiro(BarbeiroDTO dto) {
        this.idBarbeiro = dto.getIdBarbeiro();
        this.nome = dto.getNome();
        this.especialidade = dto.getEspecialidade();
        this.cpf = dto.getCpf();
    }

    public Integer getIdBarbeiro() {
        return idBarbeiro;
    }

    public void setIdBarbeiro(Integer idBarbeiro) {
        this.idBarbeiro = idBarbeiro;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @NotBlank String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(@NotNull @NotBlank String especialidade) {
        this.especialidade = especialidade;
    }

    public @NotNull @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull @NotBlank String cpf) {
        this.cpf = cpf;
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
        Barbeiro barbeiro = (Barbeiro) o;
        return Objects.equals(idBarbeiro, barbeiro.idBarbeiro) && Objects.equals(nome, barbeiro.nome) && Objects.equals(especialidade, barbeiro.especialidade) && Objects.equals(cpf, barbeiro.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBarbeiro, nome, especialidade, cpf);
    }

}
