import Grafos.Grafo;

public class pruebaBFS {
  public static void main(String s[]){
  Grafo uno = new Grafo(30);
  uno.modeloER(60);
  Grafo bfs = uno.BFS(1);
  System.out.println(bfs);
  }
}
