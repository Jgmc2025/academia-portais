package academia.facade;

import academia.builder.PortalBuilder;
import academia.chain.ValidadorLimite;
import academia.chain.ValidadorPositivo;
import academia.chain.ValidadorTentativa;
import academia.model.Portal;
import academia.model.Resultado;
import academia.observer.ObservadorTentativa;
import academia.singleton.EstatisticasAcademia;
import academia.strategy.RegraAbertura;

import java.util.ArrayList;
import java.util.List;

/**
 * FACADE: interface simples que esconde a cadeia de validação, o builder,
 * a estratégia e os observadores.
 */
public class VerificadorFacade {
    private final ValidadorTentativa cadeia;
    private final RegraAbertura regra;
    private final List<ObservadorTentativa> observadores = new ArrayList<>();

    public VerificadorFacade(RegraAbertura regra) {
        this.regra = regra;
        ValidadorTentativa inicio = new ValidadorPositivo();
        inicio.encadear(new ValidadorLimite(Long.MAX_VALUE));
        this.cadeia = inicio;
        adicionarObservador(EstatisticasAcademia.getInstance());
    }

    public void adicionarObservador(ObservadorTentativa o) { observadores.add(o); }

    public Resultado verificar(long numero) {
        Portal portal = new PortalBuilder().numero(numero).regra(regra).build();

        Resultado resultado = cadeia.validar(numero);
        if (resultado == null) {
            resultado = regra.permite(numero) ? Resultado.OPEN : Resultado.CLOSED;
        }

        for (ObservadorTentativa o : observadores) o.aoVerificar(portal, resultado);
        return resultado;
    }
}
