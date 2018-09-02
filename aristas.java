package Grafos;
import java.util.Random;
import Grafos.nodos;

public class aristas{
  public int numero;
  public nodos nodes;
  public arista[] edges;

  public aristas(int numero, nodos nodes){
    this.numero = numero;
    this.nodes = nodes;
  }

  public void modeloER(){
    this.edges = new arista[numero];
    Random randomNum1 = new Random();
    Random randomNum2 = new Random();
    for (int i = 0; i < numero; i++){
      nodo nodo1 = this.nodes.getNode(randomNum1.nextInt(numero));
      nodo nodo2 = this.nodes.getNode(randomNum2.nextInt(numero));
      arista edge = new arista(nodo1, nodo2);
      this.edges[i] = edge;
    }
  }

  public void modeloGilbert(double probabilidad){
    this.edges = new arista[this.numero];
    arista[] temporal = new arista[numero];
    int total = this.nodes.getNumNodes();
    Random randomNum = new Random();
    int contador = 0;
    for(int i = 0; i < total-1; i++ ){
      for(int j = i+1; j < total; j++){
        if(randomNum.nextDouble() < probabilidad){
          //System.out.println("i: " + i + " j: " + j + " contador: " + contador);
          nodo nodo1 = this.nodes.getNode(i);
          nodo nodo2 = this.nodes.getNode(j);
          arista edge = new arista(nodo1, nodo2);
          //System.out.println("Se agrego: " + edge.getNode(0).getName() + " -- " + edge.getNode(1).getName());
          this.edges[contador] = edge;
          contador++;
        }
      }
    }
    this.numero = contador;
  }
  
  public arista getEdge(int i){
    return this.edges[i];
  }

  public int getNumEdges(){
    return this.numero;
  }
}
