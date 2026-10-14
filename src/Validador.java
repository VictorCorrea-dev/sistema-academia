import java.util.Scanner;
import static java.lang.IO.*;

public class Validador {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String lerTexto(String mensagem) {
        println(mensagem);
        String entrada = SCANNER.nextLine().trim();
        while (entrada.isEmpty()) {
            println("Entrada inválida! Digite novamente:");
            entrada = SCANNER.nextLine().trim();
        }
        return entrada;
    }

    public static int lerNumeroInteiro(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(lerTexto(mensagem));
            } catch (NumberFormatException e) {
                println("Erro: Digite apenas números inteiros válidos!");
            }
        }
    }

    public static double lerNumeroDouble(String mensagem) {
        while (true) {
            try {
                return Double.parseDouble(lerTexto(mensagem).replace(",", "."));
            } catch (NumberFormatException e) {
                println("Erro: Digite um número decimal válido (ex: 100.0)!");
            }
        }
    }
}