package academia.chain;

public class ValidadorPositivo extends ValidadorTentativa {
    @Override protected boolean rejeita(long numero) { return numero <= 0; }
}
