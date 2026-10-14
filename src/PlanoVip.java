public class PlanoVip extends Plano implements Fidelizavel {

    private int mesesContratados;
    private boolean querPersonal;   // + R$ 50,00
    private boolean querEspacoSpa;  // + R$ 80,00 (Sauna, Spa e Cadeira de Massagem)
    private boolean analiseCorporalInclusa; // Benefício VIP padrão (Grátis)

    public PlanoVip(String nomeAluno, String cpf, int mesesContratados, boolean querPersonal, boolean querEspacoSpa) {
        super(nomeAluno, cpf, TipoPlano.VIP);
        this.mesesContratados = mesesContratados;
        this.querPersonal = querPersonal;
        this.querEspacoSpa = querEspacoSpa;
        this.analiseCorporalInclusa = true; // Continua incluso gratuitamente no VIP
    }

    @Override
    public double aplicarDesconto(int meses) {
        if (meses >= 12) return 0.20;
        if (meses >= 6) return 0.10;
        return 0.0;
    }

    @Override
    public double calcularMensalidade() {
        double valor = getValorBase(); //

        if (querPersonal) {
            valor += 50.0;
        }
        if (querEspacoSpa) {
            valor += 80.0;
        }

        double desconto = aplicarDesconto(mesesContratados);
        return valor * (1.0 - desconto);
    }

    @Override
    public String informacoesAluno() {
        double descPct = aplicarDesconto(mesesContratados) * 100;
        return super.informacoesAluno() + String.format("""
                
                Personal Trainer: %s
                Espaço Spa (Sauna, Spa, Massagem): %s
                Análise Corporal (Bioimpedância): INCLUSO (Trimestral)
                Contrato: %d meses (%.0f%% de desconto)
                ----------------------------------------
                MENSALIDADE FINAL: R$ %.2f
                """,
                (querPersonal ? "Sim (+R$ 50,00)" : "Não"),
                (querEspacoSpa ? "Sim (+R$ 80,00)" : "Não"),
                mesesContratados,
                descPct,
                calcularMensalidade());
    }
}