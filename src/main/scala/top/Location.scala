package top

case class Location(point: Point, elevation: Int, landscape: Landscape) {
  private lazy val neighbours = point.neighbours.flatMap(landscape.getLocation)
  private lazy val children   = neighbours.filter(_.elevation < elevation)

  lazy val pathLength: Int = children match {
    case Nil => 1
    case _   => 1 + children.map(_.pathLength).max
  }

  lazy val dropLength = elevation - endingElevation

  private lazy val endingElevation = path.last.elevation

  lazy val path: List[Location] = children match {
    case Nil => this :: Nil
    case _   => this :: children.maxBy(l => (l.pathLength, dropLengthVia(l))).path
  }

  private def dropLengthVia(l: Location) = elevation - l.endingElevation
}
