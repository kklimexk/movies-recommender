package pl.edu.agh.iwium

import java.io.File

import org.apache.spark.SparkContext
import org.apache.spark.mllib.recommendation.Rating

import scala.io.Source

object DataLoader {
  lazy val classLoader = getClass.getClassLoader

  /** Load ratings from file. */
  def loadPersonalRatings: Seq[Rating] = {
    val path = classLoader.getResource("personalRatings.txt").getPath
    val lines = Source.fromFile(path).getLines()
    val ratings = lines.map { line =>
      val fields = line.split("::")
      Rating(fields(0).toInt, fields(1).toInt, fields(2).toDouble)
    }.filter(_.rating > 0.0)
    if (ratings.isEmpty) {
      sys.error("No ratings provided.")
    } else {
      ratings.toSeq
    }
  }
  def loadRatings(implicit sc: SparkContext) = {
    sc.textFile(new File(classLoader.getResource("ratings.dat").getFile).toString).map { line =>
      val fields = line.split("::")
      // format: (timestamp % 10, Rating(userId, movieId, rating))
      (fields(3).toLong % 10, Rating(fields(0).toInt, fields(1).toInt, fields(2).toDouble))
    }
  }
  def loadMovies(implicit sc: SparkContext) = {
    sc.textFile(new File(classLoader.getResource("movies.dat").getFile).toString).map { line =>
      val fields = line.split("::")
      // format: (movieId, movieName)
      (fields(0).toInt, fields(1))
    }.collect().toMap
  }

}
