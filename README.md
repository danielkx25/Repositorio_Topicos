# Repositorio_Topicos
Aqui foi feita a implementação de um micro serviço que calcula as horas que determinado funcionário que
fez um registro no relógio ponto trabalhou. Baseando-se no horário de entrada e no horário de saída.

# Rotas
Nesse parágrafo temos as rotas que estão acessíveis no sistema:

### Registro do Ponto
| Verbo | Rota        	             | Descrição                                                                                |
|-------|----------------------------|------------------------------------------------------------------------------------------|
|  GET  |/registros   	             | Retorna todos os registros de ponto feitos.      	                                |
|  GET  |/registros/{id}	     | Retorna um registro de ponto específico de acordo com o id.                              |
|  GET  |/registros/calculoHoras/{id}| Retorna a quantidade de horas trabalhadas em um registro específico do ponto usando o id.|
|  POST |/registros                  | Ao passar os parâmetros, um produto é cadastrado. 	                                |


Obs: Funciona também com horários noturnos de um dia para o outro.
