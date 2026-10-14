import java.util.ArrayList;
import java.util.List;
import static java.lang.IO.*;

void main() {
    List<Plano> alunos = new ArrayList<>();
    String opcao = "";

    do {
        println("""
                
                === SISTEMA DA ACADEMIA ===
                1 - Cadastrar Plano Básico (R$ 100,00 base)
                2 - Cadastrar Plano VIP (R$ 200,00 base)
                3 - Listar Alunos Cadastrados
                0 - Sair
                """);

        opcao = Validador.lerTexto("Escolha uma opção:");

        switch (opcao) {
            case "1" -> {
                String nome = Validador.lerTexto("Nome do Aluno:");
                String cpf = Validador.lerTexto("CPF do Aluno:");

                int opcaoAulas = Validador.lerNumeroInteiro("Incluir Aulas Coletivas (Lutas, Pilates/Yoga) (+R$ 40,00)? [1-Sim / 2-Não]:");
                boolean querAulas = (opcaoAulas == 1);

                int opcaoBio = Validador.lerNumeroInteiro("Incluir Análise Corporal (Bioimpedância) (+R$ 50,00)? [1-Sim / 2-Não]:");
                boolean querBio = (opcaoBio == 1);

                PlanoBasico novoAluno = new PlanoBasico(nome, cpf, querAulas, querBio);
                alunos.add(novoAluno);

                println("\nPlano Básico cadastrado com sucesso!");
                println(novoAluno.informacoesAluno());
            }
            case "2" -> {
                String nome = Validador.lerTexto("Nome do Aluno:");
                String cpf = Validador.lerTexto("CPF do Aluno:");
                int meses = Validador.lerNumeroInteiro("Meses de contrato (1 a 24):");

                int personal = Validador.lerNumeroInteiro("Incluir Personal (+R$ 50,00)? [1-Sim / 2-Não]:");
                boolean querPersonal = (personal == 1);

                // NOVO: Pergunta sobre o adicional de Sauna/Spa/Massagem por R$ 80,00
                int spa = Validador.lerNumeroInteiro("Incluir Espaço Spa/Sauna/Massagem (+R$ 80,00)? [1-Sim / 2-Não]:");
                boolean querSpa = (spa == 1);

                PlanoVip novoAluno = new PlanoVip(nome, cpf, meses, querPersonal, querSpa);
                alunos.add(novoAluno);

                println("\nPlano VIP cadastrado com sucesso!");
                println(novoAluno.informacoesAluno());
            }
            case "3" -> {
                if (alunos.isEmpty()) {
                    println("\nNenhum aluno cadastrado até o momento.");
                } else {
                    println("\n=== LISTA DE ALUNOS ===");
                    for (Plano a : alunos) {
                        println(a.informacoesAluno());
                        println("------------------------------");
                    }
                }
            }
            case "0" -> println("Saindo do sistema... Até logo!");
            default -> println("Opção inválida! Tente novamente.");
        }
    } while (!opcao.equals("0"));
}