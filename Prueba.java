import Grafos.Grafo;

public class Prueba {
  public static void main(String s[]){
    Grafo uno = new Grafo(30);
    uno.modeloER(15);
    uno.escribirArchivo("Salidas\\GV\\Salida01.gv");

    Grafo dos = new Grafo(100);
    dos.modeloER(73);
    dos.escribirArchivo("Salidas\\GV\\Salida02.gv");

    Grafo tres = new Grafo(500);
    tres.modeloER(380);
    tres.escribirArchivo("Salidas\\GV\\Salida03.gv");

    Grafo cuatro = new Grafo(30);
    cuatro.modeloGilbert(1);
    cuatro.escribirArchivo("Salidas\\GV\\Salida04.gv");

    Grafo cinco = new Grafo(100);
    cinco.modeloGilbert(0.3);
    cinco.escribirArchivo("Salidas\\GV\\Salida05.gv");

    Grafo seis = new Grafo(500);
    seis.modeloGilbert(0.05);
    seis.escribirArchivo("Salidas\\GV\\Salida06.gv");

    Grafo siete = new Grafo(30, "geo-uniforme");
    siete.modeloGeoSimple(0.9);
    siete.escribirArchivo("Salidas\\GV\\Salida07.gv");

    Grafo ocho = new Grafo(100, "geo-uniforme");
    ocho.modeloGeoSimple(.5);
    ocho.escribirArchivo("Salidas\\GV\\Salida08.gv");

    Grafo nueve = new Grafo(500, "geo-uniforme");
    nueve.modeloGeoSimple(0.1);
    nueve.escribirArchivo("Salidas\\GV\\Salida09.gv");

    Grafo diez = new Grafo(30);
    diez.modeloBA(20);
    diez.escribirArchivo("Salidas\\GV\\Salida10.gv");

    Grafo once = new Grafo(100);
    once.modeloBA(73);
    once.escribirArchivo("Salidas\\GV\\Salida11.gv");

    Grafo doce = new Grafo(500);
    doce.modeloBA(135);
    doce.escribirArchivo("Salidas\\GV\\Salida12.gv");
  }
}
