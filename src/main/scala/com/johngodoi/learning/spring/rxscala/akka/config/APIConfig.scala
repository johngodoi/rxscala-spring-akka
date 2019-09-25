package com.johngodoi.learning.spring.rxscala.akka.config

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper, ObjectWriter}
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class APIConfig {

  @Bean
  def objectMapper():ObjectMapper = new ObjectMapper()
    .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)

  @Bean
  def objectWriter(objectMapper: ObjectMapper):ObjectWriter = objectMapper.writerWithDefaultPrettyPrinter()

  @Bean
  def webClient():WebClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector()).build()
}
