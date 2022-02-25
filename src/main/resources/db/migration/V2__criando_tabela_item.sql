CREATE TABLE item (
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  quantidade int,
  sku bigint,
  valor double,
  data_criado timestamp,
  id_pedido bigint
);