package m2s01;

import java.util.Scanner;

/**
 * [M2S01] Ex. 04 - Monitoramento de Calorias
 *
 * @see <a href="https://trello.com/c/9kMSEV4y">Requirements</a>
 * @author Vinícius Ferreira
 */
public class MonitoraCalorias {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Variáveis Globais
        String [] diaSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
        int [] calorias = new int[7];
        int LIMITE_DIARIO = 2000;
        int totalCalorias = 0;
        double mediaDiaria;
        boolean metaSemanalCumprida = true;

        // Ler entrada do usuário
        System.out.println("Informe as calorias consumidas em cada dia:");
        for (int i = 0; i < diaSemana.length; i++) {
            System.out.print(diaSemana[i] + ": ");
            calorias[i] = sc.nextInt();
        }

        sc.close();

        // Calcula Estatísticas
        for (int c : calorias) {
            totalCalorias += c;
        }
        mediaDiaria = (double) totalCalorias / 7.0;

        // Identifica os dias que ultrapassaram o limite e imprime relatório
        System.out.println("\nDia(s) acima da cota diária de calorias (2000 kcal):");
        for (int i = 0; i < calorias.length; i++) {
            if (calorias[i] > LIMITE_DIARIO) {
                System.out.println("- " + diaSemana[i] + ": " + calorias[i] + " kcal -> " + (calorias[i] - LIMITE_DIARIO) +
                        " kcal acima do limite diário.");
                metaSemanalCumprida = false;
            }
        }

        if (metaSemanalCumprida) {
            System.out.println("Parabéns! Você cumpriu a meta semanal.");
        }

        System.out.println("\nConsumo total de calorias: " + totalCalorias + " kcal.");
        System.out.printf("Média diária de calorias: %.2f kcal.%n", mediaDiaria);
    }
}
