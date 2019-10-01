package com.johngodoi.learning.spring.rxscala.akka.actors

import akka.actor.{Actor, ActorRef, Props}
import com.johngodoi.learning.spring.rxscala.akka.service.CoinbaseService

case class GetThisCryptoPrice(whatPrice:String)

case class PriceRequestor(printerActor:ActorRef, coinbaseService: CoinbaseService) extends Actor{
  override def receive: Receive = {
    case what: GetThisCryptoPrice => printerActor ! CryptoPrice(coinbaseService.getCryptoPrice(what.whatPrice))
  }
}

object PriceRequestor{
  def props(printerActor:ActorRef, coinbaseService: CoinbaseService): Props = Props(PriceRequestor(printerActor, coinbaseService))
}