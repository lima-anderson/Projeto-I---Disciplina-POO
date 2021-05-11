//Anderson Lima

package projeto;

import java.util.Random;

public class Sorteio {
	private int n;
	private int[] numeros;
	private int min;
	private int max;
	private int sorteados;
	
	
	
	public Sorteio(int n, int min, int max) throws Exception {

		if(n >= 100 || n <= 0) {
			throw new Exception("A quantidade de números é inválida");
		}

		if(min <= 0 || max <= 0 || min > max ) {
			throw new Exception("Valor min/max é inválido");
		}
		
		this.n = n;
		this.min = min;
		this.max = max;
		this.numeros = new int[n];
		this.sorteados = 0;
		
	};

	
	public void  proximoNumero() throws Exception {
		
		if (!terminou()) {
			
			Random random = new Random();
			
			
			boolean inserir = false;
			
			while(!inserir) {
				
				int num = random.nextInt((max - min) + 1) + min;
				
				int contador = 0;
				for (int i = 0; i < this.n; i++) {
					if (num != this.numeros[i]) {
						contador++;
					}
				}
				
				if (!this.terminou() && (contador == this.n)) {
					int index = this.sorteados;
					
					this.numeros[index] = num;
					this.sorteados++;
					inserir = true;
				}				
			}
			
		}
		else {
			throw new Exception("Sorteio já terminou");
		}
		
	}	
	
		
	public void gerarNumeros(){
		for (int i = this.sorteados; i < this.n; i++) {
			try {
				this.proximoNumero();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	public boolean terminou() {
		return this.sorteados == this.n;
	}
	

	public String resultado(String padrao) throws Exception {
		
		
		if (padrao == null) {
			throw new Exception("Padrão inválido");
		}
		
		else {
			
			int aux;
	        for(int i = 0; i < n; i++) {
	            for(int j = 0; j < n; j++) {
	                if(this.numeros[i]!= 0) {
	                    if(this.numeros[i] < this.numeros[j]) {
	                    aux = this.numeros[j];
	                    this.numeros[j] = this.numeros[i];
	                    this.numeros[i] = aux;
	                    }
	                }	
		        }
		    }
			
			
			String lista = new String();

			for (int i = 0; i < n; i++) {
				if (i < n-1) {
					lista += Integer.toString(this.numeros[i]) + padrao;
				}
				else {
					lista += Integer.toString(this.numeros[i]);
				}	
		 	}
			return lista;
			
		} 		
	}
}




