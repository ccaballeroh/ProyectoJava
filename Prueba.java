import Grafos.Grafo;

public class Prueba {
  public static void main(String s[]){
    Grafo uno = new Grafo(30);
    uno.modeloER(8);
    uno.escribirArchivo("Salidas\\GV\\01ER030.gv");

    Grafo dos = new Grafo(100);
    dos.modeloER(25);
    dos.escribirArchivo("Salidas\\GV\\01ER100.gv");

    Grafo tres = new Grafo(500);
    tres.modeloER(75);
    tres.escribirArchivo("Salidas\\GV\\01ER500.gv");

    Grafo cuatro = new Grafo(30);
    cuatro.modeloGilbert(0.25);
    cuatro.escribirArchivo("Salidas\\GV\\02Gilbert030.gv");

    Grafo cinco = new Grafo(100);
    cinco.modeloGilbert(0.25);
    cinco.escribirArchivo("Salidas\\GV\\02Gilbert100.gv");

    Grafo seis = new Grafo(500);
    seis.modeloGilbert(0.25);
    seis.escribirArchivo("Salidas\\GV\\02Gilbert500.gv");

    Grafo siete = new Grafo(30, "geo-uniforme");
    siete.modeloGeoSimple(0.3);
    siete.escribirArchivo("Salidas\\GV\\03Geo030.gv");

    Grafo ocho = new Grafo(100, "geo-uniforme");
    ocho.modeloGeoSimple(.3);
    ocho.escribirArchivo("Salidas\\GV\\03Geo100.gv");

    Grafo nueve = new Grafo(500, "geo-uniforme");
    nueve.modeloGeoSimple(0.3);
    nueve.escribirArchivo("Salidas\\GV\\03Geo500.gv");

    Grafo diez = new Grafo(30);
    diez.modeloBA(7);
    diez.escribirArchivo("Salidas\\GV\\04BA030.gv");

    Grafo once = new Grafo(100);
    once.modeloBA(25);
    once.escribirArchivo("Salidas\\GV\\04BA100.gv");

    Grafo doce = new Grafo(500);
    doce.modeloBA(100);
    doce.escribirArchivo("Salidas\\GV\\04BA500.gv");
  }
}
