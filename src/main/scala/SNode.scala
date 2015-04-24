
class SNode(var name: String, var distance: Int) {

  def canEqual(other: Any): Boolean = other.isInstanceOf[SNode]

  override def equals(other: Any): Boolean = other match {
    case that: SNode =>
      (that canEqual this) &&
        name == that.name
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"SNode($name, $distance)"
}
