package com.johngodoi.learning.spring.rxscala.akka.service

import com.johngodoi.learning.spring.rxscala.akka.model.CoinBaseResponse
import reactor.core.publisher.Mono

trait CoinbaseService {
  def getCryptoPrice(priceName:String):Mono[CoinBaseResponse]
}
