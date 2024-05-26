package m2s03.repositorio;

import m2s03.entidades.Nutricionista;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ex. 08 - Criar lista de nutricionistas e seus métodos.
 */
public class ListaNutricionistas {

    private static ArrayList<Nutricionista> nutricionistas;

    static {
        nutricionistas = new ArrayList<>();
    }

    public static void listarNutricionistas() {
        System.out.println("\nNutricionistas cadastrados");
        System.out.println("-----------------------");
        System.out.println("Nome  -  Nº Consultas  -  Anos de Experiência");

        for (Nutricionista n : nutricionistas) {
            System.out.println(n.getNome() + "  -  " + n.getNumeroConsultas() + "  -  " + n.getExperiencia());
        }
    }

    public static Nutricionista buscarNutricionista(int id) {
        return nutricionistas.get(id);
    }

    public static void adicionarNutricionista(Scanner sc) {
        Nutricionista nutricionista  = new Nutricionista();

        System.out.print("Nome: ");
        nutricionista.setNome(sc.next());
        System.out.print("Número de consultas: ");
        nutricionista.setNumeroConsultas(sc.nextInt());
        System.out.print("Anos de experiência: ");
        nutricionista.setExperiencia(sc.nextInt());

        // Ex. 04: valida não duplicidade do nutricionista
        boolean duplicidade = false;
        for (Nutricionista n : nutricionistas) {
            if (n.getNome().equalsIgnoreCase(nutricionista.getNome())) {
                duplicidade = true;
                break;
            }
        }
        if (!duplicidade) nutricionistas.add(nutricionista);
    }

    public static void removerNutricionista(int id) {
        nutricionistas.remove(id);
    }

    public static void editarNutricionista(Scanner sc) {
        System.out.print("Informe o ID do nutricionista: ");
        int nutricionistaID = sc.nextInt();
        Nutricionista nutricionista = buscarNutricionista(nutricionistaID);

        System.out.println("Nome atual: " + nutricionista.getNome());
        System.out.print("Novo nome: ");
        nutricionista.setNome(sc.next());

        System.out.println("Tempo de experiência atual: " + nutricionista.getExperiencia());
        System.out.print("Novo tempo de experiência: ");
        nutricionista.setExperiencia(sc.nextInt());

        System.out.println("Número de consultas atual: " + nutricionista.getNumeroConsultas());
        System.out.print("Novo número de consultas: ");
        nutricionista.setNumeroConsultas(sc.nextInt());
    }

    public static ArrayList<Nutricionista> getNutricionistas() {
        return nutricionistas;
    }
}
