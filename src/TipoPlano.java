public enum TipoPlano {
    BASICO("Plano Básico", 100.00),
    VIP("Plano VIP", 200.00);

    private final String descricao;
    private final double valorBase;

    TipoPlano(String descricao, double valorBase) {
        this.descricao = descricao;
        this.valorBase = valorBase;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorBase() {
        return valorBase;
    }
}