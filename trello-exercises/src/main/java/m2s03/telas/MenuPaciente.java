package m2s03.telas;

import m2s03.entidades.Paciente;
import m2s03.repositorio.ListaPacientes;

import java.util.Scanner;

public class MenuPaciente {

    public void opcaoDetalhar(Scanner sc) {
        System.out.print("Informe o ID do paciente: ");
        int idPacienteSelecionado = sc.nextInt();
        Paciente pacienteSelecionado = ListaPacientes.buscarPaciente(idPacienteSelecionado);
        pacienteSelecionado.monitorarPaciente();
    }

    public void opcaoCadastrarAtividade(Scanner sc) {
        System.out.print("Informe o ID do paciente: ");
        int idPacienteSelecionado = sc.nextInt();
        System.out.print("Nova atividade: ");
        String novaAtividadeFisica = sc.next();
        Paciente pacienteSelecionado = ListaPacientes.buscarPaciente(idPacienteSelecionado);
        pacienteSelecionado.registrarAtividade(novaAtividadeFisica);
    }

    public void opcaoRemover(Scanner sc) {
        System.out.print("Informe o ID do paciente: ");
        int idPacienteSelecionado = sc.nextInt();
        ListaPacientes.removerPaciente(idPacienteSelecionado);
    }

}
