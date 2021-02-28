package com.ks.kafkastreamsstatestore.controller;

import com.ks.kafkastreamsstatestore.dto.OrderLocation;
import com.ks.kafkastreamsstatestore.service.OrderLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderLocationController {

    private final Logger log = LoggerFactory.getLogger(OrderLocationController.class);

    private final OrderLocationService orderLocationService;

    public OrderLocationController(OrderLocationService orderLocationService) {
        this.orderLocationService = orderLocationService;
    }

    /**
     * {@code GET  /the order location} : order location for of an order.
     *
     * @param orderNumber order number
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the order location in body.
     */
    @GetMapping("/order-location/{orderNumber}")
    public ResponseEntity<OrderLocation> getOrderLocation(@PathVariable String orderNumber) {
        log.info("REST request to get location of Order");
        OrderLocation orderLocation = orderLocationService.getOrderLocation(orderNumber);
        return ResponseEntity.ok().body(orderLocation);
    }
}
