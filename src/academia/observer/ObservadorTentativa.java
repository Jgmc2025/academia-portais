package academia.observer;

import academia.model.Portal;
import academia.model.Resultado;

/** OBSERVER: quem quiser reagir a uma tentativa implementa esta interface. */
public interface ObservadorTentativa {
    void aoVerificar(Portal portal, Resultado resultado);
}
