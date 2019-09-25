name := "rxscala_spring_akka"

version := "0.1"

scalaVersion := "2.12.10"


libraryDependencies += "io.reactivex" %% "rxscala" % "0.26.5"
libraryDependencies += "io.reactivex.rxjava2" % "rxjava" % "2.2.0"
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-webflux" % "2.1.8.RELEASE"
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-test" % "2.1.8.RELEASE" % Test
libraryDependencies += "io.projectreactor" % "reactor-test" % "3.2.12.RELEASE" % Test

