package m2s04.main;

import m2s04.entities.Medico;
import m2s04.utils.Operacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DevMedicoAplicacao {

    Scanner sc = new Scanner(System.in);
    ArrayList<Medico> medicos = new ArrayList<>();  // Lista de médicos cadastrados

    // Loop principal do programa
    public void executar() {
        while (true) {
            MedicoCLI.exibirMenu();
            Operacao opcao = MedicoCLI.solicitarOpcao(sc);
            tratarOpcao(opcao);
        }
    }

    public void tratarOpcao(Operacao opcao) {
        switch (opcao) {
            case ADICIONAR:
                adicionarMedico();
                break;
            case LISTAR:
                listarMedicos();
                break;
            case SAIR:
                System.out.println("Encerrando o sistema...");
                System.exit(0);
                break;
            case null:
                System.out.println("Escolha uma opção listada no menu.");
        }
    }

    public void adicionarMedico() {
        System.out.println("Digite o nome do médico:");
        String nome = sc.nextLine();

        String crm;
        do {
            System.out.println("Digite o CRM do médico:");
            crm = sc.nextLine();

            for (Medico medico : medicos) {
                if (medico.getCrm().equals(crm)) {
                    System.out.println("Erro: Médico com este CRM já está cadastrado.");
                    crm = null;
                }
            }

            if (crm != null && (crm.replaceAll("[^0-9]", "").length() != 6 || crm.length() > 9)) {
                System.out.println("Erro: O CRM deve conter 6 dígitos numéricos e opcionalmente a sigla do estado de emissão.");
                System.out.println("Ex.: 123456, 123456/SC");
                crm = null;
            }

        } while(crm == null);

        int idade;
        do {
            System.out.println("Digite a idade do médico:");
            try {
                idade = sc.nextInt();
                sc.nextLine();
                if(idade <= 0){
                    System.out.println("Erro: Número inválido, digite um número inteiro e positivo.");
                    idade = 0;
                }
            } catch(InputMismatchException e) {
                sc.nextLine();
                idade = 0;
                System.out.println("Erro: Input inválido, digite um número inteiro e positivo.");
            }
        } while(idade == 0);


        System.out.println("Digite o telefone do médico:");
        String telefone = sc.nextLine();
        System.out.println("Digite a especialidade do médico:");
        String especialidade = sc.nextLine();

        Medico novoMedico = new Medico(nome, crm, idade, telefone, especialidade);
        medicos.add(novoMedico);
        System.out.println("Médico adicionado com sucesso.");
    }

    public void listarMedicos(){
        if(medicos.isEmpty()){
            System.out.println("Não há médicos cadastrados.");
        } else {
            System.out.println("Lista de médicos cadastrados:");
            for (Medico medico : medicos) {
                System.out.println("\nNome: " + medico.getNome() +
                        "\nCRM: " + medico.getCrm() +
                        "\nIdade: " + medico.getIdade() +
                        "\nTelefone: " + medico.getTelefone() +
                        "\nEspecialidade: " + medico.getEspecialidade());
            }
        }
    }
}