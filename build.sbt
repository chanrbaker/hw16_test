onLoadMessage := ""
showSuccess := false
logLevel := Level.Warn
traceLevel := 10

lazy val root = (project in file(".")).settings(
  scalaVersion := "2.12.6",
  scalacOptions ++= Seq(
    "-deprecation",
    "-unchecked",
    "-explaintypes",
    "-feature", //???
    "-Ywarn-adapted-args", //???
    "-Ywarn-dead-code",
    "-Ywarn-value-discard",
    "-Ywarn-unused:locals",
  ),
  name := "homeworks",
//  resolvers += Resolver.sonatypeRepo("public"),
  resolvers += "EECS Repo" at "http://www-internal.eecs.usma.edu/courses/scala/releases",
  libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.5",
  libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0",
  libraryDependencies += "eecs" % "eecstester_2.12" % "0.4.3",

  wartremoverWarnings ++= Seq(
    Wart.Any,Wart.ArrayEquals,Wart.Nothing,
    Wart.Null,Wart.Overloading,Wart.Product,Wart.Serializable
  ),

  // configure sbt-errors (default errorIdColor too hard to read)
  reporterConfig := reporterConfig.value.withErrorIdColor(scala.Console.MAGENTA),

  scalafmtTestOnCompile := false,
  scalafmtFailTest := false,

  scalastyleSources := Seq(baseDirectory.value) // make scalastyle look here instead of src/main/scala
)

lazy val compilecheckScalastyle = taskKey[Unit]("compile and then scalastyle")
compilecheckScalastyle := Def.sequential(
  compile in Compile,
  (scalastyle in Compile).toTask("")
).value
(run in Compile) := ((run in Compile) dependsOn compilecheckScalastyle).evaluated
