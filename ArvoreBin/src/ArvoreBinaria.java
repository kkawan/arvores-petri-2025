public class ArvoreBinaria {

    private No raiz;

    // Construtor padrão vazio
    public ArvoreBinaria() {}

    // Método público para inserção
    public void inserir(int conteudo) {
        No novoNo = new No(conteudo);
        if (raiz == null) {
            raiz = novoNo;
        } else {
            inserirRecursivo(raiz, novoNo);
        }
    }

    // Inserção recursiva - apenas lógica da posição
    private void inserirRecursivo(No atual, No novoNo) {
        if (novoNo.getConteudo() < atual.getConteudo()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
            } else {
                inserirRecursivo(atual.getEsquerda(), novoNo);
            }
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
            } else {
                inserirRecursivo(atual.getDireita(), novoNo);
            }
        }
    }

    // Remoção pública
    public void remover(int conteudo) {
        raiz = removerRec(raiz, conteudo);
    }

    // Remoção recursiva
    private No removerRec(No atual, int conteudo) {
        if (atual == null) return null;

        if (conteudo < atual.getConteudo()) {
            atual.setEsquerda(removerRec(atual.getEsquerda(), conteudo));
        } else if (conteudo > atual.getConteudo()) {
            atual.setDireita(removerRec(atual.getDireita(), conteudo));
        } else {
            // Nó sem filhos
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                return null;
            }
            // Um filho
            if (atual.getEsquerda() == null) return atual.getDireita();
            if (atual.getDireita() == null) return atual.getEsquerda();

            // Dois filhos: encontra o sucessor
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

    // Métodos de visualização
    public void exibirEmOrdem() {
        emOrdem(raiz);
    }

    public void exibirPreOrdem() {
        preOrdem(raiz);
    }

    public void exibirPosOrdem() {
        posOrdem(raiz);
    }

    private void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.getEsquerda());
            System.out.println(no.getConteudo());
            emOrdem(no.getDireita());
        }
    }

    private void preOrdem(No no) {
        if (no != null) {
            System.out.println(no.getConteudo());
            preOrdem(no.getEsquerda());
            preOrdem(no.getDireita());
        }
    }

    private void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.getEsquerda());
            posOrdem(no.getDireita());
            System.out.println(no.getConteudo());
        }
    }
}
