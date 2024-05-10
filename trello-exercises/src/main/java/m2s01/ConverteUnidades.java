package m2s01;

import java.util.Objects;
import java.util.Scanner;

/**
 * [M2S01] Ex. 05 - Conversor de Unidades
 *
 * @see <a href="https://trello.com/c/yS7us9PS">Requirements</a>
 * @author Vinícius Ferreira
 */
public class ConverteUnidades {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int category;
        String originUnit;
        String targetUnit;
        String convertionCode;
        double outputValue;
        double inputValue;

        System.out.println("""
                Escolha a categoria:\n
                1. Comprimento
                2. Peso
                """);
        do {
            System.out.print("Opção (1 | 2): ");
            category = sc.nextInt();
        } while (category != 1 && category != 2);

        if (category == 1) {
            System.out.println("""
                \nEscolha a unidade de origem:\n
                1. Metros (m)
                2. Centímetros (cm)
                3. Polegadas (in)
                """);

            do {
                System.out.print("Opção (1 | 2 | 3): ");
                originUnit = sc.next();
            } while (!Objects.equals(originUnit, "1") &&
                     !Objects.equals(originUnit, "2") &&
                     !Objects.equals(originUnit, "3"));

            System.out.println("""
                \nEscolha a unidade de destino:\n
                1. Metros (m)
                2. Centímetros (cm)
                3. Polegadas (in)
                """);

            do {
                System.out.print("Opção (1 | 2 | 3): ");
                targetUnit = sc.next();
                if (Objects.equals(targetUnit, originUnit)) {
                    System.out.printf("Erro: escolha uma unidade de destino diferente da unidade de origem (%s).%n",
                            originUnit);
                }
            } while (!Objects.equals(targetUnit, "1") &&
                     !Objects.equals(targetUnit, "2") &&
                     !Objects.equals(targetUnit, "3") ||
                     Objects.equals(targetUnit, originUnit));

            convertionCode = originUnit + targetUnit;
            System.out.print("\nInforme o valor: ");
            inputValue = sc.nextDouble();

            switch (convertionCode) {
                case "12":
                    outputValue = inputValue * 100;
                    System.out.printf("Resultado da conversão: %.2f metros = %.2f centímetros", inputValue, outputValue);
                    break;
                case "13":
                    outputValue = inputValue * 39.37;
                    System.out.printf("Resultado da conversão: %.2f metros = %.2f polegadas", inputValue, outputValue);
                    break;
                case "21":
                    outputValue = inputValue / 100;
                    System.out.printf("Resultado da conversão: %.2f centímetros = %.2f metros", inputValue, outputValue);
                    break;
                case "31":
                    outputValue = inputValue / 39.37;
                    System.out.printf("Resultado da conversão: %.2f polegadas = %.2f metros", inputValue, outputValue);
                    break;
                case "23":
                    outputValue = inputValue / 2.54;
                    System.out.printf("Resultado da conversão: %.2f centímetros = %.2f polegadas", inputValue, outputValue);
                    break;
                case "32":
                    outputValue = inputValue * 2.54;
                    System.out.printf("Resultado da conversão: %.2f polegadas = %.2f centímetros", inputValue, outputValue);
                    break;
                default:
                    System.out.println("Algo de errado. Tente novamente.");
            }
        } else {
            System.out.println("""
                \nEscolha a unidade de origem:\n
                1. Quilogramas (kg)
                2. Gramas (g) 
                3. Libras (lb)
                """);

            do {
                System.out.print("Opção (1 | 2 | 3): ");
                originUnit = sc.next();
            } while (!Objects.equals(originUnit, "1") &&
                    !Objects.equals(originUnit, "2") &&
                    !Objects.equals(originUnit, "3"));

            System.out.println("""
                \nEscolha a unidade de destino:\n
                1. Quilogramas (kg)
                2. Gramas (g) 
                3. Libras (lb)
                """);

            do {
                System.out.print("Opção (1 | 2 | 3): ");
                targetUnit = sc.next();
                if (Objects.equals(targetUnit, originUnit)) {
                    System.out.printf("Erro: escolha uma unidade de destino diferente da unidade de origem (%s)%n",
                            originUnit);
                }
            } while (!Objects.equals(targetUnit, "1") &&
                    !Objects.equals(targetUnit, "2") &&
                    !Objects.equals(targetUnit, "3") ||
                    Objects.equals(targetUnit, originUnit));

            convertionCode = originUnit + targetUnit;
            System.out.print("\nInforme o valor: ");
            inputValue = sc.nextDouble();

            switch (convertionCode) {
                case "12":
                    outputValue = inputValue * 1000;
                    System.out.printf("Resultado da conversão: %.2f quilogramas = %.2f gramas", inputValue, outputValue);
                    break;
                case "13":
                    outputValue = inputValue * 2.205;
                    System.out.printf("Resultado da conversão: %.2f quilogramas = %.2f libras", inputValue, outputValue);
                    break;
                case "21":
                    outputValue = inputValue / 1000;
                    System.out.printf("Resultado da conversão: %.2f gramas = %.2f quilogramas", inputValue, outputValue);
                    break;
                case "31":
                    outputValue = inputValue / 2.205;
                    System.out.printf("Resultado da conversão: %.2f libras = %.2f quilogramas", inputValue, outputValue);
                    break;
                case "23":
                    outputValue = inputValue / 453.6;
                    System.out.printf("Resultado da conversão: %.2f gramas = %.2f libras", inputValue, outputValue);
                    break;
                case "32":
                    outputValue = inputValue * 453.6;
                    System.out.printf("Resultado da conversão: %.2f libras = %.2f gramas", inputValue, outputValue);
                    break;
                default:
                    System.out.println("Algo de errado. Tente novamente.");
            }

            sc.close();
        }

    }
}
