package backtracking;

import java.util.Vector;

public class Ejecutar {
	private static int minimum=1;
	
	//metodo que devuelve el resultado de la mult. del arreglo de numeros con el de de 0/1 para comprobar que esa fila es = a resultEsp
	public static int sumaResultado(Integer[] numeros,Integer[] esta){
		int suma=0;
		for (int x=0;x<numeros.length;x++){
			suma+=numeros[x]*esta[x];
		}
		return suma;
	}
	
	public static void main(String[] args) {
		int cantElems=50;
		int resultadoEsp= 75; //resultado esperado. Es el numero con el que compara la suma para agregarlo a la solucion o no.
		//Inicializacion del arreglo solucion
		Integer[] solucion=new Integer[cantElems];
		for(int j = 0; j < cantElems; j++){//inicializo solucion
			solucion[j]=0;
		}
		//Generaccion de los numeros aleatorios
		Integer[] arr=new Integer[cantElems];
		for (int i = 0; i < cantElems; i++) { 
			arr[i] = minimum + (int)(Math.random() * (resultadoEsp - minimum));
		}
		//funciona con la version hardcodeada.
//		arr[0]=23;
//		arr[1]=35;
//		arr[2]=40;
//		arr[3]=34;
//		arr[4]=52;
//		arr[5]=41;
		
		
		for (int i = 0; i < arr.length; i++) { 
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		
		back1 back=new back1(resultadoEsp,cantElems,arr);
		
		back.solution(0, 0, 0, solucion); // 1er param: suma - 2do param: pos - 3er param: agregar- 4to param: solucionParcial				if(arr[0] <= resultadoEsp){
		back.solution(0, 0, 1, solucion); // 1er param: suma - 2do param: pos - 3er param: agregar- 4to param: solucionParcial
	
		
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
