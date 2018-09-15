/*Archivo de prueba del uso del paquete Grafos*/
import Grafos.Grafo;

public class Prueba {
  public static void main(String s[]){

    /*Se crean tres salidas por cada modelo de grafo aleatorio.

    Todos las creaciones de objetos toman como argumento el número de vértices
    con excepción del modelo geográfico, que también toma la cadena que
    especifica que ese modelo. Esto para que cuando se creen los nodos, se creen
    con coordenadas aleatorias en el intervalo [0.0,1.0]*/


    Grafo uno = new Grafo(30);
    uno.modeloER(8); //número de aristas
    uno.escribirArchivo("Salidas\\GV\\01ER030.gv");

    Grafo dos = new Grafo(100);
    dos.modeloER(25); //número de aristas
    dos.escribirArchivo("Salidas\\GV\\01ER100.gv");

    Grafo tres = new Grafo(500);
    tres.modeloER(75); //número de aristas
    tres.escribirArchivo("Salidas\\GV\\01ER500.gv");

    Grafo cuatro = new Grafo(30);
    cuatro.modeloGilbert(0.25); //probabilidad
    cuatro.escribirArchivo("Salidas\\GV\\02Gilbert030.gv");

    Grafo cinco = new Grafo(100);
    cinco.modeloGilbert(0.25); //probabilidad
    cinco.escribirArchivo("Salidas\\GV\\02Gilbert100.gv");

    Grafo seis = new Grafo(500);
    seis.modeloGilbert(0.25); //probabilidad
    seis.escribirArchivo("Salidas\\GV\\02Gilbert500.gv");

    Grafo siete = new Grafo(30, "geo-uniforme");
    siete.modeloGeoSimple(0.3);  //distancia a la que se deben conectar nodos
    siete.escribirArchivo("Salidas\\GV\\03Geo030.gv");

    Grafo ocho = new Grafo(100, "geo-uniforme");
    ocho.modeloGeoSimple(.3); //distancia a la que se deben conectar nodos
    ocho.escribirArchivo("Salidas\\GV\\03Geo100.gv");

    Grafo nueve = new Grafo(500, "geo-uniforme");
    nueve.modeloGeoSimple(0.3); //distancia a la que se deben conectar nodos
    nueve.escribirArchivo("Salidas\\GV\\03Geo500.gv");

    Grafo diez = new Grafo(30);
    diez.modeloBA(7);  //parámetro 'd' del modelo
    diez.escribirArchivo("Salidas\\GV\\04BA030.gv");

    Grafo once = new Grafo(100);
    once.modeloBA(25); //parámetro 'd' del modelo
    once.escribirArchivo("Salidas\\GV\\04BA100.gv");

    Grafo doce = new Grafo(500);
    doce.modeloBA(100); //parámetro 'd' del modelo
    doce.escribirArchivo("Salidas\\GV\\04BA500.gv");
  }
}
