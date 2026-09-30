package academia.builder;

import academia.model.Portal;
import academia.strategy.MultiploDe;
import academia.strategy.RegraAbertura;

/** BUILDER: monta o Portal passo a passo, com valores padrão. */
public class PortalBuilder {
    private long numero;
    private RegraAbertura regra = new MultiploDe(3);
    private String descricao = "Portal de treinamento";

    public PortalBuilder numero(long numero) { this.numero = numero; return this; }
    public PortalBuilder regra(RegraAbertura regra) { this.regra = regra; return this; }
    public PortalBuilder descricao(String descricao) { this.descricao = descricao; return this; }

    public Portal build() { return new Portal(numero, regra, descricao); }
}
