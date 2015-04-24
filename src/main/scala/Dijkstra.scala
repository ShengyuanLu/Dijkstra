import scala.collection.mutable.LinkedHashMap

object Dijkstra {

  def dijkstra(graph: Map[Node, List[Node]], start: String, end: String): List[Node] = {
    val path = new LinkedHashMap[Node, Node]
    var bigSQueue = graph.keySet.filter(_.name != start).toList
    var top = graph.keySet.find(_.name == start).get
    top.distance = 0
    path += (top -> null)

    while (bigSQueue.nonEmpty) {
      val adj = graph.get(top).get.intersect(bigSQueue)
      adj.foreach(
        (v) => {
          val candi = bigSQueue.find(_ == v).get
          val sum = top.distance + v.distance
          candi.distance = if (sum < candi.distance) sum
          else candi.distance
        }
      )

      top = bigSQueue.minBy(_.distance)
      path += (top -> path.keySet.last)
      if (top.name == end) {
        return if (top.distance == Int.MaxValue) List(top)
        else parse(path, top)
      }

      bigSQueue = bigSQueue.diff(List(top))
    }
    null
  }

  def parse(path: LinkedHashMap[Node, Node], end: Node): List[Node] = {
    var result = List[Node]()
    var n = end
    while (path.get(n).isDefined) {
      result = result :+ n
      n = path.get(n).get
    }
    result.reverse
  }

}