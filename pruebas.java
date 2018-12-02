import Grafos.Grafo;

public class pruebas {
  public static void main(String s[]){
    Grafo ejemplo = new Grafo(8);
    ejemplo.setAristaPeso(0, 1, 8.0);
    ejemplo.setAristaPeso(0, 3, 5.0);
    ejemplo.setAristaPeso(0, 2, 2.0);
    ejemplo.setAristaPeso(1, 3, 2.0);
    ejemplo.setAristaPeso(1, 5, 13.0);
    ejemplo.setAristaPeso(2, 3, 2.0);
    ejemplo.setAristaPeso(2, 4, 5.0);
    ejemplo.setAristaPeso(3, 4, 1.0);
    ejemplo.setAristaPeso(3, 6, 3.0);
    ejemplo.setAristaPeso(3, 5, 6.0);
    ejemplo.setAristaPeso(4, 6, 1.0);
    ejemplo.setAristaPeso(5, 6, 2.0);
    ejemplo.setAristaPeso(5, 7, 3.0);
    ejemplo.setAristaPeso(6, 7, 6.0);
    System.out.println(ejemplo);

    Grafo dijkstra = ejemplo.Dijsktra(0);


    //System.out.println(dijkstra);
  }
}
