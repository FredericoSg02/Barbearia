package com.barbearia.domains.dtos;

import com.barbearia.domains.Barbeiro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BarbeiroDTO {


    private Integer idBarbeiro;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo especialidade não pode ser nulo!")
    @NotBlank(message = "O campo especialidade não pode ser vazio!")
    private String especialidade;

    @NotNull(message = "O campo cpf não pode ser nulo!")
    @NotBlank(message = "O campo cpf não pode ser vazio!")
    private String cpf;

    public BarbeiroDTO() {

    }
    public BarbeiroDTO(Barbeiro barbeiro) {
        this.idBarbeiro = barbeiro.getIdBarbeiro();
        this.nome = barbeiro.getNome();
        this.especialidade = barbeiro.getEspecialidade();
        this.cpf = barbeiro.getCpf();
    }

    public Integer getIdBarbeiro() {
        return idBarbeiro;
    }

    public void setIdBarbeiro(Integer idBarbeiro) {
        this.idBarbeiro = idBarbeiro;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo especialidade não pode ser nulo!") @NotBlank(message = "O campo especialidade não pode ser vazio!") String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(@NotNull(message = "O campo especialidade não pode ser nulo!") @NotBlank(message = "O campo especialidade não pode ser vazio!") String especialidade) {
        this.especialidade = especialidade;
    }

    public @NotNull(message = "O campo cpf não pode ser nulo!") @NotBlank(message = "O campo cpf não pode ser vazio!") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo cpf não pode ser nulo!") @NotBlank(message = "O campo cpf não pode ser vazio!") String cpf) {
        this.cpf = cpf;
    }

}
