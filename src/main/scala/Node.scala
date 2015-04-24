class Node(val name: String, val distance: Int) {

  override def equals(other: Any): Boolean = other match {
    case that: AdjNode => name == that.name
    case that:    Node => name == that.name
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"Node($name, $distance)"
}


class AdjNode(val name: String, var accumulateDistance: Int) {

  override def equals(other: Any): Boolean = other match {
    case that: AdjNode => name == that.name
    case that:    Node => name == that.name
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"AdjNode($name, $accumulateDistance)"
}