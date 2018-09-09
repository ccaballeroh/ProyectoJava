import Grafos.Nodo;
import Grafos.grafo;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Iterator;

public class Prueba {
  public static void main(String s[]){
    grafo uno = new grafo(358);
    uno.modeloER(237);
    uno.escribirArchivo("Salidas\\Salida1.gv");

    grafo dos = new grafo(589);
    dos.modeloER(500);
    uno.escribirArchivo("Salidas\\Salida2.gv");

    grafo tres = new grafo(1500);
    tres.modeloER(1289);
    tres.escribirArchivo("Salidas\\Salida3.gv");
  }
}
