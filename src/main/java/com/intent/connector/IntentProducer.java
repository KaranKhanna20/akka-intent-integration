package com.intent.connector;

import akka.camel.javaapi.UntypedProducerActor;

public class IntentProducer extends UntypedProducerActor {
      public String getEndpointUri() {
         return "activemq:queue:firefly.intent.connector";
      }
}
