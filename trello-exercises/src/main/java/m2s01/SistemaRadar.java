package m2s01;

import java.util.Scanner;

/**
 * [M2S01] Ex. 03 - Sistema de Radares
 *
 * @see <a href="https://trello.com/c/5JqaBWzS">Requirements</a>
 * @author Vinícius Ferreira
 */
public class SistemaRadar {

    public static void main(String[] args) {

        double DISTANCE = 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Tempo medido pelo sensor (em segundos): ");
        double time = sc.nextDouble();
        sc.close();

        double averageSpeedKmPerHour = (DISTANCE / time) * 3.6;

        System.out.printf("Velocidade média: %.3f (Km/h).",  averageSpeedKmPerHour);

    }
}
