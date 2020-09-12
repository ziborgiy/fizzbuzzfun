package borg

import java.util.Properties
import java.util.Collections
import java.time.Duration._

import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters.iterableAsScalaIterableConverter

object Main extends App {
  val props = new Properties

  props.setProperty("bootstrap.servers", "localhost:9092")
  props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.setProperty("group.id", "something")

  val consumer = new KafkaConsumer[String,String](props)

  consumer.subscribe(Collections.singletonList("quickstart-events"))


  while (true) {
    val records = consumer.poll(ofSeconds(10))
    for (record <- records.asScala){
      println(FizzBuzz(record.value().toInt).get)
    }
  }

}
