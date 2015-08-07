package top

case class Location(point: Point, elevation: Int, landscape: Landscape) {
  private lazy val neighbours = point.neighbours.flatMap(landscape.getLocation)
  private lazy val children   = neighbours.filter(_.elevation < elevation)

  lazy val maxPathLength: Int = children match {
    case Nil => 1
    case _   => 1 + children.map(_.maxPathLength).max
  }

  lazy val drop = elevation - endingElevation

  private lazy val endingElevation = path.last.elevation

  lazy val path: List[Location] = children match {
    case Nil => this :: Nil
    case _   => this :: children.maxBy(l => (l.maxPathLength, dropVia(l))).path
  }

  private def dropVia(l: Location) = elevation - l.endingElevation
}
