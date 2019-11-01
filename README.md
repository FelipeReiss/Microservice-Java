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
	* Parâmetros: CSV file

- Pegar as capitais (considerando que é uma informação existente no banco de dados, **contempla item 2**)
	* Método: GET 
	* Path: /cities/capitals
	
- Pegar os estados com maior e menor número de cidades (**contempla item 3**)
	* Método: GET 
	* Path: /cities/states/least-most
	
- Pegar quantas cidades por estado tem no database (**contempla item 4**)
	* Método: GET 
	* Path: /cities/states

- Pegar cidade baseada no código do IBGE(foram utilizados dados fictícios, **contempla item 5**)
	* Método: GET 
	* Path: /cities/ibge
	* Parâmetros: in Path = /cities/ibge/{id_ibge}
	
- Pegar cidades específicas de um estado (**contempla item 6**)
	* Método: GET 
	* Path: /cities/states
	* Parâmetros: in Path = /cities/states/{state_initials}

- Inserir nova cidade no database (**contempla item 7**)
	* Método: POST 
	* Path: /cities
	* Parâmetros: JSON body item 
	
- Deletar uma cidade (**contempla item 8**)
	* Método: DELETE 
	* Path: /cities
	* Parâmetros: in Path = /cities/{id_to_delete}

- Pegar uma coluna qualquer do banco e filtrar por uma string (**contempla item 9**)
	* Método: GET 
	* Path: /cities
	* Parâmetros: in argument "column" and "filter" = /cities?column={some_string}&filter={some_string}

- Pegar o número de geristros unicos de uma coluna qualquer(**contempla item 10**)
	* Método: GET 
	* Path: /cities
	* Parâmetros: in argument "column" = /cities?column={some_string}

- Pegar total de cidades no database (**contempla item 11**)
	* Método: GET 
	* Path: /cities/total
	
- Pegar as cidades mais distantes (**contempla item 12**)
	* Método: GET 
	* Path: /cities/bigger-distance
	
- Atualizar cidade já existente (**item extra**)
	* Método: PUT 
	* Path: /cities
	* Parâmetros: JSON body item 

### Pontos de melhoria
- Existem pontos de segurança a serem melhorados que eu gostaria de fazer com mais tempo hábil (utilização de HATEOAS)
- Existem melhorias na documentação que também creio ser necessária (utilização do swagger)
- Comentar melhor classes mais internas do código.

### Observações
- Para realizar testes e me orientar durante o desenvolvimento eu criei um arquivo CSV com uma base de dados que imaginei que seria apropriada, creio que seja interessante ser avaliado junto com o resto do projeto. Arquivo se encontra em [Provas_Senior/JAVA/cities_example_database.csv](Provas_Senior/JAVA/cities_example_database.csv)
- Houveram algumas SQL Queries necessárias que eu acredito que a melhor prática seria colocar chamadas de procedures na API, centralizando a manipulação do database com os DBAs, desta forma qualquer alteração eventual não afetaria a API. Porém como o intuito deste projeto foi avaliar meu conhecimento em JAVA e meu conhecimento em SQL está sendo havaliado no outro projeto, mantive o controle total no projeto. Apenas gostaria de deixar claro este ponto.
- No item 12, referente a distância das cidades houve uma dificuldade da minha parte para interpretar o cálculo de logitudes e latitudes, logo, para facilitar o processo, utilizei classes próprias para este fim disponíveis na internet, priorizando a lógica de verificação das distâncias ao invés do cálculo. Os devidos créditos foram deixados ao desenvolvedor responsável exatamente como o próprio documentou.

# AVALIAÇÃO SQL

Foram respondidas todas as questões da parte teórica, porém, a questão 5 referente ao Tunning não foi realizada devido a minha falta de conhecimento neste aspecto no momento. Porém estou sempre disposto a estudar e aprender mais de forma a agregar ainda mais ao time, acredito e vivo metodologias ágeis na minha vida pessoal e profissional, como todo bom agilista estou em "continuous improvement".

Os artefatos do SQL estão no repositório também, na pasta [Provas_Senior/SQL](Provas_Senior/SQL/)
