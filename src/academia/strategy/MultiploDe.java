package academia.strategy;

public class MultiploDe implements RegraAbertura {
    private final long divisor;

    public MultiploDe(long divisor) {
        if (divisor == 0) throw new IllegalArgumentException("Divisor não pode ser zero");
        this.divisor = divisor;
    }

    @Override public boolean permite(long numero) { return numero % divisor == 0; }
    @Override public String nome() { return "multiplo-de-" + divisor; }
}
