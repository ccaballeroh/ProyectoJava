# Proyecto de la clase de Análisis y Diseño de Algoritmos
## Primera entrega del proyecto

> Escribir una biblioteca en Java para generar grafos aleatorios con los siguientes modelos de generación:
> * **Modelo G(n,m) de Erdős–Rényi**.
> * **Modelo G(n,p) de Gilbert**.
> * **Modelo G(n,r) geográfico simple.**
> * **Variante del modelo G(n,d) Barabási-Albert**

Es necesario compilar primero la clase `Vertice`. Después, la clase `Grafo`.
> javac -d [DIRECTORIO DONDE GUARDAR EL PAQUETE] Vertice.java

> javac -d [DIRECTORIO DONDE GUARDAR EL PAQUETE] Grafo.java


Ambas clases forman un **paquete** llamado `Grafos` que puede importarse a otro archivo de Java como en el archivo `Prueba.java`

```Java
import Grafos.grafo;
```

Las imágenes PNG fueron generadas con [gephi](https://gephi.org/).

## Segunda entrega del proyecto

> Implementar los algoritmos BFS y DFS (recursivo e iterativo) de tal forma que dado un nodo fuente, se calcule el árbol inducido por los algoritmos mencionados.

```Java
Grafo BFS (int s) {...}
Grafo DFS_R (int s) {...}
Grafo DFS_I (int s) {...}
```

## Tercera entrega del Proyecto

> Implementar el algoritmo de Dijkstra de tal forma que dado un nodo fuente, se calcule el árbol de caminos más cortos.

```Java
Grafo Dijkstra (int s) {...}
```

> Adicionalmente crear un método para asignar valores aleatorios a cada arista, dentro de un rango.

```Java
Grafo EdgeValues (float min, float max) {...}
```
