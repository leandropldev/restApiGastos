# testeSantander

- instruções para gerar e rodar a app:

Antes de rodar a aplicação é necessário criar uma base MySql onde os gastos serão persistidos.
As informações de acesso a base de dados se encontram no application.properties, então baixe a aplicação, importe em sua IDE e ajuste a base e schema de acordo com as informações lá contidas ou você pode editar o application.properties para atender a uma eventual base já criada em sua máquina.

Após resolver a questão da base, execute pela IDE 'run as > Java Application' na classe 'JwtmeApplication.java'.
Ou, via maven, gere um jar executável com toda a estrutura necessária -> entrando na pasta do projeto e via console executando 'mvn clean install'. 
Após isso, rode a app usando 'java -jar restApiGastosSantander-0.0.1.jar'

- Validando as funcionalidades da app.

A aplicação esta protegida com spring security, sendo que sua validação é via token.
Obtenha o token acessando via POST localhost:9090/login e passando no body do request: 
{
	"username":"admin",
	"password":"password"
}

A autenticação de credenciais esta sendo feita in Memory, sendo possível integrar via banco de dados.



Funcionalidade Obrigatória: Listagem de gastos.
	Falta filtrar listagem de gastos para 5 segundos atrás.
	
Funcionalidade Eletiva: Filtro de gastos.
	Falta filtrar listagem pela data informada.
	
Funcionalidade Eletiva: Categorização de gastos - FEITO.

Funcionalidade Eletiva: Sugestão de categoria - FEITO.
	Por se tratar de uma api REST, foi mapeado um retorno com uma lista de categoria, cabe ao front end tratar essa lista e colocar no evento 'onChange' do usuário.
	
Funcionalidade Eletiva: Categorização automatica de gasto - FEITO.
