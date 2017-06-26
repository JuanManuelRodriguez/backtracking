package backtracking;

import java.util.Vector;

public class back1 {
	private Vector<Integer[]> solTotal;
	private Integer[] arr;
	private int result;

	
	public back1(int result,int cantElem,Integer[] arr){
		this.solTotal=new Vector<Integer[]>();
		this.arr=new Integer[cantElem];
		this.arr=arr.clone();
		this.result=result;

	}
	public void solution(int suma,int pos, int agregar,Integer[] solucionParcial){//Esta funcion hace el backtracking.	
		int sumaActual=suma+arr[pos]*agregar;
		solucionParcial[pos]=agregar;
		if(sumaActual==result){
			Integer[] arrAux=new Integer[solucionParcial.length];
			for (int i=0;i<solucionParcial.length;i++){
				arrAux[i]=solucionParcial[i];
			}
			solTotal.add(arrAux);
			return;
		}
		else{
			int hijo=0;
			while((hijo<=1) && !llegoAlFinal(pos)){
				if(!poda(sumaActual)){
					solution(sumaActual,pos+1,hijo,solucionParcial);
					solucionParcial[pos+1]=0;
				}
				hijo++;
			}
		}
	}
	private boolean poda(int suma) {
		return suma > result;
	}
	private boolean llegoAlFinal(int pos) {
		return pos==arr.length-1;
	}
	public Vector<Integer[]> retornoDeResultados(){
		return solTotal;
	}
}
