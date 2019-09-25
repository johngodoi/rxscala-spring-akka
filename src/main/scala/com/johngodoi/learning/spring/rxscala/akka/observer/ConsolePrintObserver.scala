package com.johngodoi.learning.spring.rxscala.akka.observer

import java.time.LocalDateTime

import com.johngodoi.learning.spring.rxscala.akka.model.CoinBaseResponse
import reactor.core.publisher.Mono
import rx.lang.scala.Observer

class ConsolePrintObserver extends Observer[Mono[CoinBaseResponse]] {

  override def onError(e: Throwable): Unit = println(e.getMessage)

  override def onCompleted(): Unit = println("Completed")

  override def onNext(t: Mono[CoinBaseResponse]): Unit = t.subscribe(coinbaseResponse => println(s"[${LocalDateTime.now()} " +
    s"${coinbaseResponse.data.base}] Buy Price: $$${coinbaseResponse.data.amount} ${coinbaseResponse.data.currency}"))
}
