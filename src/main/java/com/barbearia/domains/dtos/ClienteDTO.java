package com.barbearia.domains.dtos;

import com.barbearia.domains.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteDTO {
    private Integer idCliente;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo telefone não pode ser nulo!")
    @NotBlank(message = "O campo telefone não pode ser vazio!")
    private String telefone;

    @NotNull(message = "O campo email não pode ser nulo!")
    @NotBlank(message = "O campo email não pode ser vazio!")
    private String email;

    @NotNull(message = "O campo cpf não pode ser nulo!")
    @NotBlank(message = "O campo cpf não pode ser vazio!")
    private String cpf;


    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo telefone não pode ser nulo!") @NotBlank(message = "O campo telefone não pode ser vazio!") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull(message = "O campo telefone não pode ser nulo!") @NotBlank(message = "O campo telefone não pode ser vazio!") String telefone) {
        this.telefone = telefone;
    }

    public @NotNull(message = "O campo email não pode ser nulo!") @NotBlank(message = "O campo email não pode ser vazio!") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "O campo email não pode ser nulo!") @NotBlank(message = "O campo email não pode ser vazio!") String email) {
        this.email = email;
    }

    public @NotNull(message = "O campo cpf não pode ser nulo!") @NotBlank(message = "O campo cpf não pode ser vazio!") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo cpf não pode ser nulo!") @NotBlank(message = "O campo cpf não pode ser vazio!") String cpf) {
        this.cpf = cpf;
    }
}
