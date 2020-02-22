# Simple-api
Api rest com operações básicas na entidade Torneio no endpoint .../api/tournament.
# Exemplo de uso
POST /api/tournament
Retorna o objeto criado.
Exemplo de dado enviado.
```javascript
{
	"title": "Torneio 2110",
	"dateTournament": "(10/10/2010)",
	"subscription": "1.111.234,40",
	"maxSubscribers": "150"
}
```

GET /api/tournament/:id
Retorna o objeto que possui o id = {:id}.

GET /api/tournament/list?
Retorna uma lista com todos os torneios e aceita parametros referentes aos atributos da entidade torneio.
(Caso não seja passado nenhum parametro todos os torneios serão retornados)

PUT /api/tournament/:id
Atualiza os dados do objeto de id = {:id} retornando o objeto atualizado.

DELETE /api/tournament/:id
Remove e retorna o objeto com id = {:id}.
