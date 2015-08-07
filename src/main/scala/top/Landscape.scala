package top

class Landscape(val rows: Int, val columns: Int, val elevations: Iterator[Array[Int]]) {

  lazy val locations = elevations.zipWithIndex.map {
    case (row, rowId) => row.zipWithIndex.map {
      case (elevation, columnId) => Location(rowId, columnId, elevation)
    }
  }.toArray

  def getLocation(rowId: Int, columnId: Int) =
    if (isValidIndex(rowId, columnId)) Some(locations(rowId)(columnId)) else None

  def isValidIndex(rowId: Int, columnId: Int) =
    rowId < rows && columnId < columns && rowId >= 0 && columnId >= 0

  lazy val best = locations.flatten.maxBy(l => (l.depth, l.elevation))

  case class Location(rowId: Int, columnId: Int, elevation: Int) {
    lazy val neighbours = List(
      getLocation(rowId, columnId + 1),
      getLocation(rowId, columnId - 1),
      getLocation(rowId + 1, columnId),
      getLocation(rowId - 1, columnId)
    ).flatten

    lazy val children = neighbours.filter(_.elevation < elevation)

    lazy val depth: Int = if(children.isEmpty) 1 else 1 + children.map(_.depth).max

    lazy val path: List[Location] = children match {
      case Nil => this :: Nil
      case _   => this :: children.maxBy(_.depth).path
    }
  }
}
