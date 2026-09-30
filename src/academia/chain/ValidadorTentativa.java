package academia.chain;

import academia.model.Resultado;

/**
 * CHAIN OF RESPONSIBILITY: cada elo decide se rejeita a tentativa;
 * se não rejeitar, repassa ao próximo. Retorna null se ninguém rejeitou.
 */
public abstract class ValidadorTentativa {
    private ValidadorTentativa proximo;

    public ValidadorTentativa encadear(ValidadorTentativa proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public Resultado validar(long numero) {
        if (rejeita(numero)) return Resultado.INVALID;
        return proximo == null ? null : proximo.validar(numero);
    }

    protected abstract boolean rejeita(long numero);
}
