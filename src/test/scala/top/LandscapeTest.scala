package top

import org.scalatest.{ShouldMatchers, FunSuite}

class LandscapeTest extends FunSuite with ShouldMatchers {

  test("small") {
    val bestLocation = Landscape.parseFile("src/test/resources/map-small.txt").bestLocation
    bestLocation.path.map(_.elevation) shouldEqual List(9, 5, 3, 2, 1)
    bestLocation.maxPathLength shouldEqual 5
    bestLocation.drop shouldEqual 8
  }

  test("big") {
    val bestLocation = Landscape.parseFile("src/test/resources/map-big.txt").bestLocation
    println(bestLocation.maxPathLength, bestLocation.drop)
  }
}
