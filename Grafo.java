/*Clase que implementa modelos de grafos.

La clase forma parte del paquete 'Grafos'. Implementa cuatro modelos para
generar grafos aleatorios:
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
  /*Regresa el grado (número de aristas) de un vértice i*/
  public int gradoVertice(int i) {
    Vertice n1 = this.getNode(i);
    return this.graph.get(n1).size();
  }

  /*Conecta dos vértices*/
  public void conectarVertices(int i, int j) {
    /*Se recuperan los vértices de los índices i y j*/
     Vertice n1 = this.getNode(i);
     Vertice n2 = this.getNode(j);
     /*Se recuperan las aristas de cada vértice*/
     HashSet<Vertice> aristas1 = this.getEdges(i);
     HashSet<Vertice> aristas2 = this.getEdges(j);

     /*Se agregan los vértices al conjunto del otro*/
     aristas1.add(n2);
     aristas2.add(n1);  //en Grafos dirigidos hay que quitar esta línea
     this.numeroAristas +=1; //Para que sean aristas únicas (en lugar de 2)
  }

  /*Nos regresa 'true' si ya existe la arista*/
  private Boolean existeConexion(int i, int j) {
    /*Se recuperan los vértices de los índices i y j*/
     Vertice n1 = this.getNode(i);
     Vertice n2 = this.getNode(j);
    /*Se recuperan las aristas de cada vértice*/
    HashSet<Vertice> aristas1 = this.getEdges(i);
    HashSet<Vertice> aristas2 = this.getEdges(j);
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

  public Vertice getNode(int i) {return this.nodes[i];}

  public HashSet<Vertice> getEdges(int i) {
    Vertice n = this.getNode(i);
    return this.graph.get(n);
  }

  /*Método toString para tener representación en String del Grafo*/
  public String toString() {
    String salida;
    salida ="graph {\n";
    for (int i = 0; i < this.getNumNodes(); i++) {
      salida += this.getNode(i).getName() + ";\n";
    }
    for (int i = 0; i < this.getNumNodes(); i++) {
      HashSet<Vertice> aristas = this.getEdges(i);
      for (Vertice n : aristas) {
      salida += this.getNode(i).getName() + " -- " + n.getName() + ";\n";
      }
     }
    salida += "}\n";
    return salida;
  }

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
        if (!existeConexion(num1, num2)) {
          conectarVertices(num1, num2);
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
          if (!existeConexion(i, j)) {
            conectarVertices(i, j);
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
        double distancia = distanciaVertices(this.getNode(i), this.getNode(j));
        if (distancia <= r) {
            conectarVertices(i, j);
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
        if (!existeConexion(i, j)) {
          conectarVertices(i, j);
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
        (double)gradoVertice(j)/(double)this.getNumEdges();
        if (volado.nextDouble() <= probabilidad) {
          if (!existeConexion(i, j) && (gradoVertice(i) < d)) {
            conectarVertices(i, j);
          }
        }
      }
      if (gradoVertice(i) >= d) i++;
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
      output.format("%s",this);
    }
    catch (FormatterClosedException formatterClosedException) {
      System.err.println("Error al escribir al archivo");
    }
    if (output != null)
    output.close();
  }

  /* Método para generar el árbol BFS del Grafo*/
  /* Regresa otro grafo. Solo toma como entrada el número
  de un nodo*/
  public Grafo BFS(int s) {
    Grafo arbol = new Grafo(this.getNumNodes());  // grafo de salida
    Boolean[] discovered = new Boolean[this.getNumNodes()];  // arreglo aux
    PriorityQueue<Integer> L = new PriorityQueue<Integer>();
    discovered[s] = true;  // se pone como descubierto el vértice raíz
    for (int i = 0; i < this.getNumNodes(); i++) {
      if (i != s) {   // el resto como no descubiertos
        discovered[i] = false;
      }
    }
    L.add(s);  // Se agrega a la cola de prioridad el nodo raíz
    while (L.peek() != null) {  // se revisa que no esté vacía la cola
      int u = L.poll();  // se extrae un elemento de la cola
      HashSet<Vertice> aristas = this.getEdges(u);  // aristas del nodo u
      for (Vertice n : aristas) {
        if(!discovered[n.getIndex()]) {
          // si no está descubierto conectarlo, marcarlo como descubierto
          // y agregarlo a la cola.
          arbol.conectarVertices(u, n.getIndex());
          discovered[n.getIndex()] = true;
          L.add(n.getIndex());
        }
      }
    }
return arbol;
  }

public Grafo DFS_R(int s) {
  Grafo arbol = new Grafo(this.getNumNodes());  // grafo de salida
  Boolean[] discovered = new Boolean[this.getNumNodes()];  // arreglo aux
  discovered[s] = true;  // se pone como descubierto el vértice raíz
  for (int i = 0; i < this.getNumNodes(); i++) {
    if (i != s) {   // el resto como no descubiertos
      discovered[i] = false;
    }
  }


  recursivo(int s);

  for (int i = 0; i < this.getNumNodes(); i++) {
    if (!discovered[])
  }

  }

  public void recursivo(int u) {
    HashSet<Vertice> aristas = this.getEdges(u);

  }

}
