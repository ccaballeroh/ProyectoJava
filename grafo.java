package Grafos;
import Grafos.nodos;
import Grafos.aristas;


public class grafo
{
  public nodos nodes;
  public aristas edges;

  public grafo(int numNodos, int aristas)
  {
    nodos nodes = new nodos(numNodos);
    this.nodes = nodes;
    this.edges = new aristas(aristas, nodes);
    this.edges.modeloER();
  }

  public grafo(int numNodos, double probabilidad)
  {
    nodos nodes = new nodos(numNodos);
    this.nodes = nodes;
    int total = nodes.getNumNodes();
    int aristas = total*(total-1)/2;
    this.edges = new aristas(aristas, nodes);
    this.edges.modeloGilbert(probabilidad);

  }

  public void info()
  {
    System.out.println("Soy un grafo con " + this.nodes.getNumNodes()  + " nodos.");
    System.out.println("Soy un grafo con " + this.edges.getNumEdges() + " aristas.");
  }

  public void exportar(String nombreArchivo){
    System.out.println("graph {");
    for (int i = 0; i < this.nodes.getNumNodes(); i++){
      System.out.println(this.nodes.getNode(i).getName() + ";");
    }
    for (int i = 0; i < this.edges.getNumEdges(); i++){
      System.out.println(this.edges.getEdge(i).getNode(0).getName() + " -- " + this.edges.getEdge(i).getNode(1).getName() + ";");
      //System.out.println(this.edges.getEdge(i).getNode(1).getName() + ";");
    }
    System.out.println("}");
  }
}
