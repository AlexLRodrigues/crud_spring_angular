## Crud simples utilizando Angular 8x, Spring Boot e MySQL

#### Instruções para uso
1 - Ter o serviço do MYSQL disponível na máquina;
2 - Exportar a api (spring-angular-api) no STS (eclipse) e efetuar o maven update.
3 - Alterar o datasource no application.properties de acordo com seus dados de conexão com o banco
	spring.datasource.url=jdbc:mysql://localhost:3306/crud_spring_angulardb?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC
	spring.datasource.username=
	spring.datasource.password=
4 - Rodar a API spring-angular-api através da opção Run As Spring Boot App
5 - Com o node instalado rodar o comando npm install no projeto do fronend (crud-angular-frontend) e ao terminar rodar o npm start
6 - Efetuar os testes na url: http://localhost:4200