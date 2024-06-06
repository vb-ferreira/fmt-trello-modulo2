package m2s04.utils;

public enum Operacao {

    ADICIONAR(1), LISTAR(2), SAIR(0);

    private final int opcao;

    Operacao(int opcao) {
        this.opcao = opcao;
    }

    public static Operacao getOpcao(int opcaoSelecionada) {
        Operacao[] operacoes = Operacao.values();
        for (Operacao opr : operacoes) {
            if (opr.opcao == opcaoSelecionada) {
                return opr;
            }
        }
        return null;
    }

    public int getOpcao() {
        return opcao;
    }

}