import Grafos.Grafo;

public class Prueba {
  public static void main(String s[]){
    Grafo uno = new Grafo(358);
    uno.modeloER(237);
    uno.escribirArchivo("Salidas\\Salida1.gv");

    Grafo dos = new Grafo(589);
    dos.modeloER(500);
    uno.escribirArchivo("Salidas\\Salida2.gv");

    Grafo tres = new Grafo(1500);
    tres.modeloER(1289);
    tres.escribirArchivo("Salidas\\Salida3.gv");

    Grafo cuatro = new Grafo(358);
    cuatro.modeloGilbert(1);
    cuatro.escribirArchivo("Salidas\\Salida4.gv");

    Grafo cinco = new Grafo(589);
    cinco.modeloGilbert(0.3);
    cinco.escribirArchivo("Salidas\\Salida5.gv");

    Grafo seis = new Grafo(1500);
    seis.modeloGilbert(0.05);
    seis.escribirArchivo("Salidas\\Salida6.gv");

    Grafo siete = new Grafo(358, "geo-uniforme");
    siete.modeloGeoSimple(1);
    siete.escribirArchivo("Salidas\\Salida7.gv");

    Grafo ocho = new Grafo(589, "geo-uniforme");
    ocho.modeloGeoSimple(.5);
    ocho.escribirArchivo("Salidas\\Salida8.gv");

    Grafo nueve = new Grafo(1500, "geo-uniforme");
    nueve.modeloGeoSimple(0.1);
    nueve.escribirArchivo("Salidas\\Salida9.gv");

    Grafo diez = new Grafo(358);
    diez.modeloBA(30);
    diez.escribirArchivo("Salidas\\Salida10.gv");

    Grafo once = new Grafo(589);
    once.modeloBA(100);
    once.escribirArchivo("Salidas\\Salida11.gv");

    Grafo doce = new Grafo(1500);
    doce.modeloBA(135);
    doce.escribirArchivo("Salidas\\Salida12.gv");
  }
}
