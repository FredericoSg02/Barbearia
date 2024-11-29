package com.barbearia.domains.dtos;

import com.barbearia.domains.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ServicoDTO {

    private Integer idServico;

    @NotNull(message = "O campo idAgendamento não pode ser nulo!")
    private Integer agendamento;

    @NotNull(message = "O campo descricao não pode ser nulo!")
    @NotBlank(message = "O campo descricao não pode ser vazio!")
    private String descricao;

    @NotNull(message = "O campo duracao não pode ser nulo!")
    @Digits(integer = 3, fraction = 0)
    private Integer duracao;

    @JsonFormat(pattern = "HH:mm dd/MM/yyyy")
    private LocalDateTime dataHora;

    @NotNull(message = "O campo barbeiro é requerido!")
    private int barbeiro;

    @NotNull(message = "O campo cliente é requerido!")
    private int cliente;

    private int localidade;

    private int status;

    private int avaliacao;

    public ServicoDTO() {

    }

    public ServicoDTO(Servico servico) {
        this.idServico = servico.getIdServico();
        this.agendamento = servico.getAgendamento();
        this.descricao = servico.getDescricao();
        this.duracao = servico.getDuracao();
        this.dataHora = servico.getDataHora();
        this.barbeiro = servico.getBarbeiro().getIdBarbeiro();
        this.cliente = servico.getCliente().getIdCliente();
        this.localidade = servico.getLocalidade().getIdLocalidade();
        this.status = servico.getStatus().getId();
        this.avaliacao = servico.getAvaliacao().getId();
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public @NotNull(message = "O campo idAgendamento não pode ser nulo!") Integer getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(@NotNull(message = "O campo idAgendamento não pode ser nulo!") Integer agendamento) {
        this.agendamento = agendamento;
    }

    public @NotNull(message = "O campo descricao não pode ser nulo!") @NotBlank(message = "O campo descricao não pode ser vazio!") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descricao não pode ser nulo!") @NotBlank(message = "O campo descricao não pode ser vazio!") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "O campo duracao não pode ser nulo!") @Digits(integer = 3, fraction = 0) Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(@NotNull(message = "O campo duracao não pode ser nulo!") @Digits(integer = 3, fraction = 0) Integer duracao) {
        this.duracao = duracao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @NotNull(message = "O campo barbeiro é requerido!")
    public int getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(@NotNull(message = "O campo barbeiro é requerido!") int barbeiro) {
        this.barbeiro = barbeiro;
    }

    @NotNull(message = "O campo cliente é requerido!")
    public int getCliente() {
        return cliente;
    }

    public void setCliente(@NotNull(message = "O campo cliente é requerido!") int cliente) {
        this.cliente = cliente;
    }

    public int getLocalidade() {
        return localidade;
    }

    public void setLocalidade(int localidade) {
        this.localidade = localidade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
}
