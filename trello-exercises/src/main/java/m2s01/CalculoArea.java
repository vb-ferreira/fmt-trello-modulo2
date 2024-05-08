package m2s01;

import java.util.Scanner;

/**
 * [M2S01] Ex. 01 - Calcular Área
 *
 * @see <a href="https://trello.com/c/lJN4OYcU">Requirements</a>
 * @author Vinícius Ferreira
 */
public class CalculoArea {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a largura do terreno: ");
        double width = sc.nextDouble();
        System.out.print("Informe o comprimento do terreno: ");
        double height = sc.nextDouble();

        sc.close();

        double area = width * height;

        System.out.println("O terreno possui " + area + " m² de área.");
    }
}
