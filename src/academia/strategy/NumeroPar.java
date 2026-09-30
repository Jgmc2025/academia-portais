package academia.strategy;

public class NumeroPar implements RegraAbertura {
    @Override public boolean permite(long numero) { return numero % 2 == 0; }
    @Override public String nome() { return "par"; }
}
