package Grafos;
import java.util.concurrent.ThreadLocalRandom;
import Grafos.nodos;

public class aristas{
  public int numero;
  public nodos nodes;
  public arista[] edges;

  public aristas(int numero, nodos nodes){
    this.numero = numero;
    this.nodes = nodes;
  }

  public void  modeloER(){
    this.edges = new arista[numero];
    for (int i = 0; i < numero; i++){
      int randomNum1 = ThreadLocalRandom.current().nextInt(0, numero + 1);
      int randomNum2 = ThreadLocalRandom.current().nextInt(0, numero + 1);
      nodo nodo1 = nodes.getNode(randomNum1);
      nodo nodo2 = nodes.getNode(randomNum2);
      arista edge = new arista(nodo1, nodo2);
      this.edges[i] = edge;
    }
  }

  public arista getEdge(int i){
    return this.edges[i];
  }

  public int getNumEdges(){
    return this.numero;
  }
}
