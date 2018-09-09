package Grafos;

public class Nodo{
  private String name;
  private Integer numAristas;
  private double x;
  private double y;

  public Nodo(){
  }

  public Nodo(String name){
    this.name = name;
    this.numAristas = 0;
  }

  public Nodo(int name){
    this.name = "n" + String.valueOf(name);
    this.numAristas = 0;
  }

  public Nodo(int name, double x, double y){
    this.name = "n" + String.valueOf(name);
    this.x = x;
    this.y = y;
  }

  public void setNumEdges(int numero){
    this.numAristas = numero;
  }

  // public void addEdge(){
  //   this.numAristas += 1;
  // }

  public String getName(){
    return name;
  }

  public Integer getNumEdges(){
    return numAristas;
  }

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }

}
