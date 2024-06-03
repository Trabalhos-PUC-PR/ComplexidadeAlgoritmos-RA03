import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Exercicio1 ex1 = new Exercicio1();
        //ex.print2D(ex.todasCombinacoesIterativo(10, 5));
        Exercicio2 ex2 = new Exercicio2();
        int max = ex1.combinacoesPossiveis(5,4);
        List<conjunto> teste = ex2.subconjunto(ex1.todasCombinacoesIterativo(8, 5),ex1.todasCombinacoesIterativo(8, 4),max);
        System.out.println(teste.size());
        for(conjunto i : teste){
            System.out.println(i);
        }
        System.out.println("oi");

        max = ex1.combinacoesPossiveis(5,3);
        teste = ex2.subconjunto(ex1.todasCombinacoesIterativo(8, 5),ex1.todasCombinacoesIterativo(8, 3),max);
        System.out.println(teste.size());
        for(conjunto i : teste){
            System.out.println(i);
        }
        System.out.println("oi");
        
    }
}