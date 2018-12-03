/*Archivo de prueba del uso del paquete Grafos*/
import Grafos.Grafo;

public class Entrega3 {
  public static void main(String s[]){

    /*Se crean dos salidas por cada modelo de grafo aleatorio.

    Todos las creaciones de objetos toman como argumento el número de vértices
    con excepción del modelo geográfico, que también toma la cadena que
    especifica que ese modelo. Esto para que cuando se creen los nodos, se creen
    con coordenadas aleatorias en el intervalo [0.0,1.0]

    Además se calculas árboles por cada grafo: un Dijkstra*/

    Grafo uno = new Grafo(30);
    uno.modeloER(90); //número de aristas
    Grafo unoPesado = uno.EdgeValues(1.0, 15.0);
    unoPesado.escribirArchivo("Salidas\\GV\\01ER030_3.gv");
    Grafo unoDijkstra = unoPesado.Dijkstra(0);
    unoDijkstra.escribirArchivo("Salidas\\GV\\01ER030_3Dijkstra.gv");

    Grafo dos = new Grafo(200);
    dos.modeloER(1000); //número de aristas
    Grafo dosPesado = dos.EdgeValues(1.0, 15.0);
    dosPesado.escribirArchivo("Salidas\\GV\\01ER200_3.gv");
    Grafo dosDijkstra = dosPesado.Dijkstra(0);
    dosDijkstra.escribirArchivo("Salidas\\GV\\01ER200_3Dijkstra.gv");

    Grafo tres = new Grafo(30);
    tres.modeloGilbert(0.25); //probabilidad
    Grafo tresPesado = tres.EdgeValues(1.0, 15.0);
    tresPesado.escribirArchivo("Salidas\\GV\\02Gilbert030_3.gv");
    Grafo tresDijkstra = tresPesado.Dijkstra(0);
    tresDijkstra.escribirArchivo("Salidas\\GV\\02Gilbert030_3Dijkstra.gv");

    Grafo cuatro = new Grafo(200);
    cuatro.modeloGilbert(0.25); //probabilidad
    Grafo cuatroPesado = cuatro.EdgeValues(1.0, 15.0);
    cuatroPesado.escribirArchivo("Salidas\\GV\\02Gilbert200_3.gv");
    Grafo cuatroDijkstra = cuatroPesado.Dijkstra(0);
    cuatroDijkstra.escribirArchivo("Salidas\\GV\\02Gilbert200_3Dijkstra.gv");

    Grafo cinco = new Grafo(30, "geo-uniforme");
    cinco.modeloGeoSimple(0.3);  //distancia a la que se deben conectar nodos
    Grafo cincoPesado = cinco.EdgeValues(1.0, 15.0);
    cincoPesado.escribirArchivo("Salidas\\GV\\03Geo030_3.gv");
    Grafo cincoDijkstra = cincoPesado.Dijkstra(0);
    cincoDijkstra.escribirArchivo("Salidas\\GV\\03Geo030_3Dijkstra.gv");

    Grafo seis = new Grafo(200, "geo-uniforme");
    seis.modeloGeoSimple(0.3); //distancia a la que se deben conectar nodos
    Grafo seisPesado = seis.EdgeValues(1.0, 15.0);
    seisPesado.escribirArchivo("Salidas\\GV\\03Geo200_3.gv");
    Grafo seisDijkstra = seisPesado.Dijkstra(0);
    seisDijkstra.escribirArchivo("Salidas\\GV\\03Geo200_3Dijkstra.gv");

    Grafo siete = new Grafo(30);
    siete.modeloBA(7);  //parámetro 'd' del modelo
    Grafo sietePesado = siete.EdgeValues(1.0, 15.0);
    sietePesado.escribirArchivo("Salidas\\GV\\04BA030_3.gv");
    Grafo sieteDijkstra = sietePesado.Dijkstra(0);
    sieteDijkstra.escribirArchivo("Salidas\\GV\\04BA030_3Dijkstra.gv");

    Grafo ocho = new Grafo(200);
    ocho.modeloBA(100); //parámetro 'd' del modelo
    Grafo ochoPesado = ocho.EdgeValues(1.0, 15.0);
    ochoPesado.escribirArchivo("Salidas\\GV\\04BA200_3.gv");
    Grafo ochoDijkstra = ochoPesado.Dijkstra(0);
    ochoDijkstra.escribirArchivo("Salidas\\GV\\04BA200_3Dijkstra.gv");
  }
}
