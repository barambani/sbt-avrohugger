organization := "com.julianpeeters"

name := "datatype-scavro-serializaton-tests"

version := "0.5-SNAPSHOT"

crossScalaVersions := Seq("2.10.6", "2.11.11")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Ywarn-value-discard")

scalacOptions in Test ++= Seq("-Yrangepos")

sourceGenerators in Compile += (avroScalaGenerateScavro in Compile).taskValue

avroScalaScavroCustomTypes in Compile := {
  avrohugger.format.Scavro.defaultTypes.copy(
    enum = avrohugger.types.JavaEnum,
    array = avrohugger.types.ScalaList)
}

avroScalaCustomNamespace in Compile := Map("SCAVRO_DEFAULT_PACKAGE$" -> "scavro")

libraryDependencies ++= Seq(
  "org.oedura" %% "scavro" % "1.0.3",
  "org.apache.avro" % "avro-ipc" % "1.7.7",
  "org.specs2" %% "specs2-core" % "3.8.6" % "test"
)
