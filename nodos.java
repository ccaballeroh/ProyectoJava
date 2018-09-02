package Grafos;
import Grafos.nodo;

public class nodos
{
  public nodo[] nodes;
  public int numero;

  public nodos(int numero)
  {
    this.nodes = new nodo[numero];
    this.numero = numero;
    for (int i = 0; i < numero; i++){
        nodo node = new nodo(i);
        this.nodes[i] = node;
    }
  }

  public int getNumNodes()
  {
    return numero;
  }

  public nodo getNode(int i){
    return this.nodes[i];
  }
}
