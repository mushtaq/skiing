package top

case class Point(rowId: Int, columnId: Int) {
  def neighbours = List(
    Point(rowId, columnId + 1),
    Point(rowId, columnId - 1),
    Point(rowId + 1, columnId),
    Point(rowId - 1, columnId)
  )
}
