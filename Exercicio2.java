import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Exercicio2 {

  public static List<conjunto> subconjunto(int[][] sub, int[][] conju, int max){
    Random gera = new Random();
    List<conjunto> conjuntos = new LinkedList<conjunto>();
    List<conjunto> subconj = new LinkedList<conjunto>();
    List<int[]> conjus = new LinkedList<int[]>();
    for(int i = 0; i < conju.length; i++) conjus.add(conju[i]);
    for(int i = 0; i < sub.length; i++) conjuntos.add(new conjunto(sub[i], max));
    int rodadas = 0;
    while (!(conjus.size() == 0)){
      List<conjunto> maximos = new LinkedList<conjunto>();
      int maximo = 1;
      
      for(conjunto i : conjuntos){
        int ident_conj = 0;
        conjunto copia = new conjunto(i.conju, max);
        for(int[] j: conjus){
          boolean contem = true;
          
          for(int elem : j){
            if (!copia.contem(elem)) {
              contem = false;
              break;
            }          
          }
          
          if (contem){
            copia.add(ident_conj);
            if(copia.quantidade == max) break;
          }
          ident_conj++;
        }
        
        if(copia.quantidade > maximo){
          maximos = new LinkedList<conjunto>();
          maximo = copia.quantidade;
          maximos.add(copia);
        }else if(copia.quantidade == maximo){
          maximos.add(copia);
        } 
      }
      int vezes = conjuntos.size() * conjus.size() * conju[0].length;
      rodadas += vezes;
      System.out.printf("Rodei pelo maximo: %d * %d * %d = %d\n", conjuntos.size(), conjus.size(), conju[0].length, vezes);
      int aleatorio = gera.nextInt(maximos.size());
      conjunto maior = maximos.get(aleatorio);
      for(int i = 0; i < maior.quantidade(); i++) conjus.remove(maior.contidos[i] - i);   
      conjuntos.remove(maior);
      subconj.add(maior);

    }
    System.out.printf("Rodei %d vezes\n", rodadas);
    return  subconj;
    
  }
}