package com.johngodoi.learning.spring.rxscala.akka.cmd

import akka.actor.ActorSystem
import com.johngodoi.learning.spring.rxscala.akka.actors.{Poller, PriceRequestor, Printer}
import com.johngodoi.learning.spring.rxscala.akka.service.CoinbaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CMDLineUI(@Autowired coinbaseService: CoinbaseService) extends CommandLineRunner {
  override def run(args: String*): Unit = {
    /*coinbaseService
      .getCryptoPrice("BTC-USD")
      .subscribe(s => println(s.data.amount))*/
/*

    println("LinkEdin Learning Reactive Programming with Scala")

    Observable.interval(3000.millis, IOScheduler.apply())
      .map(tick => coinbaseService.getCryptoPrice("BTC-USD")).subscribe(new ConsolePrintObserver)
    Observable.interval(3000.millis, IOScheduler.apply())
      .map(tick => coinbaseService.getCryptoPrice("ETH-USD")).subscribe(new ConsolePrintObserver)
*/
    val system = ActorSystem.create("helloakka")
    val printerActor = system.actorOf(Printer.props(),"printerActor")
    val requestor = system.actorOf(PriceRequestor.props(printerActor, coinbaseService), "requestor")
    val poller = system.actorOf(Poller.props("BTC-USD", requestor), "poller")
    val pollerETH = system.actorOf(Poller.props("ETH-USD", requestor), "ethPoller")
  }
}
