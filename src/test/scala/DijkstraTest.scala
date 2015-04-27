
import org.junit.{Test, Assert}

class DijkstraTest {

  @Test
  def testDirect() {

    val graph = Map(
        AdjNode("A", Int.MaxValue) -> List( Node("B", 2),  Node("C", 1)),
        AdjNode("B", Int.MaxValue) -> List( Node("A", 2),  Node("D", 2)),
        AdjNode("C", Int.MaxValue) -> List( Node("A", 1),  Node("D", 3)),
        AdjNode("D", Int.MaxValue) -> List( Node("B", 2),  Node("C", 3))
    )

    val l = Dijkstra.dijkstra(graph, "A", "C")

    Assert.assertEquals(1, l.last.accumulateDistance)
  }

  @Test
  def testUnDirect() {

    val graph = Map(
       AdjNode("A", Int.MaxValue) -> List( Node("B", 1),  Node("C", 10)),
       AdjNode("B", Int.MaxValue) -> List( Node("A", 1),  Node("D", 2)),
       AdjNode("C", Int.MaxValue) -> List( Node("A", 10), Node("D", 3)),
       AdjNode("D", Int.MaxValue) -> List( Node("B", 2),  Node("C", 3))
    )

    val l = Dijkstra.dijkstra(graph, "A", "C")
    Assert.assertEquals(6, l.last.accumulateDistance)

  }

}
