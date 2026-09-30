package academia.chain;

public class ValidadorLimite extends ValidadorTentativa {
    private final long maximo;

    public ValidadorLimite(long maximo) { this.maximo = maximo; }

    @Override protected boolean rejeita(long numero) { return numero > maximo; }
}
