package academia;

import academia.facade.VerificadorFacade;
import academia.factory.RegraFactory;
import academia.observer.LogObservador;
import academia.singleton.EstatisticasAcademia;

import java.util.Scanner;

/**
 * Uso: java academia.Main [regra] [--log]
 * Lê N e depois N inteiros da entrada padrão (formato do desafio).
 * Regra padrão: multiplo-de-3.
 */
public class Main {
    public static void main(String[] args) {
        String tipoRegra = "multiplo-de-3";
        boolean log = false;
        for (String a : args) {
            if (a.equals("--log")) log = true; else tipoRegra = a;
        }

        VerificadorFacade verificador = new VerificadorFacade(RegraFactory.criar(tipoRegra));
        if (log) verificador.adicionarObservador(new LogObservador());

        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.println(verificador.verificar(sc.nextLong()));
            }
        }
        if (log) System.err.println("[RESUMO] " + EstatisticasAcademia.getInstance().resumo());
    }
}
