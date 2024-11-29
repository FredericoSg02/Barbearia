package com.barbearia.domains.dtos;

import com.barbearia.domains.Localidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LocalidadeDTO {

    private Integer idLocalidade;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo endereço não pode ser nulo!")
    @NotBlank(message = "O campo endereço não pode ser vazio!")
    private String endereco;

    @NotNull(message = "O campo cidade não pode ser nulo!")
    @NotBlank(message = "O campo cidade não pode ser vazio!")
    private String cidade;

    public LocalidadeDTO() {
    }

    public LocalidadeDTO(Localidade localidade) {
        this.idLocalidade = localidade.getIdLocalidade();
        this.nome = localidade.getNome();
        this.endereco = localidade.getEndereco();
        this.cidade = localidade.getCidade();
    }

    public Integer getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Integer idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo endereço não pode ser nulo!") @NotBlank(message = "O campo endereço não pode ser vazio!") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull(message = "O campo endereço não pode ser nulo!") @NotBlank(message = "O campo endereço não pode ser vazio!") String endereco) {
        this.endereco = endereco;
    }

    public @NotNull(message = "O campo cidade não pode ser nulo!") @NotBlank(message = "O campo cidade não pode ser vazio!") String getCidade() {
        return cidade;
    }

    public void setCidade(@NotNull(message = "O campo cidade não pode ser nulo!") @NotBlank(message = "O campo cidade não pode ser vazio!") String cidade) {
        this.cidade = cidade;
    }

}
