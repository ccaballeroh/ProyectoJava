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

    grafo cuatro = new grafo(358);
    cuatro.modeloGilbert(1);
    cuatro.escribirArchivo("Salidas\\Salida.gv");

    grafo cinco = new grafo(589);
    cinco.modeloGilbert(0.3);
    cinco.escribirArchivo("Salidas\\Salida5.gv");

    grafo seis = new grafo(1500);
    seis.modeloGilbert(0.05);
    seis.escribirArchivo("Salidas\\Salida6.gv");

    grafo siete = new grafo(358, "geo-uniforme");
    siete.modeloGeoSimple(1);
    siete.escribirArchivo("Salidas\\Salida7.gv");

    grafo ocho = new grafo(589, "geo-uniforme");
    ocho.modeloGeoSimple(.5);
    ocho.escribirArchivo("Salidas\\Salida8.gv");

    grafo nueve = new grafo(1500, "geo-uniforme");
    nueve.modeloGeoSimple(0.1);
    nueve.escribirArchivo("Salidas\\Salida9.gv");

    grafo diez = new grafo(358);
    diez.modeloBA(30);
    diez.escribirArchivo("Salidas\\Salida10.gv");

    grafo once = new grafo(589);
    once.modeloBA(100);
    once.escribirArchivo("Salidas\\Salida11.gv");

    grafo doce = new grafo(1500);
    doce.modeloBA(135);
    doce.escribirArchivo("Salidas\\Salida12.gv");
  }
}
