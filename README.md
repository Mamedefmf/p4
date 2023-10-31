# FIAP PosTech Tech Challenge Fase I

Esse repositório é um pacote para atender ao challenge da fase 1. Usando o springboot foi criada uma API Rest para demonstrar o funcionamento de uma Ferramenta de Pesquisa de Preço Padrão. 

## Criar uma Pesquisa de Preço Padrão
Um request POST para http://localhost:8080/ppp com um JSON no formato do exemplo abaixo cria um objeto no banco de dados H2 e com o Id gerado é possível outras operações.

> {
>   "descricao": "nome da pesquisa",
>   "responsavel": "nome do responsável",
>   "itensPesquisa": [
>        {
>            "nome": "nome do item",
>           "precoEmpresa1": 10.0,
>            "precoEmpresa2": 20.0,
>            "precoEmpresa3": 30.0,
>            "urlEmpresa1": "http://exemplo.com.br/itemexemplo1",
>            "urlEmpresa2": "http://exemplo.com.br/itemexemplo2",
>            "urlEmpresa3": "http://exemplo.com.br/itemexemplo2"
>        },
>        {
>            "nome": "nome do item 2",
>            "precoEmpresa1": 40.0,
>            "precoEmpresa2": 50.0,
>            "precoEmpresa3": 60.0,
>            "urlEmpresa1": "http://exemplo.com.br/itemexemplo1",
>            "urlEmpresa2": "http://exemplo.com.br/itemexemplo2",
>            "urlEmpresa3": "http://exemplo.com.br/itemexemplo3"
>        }
>    ]
>}

É possível adicionar quantos itens forem necessários na pesquisa.


## Alterar uma Pesquisa de Preço Padrão
Um request PUT para http://localhost:8080/ppp/+"ID" com um JSON no formato do exemplo acima, atualiza a pesquisa de preço padrão do ID colocado na url.


## Consultar todas as pesquisas salvas
Um request GET para http://localhost:8080/ppp retorna todas as pesquisas cadastradas e seus atributos.

## Consultar pesquisa por ID
Um request GET para http://localhost:8080/ppp/+"ID" consulta apenas os atributos do ID fornecido na url.

## Deletar uma pesquisa
Um request DELETE para http://localhost:8080/ppp/+"ID" deleta o objeto com o ID fornecido na url.



