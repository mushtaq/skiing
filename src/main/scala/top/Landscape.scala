package top

import scala.io.Source

case class Landscape(elevations: List[List[Int]]) {
  private val locations = for {
    (row, rowId) <- elevations.zipWithIndex.toMap
    (elevation, columnId) <- row.zipWithIndex
    point = Point(rowId, columnId)
  } yield point -> Location(point, elevation, this)

  def getLocation(point: Point) = locations.get(point)

  def bestLocation = locations.values.toSeq.maxBy(l => (l.maxPathLength, l.drop))
}

object Landscape {
  def parseFile(file: String) = Landscape {
    Source.fromFile(file)
      .getLines()
      .drop(1)
      .map(parseLine)
      .toList
  }

  private def parseLine(line: String) = line.split(" ").map(_.toInt).toList
}
