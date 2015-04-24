
import org.junit.{Test, Assert}

class DijkstraTest {

  @Test
  def testDirect() {

    val graph = Map(
      new AdjNode("A", Int.MaxValue) -> List(new Node("B", 2), new Node("C", 1)),
      new AdjNode("B", Int.MaxValue) -> List(new Node("A", 2), new Node("D", 2)),
      new AdjNode("C", Int.MaxValue) -> List(new Node("A", 1), new Node("D", 3)),
      new AdjNode("D", Int.MaxValue) -> List(new Node("B", 2), new Node("C", 3))
    )

    val l = Dijkstra.dijkstra(graph, "A", "C")

    Assert.assertEquals(1, l.last.accumulateDistance)
  }

  @Test
  def testUnDirect() {

    val graph = Map(
      new AdjNode("A", Int.MaxValue) -> List(new Node("B", 1), new Node("C", 10)),
      new AdjNode("B", Int.MaxValue) -> List(new Node("A", 1), new Node("D", 2)),
      new AdjNode("C", Int.MaxValue) -> List(new Node("A", 10), new Node("D", 3)),
      new AdjNode("D", Int.MaxValue) -> List(new Node("B", 2), new Node("C", 3))
    )

    val l = Dijkstra.dijkstra(graph, "A", "C")
    Assert.assertEquals(6, l.last.accumulateDistance)

  }

}
