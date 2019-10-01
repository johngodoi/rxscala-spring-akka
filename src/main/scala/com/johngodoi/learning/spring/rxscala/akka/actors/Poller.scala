package com.johngodoi.learning.spring.rxscala.akka.actors

import akka.actor.{Actor, ActorRef, Props, Timers}

import scala.concurrent.duration._

case object FirstTick
case object Tick
case object TickKey
case class Poller(cryptoName:String, requestorActor:ActorRef) extends Actor with Timers {

  timers.startSingleTimer(TickKey,FirstTick,500 millis)

  override def receive = {
    case Tick => requestorActor ! GetThisCryptoPrice(cryptoName)
    case FirstTick  => timers.startTimerWithFixedDelay(TickKey,Tick,3 seconds)
  }
}
object Poller {
  def props(cryptoName:String, requestorActor: ActorRef): Props = Props(Poller(cryptoName, requestorActor))
}
