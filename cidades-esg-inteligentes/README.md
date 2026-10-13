# Projeto - Cidades ESG Inteligentes

API REST acadêmica desenvolvida em Java com Spring Boot para cadastrar cidades e acompanhar indicadores ESG, como índice de sustentabilidade, emissão de CO2, uso de energia renovável e reciclagem.

## Como executar localmente com Docker

### Pré-requisitos
- Docker Desktop instalado
- Git instalado

### Subir staging e produção
```bash
docker compose up --build -d
```

Ambientes:
- Produção: http://localhost:8080/api/cidades
- Staging: http://localhost:8081/api/cidades

Para visualizar os containers:
```bash
docker compose ps
```

Para encerrar:
```bash
docker compose down
```

## Executar sem Docker

Pré-requisitos:
- Java 21
- Maven 3.9+

```bash
mvn spring-boot:run
```

A aplicação ficará disponível em:
http://localhost:8080/api/cidades

## Exemplos de uso

### Criar cidade
```bash
curl -X POST http://localhost:8080/api/cidades \
  -H "Content-Type: application/json" \
  -d '{
    "nome":"Curitiba",
    "estado":"PR",
    "indiceSustentabilidade":88.5,
    "emissaoCo2":2.3,
    "energiaRenovavelPercentual":76.0,
    "reciclagemPercentual":64.0
  }'
```

### Listar cidades
```bash
curl http://localhost:8080/api/cidades
```

## Pipeline CI/CD

Ferramenta utilizada: **GitHub Actions**.

O pipeline está em `.github/workflows/ci-cd.yml` e executa:
1. Checkout do código.
2. Configuração do Java 21.
3. Build automático com Maven.
4. Execução de testes automatizados.
5. Build da imagem Docker.
6. Deploy automatizado em staging para push na branch `develop`.
7. Deploy automatizado em produção para push na branch `main`.

> Observação acadêmica: no GitHub Actions hospedado, os containers são executados no runner temporário. Para um deploy persistente real, seria necessário configurar um servidor, serviço de nuvem ou self-hosted runner. Para esta atividade, o fluxo demonstra corretamente a automação das etapas de staging e produção.

## Containerização

A aplicação utiliza um Dockerfile multi-stage:
- A primeira etapa usa Maven + JDK 21 para compilar o projeto.
- A segunda etapa usa uma imagem Java Runtime menor para executar o `.jar`.

O `docker-compose.yml` define dois ambientes:
- `app-staging`, exposto na porta 8081.
- `app-production`, exposto na porta 8080.

Também são utilizados:
- volumes persistentes separados para staging e produção;
- variáveis de ambiente;
- rede Docker própria (`esg-network`).

## Prints do funcionamento

Inclua aqui as evidências reais antes da entrega:

1. Print do GitHub Actions com o job `build-test` concluído.
2. Print do job `deploy-staging` concluído na branch `develop`.
3. Print do job `deploy-production` concluído na branch `main`.
4. Print de `http://localhost:8081/api/cidades` funcionando.
5. Print de `http://localhost:8080/api/cidades` funcionando.
6. Print do comando `docker compose ps`.

## Tecnologias utilizadas

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Bean Validation
- H2 Database
- Maven
- JUnit 5
- Docker
- Docker Compose
- GitHub Actions
- Git/GitHub

## Desafios encontrados e soluções

### Separação de ambientes
Foi necessário garantir que staging e produção não compartilhassem a mesma porta nem os mesmos dados. A solução foi utilizar serviços e volumes Docker separados.

### Automatização de build e testes
O GitHub Actions foi configurado para executar Maven automaticamente em cada push ou pull request para as branches principais.

### Reprodutibilidade do ambiente
O Docker elimina diferenças entre máquinas, garantindo que a mesma imagem seja usada para executar a aplicação.

## Checklist de entrega

| Item | OK |
|---|---|
| Projeto compactado em .ZIP com estrutura organizada | ☑ |
| Dockerfile funcional | ☑ |
| docker-compose.yml ou arquivos Kubernetes | ☑ |
| Pipeline com etapas de build, teste e deploy | ☑ |
| README.md com instruções e espaço para prints | ☑ |
| Documentação técnica com evidências (PDF ou PPT) | ☐ |
| Deploy realizado nos ambientes staging e produção | ☐ |

Os dois últimos itens devem ser marcados após executar o projeto, tirar os prints reais e gerar/anexar a documentação final.

## Evidências incluídas

A pasta `evidencias/` contém uma prévia visual da interface, a estrutura do projeto, a validação estática executada e os arquivos de configuração de CI/CD e Docker.

> Observação de integridade: o ambiente usado para preparar esta entrega não possui Docker nem Maven disponíveis para execução completa, e não há um repositório GitHub do aluno conectado. Por isso, prints de execução real do GitHub Actions e dos containers não foram fabricados. O pipeline, Dockerfile e Docker Compose estão incluídos e prontos para execução em ambiente compatível.
