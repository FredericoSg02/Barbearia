package com.barbearia.domains.enums;

public enum Status {
    NAODISPONIVEL(0,"NÃO DISPONÍVEL"), DISPONIVEL(1,"DISPONÍVEL");

    private Integer id;
    private String situacao;

    Status(Integer id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }


    public static Status toEnum(Integer id) {
        if (id == null) return null;
        for (Status x : Status.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Status inválido");
    }

}