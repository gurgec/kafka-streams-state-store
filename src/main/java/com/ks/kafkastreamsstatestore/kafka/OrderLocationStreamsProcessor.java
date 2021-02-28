package com.ks.kafkastreamsstatestore.kafka;

import com.ks.kafkastreamsstatestore.dto.OrderLocation;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderLocationStreamsProcessor implements Processor<String, OrderLocation> {

    private final Logger log = LoggerFactory.getLogger(OrderLocationStreamsProcessor.class);

    private KeyValueStore<String, OrderLocation> stateStore;

    @Value(value = "${kafka.streams.stateStoreName}")
    private String stateStoreName;

    @Override
    public void init(ProcessorContext context) {
        stateStore = (KeyValueStore<String, OrderLocation>) context.getStateStore(stateStoreName);
        Objects.requireNonNull(stateStore, "State store can't be null");
    }

    @Override
    public void process(String orderNumber, OrderLocation orderLocation) {
        log.info("Streams Request to save process Order Location : {}", orderLocation);

        //add processing the kafka message here like save to NoSQL DB, Elastic Search, do aggregation

        stateStore.put(orderNumber, orderLocation);
    }

    @Override
    public void close() {

    }
}
