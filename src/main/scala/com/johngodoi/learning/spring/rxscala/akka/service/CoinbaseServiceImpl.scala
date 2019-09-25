package com.johngodoi.learning.spring.rxscala.akka.service

import com.johngodoi.learning.spring.rxscala.akka.model.CoinBaseResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class CoinbaseServiceImpl(@Autowired webClient:WebClient) extends CoinbaseService {

  override def getCryptoPrice(priceName: String): Mono[CoinBaseResponse] = {
    webClient
      .get()
      .uri("https://api.coinbase.com/v2/prices/{cryptoName}/buy", priceName)
      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .flatMap(clientResponse => clientResponse.bodyToMono(classOf[CoinBaseResponse]))
  }
}
