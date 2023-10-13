# primeiraapi
Desafio de primeira API da DIO.

```mermaid
classDiagram
    class Questao {
        +id: String
        +textosDeApoio: TextoDeApoio[]
        +enunciado: String
        +enunciadoAssercoes: EnunciadoAssercoes
        +opcoes: Opcoes
        +opcao_correta: String
    }

    class TextoDeApoio {
        +numero: String
        +img: Boolean
        +texto: String
        +fonte: String
    }

    class EnunciadoAssercoes {
        +existe: Boolean
        +relacao: Relacao
        +textos: TextoAssercao[]
    }

    class Relacao {
        +questiona: Boolean
        +texto: String
        +posAssercoes: String
    }

    class TextoAssercao {
        +id: String
        +texto: String
    }

    class Opcoes {
        +temImg: Boolean
        +opcoes: Opcao[]
    }

    class Opcao {
        +id: String
        +questao: String
    }

    Questao -- TextoDeApoio
    Questao -- EnunciadoAssercoes
    Questao -- Opcoes
    Opcoes -- Opcao
    EnunciadoAssercoes -- TextoAssercao
    EnunciadoAssercoes -- Relacao
```
