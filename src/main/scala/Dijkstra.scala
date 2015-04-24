import scala.collection.mutable.LinkedHashMap

object Dijkstra {

  def dijkstra(graph: Map[AdjNode, List[Node]], start: String, end: String): List[AdjNode] = {
    val path = new LinkedHashMap[AdjNode, AdjNode]
    var bigSQueue = graph.keySet.filter(_.name != start).toList
    var top = graph.keySet.find(_.name == start).get
    top.accumulateDistance = 0
    path += (top -> null)

    while (bigSQueue.nonEmpty) {
      val adj = graph.get(top).get.intersect(bigSQueue)  //Nodes intersect AdjNode of Q
      adj.foreach(
        (v) => {
          val candi = bigSQueue.find(_ == v).get    // Node -> AdjNode
          val sum = top.accumulateDistance + v.distance
          candi.accumulateDistance = if (sum < candi.accumulateDistance) sum
                                     else candi.accumulateDistance
        }
      )

      top = bigSQueue.minBy(_.accumulateDistance)
      path += (top -> path.keySet.last)
      if (top.name == end) {
        return if (top.accumulateDistance == Int.MaxValue) List(top)
        else parse(path, top)
      }

      bigSQueue = bigSQueue.diff(List(top))
    }
    null
  }

  def parse(path: LinkedHashMap[AdjNode, AdjNode], end: AdjNode): List[AdjNode] = {
    var result = List[AdjNode]()
    var n = end
    while (path.get(n).isDefined) {
      result = result :+ n
      n = path.get(n).get
    }
    result.reverse
  }

}