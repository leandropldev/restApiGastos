# testeSantander

- ## instruções para gerar e rodar a app:

Antes de rodar a aplicação é necessário criar uma base MySql onde os gastos serão persistidos.
As informações de acesso a base de dados se encontram no application.properties, então baixe a aplicação, importe em sua IDE e ajuste a base e schema de acordo com as informações lá contidas ou você pode editar o application.properties para atender a uma eventual base já criada em sua máquina.

> create database testSantander

Após resolver a questão da base, execute pela IDE 'run as > Java Application' na classe 'JwtmeApplication.java'.
Ou, via maven, gere um jar executável com toda a estrutura necessária -> entrando na pasta do projeto e via console executando 'mvn clean install'. 
Após isso, rode a app usando 'java -jar restApiGastosSantander-0.0.1.jar'

- ## Validando acesso via spring security.

A aplicação esta protegida com spring security, sendo que sua validação é via token.
Obtenha o token acessando via POST **localhost:9090/login** e passando no body do request: 
```
{
	"username":"admin",
	"password":"password"
}
```
Esse acesso pode ser via curl, ou qualquer app para requisições (Ex soap-ui / postMan).

A autenticação de credenciais esta sendo feita in Memory, sendo possível integrar via banco de dados.
No header do response, virá o token que iremos usar nas demais requisições, exemplo:.

> Authorization →Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU1Mzc4OTg5MH0.vn6YKLPewrHOr0xwIGxexMAhDEOJ_rdHQ4po7P-VJmx14XJOdBUzdz8DXXyPvHJam5GQbKT4qoDFkL7BYje0kA

- ## Testando funcionalidades do exercício.

**Para todas as demais requisições, sempre enviar o token recebido no header através da chave "Authorization".**
Exemplo:.

> Content-Type = application/json 
 
> Authorization = eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU1Mzc4OTg5MH0.vn6YKLPewrHOr0xwIGxexMAhDEOJ_rdHQ4po7P-VJmx14XJOdBUzdz8DXXyPvHJam5GQbKT4qoDFkL7BYje0kA 


##### Funcionalidade Obrigatória: Listagem de gastos.
	Infelizmente só pude fazer o projeto hoje, então decidi não implementar a funcionalidade de secundos pois gastaria tempo implementando uma lógica para LocalDateTime.
	Sendo assim, a api só retorna uma lista sem critérios de todos os gastos.
	
	> url de acesso: GET localhost:9090/allGastos
	retorno esperado: Array list em JSON com todos os gastos cadastrados na base.
	
##### Funcionalidade Eletiva: Filtro de gastos.
	Devido ao tempo, as datas estão em String
	> url de acesso: GET localhost:9090/informaGastosData?data=18/03/2019 
	sendo que data= 'data que deseja buscar'
	retorno esperado: Array list em JSON com todos os gastos cadastrados para aquela data.
	
##### Funcionalidade Eletiva: Categorização de gastos - FEITO.
	> url de acesso: GET localhost:9090/categorizaGasto?id=1&categoria=leandro
	retorno esperado: mensagem confirmando categoria cadastrada, que o gasto já tem categoria cadastrada ou que o id do gasto informado não existe.
	
##### Funcionalidade Eletiva: Sugestão de categoria - FEITO.
	Por se tratar de uma api REST, foi mapeado um retorno com uma lista de categoria, cabe ao front end tratar essa lista e colocar no evento 'onChange' do usuário.
	> url de acesso: localhost:9090/retornaCategorias
	retorno esperado: lista com todas as categorias cadastradas
	
##### Funcionalidade Eletiva: Categorização automatica de gasto - FEITO.
	Ao cadastrar uma nova regra, a aplicação filtra um gasto com a mesma descrição do gasto informado, caso exista um registro igual, então a categoria será atualizada.
	> url de acesso: localhost:9090/registraGastos
	retorno esperado: o gasto cadastrado em JSON com a categoria já atualizada.
