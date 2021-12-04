/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  @Test
  public void addVertex(){

    Graph graph = new Graph();

    graph.addVertex("Alaa");
    graph.addVertex("Fares");
    graph.addVertex("a");
    graph.addVertex("f");


    assertNotNull(graph.getVertices());
    assertEquals(4,graph.size());
  }

  @Test
  public void addEdge(){

    Graph graph = new Graph();

    graph.addVertex("Alaa");
    graph.addVertex("Fares");
    graph.addEdge("Alaa", "Fares");

    assertEquals("Vertex{label='Alaa', weight=0}[Vertex{label='Fares', weight=0}]Vertex{label='Fares', weight=0}[Vertex{label='Alaa', weight=0}]", graph.printGraph());
  }
//
  @Test
  public void vertexNeighbors(){

    Graph graph = new Graph();

    graph.addVertex("a");
    graph.addVertex("b");
    graph.addVertex("c");
    graph.addEdge("a", "c");
    graph.addEdge("a", "b");

    assertEquals("[Vertex{label='c', weight=0}, Vertex{label='b', weight=0}]",graph.getNeighbors("a").toString());

  }


////    <<< Code Challenge 37 >>>
//
  @Test
  public void businessTripTest(){

    Graph graph2 = new Graph();

    graph2.addVertex("Pandora");
    graph2.addVertex("Arendelle");
    graph2.addVertex("Metroville");
    graph2.addVertex("Monstroplolis");

    graph2.addEdgeWithWeight("Pandora", "Arendelle", 150);
    graph2.addEdgeWithWeight("Arendelle", "Metroville",99);
    graph2.addEdgeWithWeight("Arendelle", "Monstroplolis",42);

    List<String> cities1 = new ArrayList<>();
    cities1.add("Pandora");
    cities1.add("Arendelle");
    assertEquals(150, graph2.businessTrip(graph2, cities1));

    List<String> cities2 = new ArrayList<>();
    cities2.add("Pandora");
    cities2.add("Arendelle");
    cities2.add("Monstroplolis");
    assertEquals(192, graph2.businessTrip(graph2, cities2));

  }

  @Test
  public void businessTripNoEdge(){

    Graph graph2 = new Graph();

    graph2.addVertex("Pandora");
    graph2.addVertex("Arendelle");
    graph2.addVertex("Metroville");
    graph2.addVertex("Monstroplolis");

    graph2.addEdgeWithWeight("Pandora", "Arendelle", 150);
    graph2.addEdgeWithWeight("Arendelle", "Metroville",99);
    graph2.addEdgeWithWeight("Arendelle", "Monstroplolis",42);

    List<String> cities1 = new ArrayList<>();
    cities1.add("Pandora");
    cities1.add("Monstroplolis");
    assertEquals(0, graph2.businessTrip(graph2, cities1));
  }

  @Test
  public void businessTripAtLeastOnoEdge(){

    Graph graph2 = new Graph();

    graph2.addVertex("Pandora");
    graph2.addVertex("Arendelle");
    graph2.addVertex("Metroville");
    graph2.addVertex("Monstroplolis");
    graph2.addVertex("Naboo");

    graph2.addEdgeWithWeight("Pandora", "Arendelle", 150);
    graph2.addEdgeWithWeight("Arendelle", "Metroville",99);
    graph2.addEdgeWithWeight("Arendelle", "Monstroplolis",42);
    graph2.addEdgeWithWeight("Naboo", "Monstroplolis",42);


    List<String> cities1 = new ArrayList<>();
    cities1.add("Pandora");
    cities1.add("Naboo");
    cities1.add("Monstroplolis");
    assertEquals(42, graph2.businessTrip(graph2, cities1));
  }
//
//  //    <<< Code Challenge 38 >>>

  @Test
  public void depthFirstTest(){

    Graph graph3 = new Graph();

    graph3.addVertex("A");
    graph3.addVertex("B");
    graph3.addVertex("C");
    graph3.addVertex("D");
    graph3.addVertex("E");
    graph3.addVertex("F");
    graph3.addVertex("G");
    graph3.addVertex("H");

    graph3.addEdge("A", "D");
    graph3.addEdge("A", "B");
    graph3.addEdge("B", "D");
    graph3.addEdge("B", "C");
    graph3.addEdge("C", "G");
    graph3.addEdge("D", "F");
    graph3.addEdge("D", "H");
    graph3.addEdge("D", "E");
    graph3.addEdge("F", "H");

    assertEquals("[A, B, C, G, D, E, H, F]", graph3.depthFirstTraverse("A").toString());
  }

  @Test
  public void depthFirstOneVertex(){

    Graph graph3 = new Graph();

    graph3.addVertex("A");

    assertEquals("[A]", graph3.depthFirstTraverse("A").toString());
  }

  @Test
  public void depthFirstTest2(){

    Graph graph3 = new Graph();

    graph3.addVertex("A");
    graph3.addVertex("B");
    graph3.addVertex("C");

    graph3.addEdge("A", "B");

    assertEquals("[A, B]", graph3.depthFirstTraverse("A").toString());
  }



}