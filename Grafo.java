/*Clase que implementa modelos de grafos.

La clase forma parte del paquete 'Grafos'. Implementa cuatro modelos para
genera grafos aleatorios:
1. Erdös-Rényi
2. Gilbert
3. Geográfico simple
4. Barabási-Albert

La clase utiliza la clase 'Vertice' del mismo paquete, que incluye
constructores para el modelo geográfico simple, que necesita un par de
coordenadas, y otro para los otros tres modelos.*/
package Grafos;
import Grafos.Vertice;
import java.util.*;
import java.io.FileNotFoundException;

public class Grafo
{ //Variables de instancia

  /*arreglo de objetos 'Vertice'. De esta forma nos podemos referir a cada
  vértice por su posición en el arreglo*/
  private Vertice[] nodes;
  /*El grafo en sí es un mapa Hash. Toma como llave el vértice, que es mapeado
  a un conjunto Hash de vértices con los cuales hay conexión.*/
  private HashMap<Vertice, HashSet<Vertice>> graph;
  private final int numeroVertices; //número de vértices del grafo
  private int numeroAristas;  //número de aristas únicas del grafo
  private static Formatter output; //objeto para escribir a disco


  /* Constructores*/

  public Grafo(int numVertices)
  {
    this.graph = new HashMap<Vertice, HashSet<Vertice>>();
    this.numeroVertices = numVertices;
    this.nodes = new Vertice[numVertices];
    for (int i = 0; i < numVertices; i++) {
      Vertice n = new Vertice(i);
      this.nodes[i] = n;
      this.graph.put(n, new HashSet<Vertice>());
    }
  }

  /*Constructor usado para el modelo geofráfico simple.

  Se le tienen que pasar el número de vértices y la cadena "geo-uniforme"*/
  public Grafo(int numVertices, String modelo) {
      this.graph = new HashMap<Vertice, HashSet<Vertice>>();
      this.numeroVertices = numVertices;
      this.nodes = new Vertice[numVertices];
      Random coorX = new Random();
      Random coorY = new Random();
      if (modelo == "geo-uniforme") {
        for (int i = 0; i < numVertices; i++) {
          Vertice n = new Vertice(i, coorX.nextDouble(), coorY.nextDouble());
          this.nodes[i] = n;
          this.graph.put(n, new HashSet<Vertice>());
        }
      }
    }

  /*Métodos auxiliares*/
  /*Regresa el grado (número de aristas) de un vértice*/
  private int gradoVertice(Vertice n1) {
    return this.graph.get(n1).size();
  }

  /*Conecta dos vértices*/
  private void conectarVertices(Vertice n1, Vertice n2) {
    /*Se recuperan las aristas de cada vértice*/
     HashSet<Vertice> aristas1 = this.graph.get(n1);
     HashSet<Vertice> aristas2 = this.graph.get(n2);

     /*Se agregan los vértices al conjunto del otro*/
     aristas1.add(n2);
     aristas2.add(n1);  //en Grafos dirigidos hay que quitar esta línea
     this.numeroAristas +=1; //Para que sean aristas únicas (en lugar de 2)
  }

  /*Nos regresa 'true' si ya existe la arista*/
  private Boolean existeConexion(Vertice n1, Vertice n2) {
    /*Se recuperan las aristas de cada vértice*/
    HashSet<Vertice> aristas1 = this.graph.get(n1);
    HashSet<Vertice> aristas2 = this.graph.get(n2);
    /*Se revisa que un nodo esté en el conjunto de aristas del otro*/
     if (aristas1.contains(n2) || aristas2.contains(n1)) {
       return true;
     }
     else{
       return false;
     }
  }

  /*Distancia L2 entre vértices para el modelo geofráfico*/
  private double distanciaVertices(Vertice n1, Vertice n2) {
    return Math.sqrt(Math.pow((n1.getX() - n2.getX()), 2)
    + Math.pow((n1.getY() - n2.getY()), 2));
  }

  /*getters de las variables de instancia del objeto 'Grafo'*/
  public int getNumNodes() {return numeroVertices;}

  public int getNumEdges() {return numeroAristas;}

  /*Métodos de instancia que implementan los modelos*/

  /*Modelo Erdös-Rényi.

  Crea n vértices y elige uniformemente al azar m distintos
   pares de distintos vértices*/
  public void modeloER(int numAristas) {
    Random randomNum1 = new Random();
    Random randomNum2 = new Random();
    /*mientras el número de aristas del grafo sea menor que el número con el
    que se llamó este modelo se generan números al azar entre 0 y el número de
    nodos -1. Se verifica si ya existe conexión entre los nodos que
    corresponden a esos índices y si no, se conectan. Se verifica que
    los números pseudoaleatorios no sean el mismo*/
    while (this.getNumEdges() < numAristas) {
      int num1 = randomNum1.nextInt(this.getNumNodes());
      int num2 = randomNum2.nextInt(this.getNumNodes());
      if (num1 != num2) {
        if (!existeConexion(this.nodes[num1], this.nodes[num2])) {
          conectarVertices(this.nodes[num1], this.nodes[num2]);
        }
      }
    }
  }

  /*Modelo de Gilbert.

  Crear m aristas crear n vértices y poner una arista entre cada par
  independiente y uniformemente con probabilidad p*/
  public void modeloGilbert(double probabilidad) {
    Random randomNum = new Random();
    /*Para cada vértice i se recorren todos los vértices j con i<>j. En cada
    par se calcula un número pseudoaleatorio entre 0.0 y 1.0 y se compara
    con la probabilidad que se le pasó como argumento al modelo. Si es menor
    que la probabilidad y no existe ya una conexión, se realiza la conexión.*/
    for(int i = 0; i < this.getNumNodes(); i++) {
      for(int j = 0; j <this.getNumNodes(); j++) {
        if ((i != j) && (randomNum.nextDouble() <= probabilidad)) {
          if (!existeConexion(this.nodes[i], this.nodes[j])) {
            conectarVertices(this.nodes[i], this.nodes[j]);
          }
        }
      }
    }
  }

/*Modelo geográfico simple.

Colocar n vértices en un rectángulo unitario con coordenadas uniformes
(o normales) y colocar una arista entre cada par que queda a una
distancia r o menor*/
  public void modeloGeoSimple(double r) {
    /*Para cada vértice i se compara con el resto de los vértices con los que
    no se ha comparado y si están a una distancia r o menor se realiza la
    conexión.*/
    for(int i = 0; i < this.getNumNodes(); i++) {
      for(int j = i + 1; j < this.getNumNodes(); j++) {
        double distancia = distanciaVertices(this.nodes[i], this.nodes[j]);
        if (distancia <= r) {
            conectarVertices(this.nodes[i], this.nodes[j]);
        }
      }
    }
  }


  /*Modelo Barabási-Albert.

  Colocar n vértices uno por uno, asignando a cada uno d aristas a vértices
  distintos de tal manera que la probabilidad de que el vértice nuevo se
  conecte a un vértice existente v es proporcional a la cantidad de aristas que
  v tiene actualmente - los primeros d vértices se conecta todos a todos*/
  public void modeloBA(int d) {
    Random volado = new Random();
  /*Para los primeros d vértices, se conecta el vértice i con el vértice j
  con i distinto de j y recorriendo todos los vértices.*/
    for(int i = 0; i < d; i++){
      for(int j = 0; j < i; j++) {
        if (!existeConexion(this.nodes[i], this.nodes[j])) {
          conectarVertices(this.nodes[i], this.nodes[j]);
        }
      }
    }
  /*Del vértice d en adelante hasta el vértice n, el vértice i de trata de
  emparejar con cada vértice j desde el primero hasta i-1. La manera de hacer
  el emparejamiento es con probabilidad. La probabilidad de que el vértice i
  se conecte con j es proporcional al número de aristas del vértice j dividido
  por el número total de aristas en el grafo hasta ese momento. Un número
  pseudoaleatorio se compara con esa probabilidad, de ser menor, se realiza
  la conexión. Antes de realizar la conexión se verifica que no exista ya y que
  el vértice i no tenga ya d o más conexiones.*/
  // i no se incrementa hasta que ese vértice tiene d conexiones
    for(int i = d; i < this.getNumNodes();) {
      for(int j = 0; j < i; j++) {
        double probabilidad =
        (double)gradoVertice(this.nodes[j])/(double)this.getNumEdges();
        if (volado.nextDouble() <= probabilidad) {
          if ((!existeConexion(this.nodes[i], this.nodes[j]))
                && (gradoVertice(this.nodes[i]) < d)){
            conectarVertices(this.nodes[i], this.nodes[j]);
          }
        }
      }
      if (gradoVertice(this.nodes[i]) >= d) i++;
    }
  }

/*Método para escribir a disco en un formato GraphVis.

El método toma como argumento, el nombre del archivo.*/
  public void escribirArchivo(String nombre) {
    try{
      output = new Formatter(nombre);
    }
    catch (SecurityException securityException) {
      System.err.println("No hay permiso de escritura.");
      System.exit(1);
    }
    catch (FileNotFoundException fileNotFoundException) {
      System.err.println("Error al abrir el archivo.");
      System.exit(1);
    }
    try{
      output.format("%s","graph {\n");
      for (int i = 0; i < this.getNumNodes(); i++) {
        output.format("%s", this.nodes[i].getName() + ";\n");
      }
      for (int i = 0; i < this.getNumNodes(); i++) {
        HashSet<Vertice> aristas = graph.get(this.nodes[i]);
        for (Vertice n : aristas) {
        output.format("%s",this.nodes[i].getName() + " -- "
                      + n.getName() + ";\n");
        }
       }
      output.format("}\n");
    }
    catch (FormatterClosedException formatterClosedException) {
      System.err.println("Error al escribir al archivo");
    }
    if (output != null)
    output.close();
  }
}
