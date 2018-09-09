package Grafos;
import Grafos.Vertice;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.FormatterClosedException;
import java.io.FileNotFoundException;

public class Grafo
{
  private Vertice[] nodes;
  private HashMap<Vertice, HashSet<Vertice>> graph;
  private int numeroVertices;
  private int numeroAristas;
  private static Formatter output;

  public Grafo(int numVertices)
  {
    this.graph = new HashMap<Vertice, HashSet<Vertice>>();
    this.numeroVertices = numVertices;
    this.nodes = new Vertice[numVertices];
    for (int i = 0; i < numVertices; i++){
      Vertice n = new Vertice(i);
      this.nodes[i] = n;
      this.graph.put(n, new HashSet<Vertice>());
    }
  }

  public Grafo(int numVertices, String modelo){
      this.graph = new HashMap<Vertice, HashSet<Vertice>>();
      this.numeroVertices = numVertices;
      this.nodes = new Vertice[numVertices];
      Random coorX = new Random();
      Random coorY = new Random();
      if (modelo == "geo-uniforme"){
        for (int i = 0; i < numVertices; i++){
          Vertice n = new Vertice(i, coorX.nextDouble(), coorY.nextDouble());
          this.nodes[i] = n;
          this.graph.put(n, new HashSet<Vertice>());
        }
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
          conectarVertices(this.nodes[num1], this.nodes[num2]);
          conexiones++;
        }
      }
    }
  }

  public void modeloGilbert(double probabilidad){
    Random randomNum = new Random();

    for(int i = 0; i < this.getNumNodes(); i++){
      for(int j = 0; j <this.getNumNodes(); j++){
        if ((i != j) && (randomNum.nextDouble() <= probabilidad)){
          if (!existeConexion(this.nodes[i], this.nodes[j])){
            conectarVertices(this.nodes[i], this.nodes[j]);
          }
        }
      }
    }
  }

  public void modeloGeoSimple(double r){
    for(int i = 0; i < this.getNumNodes(); i++){
      for(int j = 0; j < this.getNumNodes(); j++){
        double distancia = distanciaVertices(this.nodes[i], this.nodes[j]);
        if ((i != j) && (distancia <= r)){
           if (!existeConexion(this.nodes[i], this.nodes[j])){
            conectarVertices(this.nodes[i], this.nodes[j]);
           }
        }
      }
    }
  }

  public void modeloBA(int d){
    Random volado = new Random();
    for(int i = 0; i < this.getNumNodes(); i++){
      for(int j = 0; j < this.getNumNodes(); j++){
        if ((i != j) && (i < d)){
          if (!existeConexion(this.nodes[i], this.nodes[j])){
            conectarVertices(this.nodes[i], this.nodes[j]);
          }
        }
        else if ((i != j) && (i >= d)){
          double probabilidad =
          (double)gradoVertice(this.nodes[j])/(double)this.getNumEdges();
          if (volado.nextDouble() <= probabilidad){
            if (!existeConexion(this.nodes[i], this.nodes[j])){
              conectarVertices(this.nodes[i], this.nodes[j]);
            }
          }
        }
      }
    }
  }

  private int gradoVertice(Vertice n1){
    return this.graph.get(n1).size();
  }

  private void conectarVertices(Vertice n1, Vertice n2){
     HashSet<Vertice> vertices1 = this.graph.get(n1);
     HashSet<Vertice> vertices2 = this.graph.get(n2);

     vertices1.add(n2);
     vertices2.add(n1);  //en Grafos dirigidos hay que quitar esta
     this.numeroAristas +=1;
  }

  private Boolean existeConexion(Vertice n1, Vertice n2){
    HashSet<Vertice> vertices1 = this.graph.get(n1);
    HashSet<Vertice> vertices2 = this.graph.get(n2);
     if (vertices1.contains(n2) || vertices2.contains(n1)){
       return true;
     }
     else{
       return false;
     }
  }

  private double distanciaVertices(Vertice n1, Vertice n2){
    return Math.sqrt(Math.pow((n1.getX() - n2.getX()), 2)
    + Math.pow((n1.getY() - n2.getY()), 2));
  }

  public int getNumNodes(){
    return this.numeroVertices;
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
      HashSet<Vertice> aristas = graph.get(this.nodes[i]);
      for (Vertice n : aristas){
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
        HashSet<Vertice> aristas = graph.get(this.nodes[i]);
        for (Vertice n : aristas){
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
