package m2s04.main;

import m2s04.utils.Operacao;

import java.util.Scanner;

public class MedicoCLI {

    public static void exibirMenu() {
        System.out.println("\n******** MENU ********");
        Operacao[] operacoes = Operacao.values();
        for (Operacao opr : operacoes) {
            System.out.println(opr.getOpcao() + " - " + opr);
        }
        System.out.print("\nEscolha uma opção: ");
    }

    public static Operacao solicitarOpcao(Scanner scanner){
        String opcaoSelecionada = scanner.next();
        scanner.nextLine();
        try {
            int opcaoInt = Integer.parseInt(opcaoSelecionada);
            return Operacao.getOpcao(opcaoInt);
        } catch (NumberFormatException e) {
            System.out.println("Erro. Por favor, tente novamente com um número válido.");
            return null;
        }
    }

}