package Grafos;
import Grafos.Nodo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.FormatterClosedException;
import java.io.FileNotFoundException;

public class grafo
{
  private Nodo[] nodes;
  private HashMap<Nodo, HashSet<Nodo>> graph;
  private int numeroNodos;
  private int numeroAristas;
  private static Formatter output;

  public grafo(int numNodos)
  {
    this.graph = new HashMap<Nodo, HashSet<Nodo>>();
    this.numeroNodos = numNodos;
    this.nodes = new Nodo[numNodos];
    for (int i = 0; i < numNodos; i++){
      Nodo n = new Nodo(i);
      this.nodes[i] = n;
      this.graph.put(n, new HashSet<Nodo>());
    }
  }

  public void modeloER(int numAristas){
    Random randomNum1 = new Random();
    Random randomNum2 = new Random();

    int conexiones = 0;
    while (conexiones < numAristas){
      int num1 = randomNum1.nextInt(this.getNumNodes());
      int num2 = randomNum2.nextInt(this.getNumNodes());
      if (num1 != num2){
        if (!existeConexion(this.nodes[num1], this.nodes[num2])){
          conectarNodos(this.nodes[num1], this.nodes[num2]);
          conexiones++;
        }
      }
    }
  }

  public void modeloGilbert(double probabilidad){

  }

  public void modeloGeoSimple(double distancia){

  }

  public void modeloBA(int d){

  }

  private void conectarNodos(Nodo n1, Nodo n2){
     HashSet<Nodo> vertices1 = this.graph.get(n1);
     // HashSet<Nodo> vertices2 = this.graph.get(n2);

     vertices1.add(n2);
     // vertices2.add(n1);  // Se usará para grafos dirigidos

     // System.out.println("Se hizo una conexion entre " + n1.getName() + " y " +
     //  n2.getName());
  }

  private Boolean existeConexion(Nodo n1, Nodo n2){
    HashSet<Nodo> vertices1 = this.graph.get(n1);
    HashSet<Nodo> vertices2 = this.graph.get(n2);
     if (vertices1.contains(n2) || vertices2.contains(n1)){
       return true;
     }
     else{
       return false;
     }
  }

  public int getNumNodes(){
    return this.numeroNodos;
  }

  public int getNumEdges(){
    return this.numeroAristas;
  }

  public void imprimirStdOut(){
    System.out.println("graph {");
    for (int i = 0; i < this.getNumNodes(); i++){
      System.out.println(this.nodes[i].getName() + ";");
    }
    for (int i = 0; i < this.getNumNodes(); i++){
      HashSet<Nodo> aristas = graph.get(this.nodes[i]);
      for (Nodo n : aristas){
      System.out.println(this.nodes[i].getName() + " -- " + n.getName() + ";");
      }
     }
    System.out.println("}");
  }

  public void escribirArchivo(String nombre){
    try{
      output = new Formatter(nombre);
    }
    catch (SecurityException securityException){
      System.err.println("No hay permiso de escritura.");
      System.exit(1);
    }
    catch (FileNotFoundException fileNotFoundException){
      System.err.println("Error al abrir el archivo.");
      System.exit(1);
    }
    try{
      output.format("%s","graph {\n");
      for (int i = 0; i < this.getNumNodes(); i++){
        output.format("%s", this.nodes[i].getName() + ";\n");
      }
      for (int i = 0; i < this.getNumNodes(); i++){
        HashSet<Nodo> aristas = graph.get(this.nodes[i]);
        for (Nodo n : aristas){
        output.format("%s",this.nodes[i].getName() + " -- " + n.getName() + ";\n");
        }
       }
      output.format("}\n");
    }
    catch (FormatterClosedException formatterClosedException){
      System.err.println("Error al escribir al archivo");
    }
    if (output != null)
    output.close();
  }
}
