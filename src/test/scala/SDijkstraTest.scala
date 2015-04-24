
import org.junit.{Test, Assert}

class SDijkstraTest {

  @Test
  def testDirect() {

    val graph = Map(
      new SNode("A", Int.MaxValue) -> List(new SNode("B", 2), new SNode("C", 1)),
      new SNode("B", Int.MaxValue) -> List(new SNode("A", 2), new SNode("D", 2)),
      new SNode("C", Int.MaxValue) -> List(new SNode("A", 1), new SNode("D", 3)),
      new SNode("D", Int.MaxValue) -> List(new SNode("B", 2), new SNode("C", 3))
    )

    val l = SDijkstra.dijkstra(graph, "A", "C")

    Assert.assertEquals(1, l.last.distance)
  }

  @Test
  def testUnDirect() {

    val graph = Map(
      new SNode("A", Int.MaxValue) -> List(new SNode("B", 1), new SNode("C", 10)),
      new SNode("B", Int.MaxValue) -> List(new SNode("A", 1), new SNode("D", 2)),
      new SNode("C", Int.MaxValue) -> List(new SNode("A", 10), new SNode("D", 3)),
      new SNode("D", Int.MaxValue) -> List(new SNode("B", 2), new SNode("C", 3))
    )

    val l = SDijkstra.dijkstra(graph, "A", "C")
    Assert.assertEquals(6, l.last.distance)

  }

}
