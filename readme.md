# Projeto RMI Dicionário

Este projeto demonstra o uso de Java RMI (Remote Method Invocation) para criar um serviço de dicionário distribuído. O projeto inclui um servidor RMI que oferece funcionalidades de adicionar, consultar e remover palavras de um dicionário, bem como um cliente que interage com esse serviço.

## Estrutura do Projeto

1. **`DictionaryService.java`**: Interface que define os métodos remotos disponíveis.
2. **`DictionaryServer.java`**: Implementação do serviço de dicionário.
3. **`DictionaryClient.java`**: Cliente que interage com o serviço de dicionário.
4. **`README.md`**: Este arquivo.

## Requisitos

- Java JDK 8 ou superior
- `rmiregistry` (geralmente incluído no JDK)

## Passos para Configuração e Execução

### 1. Compilação do Código

Abra um terminal ou prompt de comando e navegue até o diretório onde os arquivos `.java` estão localizados. Compile todos os arquivos Java usando o seguinte comando:

```bash
javac *.java 
```
Antes de iniciar o servidor RMI, você precisa iniciar o rmiregistry. Abra um novo terminal e execute o comando:

```bash
rmiregistry 1099
```


No terminal onde você compilou os arquivos, execute o servidor RMI com o seguinte comando:
```bash
java DictionaryServer
```

Em outro terminal, execute o cliente RMI com o comando:
```bash
java DictionaryClient
```


