import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class DictionaryClient {
    public static void main(String[] args) {
        try {
            // Conectar ao registro RMI na porta 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Obter a referência ao serviço DictionaryService
            DictionaryService service = (DictionaryService) registry.lookup("DictionaryService");

            // Exemplo de interface gráfica ou CLI (Command Line Interface) simples
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Consultar significado de uma palavra");
                System.out.println("2. Adicionar uma nova palavra");
                System.out.println("3. Remover uma palavra");
                System.out.println("4. Sair");

                int option = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (option) {
                    case 1:
                        System.out.print("Digite a palavra para consultar: ");
                        String wordToConsult = scanner.nextLine();
                        String meaning = service.getMeaning(wordToConsult);
                        System.out.println("Significado: " + meaning);
                        break;

                    case 2:
                        System.out.print("Digite a palavra para adicionar: ");
                        String wordToAdd = scanner.nextLine();
                        System.out.print("Digite o significado da palavra: ");
                        String meaningToAdd = scanner.nextLine();
                        String addResult = service.addWord(wordToAdd, meaningToAdd);
                        System.out.println(addResult);
                        break;

                    case 3:
                        System.out.print("Digite a palavra para remover: ");
                        String wordToRemove = scanner.nextLine();
                        String removeResult = service.removeWord(wordToRemove);
                        System.out.println(removeResult);
                        break;

                    case 4:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opção inválida.");
                }
            }

        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
