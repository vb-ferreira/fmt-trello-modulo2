package m2s03;

import m2s03.entidades.Paciente;
import m2s03.repositorio.ListaPacientes;

import java.util.List;
import java.util.Scanner;

public class Principal {

    // Variáveis globais
    Scanner sc = new Scanner(System.in).useDelimiter(";|\\R");
    List<String> itens = List.of("Cadastrar novo paciente", "Listar pacientes", "Alterar informações do paciente",
            "Mostrar informações do paciente", "Registrar atividade física", "Remover paciente",
            "Sair");
    int idPacienteSelecionado;
    Paciente pacienteSelecionado;
    String novaAtividadeFisica;

    public static void main(String[] args) {
        Principal main = new Principal();
        main.start();
    }

    public void start() {
        // Loop principal do programa
        while (true) {
            exibirMenu(itens);
            int opcao = Integer.parseInt(sc.next());
            handleOpcao(opcao);
        }
    }

    private static void exibirMenu(List<String> itens) {
        System.out.println("\nO P Ç Õ E S");
        System.out.println("=".repeat(25));
        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + ". " + itens.get(i));
        }
        System.out.println("=".repeat(25));
        System.out.print("Selecionar opção: ");
    }

    private void handleOpcao(int opcao) {
        switch (opcao){
            case 1:
                // Ex5: Adicionar paciente
                ListaPacientes.adicionarPaciente(sc);
                break;
            case 2:
                // Ex6: Listar todos os pacientes
                ListaPacientes.listarPacientes();
                break;
            case 3:
                // Ex7: Editar paciente selecionado
                ListaPacientes.editarPaciente(sc);
                break;
            case 4:
                // Ex8: Exibir informações do paciente selecionado
                System.out.print("Informe o ID do paciente: ");
                idPacienteSelecionado = sc.nextInt();
                pacienteSelecionado = ListaPacientes.buscarPaciente(idPacienteSelecionado);
                pacienteSelecionado.monitorarPaciente();
                break;
            case 5:
                // Ex9: Cadastrar atividade física para paciente selecionado
                System.out.print("Informe o ID do paciente: ");
                idPacienteSelecionado = sc.nextInt();
                System.out.print("Nova atividade: ");
                novaAtividadeFisica = sc.next();
                pacienteSelecionado = ListaPacientes.buscarPaciente(idPacienteSelecionado);
                pacienteSelecionado.registrarAtividade(novaAtividadeFisica);
                break;
            case 6:
                // Ex10: Remover paciente selecionado
                System.out.print("Informe o ID do paciente: ");
                idPacienteSelecionado = sc.nextInt();
                ListaPacientes.removerPaciente(idPacienteSelecionado);
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Opção não cadastrada.");
                break;
        }
    }
}