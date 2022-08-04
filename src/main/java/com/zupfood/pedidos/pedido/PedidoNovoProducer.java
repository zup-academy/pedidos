package com.zupfood.pedidos.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PedidoNovoProducer {

    @Autowired
    private KafkaTemplate<String, Pedido> kafkaTemplate;

    @Value("${spring.kafka.producer.topic}" )
    private String topico;

    @Async
    public void enviar(Pedido pedido){
        kafkaTemplate.send(topico, pedido.getId().toString(), pedido);
    }
}
