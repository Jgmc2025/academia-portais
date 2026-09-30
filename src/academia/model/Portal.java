package academia.model;

import academia.strategy.RegraAbertura;

public class Portal {
    private final long numero;
    private final RegraAbertura regra;
    private final String descricao;

    public Portal(long numero, RegraAbertura regra, String descricao) {
        this.numero = numero;
        this.regra = regra;
        this.descricao = descricao;
    }

    public long getNumero() { return numero; }
    public RegraAbertura getRegra() { return regra; }
    public String getDescricao() { return descricao; }
}
