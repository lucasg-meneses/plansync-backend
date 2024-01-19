# PlanSync Backend
RESTful API de um App para gestão de uma rotina, ajudando a organizar e a 
lembrar das tarefas diarias e corriqueiras
## Tecnologias 🚀
* Java 17+
* Spring Boot (3.2.1)
* POSTGRESQL

## Requisitos 

### Principais
-  [ ] CRUD **Usuario**(nome de usuário, email e senha);
-  [ ] CRUD **Tarefa Pendente**(título, descrição, dia da semana, hora inicial e hora final);
-  [X] CRUD **Planner Semanal**(título, anotações,mês e ano);
-  [ ] A **Tarefa Pendente** precisa ser definida em algum dia da semana;
-  [ ] A **Tarefa Pendente** precisa ser definida em alguma hora inicial;
-  [ ] O **Planner Semanal** precisa dar a opção de adicionar notas extras nele.
-  [ ] **Planner Semanal** pode possuir um ou mais  **Tarefas Pendentes** distribuidos
entre os dias da semana e horas do dia;
-  [ ] O **Usuário** pode possuir um ou mais **Planner Semanal**.

### Opcionais

- [ ] Implementar autenticação de consumidores da API;
- [ ] Criar documentação(Swagger);
- [ ] implementar autenticação 2FA para **Usuários**;
- [ ] Suporte a multilinguagem.