
import org.junit.{Test, Assert}

class SDijkstraTest {

  @Test
  def testDirect() {

    val graph = Map(
      new Node("A", Int.MaxValue) -> List(new Node("B", 2), new Node("C", 1)),
      new Node("B", Int.MaxValue) -> List(new Node("A", 2), new Node("D", 2)),
      new Node("C", Int.MaxValue) -> List(new Node("A", 1), new Node("D", 3)),
      new Node("D", Int.MaxValue) -> List(new Node("B", 2), new Node("C", 3))
    )

    val l = SDijkstra.dijkstra(graph, "A", "C")

    Assert.assertEquals(1, l.last.distance)
  }

  @Test
  def testUnDirect() {

    val graph = Map(
      new Node("A", Int.MaxValue) -> List(new Node("B", 1), new Node("C", 10)),
      new Node("B", Int.MaxValue) -> List(new Node("A", 1), new Node("D", 2)),
      new Node("C", Int.MaxValue) -> List(new Node("A", 10), new Node("D", 3)),
      new Node("D", Int.MaxValue) -> List(new Node("B", 2), new Node("C", 3))
    )

    val l = SDijkstra.dijkstra(graph, "A", "C")
    Assert.assertEquals(6, l.last.distance)

  }

}
