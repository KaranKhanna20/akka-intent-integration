package com.intent.connector;

import com.adtran.firefly.messaging.RequestMessage;
import com.google.gson.Gson;

import akka.camel.CamelMessage;
import akka.camel.javaapi.UntypedConsumerActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class IntentConsumer extends UntypedConsumerActor{
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	@Override
	public String getEndpointUri() {
		return "activemq:queue:firefly.intent.connector";
	}

	@Override
	public void onReceive(Object message) throws Exception {
		 if(message instanceof CamelMessage) {
	            Gson gson = new Gson();
	            CamelMessage camelMessage = (CamelMessage)message;
	            String body = camelMessage.getBodyAs(String.class, getCamelContext());
	            //RequestMessage ffMessage = new RequestMessage(body);
	            log.info("Found msg => " + body);
	        } else {
	            unhandled(message);
	        }
	}

}
