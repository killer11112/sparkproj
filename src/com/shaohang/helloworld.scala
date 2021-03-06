package com.shaohang
import org.apache.spark.{SparkContext, SparkConf}


object helloworld {
  def main(args : Array[String]) = {
    val conf = new SparkConf().setAppName("WordCount")
    val sc = new SparkContext(conf)
    val input = args(0)
    val texts = sc.textFile("a.txt").map(line => line.split(" "))
      .flatMap(words => words.map(word => (word.replaceAll("[^A-Za-z]", ""), 1)))
    val counts =  texts.reduceByKey(_ + _)
    counts.collect.foreach{
      case (word, num) =>
        println(word + " " + num.toString)
        //git com
    }

  }


}
