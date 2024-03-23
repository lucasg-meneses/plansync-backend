# PlanSync Backend
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

RESTful API de um App para gestão de uma rotina, ajudando a organizar e a lembrar das tarefas diarias e corriqueiras.

## Tecnologias 🚀
* JDK 17+
* Spring Boot (3.2.1)
* POSTGRESQL 10+
## Requisitos 

### Principais
-  [X] CRUD **Usuario**(nome de usuário, email e senha);
-  [X] CRUD **Tarefa Pendente**(título, descrição, dia da semana, hora inicial e hora final);
-  [X] CRUD **Planner Semanal**(título, anotações,mês e ano);
-  [X] A **Tarefa Pendente** precisa ser definida em algum dia da semana;
-  [X] A **Tarefa Pendente** precisa ser definida em alguma hora inicial;
-  [X] O **Planner Semanal** precisa dar a opção de adicionar notas extras nele.
-  [X] **Planner Semanal** pode possuir um ou mais  **Tarefas Pendentes** distribuidos
entre os dias da semana e horas do dia;
-  [X] O **Usuário** pode possuir um ou mais **Planner Semanal**.

### Opcionais

- [ ] Implementar autenticação de consumidores da API;
- [ ] Criar documentação usando o Swagger ;
- [ ] implementar autenticação 2FA para **Usuários**;
- [ ] permitir que o Usuário deixe público seu planner para visualizá-lo.
- [ ] permitir que multiplos usuarios possam manipular o mesmo planner.

## Projetos Extras
[Frontend](https://github.com/lucasg-meneses/plansync-frontend)
