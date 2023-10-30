# primeiraapi
Desafio de primeira API da DIO.

```mermaid
classDiagram
    class Questao {
        +numeroDaQuestao: String
        +anulada: Boolean
        +temAssercoes: Boolean
        +enunciado: String
        +opcaoCorreta: String
        +textosDeApoioDto: TextoDeApoio[]
        +respostasDto: Respostas
        +enunciadoAssercoesDto: EnunciadoAssercoes
    }

    class TextoDeApoio {
        +numero: Number
        +temImagem: Boolean
        +texto: String
        +fonte: String
    }

    class Respostas {
        +temImagem: Boolean
        +opcoesDto: Opcao[]
    }

    class Opcao {
        +letra: String
        +texto: String
    }

    class EnunciadoAssercoes {
        +temRelacao: Boolean
        +textoRelacao: String
        +posAssercoes: String
        +assercoes: Assercao[]
    }

    class Assercao {
        +numeroRomano: String
        +texto: String
    }

    Questao -- TextoDeApoio
    Questao -- EnunciadoAssercoes
    Questao -- Respostas
    Respostas -- Opcao
    EnunciadoAssercoes -- Assercao

```
