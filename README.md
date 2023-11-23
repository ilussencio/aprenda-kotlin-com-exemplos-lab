# Aprenda Kotlin Com Exemplos: Desafio de Projeto (Lab)

Desafio de Projeto criado para avaliação do conteúdo técnico explorado no repositório [aprenda-kotlin-com-exemplos](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos). **Nesse contexto, iremos abstrair o seguinte domínio de aplicação:**

**A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**


## Solução
Nessa solução busquei inserir algumas funções na classe de `Formacao` como:

 `cargaHorariaTotal()`: Onde vai retornar a carga horária total do curso com base no conteudo educacional inserido

 `quantidadeDeInscritos()`: Onde vai retornar o total de inscrições no curso

 `toString()`: Sobrescrevi a função toString para listar mais informações sobre a Formação
 
 `matricular()` : Nesta função criei um exceção personalizada caso o aluno tente se cadastrar e não esta no mesmo nível da Formação