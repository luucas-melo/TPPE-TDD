- UnB - Universidade de Brasilia  
- FGA - Faculdade do Gama  
- TPPE - Técnicas de Programação para Plataformas Emergentes  

## TP1 - ESTACIONAMENTO TDD

|Matrícula | Aluno |
| :--: | :--: |
| 18/0011961 |  [Aline Lermen](https://github.com/AlineLermen) |
| 18/0020251 |  [João Vitor Farias](https://github.com/JoaoVitorFarias) |
| 18/0125885 |  [Lucas Melo](https://github.com/luucas-melo/) |
| 17/0122468 |  [Nilvan Peres](https://github.com/DaviAntonio/) |
| 16/0037522 |  [Nilo Medonça](https://github.com/NiloMendonca/) |


* Linguagem Java:
    * Versão: openjdk 16.0.2 2021-07-20
* Framework para Testes: JUnit 4
* IDE: Eclipse

## TP2 - REFATORAÇÂO

## TP3 - PROJETO DE CÓDIGO

### Ausência de duplicidades

- Em um bom projeto de código não deve existir código duplicado. Duplicação de código pode apenas complicar o projeto e reduzir sua elegância e simplicidade. Um exemplo de problema que pode ser causado por isso é o caso em que dois pedaços de código muito parecidos, em que apenas um detalhe os diferencia, possui um "bug" que deve ser resolvido. Após ser resolvido em um dos pedaços, o outro pode ficar esquecido e continuar com o "bug". Não apenas isso, mas só o fato de ser preciso resolver esse "bug" duas vezes (por estar nos dois pedaços de código) já seria um trabalho extra desnecessário. Com a duplicidade, a estrutura do código pode acabar ficando desnecessariamente mais longa e até mais complexa de se entender, enquanto que seria possível trazer mais clareza unindo pedaços de código semelhantes em apenas uma função com um nome que deixe claro qual a sua responsabilidade. A característica de duplicidade de código não se aplica somente a pedaços aleatórios de código e funções, mas também pode ser útil em classes que possuem alguma funcionalidade semelhante e que poderia ser passada para uma superclasse.
- Essa característica pode estar relacionada com alguns mau-cheiros de código: código duplicado, classe grande, instruções switch, hierarquias de herança paralelas. Em relação ao primeiro mau-cheiro, "código duplicado", é intuitivo. O mau-cheiro de "instruções switch" é a repetição da estrutura switch-case em diferentes partes do projeto, o que resulta em duplicação de código. Os outros dois mau-cheiros citados, "classe grande" e "hierarquias de herança paralelas" são os que indicam que pode haver código duplicado, pois uma classe com muito código possui altas chances de possuir duplicação. Ou então, quando em uma herança, ao criar uma subclasse é necessário criar também outra subclasse, há um início de duplicação de código.
- Para eliminar os possíveis mau-cheiros e alcançar a característica "ausência de duplicidades" de um bom projeto, pode-se utilizar a operação de refatoração "extrair método" que pode resolver alguns dos mau-cheiros citados anteriormente.


### Modularidade

- A modularidade na Engenharia de Software consiste em uma técnica que visa separar os trechos de código em módulos, que por sua vez funcionarão como blocos de instruções que individualmente serão responsáveis por implementar determinada funcionalidade. Essa técnica gera inúmeros benefícios, entre eles facilita na manutenção e evolução do código uma vez que cada módulo pode ser editado sem interferir nos demais, permite o desenvolvimento de diferentes partes do programa de forma paralela entre um ou mais desenvolvedores, diminuindo o tempo necessário para o desenvolvimento, além de facilitar no entendimento, claridade,  desenvolvimento de testes, reutilização e diminuir o acoplamento.
- Entre os possíveis mau-cheiros que podem estar relacionados a essa característica tem a classe inchada, uma vez que um código pouco modularizado tende a agrupar um grande número de variáveis e funções dentro de uma mesma classe, além de conter funções extensas e de difícil entendimento.
- Entre as operações de refatoração que podem auxiliar na obtenção de uma maior modularidade se encontra a operação de extrair classe, uma vez que ajuda no agrupamento de variáveis que possuem sentido em ficarem juntas, além da operação de extrair subclasse.

