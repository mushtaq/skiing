package top

import org.scalatest.FunSuite

class ReaderTest extends FunSuite {

  test("small") {
    val landscape = Reader.load("src/test/resources/map-small.txt")
    println(landscape.best)
    println(landscape.best.path.map(_.elevation))
  }

  test("big") {
    val landscape = Reader.load("src/test/resources/map-big.txt")
    println(landscape.best)
    println(landscape.best.path.map(_.elevation))
  }

}
