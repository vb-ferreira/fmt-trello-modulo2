package m2s03.repositorio;

import m2s03.entidades.Consulta;
import m2s03.entidades.Nutricionista;
import m2s03.entidades.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ex. 07 - Criar lista de consultas e seus métodos.
 */
public class ListaConsultas {

    private static ArrayList<Consulta> consultas;

    static {
        consultas = new ArrayList<>();
    }

    public static void listarConsultas() {
        System.out.println("\nConsultas cadastradas");
        System.out.println("-----------------------");
        System.out.println("Data-Hora  -  Nutricionista  -  Paciente  -  Consulta Realizada");

        for (Consulta c : consultas) {
            System.out.println(c.getDataHora() + "  -  " + c.getNomeNutricionista() + "  -  " + c.getNomePaciente() +
                               "  -  " + (c.isConsultaRealizada() ? "SIM" : "NÃO"));
        }
    }

    public static Consulta buscarConsulta(int id) {
        return consultas.get(id);
    }

    public static void adicionarConsulta(Scanner sc) {
        Consulta consulta = new Consulta();
        List<Paciente> pacientesCadastrados = ListaPacientes.getPacientes();
        List<Nutricionista> nutricionistasCadastrados = ListaNutricionistas.getNutricionistas();
        boolean existePaciente = false;
        boolean existeNutricionista = false;

        System.out.print("Data e hora (AAAA-MM-DDTHH:MM:SS): ");
        consulta.setDataHora(sc.next());
        System.out.print("Nome do nutricionista: ");
        consulta.setNomeNutricionista(sc.next());
        System.out.print("Nome do paciente: ");
        consulta.setNomePaciente(sc.next());

        for (Paciente p : pacientesCadastrados) {
            if(p.getNome().equalsIgnoreCase(consulta.getNomePaciente())) {
                existePaciente = true;
            }
        }

        for (Nutricionista n : nutricionistasCadastrados) {
            if(n.getNome().equalsIgnoreCase(consulta.getNomeNutricionista())) {
                existeNutricionista = true;
            }
        }

        if (existePaciente && existeNutricionista) {
            consultas.add(consulta);
        } else {
            System.out.println("Paciente ou nutricionista não cadastrado. Tente novamente.");
        }

    }

    public static void removerConsulta(int id) {
        consultas.remove(id);
    }

    public static void editarConsulta(Scanner sc) {
        System.out.print("Informe o ID da consulta: ");
        int consultaID = sc.nextInt();
        Consulta consulta = buscarConsulta(consultaID);

        System.out.println("Data e hora atual: " + consulta.getDataHora());
        System.out.print("Nova data e hora ((AAAA-MM-DDTHH:MM:SS)): ");
        consulta.setDataHora(sc.next());

        System.out.println("Nutricionista atual: " + consulta.getNomeNutricionista());
        System.out.print("Novo nutricionista: ");
        consulta.setNomeNutricionista(sc.next());

        System.out.println("Paciente atual: " + consulta.getNomePaciente());
        System.out.print("Novo paciente: ");
        consulta.setNomePaciente(sc.next());

        System.out.println("Consulta realizada: " + consulta.isConsultaRealizada());
        System.out.print("Consulta realizada: ");
        consulta.setConsultaRealizada(sc.nextBoolean());
    };

    public static void realizarConsulta(Scanner sc) {
        System.out.print("Informe a ID da consulta: ");
        int idConsulta = sc.nextInt();
        Consulta consultaSelecionada = ListaConsultas.buscarConsulta(idConsulta);
        consultaSelecionada.setConsultaRealizada(true);
    }

}
