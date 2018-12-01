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

  public String getNode1() {return "n" + n1.toString();}

  public String getNode2() {return "n" + n2.toString();}

  public double getWeight() {return peso;}

}
