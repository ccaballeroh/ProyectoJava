package Grafos;
import Grafos.nodo;

public class arista{
  public nodo[] nodos;

    public arista(nodo nodo1, nodo nodo2){
      nodos = new nodo[2];
      this.nodos[0] = nodo1;
      this.nodos[1] = nodo2;
    }

    public nodo getNode(int i){
      return this.nodos[i];
    }
}
