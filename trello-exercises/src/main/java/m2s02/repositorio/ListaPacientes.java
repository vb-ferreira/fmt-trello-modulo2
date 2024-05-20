package m2s02.repositorio;

import m2s02.entidades.Paciente;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Ex2: criar lista para receber pacientes
 */
public class ListaPacientes {

    private static ArrayList<Paciente> pacientes;

    static {
        pacientes = new ArrayList<>();
    }

    /**
     * Ex5: Criar método para adicionar paciente
     * @param sc objeto para leitura de input
     */
    public static void adicionarPaciente(Scanner sc) {
        Paciente paciente = new Paciente();

        System.out.print("Nome do paciente: ");
        paciente.setNome(sc.next());
        System.out.print("Idade do paciente: ");
        paciente.setIdade(sc.nextInt());
        System.out.print("Peso do paciente (kg): ");
        paciente.setPeso(sc.nextDouble());
        System.out.print("Altura do paciente (m): ");
        paciente.setAltura(sc.nextDouble());
        System.out.print("Pressão arterial do paciente: ");
        paciente.setPressaoArterial(sc.nextDouble());
        System.out.print("Frequência cardíaca do paciente: ");
        paciente.setFrequenciaCardiaca(sc.nextDouble());
        System.out.print("Dieta alimentar: ");
        paciente.setDietaAlimentar(sc.next());

        pacientes.add(paciente);
    }

    /**
     * Ex6: Criar método para listar pacientes
     */
    public static void listarPacientes() {
        System.out.println("\nPacientes cadastrados");
        System.out.println("-----------------------");
        System.out.println("Id  -  Nome");

        for (Paciente paciente : pacientes) {
            System.out.println(pacientes.indexOf(paciente) + "  -  " + paciente.getNome());
        }
    }

    /**
     * Ex7: Criar método para editar paciente
     * @param sc objeto para leitura de input
     */
    public static void editarPaciente(Scanner sc) {
        System.out.print("Informe o ID do paciente: ");
        int pacienteID = sc.nextInt();
        String simOuNao;
        Paciente paciente = pacientes.get(pacienteID);
        String pacienteNome = paciente.getNome();

        System.out.println("Deseja editar o peso do paciente " + pacienteNome + "? (s/n)");
        simOuNao = sc.next();
        if (Objects.equals(simOuNao, "s")) {
            System.out.println("Peso atual: " + paciente.getPeso());
            System.out.print("Novo peso: ");
            paciente.setPeso(sc.nextDouble());
        };
        System.out.println("Deseja editar a altura do paciente " + pacienteNome + "? (s/n)");
        simOuNao = sc.next();
        if (Objects.equals(simOuNao, "s")) {
            System.out.println("Altura atual: " + paciente.getPeso());
            System.out.print("Nova altura: ");
            paciente.setAltura(sc.nextDouble());
        };
        System.out.println("Deseja editar a pressão arterial do paciente " + pacienteNome + "? (s/n)");
        simOuNao = sc.next();
        if (Objects.equals(simOuNao, "s")) {
            System.out.println("Pressão arterial atual: " + paciente.getPressaoArterial());
            System.out.print("Nova pressão arterial: ");
            paciente.setPressaoArterial(sc.nextDouble());
        };
        System.out.println("Deseja editar a frequência cardíaca do paciente " + pacienteNome + "? (s/n)");
        simOuNao = sc.next();
        if (Objects.equals(simOuNao, "s")) {
            System.out.println("Frequência atual: " + paciente.getFrequenciaCardiaca());
            System.out.print("Nova frequência cardíaca: ");
            paciente.setFrequenciaCardiaca(sc.nextDouble());
        };
        System.out.println("Deseja editar a dieta do paciente " + pacienteNome + "? (s/n)");
        simOuNao = sc.next();
        if (Objects.equals(simOuNao, "s")) {
            System.out.println("Dieta atual: " + paciente.getDietaAlimentar());
            System.out.print("Nova dieta: ");
            paciente.setDietaAlimentar(sc.next());
        };
    };

    /**
     * Ex7: Criar método auxiliar para encontrar paciente pelo id
     * @param id index do paciente
     * @return objeto do tipo Paciente
     */
    public static Paciente buscarPaciente(int id) {
        return pacientes.get(id);
    }

    /**
     * Ex10: Criar método para remover paciente
     * @param id identificador único do paciente.
     */
    public static void removerPaciente(int id) {
        pacientes.remove(id);
    }

}