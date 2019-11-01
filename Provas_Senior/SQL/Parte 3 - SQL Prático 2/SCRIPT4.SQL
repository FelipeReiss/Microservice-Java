/*
Parte 3 – SQL Prático1
Exercício 4.
Crie uma consulta SELECT que exiba o total de linhas 
da tabela EXAME_NF por dia. Exiba somente as linhas 
que possuam ao menos um item (EXAME_ITEMNF) com valor 
inferior a 50. Salve a consulta no arquivo SCRIPT4.SQL.

*/

-- Crie uma consulta SELECT que exiba o total de linhas da tabela EXAME_NF por dia. 
SELECT DATACADASTRO, COUNT(*) AS `TOTAL DE NF` FROM EXAME_NF GROUP BY DATACADASTRO;

-- Exiba somente as linhas que possuam ao menos um item (EXAME_ITEMNF) com valor inferior a 50. 
SELECT DISTINCT N.IDNF, N.NUMERO, N.DATACADASTRO, N.TOTALGERAL 
FROM EXAME_NF AS N, EXAME_ITEMNF AS I 
WHERE N.IDNF = I.IDNF AND I.VALOR < 50; 