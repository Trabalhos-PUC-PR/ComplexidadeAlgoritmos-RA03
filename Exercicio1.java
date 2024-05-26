package algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercicio1 {
	
	public static void main(String[] args) {		
		try {
			print2D(todasCombinacoesIterativo(25, 13));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static int[][] todasCombinacoesIterativo(int n, int k) throws RuntimeException {
		
		if (k > n) {
			throw new RuntimeException("k deve ser maior que n");
		}
		
		
		int cnk = combinacoesPossiveis(n,k);
		int[][] combinacoes = new int[cnk][k];
		int contador = 0;
		
		//gera array de 1 .. k
		int[] inicial = IntStream.range(1, k + 1).toArray(); 

		//Condição de parada: 
        //último elemento vira n+1 com reajuste
		while (inicial[k - 1] <= n) {
			 //adiciona combinação a lista
			 combinacoes[contador] = inicial.clone(); 
			 contador++;
			 
			 
			 int t = k - 1;
			 //verifica em qual elemento é possível incrementar 
			 while (t != 0 && inicial[t] == n - k + t + 1) { 
				 t--;
	         }
			 inicial[t]++;
			 
			 //realiza reajuste para novas combinações
			 // caso o elemento possível de incrementar não seja o mais a direita
	         for (int i = t + 1; i < k; i++) {
	        	 inicial[i] = inicial[i - 1] + 1;
	        	 
	         }
		}
		
		
		return combinacoes;
	} 
	
	
	
	
	
	
	public static void print2D(int mat[][])
    {
        
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }
	
	public static int combinacoesPossiveis(int n, int k) {
		long numerador = 1;
		long denominador = 1;
		
		for (long i = Math.max(n-k, k) + 1; i <= n; i++) {
			numerador *= i;
		}
		for (long j = 2; j <= Math.min(n-k, k); j++) {
			denominador *= j;
		}
		
		return (int) (numerador / denominador);
		
	}
	
	
}
