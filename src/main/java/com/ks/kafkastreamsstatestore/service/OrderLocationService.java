package com.ks.kafkastreamsstatestore.service;

import com.ks.kafkastreamsstatestore.dto.OrderLocation;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderLocationService {

    private final Logger log = LoggerFactory.getLogger(OrderLocationService.class);

    private final KafkaStreams kafkaStreams;

    @Value(value = "${kafka.streams.stateStoreName}")
    private String stateStoreName;

    public OrderLocationService(KafkaStreams kafkaStreams) {
        this.kafkaStreams = kafkaStreams;
    }

    public OrderLocation getOrderLocation(String orderNumber) {
        StoreQueryParameters<ReadOnlyKeyValueStore<String, OrderLocation>> storeQueryParameters =
                StoreQueryParameters.fromNameAndType(stateStoreName, QueryableStoreTypes.keyValueStore());
        OrderLocation orderLocation = kafkaStreams.store(storeQueryParameters)
                .get(orderNumber);
        log.info("Order Location Result: {}", orderLocation);
        return orderLocation;
    }
}
