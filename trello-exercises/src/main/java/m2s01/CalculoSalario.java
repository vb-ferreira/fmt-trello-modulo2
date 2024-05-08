package m2s01;

import java.util.Scanner;

/**
 * [M2S01] Ex. 02 - Calcular Salário
 *
 * @see <a href="https://trello.com/c/9kMSEV4y">Requirements</a>
 * @author Vinícius Ferreira
 */
public class CalculoSalario {

    public static void main(String[] args) {

        int MINIMUM_WAGE = 1412;
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual é o seu salário?");
        double wage = sc.nextDouble();
        sc.close();

        double qtdMinimumWage = wage / (double) MINIMUM_WAGE;

        System.out.printf("Você recebe aproximadamente %.2f salário(s) mínimo(s).", qtdMinimumWage);
    }
}
