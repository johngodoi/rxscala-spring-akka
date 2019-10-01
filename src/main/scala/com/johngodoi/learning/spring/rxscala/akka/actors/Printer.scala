package com.johngodoi.learning.spring.rxscala.akka.actors

import java.time.LocalDateTime

import akka.actor.{Actor, Props}
import com.johngodoi.learning.spring.rxscala.akka.model.CoinBaseResponse
import reactor.core.publisher.Mono

case class CryptoPrice(message:Mono[CoinBaseResponse])
case class Printer() extends Actor {
  override def receive: Receive = {
    case msg:CryptoPrice =>
      msg.message.subscribe(
      coinBaseResponse =>
      println(s"[${LocalDateTime.now()}] ${coinBaseResponse.data.base} Buy Price: $$ ${coinBaseResponse.data.amount} " +
        s"${coinBaseResponse.data.currency}"))
  }
}

object Printer{
  def props():Props = Props(Printer())
}