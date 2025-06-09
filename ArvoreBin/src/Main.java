public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Inserindo elementos
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Em ordem (deve estar ordenado):");
        arvore.exibirEmOrdem();

        System.out.println("\nPré-ordem:");
        arvore.exibirPreOrdem();

        System.out.println("\nPós-ordem:");
        arvore.exibirPosOrdem();

        // Remoção
        System.out.println("\nRemovendo o valor 70...");
        arvore.remover(70);

        System.out.println("\nEm ordem após remoção:");
        arvore.exibirEmOrdem();
    }
}
