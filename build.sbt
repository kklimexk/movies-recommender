name := "movies-recommender"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.1",
  "org.apache.spark" %% "spark-sql" % "1.6.1",
  "org.apache.spark" %% "spark-mllib" % "1.6.1",
  "org.scala-lang" % "scala-compiler" % "2.11.7",
  "org.apache.commons" % "commons-lang3" % "3.3.2",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.4",
  "org.slf4j" % "slf4j-api" % "1.7.10"
)
