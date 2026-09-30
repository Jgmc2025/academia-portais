# Academia dos Portais — Padrões de Projeto em Java Puro

Verificador de portais (desafio "positivo e divisível por 3") reescrito para
praticar Design Patterns. Cada portal resulta em `INVALID`, `OPEN` ou `CLOSED`.

## Padrões aplicados

| Padrão | Onde | Para quê |
|---|---|---|
| **Strategy** | `strategy/RegraAbertura` | Trocar a regra de abertura (múltiplo de N, par...) sem mexer no resto |
| **Chain of Responsibility** | `chain/ValidadorTentativa` | Encadear validações (positivo, limite) antes da regra |
| **Factory** | `factory/RegraFactory` | Criar regras a partir de texto (`par`, `multiplo-de-5`) |
| **Builder** | `builder/PortalBuilder` | Montar o `Portal` com valores padrão |
| **Observer** | `observer/*` | Reagir a cada tentativa (log, estatísticas) |
| **Singleton** | `singleton/EstatisticasAcademia` | Contagem global única e thread-safe |
| **Facade** | `facade/VerificadorFacade` | API simples que esconde todo o fluxo acima |

## Como executar

```bash
mkdir -p out && javac -d out $(find src -name "*.java")
printf "4\n3\n4\n-2\n0\n" | java -cp out academia.Main            # regra padrão
printf "3\n4\n5\n6\n"     | java -cp out academia.Main par --log  # outra regra + observer de log
```

Saída do primeiro exemplo: `OPEN`, `CLOSED`, `INVALID`, `INVALID`.

## Ideias de evolução
- Decorator para combinar regras (ex.: "par E múltiplo de 3")
- Versão com Spring Boot expondo `POST /portais/verificar`
- Testes unitários com JUnit para cada padrão
