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
        +temImagem: Boolean
        +texto: String
        +fonte: String
    }

    class EnunciadoAssercoes {
        +temAssercao: Boolean
        +relacao: Relacao
        +textosAssercao: TextoAssercao[]
        +posAssercoes: String
    }

    class Relacao {
        +temRelacao: Boolean
        +texto: String
    }

    class TextoAssercao {
        +id: String
        +texto: String
    }

    class Opcoes {
        +temImagem: Boolean
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
