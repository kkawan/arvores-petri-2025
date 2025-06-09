public class No {
    private int conteudo;
    private No direita;
    private No esquerda;

    public No(int conteudo) {
        this.conteudo = conteudo;
        this.direita = null;
        this.esquerda = null;
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
}
