public class PlanoBasico extends Plano {

    private double taxaInscricao;
    private boolean querAulasColetivas;
    private boolean querAnaliseCorporal;

    public PlanoBasico(String nomeAluno, String cpf, boolean querAulasColetivas, boolean querAnaliseCorporal) {
        super(nomeAluno, cpf, TipoPlano.BASICO);
        this.taxaInscricao = 15.0;
        this.querAulasColetivas = querAulasColetivas;
        this.querAnaliseCorporal = querAnaliseCorporal;
    }

    @Override
    public double calcularMensalidade() {
        double total = getValorBase() + taxaInscricao;

        if (querAulasColetivas) {
            total += 40.00;
        }
        if (querAnaliseCorporal) {
            total += 50.00; // Custo opcional para o Básico
        }

        return total;
    }

    @Override
    public String informacoesAluno() {
        return super.informacoesAluno() + String.format("""
                
                Taxa de Inscrição: R$ %.2f
                Aulas Coletivas (Lutas, Pilates/Yoga): %s
                Análise Corporal (Bioimpedância): %s
                ----------------------------------------
                MENSALIDADE FINAL: R$ %.2f
                """,
                taxaInscricao,
                (querAulasColetivas ? "Sim (+R$ 50,00)" : "Não"),
                (querAnaliseCorporal ? "Sim (+R$ 60,00)" : "Não"),
                calcularMensalidade());
    }
}