ALTER TABLE item ADD CONSTRAINT fk_id_pedido_item
FOREIGN KEY (id_pedido) REFERENCES pedido(id);