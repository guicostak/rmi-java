import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.rmi.RemoteException;
import java.util.Map;

public class DictionaryServer extends UnicastRemoteObject implements DictionaryService {

    private Map<String, String> dictionary;

    public DictionaryServer() throws RemoteException {
        super();
        dictionary = new HashMap<>();
        loadDictionary(); // Método para carregar o dicionário persistido
    }

    @Override
    public synchronized String getMeaning(String word) throws RemoteException {
        if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        } else {
            return "Palavra não encontrada.";
        }
    }

    @Override
    public synchronized String addWord(String word, String meaning) throws RemoteException {
        if (dictionary.containsKey(word)) {
            return "Palavra já existe.";
        } else {
            dictionary.put(word, meaning);
            saveDictionary(); // Método para salvar o dicionário
            return "Palavra adicionada com sucesso.";
        }
    }

    @Override
    public synchronized String removeWord(String word) throws RemoteException {
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
            saveDictionary(); // Método para salvar o dicionário
            return "Palavra removida com sucesso.";
        } else {
            return "Palavra não encontrada.";
        }
    }

    private void loadDictionary() {
        // Implementação de carregamento do dicionário (ex: de um arquivo JSON ou XML)
    }

    private void saveDictionary() {
        // Implementação de salvamento do dicionário (ex: para um arquivo JSON ou XML)
    }
}
