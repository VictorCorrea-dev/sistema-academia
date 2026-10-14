public abstract class Plano {

    private String nomeAluno;
    private String cpf;
    private TipoPlano tipoPlano;

    public Plano(String nomeAluno, String cpf, TipoPlano tipoPlano) {
        this.nomeAluno = nomeAluno;
        this.cpf = cpf;
        this.tipoPlano = tipoPlano;
    }

    public abstract double calcularMensalidade();

    public String getNomeAluno() { return nomeAluno; }
    public String getCpf() { return cpf; }
    public TipoPlano getTipoPlano() { return tipoPlano; }

    public double getValorBase() {
        return tipoPlano.getValorBase();
    }

    public String informacoesAluno() {
        return String.format("""
                --- Dados do Aluno ---
                Nome: %s
                CPF: %s
                Modalidade: %s
                Valor Base do Plano: R$ %.2f""",
                nomeAluno, cpf, tipoPlano.getDescricao(), getValorBase());
    }
}