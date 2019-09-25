package com.johngodoi.learning.spring.rxscala.akka.model

class Data() {
  @scala.beans.BeanProperty  var base: String = _
  @scala.beans.BeanProperty var currency: String = _
  @scala.beans.BeanProperty var amount: String =_
}

class CoinBaseResponse(){
  @scala.beans.BeanProperty var data: Data = _
}