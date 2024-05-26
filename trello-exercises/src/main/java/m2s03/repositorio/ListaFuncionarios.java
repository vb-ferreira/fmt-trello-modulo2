package m2s03.repositorio;

import m2s03.entidades.Endereco;
import m2s03.entidades.Funcionario;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ex. 08 - Criar lista de funcionários e seus métodos.
 */
public class ListaFuncionarios {

    private static ArrayList<Funcionario> funcionarios;

    static {
        funcionarios = new ArrayList<>();
    }

    public static void listarFuncionarios() {
        System.out.println("\nFuncionários cadastrados");
        System.out.println("-----------------------");
        System.out.println("Nome  -  Idade  -  Salário");

        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + "  -  " + f.getIdade() + "  -  " + f.getSalario());
        }
    }

    public static Funcionario buscarFuncionario(int id) {
        return funcionarios.get(id);
    }

    public static void adicionarFuncionario(Scanner sc) {
        Funcionario funcionario  = new Funcionario();
        Endereco endereco = new Endereco();

        System.out.print("Nome: ");
        funcionario.setNome(sc.next());
        System.out.print("Idade: ");
        funcionario.setIdade(sc.nextInt());
        System.out.print("Salário: ");
        funcionario.setSalario(sc.nextDouble());

        System.out.println("Rua: ");
        endereco.setLogradouro(sc.next());
        System.out.println("Estado: ");
        endereco.setEstado(sc.next());
        System.out.println("Cidade: ");
        System.out.println("Número: ");
        endereco.setNumero(sc.nextInt());
        System.out.println("CEP: ");
        endereco.setCep(sc.next());

        funcionario.setEndereco(endereco);
        funcionarios.add(funcionario);
    }

    public static void removerFuncionario(int id) {
        funcionarios.remove(id);
    }

    public static void editarFuncionario(Scanner sc) {
        System.out.print("Informe o ID do funcionario: ");
        int funcionarioID = sc.nextInt();
        Funcionario funcionario = buscarFuncionario(funcionarioID);
        Endereco endereco = funcionario.getEndereco();

        System.out.println("Nome atual: " + funcionario.getNome());
        System.out.print("Novo nome: ");
        funcionario.setNome(sc.next());

        System.out.println("Idade atual: " + funcionario.getIdade());
        System.out.print("Nova idade: ");
        funcionario.setIdade(sc.nextInt());

        System.out.println("Salário atual: " + funcionario.getSalario());
        System.out.print("Novo salário: ");
        funcionario.setSalario(sc.nextDouble());

        System.out.println("Rua atual: " + endereco.getLogradouro());
        System.out.print("Nova rua: ");
        endereco.setLogradouro(sc.next());

        System.out.println("UF atual: " + endereco.getEstado());
        System.out.print("Nova UF: ");
        endereco.setEstado(sc.next());

        System.out.println("Cidade atual: " + endereco.getCidade());
        System.out.print("Nova cidade: ");
        endereco.setCidade(sc.next());

        System.out.println("Número atual: " + endereco.getNumero());
        System.out.print("Novo número: ");
        endereco.setNumero(sc.nextInt());

        System.out.println("CEP atual: " + endereco.getCep());
        System.out.print("Novo CEP: ");
        endereco.setCep(sc.next());

        funcionario.setEndereco(endereco);
    };
}
