package controller;

import service.CreateService;
import service.DeleteService;
import service.ReadService;
import service.UpdateService;
import connection.DatabaseConnection;

import java.sql.Connection;
import java.util.Scanner;

public class JDBCController {

    private final CreateService createService;
    private final ReadService readService;
    private final DeleteService deleteService;
    private final UpdateService updateService;
    private final Scanner scanner;

    public JDBCController(CreateService createService,
                          ReadService readService,
                          DeleteService deleteService,
                          UpdateService updateService) {
        this.createService = createService;
        this.readService = readService;
        this.deleteService = deleteService;
        this.updateService = updateService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            int opcao;
            do {
                exibirMenu();
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer

                switch (opcao) {
                    case 1 -> criarRegistro(connection);
                    case 2 -> atualizarRegistro(connection);
                    case 3 -> listarRegistros(connection);
                    case 4 -> deletarRegistro(connection);
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }
            } while (opcao != 0);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void exibirMenu() {
        System.out.println("\n=== Menu CRUD JDBC ===");
        System.out.println("1. Criar registro");
        System.out.println("2. Atualizar registro");
        System.out.println("3. Listar registros");
        System.out.println("4. Deletar registro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void criarRegistro(Connection connection) throws Exception {
        System.out.print("Digite o nome para o novo registro: ");
        String nome = scanner.nextLine();
        createService.criarRegistro(connection, nome);
    }

    private void atualizarRegistro(Connection connection) throws Exception {
        System.out.print("Digite o ID do registro que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Digite o novo nome: ");
        String nome = scanner.nextLine();
        updateService.atualizarRegistro(connection, id, nome);
    }

    private void listarRegistros(Connection connection) throws Exception {
        readService.lerRegistros(connection);
    }

    private void deletarRegistro(Connection connection) throws Exception {
        System.out.print("Digite o ID do registro que deseja deletar: ");
        int id = scanner.nextInt();
        deleteService.deletarRegistro(connection, id);
    }
}
