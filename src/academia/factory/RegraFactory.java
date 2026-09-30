package academia.factory;

import academia.strategy.*;

/** FACTORY: centraliza a criação das regras a partir de um nome. */
public final class RegraFactory {
    private RegraFactory() {}

    public static RegraAbertura criar(String tipo) {
        if (tipo == null) throw new IllegalArgumentException("Tipo de regra nulo");
        String t = tipo.trim().toLowerCase();
        if (t.equals("par")) return new NumeroPar();
        if (t.startsWith("multiplo-de-")) {
            return new MultiploDe(Long.parseLong(t.substring("multiplo-de-".length())));
        }
        throw new IllegalArgumentException("Regra desconhecida: " + tipo);
    }
}
