import java.util.Arrays;

public class conjunto{

  int[] conju;
  int[] contidos;
  int quantidade;
    
  public conjunto(int[] conju, int tamanho_max){
    this.conju = conju;
    this.contidos = new int[tamanho_max];
    this.quantidade = 0;
  }

  public void add(int contido){
    this.contidos[this.quantidade] = contido;
    this.quantidade++;
  }

  public int quantidade(){
    return this.quantidade;
  }

  public boolean contem(int contido){
    for(int i : conju){
      if(i == contido)return true;
    }
    return false;
  }

  public String toString(){
    String retorno = "[ ";
    for(int i : this.conju)retorno += i + ", ";
    retorno += "]: " + this.quantidade + " [ ";
    for (int i = 0; i < this.quantidade; i++) retorno += contidos[i] + ", ";
    retorno += "]";
    return retorno;
  }

  public boolean equals(Object o){
    conjunto cast = (conjunto) o;
    if (Arrays.equals(cast.conju, this.conju)) return true;
    return false;
  }

  
}