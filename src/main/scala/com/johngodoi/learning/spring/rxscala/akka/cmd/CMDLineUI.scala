package com.johngodoi.learning.spring.rxscala.akka.cmd

import com.johngodoi.learning.spring.rxscala.akka.observer.ConsolePrintObserver
import com.johngodoi.learning.spring.rxscala.akka.service.CoinbaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import rx.lang.scala.Observable
import rx.lang.scala.schedulers.IOScheduler

import scala.concurrent.duration._

@Component
class CMDLineUI(@Autowired coinbaseService: CoinbaseService) extends CommandLineRunner {
  override def run(args: String*): Unit = {
    /*coinbaseService
      .getCryptoPrice("BTC-USD")
      .subscribe(s => println(s.data.amount))*/

    println("LinkEdin Learning Reactive Programming with Scala")

    Observable.interval(3000.millis, IOScheduler.apply())
      .map(tick => coinbaseService.getCryptoPrice("BTC-USD")).subscribe(new ConsolePrintObserver)
    Observable.interval(3000.millis, IOScheduler.apply())
      .map(tick => coinbaseService.getCryptoPrice("ETH-USD")).subscribe(new ConsolePrintObserver)

  }
}
