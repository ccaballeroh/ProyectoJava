package Grafos;

public class nodo{
  private String name;
  public nodo(){
  }

  public nodo(String name){
    this.name = name;
  }

  public nodo(int name){
    this.name = "n" + String.valueOf(name);
  }

  public String getName(){
    return name;
  }
}
