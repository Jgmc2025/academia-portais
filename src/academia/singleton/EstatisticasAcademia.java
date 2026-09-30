package academia.singleton;

import academia.model.Portal;
import academia.model.Resultado;
import academia.observer.ObservadorTentativa;

import java.util.EnumMap;
import java.util.Map;

/** SINGLETON (holder idiom, thread-safe): uma única contagem global de resultados. */
public final class EstatisticasAcademia implements ObservadorTentativa {
    private final Map<Resultado, Integer> contagem = new EnumMap<>(Resultado.class);

    private EstatisticasAcademia() {
        for (Resultado r : Resultado.values()) contagem.put(r, 0);
    }

    private static class Holder {
        private static final EstatisticasAcademia INSTANCIA = new EstatisticasAcademia();
    }

    public static EstatisticasAcademia getInstance() { return Holder.INSTANCIA; }

    @Override
    public synchronized void aoVerificar(Portal portal, Resultado resultado) {
        contagem.merge(resultado, 1, Integer::sum);
    }

    public synchronized String resumo() {
        return "OPEN=" + contagem.get(Resultado.OPEN)
             + " CLOSED=" + contagem.get(Resultado.CLOSED)
             + " INVALID=" + contagem.get(Resultado.INVALID);
    }
}
