import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerLauncher {
    public static void main(String[] args) {
        try {
            DictionaryService server = new DictionaryServer();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("DictionaryService", server);
            System.out.println("Servidor está pronto...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
