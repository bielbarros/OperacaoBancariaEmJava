import java.util.Scanner;
public class VerificarDeIdade {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int idade = scanner.nextInt();
            if (idade >= 18) {
                System.out.println("Voce esta elegivel para criar uma conta bancaria.");
            } else {
                System.out.println("Voce nao esta elegivel para criar uma conta bancaria.");
            }

            // Verificar se a idade do cliente
            // Se >= 18, imprimir "Voce esta elegivel para criar uma conta bancaria."
            // Caso contrário, imprimir "Voce nao esta elegivel para criar uma conta bancaria."

            // Fechar o scanner para evitar vazamentos de recursos
            scanner.close();
        }

}
