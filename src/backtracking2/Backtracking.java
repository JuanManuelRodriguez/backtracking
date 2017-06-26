//Ejercicio 2.

//Partición de conjunto. Dado un conjunto de n enteros se desea encontrar, si existe, una

//partición en dos subconjuntos disjuntos, tal que la suma de sus elementos sea la misma.

//Compare los tiempos de ejecución de conjuntos de entrada con números enteros positivos

//generados al azar, conjuntos con 50, 100, 500 y 1000 elementos.
package backtracking2;

import java.util.Vector;

public class Backtracking {
	private Integer[] solParticion1;
	private Integer[] solParticion2;
	private Integer[] arr;

	
	public Backtracking(int cantElem,Integer[] arr) {
		this.solParticion1=new Integer[cantElem];
		this.solParticion2=new Integer[cantElem];
		this.arr=new Integer[cantElem];
		this.arr=arr.clone();

	}
	public void resolve(int suma1,int suma2,int pos,int agregar,Integer[] solucionParcial1,Integer[] solucionParcial2){
		int sumaActual1=suma1+arr[pos]*agregar;
		solucionParcial1[pos]=agregar;
		int sumaActual2;
		if(agregar==0){
			sumaActual2=suma2+arr[pos]*1;
			solucionParcial2[pos]=1;
		}else{
			sumaActual2=suma2+arr[pos]*0;
			solucionParcial2[pos]=0;
		}
		
		if(sumaActual1==sumaActual2 && llegoAlFinal(pos)){
			for (int i=0;i<solucionParcial1.length;i++){
				this.solParticion1[i]=solucionParcial1[i];
				this.solParticion2[i]=solucionParcial2[i];
			}
			return;
		}
		else{
			int hijo=0;
			while((hijo<=1) && !llegoAlFinal(pos)){
				resolve(sumaActual1,sumaActual2,pos+1,hijo,solucionParcial1,solucionParcial2);
				solucionParcial1[pos+1]=0;
				solucionParcial2[pos+1]=1;
				hijo++;
			}
		}
	}
	private boolean llegoAlFinal(int pos) {
		return pos==arr.length-1;
	}
	
	public Vector<Integer[]> retornoDeResultados(){
		Vector<Integer[]> resultados=new Vector<Integer[]>();
		resultados.add(solParticion1);
		resultados.add(solParticion2);
		return resultados;
	}
}
