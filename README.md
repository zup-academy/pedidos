# Pedidos

## Subir a aplicação
Essa aplicação utiliza banco em memória por isso é somente subir a aplicação, ela esta configurada para responder na porta 8081.

## API

Exemplo de chamada para /pedidos : 
```shell
curl --request POST \
  --url http://localhost:8081/pedidos \
  --header 'Content-Type: application/json' \
  --data '{
	"idCliente":321,
	"idRestaurante": 123,
	"items":[
		{
			"quantidade":2,
			"sku":12025646,
			"valor": 10.25
		}
	]
}'
```