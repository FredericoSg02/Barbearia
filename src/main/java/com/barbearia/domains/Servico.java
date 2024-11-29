package com.barbearia.domains;


import com.barbearia.domains.dtos.ServicoDTO;
import com.barbearia.domains.enums.Avaliacao;
import com.barbearia.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_servico")
    private Integer idServico;

    @NotNull
    @Column(unique = true)
    private Integer agendamento;

    @NotBlank @NotNull
    private String descricao;

    @NotNull
    @Digits(integer = 3, fraction = 0)
    private Integer duracao;

    @JsonFormat(pattern = "HH:mm dd/MM/yyyy")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name="idbarbeiro")
    private Barbeiro barbeiro;

    @ManyToOne
    @JoinColumn(name="idcliente")
    private Cliente  cliente;

    @ManyToOne
    @JoinColumn(name="idlocalidade")
    private Localidade localidade;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    private Avaliacao avaliacao;


    public Servico() {
    }

    public Servico(Integer idServico, Integer agendamento, String descricao, Integer duracao, LocalDateTime dataHora, Barbeiro barbeiro, Cliente cliente, Localidade localidade, Status status, Avaliacao avaliacao) {
        this.idServico = idServico;
        this.agendamento = agendamento;
        this.descricao = descricao;
        this.duracao = duracao;
        this.dataHora = dataHora;
        this.barbeiro = barbeiro;
        this.cliente = cliente;
        this.localidade = localidade;
        this.status = status;
        this.avaliacao = avaliacao;
    }

    public Servico(ServicoDTO dto) {
        this.idServico = dto.getIdServico();
        this.agendamento = dto.getAgendamento();
        this.descricao = dto.getDescricao();
        this.duracao = dto.getDuracao();
        this.dataHora = dto.getDataHora();
        this.barbeiro = new Barbeiro();
        this.barbeiro.setIdBarbeiro(dto.getBarbeiro());
        this.cliente = new Cliente();
        this.cliente.setIdCliente(dto.getCliente());
        this.localidade = new Localidade();
        this.localidade.setIdLocalidade(dto.getLocalidade());
        this.status = Status.toEnum(dto.getStatus());
        this.avaliacao = Avaliacao.toEnum(dto.getAvaliacao());
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public @NotNull Integer getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(@NotNull Integer agendamento) {
        this.agendamento = agendamento;
    }

    public @NotBlank @NotNull String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank @NotNull String descricao) {
        this.descricao = descricao;
    }

    public @NotNull @Digits(integer = 3, fraction = 0) Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(@NotNull @Digits(integer = 3, fraction = 0) Integer duracao) {
        this.duracao = duracao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return Objects.equals(idServico, servico.idServico) && Objects.equals(agendamento, servico.agendamento) && Objects.equals(descricao, servico.descricao) && Objects.equals(duracao, servico.duracao) && Objects.equals(dataHora, servico.dataHora) && Objects.equals(barbeiro, servico.barbeiro) && Objects.equals(cliente, servico.cliente) && Objects.equals(localidade, servico.localidade) && status == servico.status && avaliacao == servico.avaliacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServico, agendamento, descricao, duracao, dataHora, barbeiro, cliente, localidade, status, avaliacao);
    }
}