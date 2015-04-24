import scala.collection.mutable.LinkedHashMap

object SDijkstra {

  def dijkstra(graph: Map[SNode, List[SNode]], start: String, end: String): List[SNode] = {
    val path = new LinkedHashMap[SNode, SNode]
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

  def parse(path: LinkedHashMap[SNode, SNode], end: SNode): List[SNode] = {
    var result = List[SNode]()
    var n = end
    while (path.get(n).isDefined) {
      result = result :+ n
      n = path.get(n).get
    }
    result.reverse
  }

}