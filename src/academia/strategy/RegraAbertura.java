package academia.strategy;

/** STRATEGY: cada regra é um algoritmo intercambiável para abrir um portal. */
public interface RegraAbertura {
    boolean permite(long numero);
    String nome();
}
