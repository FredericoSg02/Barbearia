package com.barbearia.domains;

import com.barbearia.domains.dtos.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cliente")
    private Integer idCliente;

    @NotBlank @NotNull
    private String nome;

    @NotBlank @NotNull
    @Column(unique = true)
    private String telefone;

    @NotBlank @NotNull
    @Column(unique = true)
    private String email;

    @NotBlank @NotNull
    @Column(unique = true)
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Servico> servicos = new ArrayList<>();

    public Cliente() {

    }

    public Cliente(Integer idCliente, String nome, String telefone, String email, String cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public Cliente(ClienteDTO dto) {
        this.idCliente = dto.getIdCliente();
        this.nome = dto.getNome();
        this.telefone = dto.getTelefone();
        this.email = dto.getEmail();
        this.cpf = dto.getCpf();
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public @NotBlank @NotNull String getNome() {
        return nome;
    }

    public void setNome(@NotBlank @NotNull String nome) {
        this.nome = nome;
    }

    public @NotBlank @NotNull String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank @NotNull String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @NotNull String email) {
        this.email = email;
    }

    public @NotBlank @NotNull String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank @NotNull String cpf) {
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
        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, cliente.idCliente) && Objects.equals(nome, cliente.nome) && Objects.equals(telefone, cliente.telefone) && Objects.equals(email, cliente.email) && Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nome, telefone, email, cpf);
    }

}
