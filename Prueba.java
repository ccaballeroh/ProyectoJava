import Grafos.Graph;

public class Prueba {
  public static void main(String s[]){
    Graph uno = new Graph(358);
    uno.modeloER(237);
    uno.escribirArchivo("Salidas\\Salida1.gv");

    Graph dos = new Graph(589);
    dos.modeloER(500);
    uno.escribirArchivo("Salidas\\Salida2.gv");

    Graph tres = new Graph(1500);
    tres.modeloER(1289);
    tres.escribirArchivo("Salidas\\Salida3.gv");

    Graph cuatro = new Graph(358);
    cuatro.modeloGilbert(1);
    cuatro.escribirArchivo("Salidas\\Salida4.gv");

    Graph cinco = new Graph(589);
    cinco.modeloGilbert(0.3);
    cinco.escribirArchivo("Salidas\\Salida5.gv");

    Graph seis = new Graph(1500);
    seis.modeloGilbert(0.05);
    seis.escribirArchivo("Salidas\\Salida6.gv");

    Graph siete = new Graph(358, "geo-uniforme");
    siete.modeloGeoSimple(1);
    siete.escribirArchivo("Salidas\\Salida7.gv");

    Graph ocho = new Graph(589, "geo-uniforme");
    ocho.modeloGeoSimple(.5);
    ocho.escribirArchivo("Salidas\\Salida8.gv");

    Graph nueve = new Graph(1500, "geo-uniforme");
    nueve.modeloGeoSimple(0.1);
    nueve.escribirArchivo("Salidas\\Salida9.gv");

    Graph diez = new Graph(358);
    diez.modeloBA(30);
    diez.escribirArchivo("Salidas\\Salida10.gv");

    Graph once = new Graph(589);
    once.modeloBA(100);
    once.escribirArchivo("Salidas\\Salida11.gv");

    Graph doce = new Graph(1500);
    doce.modeloBA(135);
    doce.escribirArchivo("Salidas\\Salida12.gv");
  }
}
