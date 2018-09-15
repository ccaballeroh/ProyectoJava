/*Clase de un vértice de un grafo. Forma parte del paquete 'Grafos'*/
package Grafos;


public class Vertice {
  /* Variables de instancia*/
  private String name;
  private Integer numAristas;
  /*Estas variables solo son usadas en el modelo geográfico simple
  por lo que solo se usan cuando se llama al constructor correspondiente*/
  private double x;
  private double y;

  /*Constructor que toma una cadena como nombre del vértice*/
  public Vertice(String name) {
    this.name = name;
    this.numAristas = 0;
  }

  /*Constructor que toma un entero como argumento. Asigna a la variable
  de instancia 'name' la cadena formada por la letra 'n' concatenada con
  la representación en cadena del número entero que tomó como argumento*/
  public Vertice(int name) {
    this.name = "n" + String.valueOf(name);
    this.numAristas = 0;
  }

  /*Constructor usado en el modelo geográfico simple. Toma un entero que sirve
  como nombre del vértice y dos números de punto flotante como coordenadas
  del vértice. El modelo geofráfico simple toma coordenadas en un cuadrado
  unitario*/
  public Vertice(int name, double x, double y) {
    this.name = "n" + String.valueOf(name);
    this.x = x;
    this.y = y;
  }

  /*getters de variables de instancia */

  public String getName() {return name;}

  public Integer getNumEdges() {return numAristas;}

  /*Variables de instancia usadas en el modelo geográfico simple*/
  public double getX() {return x;}

  public double getY() {return y;}
}
