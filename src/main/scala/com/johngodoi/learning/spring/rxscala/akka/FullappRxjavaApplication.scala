package com.johngodoi.learning.spring.rxscala.akka

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
class FullappRxjavaApplication
object FullappRxjavaApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[FullappRxjavaApplication], args: _*)
  }
}
