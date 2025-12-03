package src;

import java.util.Scanner;

public class Main {
    static int esquerda = 0, direita = 0,  alturaEsq = 0, alturaDir = 0;
    public static void main(String[] args) {
        //Arvore binaria comum
        //
        //objetivo:
        //
        //inserção
        //
        //percursos (pré, in, pós)
        //
        //impressão visual da árvore(nivel)
        //
        //busca
        //
        //remoção
        //altura da arvore
        //contar nós
        //contar folhas
        //profundidade de um nó

        Scanner sc = new Scanner(System.in);

        No<String> raiz = inserirNaArvore(sc);

        System.out.println("Imprimindo arvore utilizando o percurso preOrdem:");
        preOrdem(raiz);

        System.out.println("Imprimindo arvore utilizando o percurso emOrdem:");
        emOrdem(raiz);

        System.out.println("Imprimindo arvore utilizando o percurso posOrdem:");
        posOrdem(raiz);

        System.out.println("Quantidade de nós que a arvore possui: " + quantidadeNos(raiz));
        System.out.println("Quantidade de folhas que a arvore possui: " + quantidadeFolhas(raiz));

        System.out.print("Informe o valor que deseja buscar na arvore: ");
        String valor = sc.next();


          if (buscarValor(raiz, "E")) {
            System.out.println("Valor encontrado!");
          }
          else{
            System.out.println("Valor não encontrado!");
          }

        System.out.print("Altura da arvore: " + alturaArvore(raiz));


        sc.close();
    }

    public static No<String> inserirNaArvore(Scanner sc) {
        System.out.print("Criar árvore binária comum? (1 - Sim / 2 - Não): ");
        int opc = sc.nextInt();

        if (opc == 2) return null;

        System.out.print("Informe o valor: ");
        String valor = sc.next();
        No<String> no = new No<>();
        no.setValor(valor);

        System.out.println("Deseja criar um nó para a esquerda do valor: " + valor + "?");
        no.setEsquerda(inserirNaArvore(sc));

        System.out.println("Deseja criar um nó para a direita do valor: " + valor + "?");
        no.setDireita(inserirNaArvore(sc));

        return no;
    }

    public static void preOrdem(No<String> no) {
        if (no == null) return;
        System.out.println(no.getValor());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    public static void emOrdem(No<String> no) {
        if (no == null) return;
        emOrdem(no.getEsquerda());
        System.out.println(no.getValor());
        emOrdem(no.getDireita());
    }

    public static void posOrdem(No<String> no) {
        if (no == null) return;
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getValor());
    }


    public static int quantidadeNos(No<String> no) {
        if(no == null) return 0;

        esquerda = quantidadeNos(no.getEsquerda());
        direita = quantidadeNos(no.getDireita());

        return esquerda + direita + 1;
    }

    public static int quantidadeFolhas(No<String> no) {
        if (no == null) return 0;

        if (no.getEsquerda() == null && no.getDireita() == null){
            return 1;
        }

        return quantidadeFolhas(no.getEsquerda()) + quantidadeFolhas(no.getDireita());
    }

    public static boolean buscarValor(No<String> no, String valor) {
        if (no == null) return false;

        if (no.getValor().equals(valor)){
            return true;
        }

        if (buscarValor(no.getEsquerda(), valor)){
            return true;
        }

        if (buscarValor(no.getDireita(), valor)){
            return true;
        }

        return false;
    }

    public static int alturaArvore(No<String> no){
        if (no == null) return 0;

        alturaEsq = alturaArvore(no.getEsquerda());
        alturaDir = alturaArvore(no.getDireita());

       return Math.max(alturaEsq, alturaDir) + 1;
    }
}
