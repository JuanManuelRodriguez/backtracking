//Ejercicio 4.

//Asignación de tareas a procesadores. Se tienen m procesadores idénticos y n tareas con un

//tiempo de ejecución dado. Se requiere encontrar una asignación de tareas a procesadores

//de manera de minimizar el tiempo de ejecución del total de tareas.
package backtracking4;

import java.util.Vector;

public class Backtracking {
	private Vector<Vector<Integer>> solProcesadores;
	private Integer[] arrTiempoSolucionProc;
	private Integer[] arrTareas;
	private int cantProc;
	private int cantOptima;
	
	public Backtracking(Integer[] tareas,int cantProcesadores){
		solProcesadores=new Vector<Vector<Integer>>();
		for(int i=0;i<cantProcesadores;i++){
			solProcesadores.add(new Vector<Integer>());
		}
		arrTareas=new Integer[tareas.length];
		arrTareas=tareas.clone();
		this.cantProc=cantProcesadores;
		int suma=0;
		for(int j=0;j<arrTareas.length;j++){
			suma+=arrTareas[j];
		}
		cantOptima=suma/arrTareas.length;
	}
	//cada intancia de la recursion es una tarea que se agrega a todos los procesadores buscando la solucion optima
	public void asignacionProcesadores(int capacidadMaxProc,int nroProc, int pos,Integer[] espacioOcupProc,Vector<Vector<Integer>> solParcial){//espacioDispProc[cantProcesadores]- dice el espacio que queda libre por procesador
		espacioOcupProc[nroProc]+=arrTareas[pos];
		solParcial.elementAt(nroProc).add(arrTareas[pos]);
		if(llegoAlFinal(pos)){
			if(solucionOptima(espacioOcupProc)){
				Vector<Vector<Integer>> solOptimaAux=new Vector<Vector<Integer>>();
				for (int i = 0; i < cantProc; i++) {
					solOptimaAux.add(new Vector<Integer>());
					for(int j=0;j<solParcial.elementAt(i).size();j++){
						solOptimaAux.elementAt(i).add(solParcial.elementAt(i).elementAt(j));
					}
				}
				solProcesadores=solOptimaAux;
			}
		}
		else{
			int hijo=0;
			while(hijo<cantProc){
				if(!poda(espacioOcupProc,capacidadMaxProc)){
					asignacionProcesadores(capacidadMaxProc,hijo, pos+1, espacioOcupProc);
					//sacar la tarea que agregue del procesador X
				}
				
			}
		}
	}
	
	private boolean poda(Integer[] espacioDispProc,int capacidadMaxProc) {
		for(int i=0;i<this.cantProc;i++){
			if(espacioDispProc[i]>capacidadMaxProc ){
				return true;
			};
		}
		return false;
	}
	private boolean solucionOptima(Integer[] espacioOcupProc) {
		int peorProc=0;
		int peorProcSol=0;
		for(int i=0;i<cantProc;i++){
			if(Math.abs(cantOptima-espacioOcupProc[i])>peorProc){
				peorProc=Math.abs(cantOptima-espacioOcupProc[i]);
			}
			if(Math.abs(cantOptima-arrTiempoSolucionProc[i])>peorProcSol){
				peorProcSol=Math.abs(cantOptima-arrTiempoSolucionProc[i]);
			}
		}
		if(peorProcSol>peorProc){
			return true;
		}
		return false;
	}
	private boolean llegoAlFinal(int pos) {
		return pos==arrTareas.length-1;
	}
}
