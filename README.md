# Avaliação JAVA
### Para o desenvolvimento desta API Rest foram utilizadas as seguintes ferramentas:
- Spring Boot
- Hibernate
- MySQL
- Maven
- Json.org

### Modo de utilização

- Enviar arquivo para upload no database (**contempla item 1**)
	* Método: POST
	* Path: /cities/upload
	* Parametro: CSV file

- Pegar as capitais (considerando que é uma informação existente no banco de dados, **contempla item 2**)
	* Método: GET 
	* Path: /cities/capitals
	
- Pegar os estados com maior e menor numero de cidades (**contempla item 3**)
	* Método: GET 
	* Path: /cities/states/least-most
	
- Pegar quantas cidades por estado tem no database (**contempla item 4**)
	* Método: GET 
	* Path: /cities/states

- Pegar cidade baseada no código do IBGE(foram utilizados dados fictícios, **contempla item 5**)
	* Método: GET 
	* Path: /cities/ibge
	* Parametros: in Path = /cities/ibge/{id_ibge}
	
- Pegar cidades específica de um estado (**contempla item 6**)
	* Método: GET 
	* Path: /cities/states
	* Parametros: in Path = /cities/states/{state_initials}

- Inserir nova cidade no database (**contempla item 7**)
	* Método: POST 
	* Path: /cities
	* Parametro: JSON body item 
	
- Deletar uma cidade (**contempla item 8**)
	* Método: DELETE 
	* Path: /cities
	* Parametro: in Path = /cities/{id_to_delete}

- Pegar uma coluna qualquer do banco e filtrar por uma string (**contempla item 9**)
	* Método: GET 
	* Path: /cities
	* Parametros: in argument "column" and "filter" = /cities?column={some_string}&filter={some_string}

- Pegar o número de geristros unicos de uma coluna qualquer(**contempla item 10**)
	* Método: GET 
	* Path: /cities
	* Parametros: in argument "column" = /cities?column={some_string}

- Pegar total de cidades no database (**contempla item 11**)
	* Método: GET 
	* Path: /cities/total
	
- Pegar as cidades mais distantes (**contempla item 12**)
	* Método: GET 
	* Path: /cities/bigger-distance
	
- Atualizar cidade já existente (**item extra**)
	* Método: PUT 
	* Path: /cities
	* Parametro: JSON body item 

### Pontos de melhoria
- Existem pontos de segurança a serem melhorados que eu gostaria de fazer com mais tempo hábil (utilização de HATEOAS)
- Existem melhorias na documentação que também creio ser necessária (utilização do swagger)
- Commentar melhor classes mais insternas do código.

### Observações
- Para realizar testes e me orientar durante o desenvolvimento eu criei um arquivo CSV com uma base de dados que imaginei que seria apropriada, creio que seja interessante ser avaliado junto com o resto do projeto. Arquivo se encontra na pasta [Provas_Senior/JAVA/cities_example_database.csv](Provas_Senior/JAVA/cities_example_database.csv)
- No item 12, referente a distância das cidades houve uma dificuldade da minha parte para interpretar o cálculo de logitudes e latitudes, logo, para facilitar o processo, utilizei classes próprias para este fim disponíveis na internet, priorizando a lógica de verificação das distância ao invéz do cáculo. Os devidos créditos foram deixados ao desenvolvedor responsável exatamente como o próprio documentou.

# AVALIAÇÃO SQL

Foram respondidas todas as questões da parte teórica, porém, a questão 5 referente ao Tunning não foi relizada devido a minha falta de conhecimento neste aspecto no momento. Porém estou sempre disposto a estudar e aprender mais de forma a agregar ainda mais ao time, acredito e vivo metodologias ágeis na minha vida pessoal e profissional, como todo bom agilista estou em "continuous improvement".

Os artefatos do SQL estão no repositório também, na pasta [Provas_Senior/SQL](Provas_Senior/SQL/)
