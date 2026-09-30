package academia.observer;

import academia.model.Portal;
import academia.model.Resultado;

public class LogObservador implements ObservadorTentativa {
    @Override
    public void aoVerificar(Portal portal, Resultado resultado) {
        System.err.printf("[LOG] %s | numero=%d | regra=%s -> %s%n",
                portal.getDescricao(), portal.getNumero(), portal.getRegra().nome(), resultado);
    }
}
