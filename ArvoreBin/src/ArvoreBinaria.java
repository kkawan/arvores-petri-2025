public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria(int conteudo) {
        raiz = new No(conteudo);
    }


    public void inserirRecursivo(No raizAtual, No novoNo) {
        if(this.raiz == null) {
            raiz = novoNo;
            return;
        }
        if(novoNo.getConteudo() > raizAtual.getConteudo()) {
            if(raizAtual.getDireita() == null) {
                raizAtual.setDireita(novoNo);
                return;
            } else {
                inserirRecursivo(raizAtual.getDireita(), novoNo);
            }
        } else {
            if(raizAtual.getEsquerda() == null) {
                raizAtual.setEsquerda(novoNo);
                return;
            } else {
                inserirRecursivo(raizAtual.getEsquerda(), novoNo);
            }
        }
    }


    public void visualizar() {
        posOrdem(raiz);
    }

    public void emOrdem(No no) {
        if (no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    public void posOrdem(No no){
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    public void preOrdem(No no){
        if (no == null){
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    public void remover(int conteudo) {
        raiz = removerRec(raiz, conteudo);
    }

    private No removerRec(No atual, int conteudo) {
        if (atual == null) return null;

        if (conteudo < atual.getConteudo()) {
            atual.setEsquerda(removerRec(atual.getEsquerda(), conteudo));
        } else if (conteudo > atual.getConteudo()) {
            atual.setDireita(removerRec(atual.getDireita(), conteudo));
        } else {
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                return null;
            }

            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            No sucessor = encontrarMenor(atual.getDireita());
            atual.setConteudo(sucessor.getConteudo());
            atual.setDireita(removerRec(atual.getDireita(), sucessor.getConteudo()));
        }

        return atual;
    }

    private No encontrarMenor(No no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }

}