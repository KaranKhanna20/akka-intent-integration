/*
 * Copyright 2014 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intent.connector;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import akka.osgi.ActorSystemActivator;

/**
 * Skeletal ONOS application component.
 */
public class IntentConnector extends ActorSystemActivator{
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
    public void start(BundleContext context) {
        log.info("Bundle starting!");
        super.start(context);
    }

    @Override
    public void stop(BundleContext context) {
        log.info("Bundle stopping!");
        // Unregister any services here.
        super.stop(context);
    }

	@Override
	public void configure(BundleContext context, ActorSystem system) {
		// TODO Auto-generated method stub
		ActorRef consumer = system.actorOf(Props.create(IntentConsumer.class), "intent-consumer");
		Props props = Props.create(IntentProducer.class);
        ActorRef producer = system.actorOf(props, "intent-producer");
        producer.tell("Hello I am Here...", ActorRef.noSender());
        log.info("Message send Successfully......");
    	
	}



}
