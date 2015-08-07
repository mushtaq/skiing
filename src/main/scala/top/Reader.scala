package top

object Reader {
  def load(file: String) = {
    val lines = scala.io.Source.fromFile(file).getLines()
    val Array(rows, columns) = parseLine(lines.next())
    val data = lines.map(parseLine)
    new Landscape(rows, columns, data)
  }

  def parseLine(line: String) = line.split(" ").map(_.toInt)
}
