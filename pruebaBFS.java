import Grafos.Grafo;

public class pruebaBFS {
  public static void main(String s[]){
  // Grafo nueve = new Grafo(200);
  // nueve.modeloGilbert(.9); //distancia a la que se deben conectar nodos
  // Grafo dfs = nueve.DFS_R(1);
  // System.out.println(dfs);
  Grafo nueve = new Grafo(50, "geo-uniforme");
  nueve.modeloGeoSimple(0.3);
  //System.out.println(nueve);
  Grafo dfs = nueve.BFS(30);
  System.out.println(dfs);
  }
}
