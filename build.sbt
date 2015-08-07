name := "skiing"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.5" % "test"
)

transitiveClassifiers in Global := Seq(Artifact.SourceClassifier)
