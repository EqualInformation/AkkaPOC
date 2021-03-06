package com.equalinformation.poc.akka.scala

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class SampleActor extends Actor {
  def receive = {
    case "test" => println("test reflected")
    case _      => println("not a test")
  }
}

object SampleApp extends App {
  val system = ActorSystem("SampleSystem")
  // Default Actor constructor
  val testActor = system.actorOf(Props[SampleActor], name = "testactor")
  testActor ! "test"
  testActor ! "alternate message"
}