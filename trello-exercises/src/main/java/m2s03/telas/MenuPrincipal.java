package m2s03.telas;

import m2s03.repositorio.ListaConsultas;
import m2s03.repositorio.ListaFuncionarios;
import m2s03.repositorio.ListaNutricionistas;
import m2s03.repositorio.ListaPacientes;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

//    Scanner sc = new Scanner(System.in).useDelimiter(";|\\R");
    Scanner sc = new Scanner(System.in).useDelimiter("\\R");
    // Opções do menu principal
    List<String> itens = List.of("Cadastrar paciente", "Listar pacientes", "Editar paciente",
            "Detalhar paciente", "Registrar atividade física", "Remover paciente", "Cadastrar funcionário",
            "Listar funcionários", "Cadastrar nutricionista", "Criar consulta", "Listar consultas",
            "Realizar consulta", "Sair");
    // Menus auxiliares
    MenuPaciente menuPaciente = new MenuPaciente();

    public static void main(String[] args) {
        MenuPrincipal main = new MenuPrincipal();
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

    /**
     * Ex. 09 - Inserir novas opções.
     * @param opcao int representando a opção do menu.
     */
    private void handleOpcao(int opcao) {
        switch (opcao){
            case 1:
                ListaPacientes.adicionarPaciente(sc);
                break;
            case 2:
                ListaPacientes.listarPacientes();
                break;
            case 3:
                ListaPacientes.editarPaciente(sc);
                break;
            case 4:
                menuPaciente.opcaoDetalhar(sc);
                break;
            case 5:
                menuPaciente.opcaoCadastrarAtividade(sc);
                break;
            case 6:
                menuPaciente.opcaoRemover(sc);
                break;
            case 7:
                ListaFuncionarios.adicionarFuncionario(sc);
                break;
            case 8:
                ListaFuncionarios.listarFuncionarios();
                ListaNutricionistas.listarNutricionistas();
                break;
            case 9:
                ListaNutricionistas.adicionarNutricionista(sc);
                break;
            case 10:
                ListaConsultas.adicionarConsulta(sc);
                break;
            case 11:
                ListaConsultas.listarConsultas();
                break;
            case 12:
                ListaConsultas.realizarConsulta(sc);
                break;
            case 13:
                System.exit(0);
                break;
            default:
                System.out.println("Opção não cadastrada.");
                break;
        }
    }
}