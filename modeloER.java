import Grafos.grafo;

public class modeloER{
  public static void main(String s[]){
    grafo red = new grafo(100, 0.1);
    //red.info();
    red.exportar("nombreArchivo.gv");
  }
}
