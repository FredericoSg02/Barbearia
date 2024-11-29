package com.barbearia.domains.enums;

public enum Avaliacao {
    OTIMO(0,"OTIMO"),BOM(1,"BOM"),RUIM(2,"RUIM"),PESSIMO(3,"PESSIMO"),;

    private Integer id;
    private String situacao;

    Avaliacao() {
    }

    Avaliacao(Integer id, String situacao) {
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


    public static Avaliacao toEnum(Integer id) {
        if (id == null) return null;
        for (Avaliacao x : Avaliacao.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Conservacao inválida");
    }

}
