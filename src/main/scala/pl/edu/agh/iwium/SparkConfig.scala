package pl.edu.agh.iwium

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

object SparkConfig {
  Logger.getLogger("org.apache.spark").setLevel(Level.WARN)
  Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)

  val conf = new SparkConf()
    .setAppName("MovieLensALS")
    .set("spark.executor.memory", "2g")
    .setMaster("local[*]")

  implicit val sc = new SparkContext(conf)
}
