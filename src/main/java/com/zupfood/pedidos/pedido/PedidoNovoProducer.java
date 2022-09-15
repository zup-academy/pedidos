package com.zupfood.pedidos.pedido;

import com.zupfood.pedidos.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoNovoProducer {

    Logger logger = LoggerFactory.getLogger(PedidoNovoProducer.class);

    @Autowired
    private KafkaTemplate<String, PedidoNovoEvent> kafkaTemplate;

    @Value("${spring.kafka.producer.topic.novo-pedido}" )
    private String topico;

    @Async
    public void enviar(Pedido pedido, List<Item> itens){
        List<ItemEvent> itensEvent = itens.stream()
                .map(i -> new ItemEvent(i.getId(), i.getQuantidade(), i.getSku(), i.getValor(), i.getDataCriado()))
                .collect(Collectors.toList());

        PedidoNovoEvent evento = new PedidoNovoEvent(pedido.getId(),
                pedido.getIdCliente(), pedido.getIdRestaurante(),
                pedido.getDataCriado(), itensEvent, StatusEvent.valueOf(pedido.getStatus().toString()));

        kafkaTemplate.send(topico, pedido.getId().toString(), evento);

        logger.info("Evento gerado com sucesso : " + evento.toString());
    }
}
