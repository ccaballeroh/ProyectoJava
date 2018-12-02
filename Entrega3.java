/*Archivo de prueba del uso del paquete Grafos*/
import Grafos.Grafo;

public class Entrega3 {
  public static void main(String s[]){

    /*Se crean dos salidas por cada modelo de grafo aleatorio.

    Todos las creaciones de objetos toman como argumento el número de vértices
    con excepción del modelo geográfico, que también toma la cadena que
    especifica que ese modelo. Esto para que cuando se creen los nodos, se creen
    con coordenadas aleatorias en el intervalo [0.0,1.0]

    Además se calculas árboles por cada grafo: un BFS y dos DFS*/


    Grafo uno = new Grafo(30);
    uno.modeloER(8); //número de aristas
    uno.escribirArchivo("Salidas\\GV\\01ER030_2.gv");
    Grafo unoBFS = uno.BFS(0);
    unoBFS.escribirArchivo("Salidas\\GV\\01ER030_2BFS.gv");
    Grafo unoDFS_R = uno.DFS_R(0);
    unoDFS_R.escribirArchivo("Salidas\\GV\\01ER030_2DFS_R.gv");
    Grafo unoDFS_I = uno.DFS_I(0);
    unoDFS_I.escribirArchivo("Salidas\\GV\\01ER030_2DFS_I.gv");

    Grafo dos = new Grafo(500);
    dos.modeloER(75); //número de aristas
    dos.escribirArchivo("Salidas\\GV\\01ER500_2.gv");
    Grafo dosBFS = dos.BFS(0);
    dosBFS.escribirArchivo("Salidas\\GV\\01ER500_2BFS.gv");
    Grafo dosDFS_R = dos.DFS_R(0);
    dosDFS_R.escribirArchivo("Salidas\\GV\\01ER500_2DFS_R.gv");
    Grafo dosDFS_I = dos.DFS_I(0);
    dosDFS_I.escribirArchivo("Salidas\\GV\\01ER500_2DFS_I.gv");

    Grafo tres = new Grafo(30);
    tres.modeloGilbert(0.25); //probabilidad
    tres.escribirArchivo("Salidas\\GV\\02Gilbert030_2.gv");
    Grafo tresBFS = tres.BFS(0);
    tresBFS.escribirArchivo("Salidas\\GV\\02Gilbert030_2BFS.gv");
    Grafo tresDFS_R = tres.DFS_R(0);
    tresDFS_R.escribirArchivo("Salidas\\GV\\02Gilbert030_2DFS_R.gv");
    Grafo tresDFS_I = tres.DFS_I(0);
    tresDFS_I.escribirArchivo("Salidas\\GV\\02Gilbert030_2DFS_I.gv");

    Grafo cuatro = new Grafo(500);
    cuatro.modeloGilbert(0.25); //probabilidad
    cuatro.escribirArchivo("Salidas\\GV\\02Gilbert500_2.gv");
    Grafo cuatroBFS = cuatro.BFS(0);
    cuatroBFS.escribirArchivo("Salidas\\GV\\02Gilbert500_2BFS.gv");
    Grafo cuatroDFS_R = cuatro.DFS_R(0);
    cuatroDFS_R.escribirArchivo("Salidas\\GV\\02Gilbert500_2DFS_R.gv");
    Grafo cuatroDFS_I = cuatro.DFS_I(0);
    cuatroDFS_I.escribirArchivo("Salidas\\GV\\02Gilbert500_2DFS_I.gv");

    Grafo cinco = new Grafo(30, "geo-uniforme");
    cinco.modeloGeoSimple(0.3);  //distancia a la que se deben conectar nodos
    cinco.escribirArchivo("Salidas\\GV\\03Geo030_2.gv");
    Grafo cincoBFS = cinco.BFS(0);
    cincoBFS.escribirArchivo("Salidas\\GV\\03Geo030_2BFS.gv");
    Grafo cincoDFS_R = cinco.DFS_R(0);
    cincoDFS_R.escribirArchivo("Salidas\\GV\\03Geo030_2DFS_R.gv");
    Grafo cincoDFS_I = cinco.DFS_I(0);
    cincoDFS_I.escribirArchivo("Salidas\\GV\\03Geo030_2DFS_I.gv");

    Grafo seis = new Grafo(500, "geo-uniforme");
    seis.modeloGeoSimple(0.3); //distancia a la que se deben conectar nodos
    seis.escribirArchivo("Salidas\\GV\\03Geo500_2.gv");
    Grafo seisBFS = seis.BFS(0);
    seisBFS.escribirArchivo("Salidas\\GV\\03Geo500_2BFS.gv");
    Grafo seisDFS_R = seis.DFS_R(0);
    seisDFS_R.escribirArchivo("Salidas\\GV\\03Geo500_2DFS_R.gv");
    Grafo seisDFS_I = seis.DFS_I(0);
    seisDFS_I.escribirArchivo("Salidas\\GV\\03Geo500_2DFS_I.gv");

    Grafo siete = new Grafo(30);
    siete.modeloBA(7);  //parámetro 'd' del modelo
    siete.escribirArchivo("Salidas\\GV\\04BA030_2.gv");
    Grafo sieteBFS = siete.BFS(0);
    sieteBFS.escribirArchivo("Salidas\\GV\\04BA030_2BFS.gv");
    Grafo sieteDFS_R = siete.DFS_R(0);
    sieteDFS_R.escribirArchivo("Salidas\\GV\\04BA030_2DFS_R.gv");
    Grafo sieteDFS_I = siete.DFS_I(0);
    sieteDFS_I.escribirArchivo("Salidas\\GV\\04BA030_2DFS_I.gv");

    Grafo ocho = new Grafo(500);
    ocho.modeloBA(100); //parámetro 'd' del modelo
    ocho.escribirArchivo("Salidas\\GV\\04BA500_2.gv");
    Grafo ochoBFS = ocho.BFS(0);
    ochoBFS.escribirArchivo("Salidas\\GV\\04BA500_2BFS.gv");
    Grafo ochoDFS_R = ocho.DFS_R(0);
    ochoDFS_R.escribirArchivo("Salidas\\GV\\04BA500_2DFS_R.gv");
    Grafo ochoDFS_I = ocho.DFS_I(0);
    ochoDFS_I.escribirArchivo("Salidas\\GV\\04BA500_2DFS_I.gv");
  }
}
