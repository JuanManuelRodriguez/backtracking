package backtracking2;

import backtracking.back1;

public class Ejecutar {
	private static int minimum=1;
	private static int maximum=30;
	
	//metodo que devuelve el resultado de la mult. del arreglo de numeros con el de de 0/1 para comprobar que esa fila es = a resultEsp
	public static int sumaResultado(Integer[] numeros,Integer[] esta){
		int suma=0;
		for (int x=0;x<numeros.length;x++){
			suma+=numeros[x]*esta[x];
		}
		return suma;
	}
	
	public static void main(String[] args) {
		int cantElems=20;
		
		//Inicializacion del arreglo solucion
		Integer[] solucionPart=new Integer[cantElems];
		Integer[] solucionPart2=new Integer[cantElems];
		for(int j = 0; j < cantElems; j++){//inicializo las soluciones
			solucionPart[j]=0;
			solucionPart2[j]=1;
		}
		
		//Generaccion de los numeros aleatorios
		Integer[] arr=new Integer[cantElems];
		for (int i = 0; i < cantElems; i++) { 
			arr[i] = minimum + (int)(Math.random() * (maximum - minimum));
		}
		//funciona con la version hardcodeada.
//		arr[0]=25;
//		arr[1]=20;
//		arr[2]=5;
//		arr[3]=12;
//		arr[4]=30;
//		arr[5]=8;
		
		//impresion del arreglo de numeros generados aleatoriamente
		for (int i = 0; i < arr.length; i++) { 
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		Backtracking back=new Backtracking(cantElems,arr);
		
		back.resolve(0,0,0,0, solucionPart,solucionPart2); // 1er param: suma - 2do param: suma2 - 3er param: pos - 4to param: agregar- 5to param: solucionParcial1- 6to param: solucionParcial2	
		back.resolve(0,0,0,1, solucionPart,solucionPart2); // 1er param: suma - 2do param: suma2 - 3er param: pos - 4to param: agregar- 5to param: solucionParcial1- 6to param: solucionParcial2
	
		
		//Impresion de los resultados
		for(int i=0;i<back.retornoDeResultados().size();i++){
			for(int j=0;j<back.retornoDeResultados().elementAt(i).length;j++){
				System.out.print(back.retornoDeResultados().elementAt(i)[j]+" ");
			}
			System.out.print(sumaResultado(arr,back.retornoDeResultados().elementAt(i)));
			System.out.println();
		}
	}

}
