package algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercicio1 {
	
	public static void main(String[] args) {		
		try {
			long timeMillis = System.currentTimeMillis();

			//print2D(todasCombinacoesIterativo(25, 12));
		
			//System.out.println(nEquals(array1,array2, 3));
			//System.out.println(Teste(10, 5 , 4 , 1));
			System.out.println(Exercicio2(13,8,7));
			//System.out.println(nEquals(a1,a2, 10));
			
			long timeMillis2 = System.currentTimeMillis() - timeMillis;

			System.out.print("Tempo de processamento : ");
			System.out.println(timeMillis2);
			
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

	public static double Exercicio2(int n, int k1, int k2){
		
		int cnk = combinacoesPossiveis(n, k2);
		int[] abrangencia2 = new int[cnk];
		
		int[][] s1 = todasCombinacoesIterativo(n, k1);
		
		int[][] s2 = todasCombinacoesIterativo(n, k2);
		
		int abrangencia_total = 0;
		int abrangencia = 0;
		int n_conjuntos= 0;
		
		for(int step = 0; step < s1.length/ k2; step++) {
			for(int i = step; i < s1.length; i+= k2) {
				abrangencia = 0;
				for(int j = 0; j < s2.length; j++) {
					if (abrangencia2[j] == 0 && nEquals(s1[i],  s2[j], n) == k2) {
						abrangencia++;
						abrangencia2[j] = 1;
						abrangencia_total++;
					}
				}
				if(abrangencia == 0) { n_conjuntos--; i+=2;}
				n_conjuntos++;
				
				if (abrangencia_total == cnk) break;
			}
			if (abrangencia_total == cnk) break;
		}

		return (double) n_conjuntos;
	}

	public static int nEquals(int[] array1, int[] array2, int n) {
		
		int[] equality = new int[n];
		int[] equality2 = new int[n];
		
		for(int i = 0; i < array1.length; i++) {
			equality[array1[i] - 1] = 1;
		}
		
		for(int j = 0; j < array2.length; j++) {
			equality2[array2[j] - 1] = 1;
		}
		
		int sum = 0;
		for(int k = 0; k < equality.length; k++) {
			sum += (equality[k] == 1) && (equality[k] == equality2[k])? 1:0;
		} 
		return sum;
	}
	
	
	
}
