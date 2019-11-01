# Avaliação JAVA
### Para o desenvolvimento desta API Rest foram utilizadas as seguintes ferramentas:
- Spring Boot
- Hibernate
- MySQL
- Maven
- Json.org

### Modo de utilização

- Enviar arquivo para upload no database
	* Método: POST
	* Path: /cities/upload
	* Parametro: CSV file
	
- Inserir nova cidade no database
	* Método: POST 
	* Path: /cities
	* Parametro: JSON body item 
	
- Atualizar cidade já existente 
	* Método: PUT 
	* Path: /cities
	* Parametro: JSON body item 

- Deletar uma cidade
	* Método: DELETE 
	* Path: /cities
	* Parametro: in Path = /cities/{id_to_delete}
	
- Pegar total de cidades no database
	* Método: GET 
	* Path: /cities/total
	
- Pegar as cidades mais distantes
	* Método: GET 
	* Path: /cities/bigger-distance
	
- Pegar as capitais (considerando que é uma informação existente no banco de dados)
	* Método: GET 
	* Path: /cities/capitals
	
- Pegar os estados com maior e menor numero de cidades
	* Método: GET 
	* Path: /cities/states/least-most
	
- Pegar quantas cidades por estado tem no database
	* Método: GET 
	* Path: /cities/states
	
- Pegar cidade baseada no código do IBGE(foram utilizados dados fictícios)
	* Método: GET 
	* Path: /cities/ibge
	* Parametros: in Path = /cities/ibge/{id_ibge}
	
- Pegar cidades específica de um estado
	* Método: GET 
	* Path: /cities/states
	* Parametros: in Path = /cities/states/{state_initials}
	
- Pegar o número de geristros unicos de uma coluna qualquer
	* Método: GET 
	* Path: /cities
	* Parametros: in argument "column" = /cities?column={some_string}

- Pegar uma coluna qualquer do banco e filtrar por uma string
	* Método: GET 
	* Path: /cities
	* Parametros: in argument "column" and "filter" = /cities?column={some_string}&filter={some_string}


### Pontos de melhoria
- Existem pontos de segurança (utilização de HATEOAS)
- Existem melhorias na documentação (utilização do swagger)
- Commentar melhor o código

### Observações
- No item 12, referente a distância das cidades houve uma dificuldade da minha parte para interpretar o cálculo de logitudes e latitudes, logo, utilizei classes próprias para este fim, focando apenas na lógica de verificação, não no cáculo. Os devidos créditos foram deixados ao desenvolvedor responsável

# AVALIAÇÃO SQL

Foram respondidas todas as questões da parte teórica, porém, a questão 5 referente ao Tunning não foi relizada devido a minha falta de conhecimento neste aspecto no momento. Porém estou disposto a estudar e aprender mais de forma a agregar ainda mais ao time.

Os artefatos do SQL estão no repositório na pasta [Provas_Senior/SQL](Provas_Senior/SQL/)
