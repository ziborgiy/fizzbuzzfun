name := "fizzbuzzfun"

version := "0.1"

scalaVersion := "2.13.3"

enablePlugins(JmhPlugin)

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "2.6.0",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.11.2"
)
