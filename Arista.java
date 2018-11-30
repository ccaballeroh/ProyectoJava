/*Clase de un vértice de un grafo. Forma parte del paquete 'Grafos'*/
package Grafos;


public class Arista {
  /* Variables de instancia*/
  private Integer n1;
  private Integer n2;
  private double peso;

  /*Constructor que toma una cadena como nombre del vértice*/
  public Arista(int n1, int n2, double peso) {
    this.n1 = n1;
    this.n2 = n2;
    this.peso = peso;
  }

  /*getters de variables de instancia */

  public Integer getNode1() {return n1;}

  public Integer getNode2() {return n2;}

  public double getWeight() {return peso;}

}
