
# Petstore - Test Rest-Assured 🐾

Este repositório contém um conjunto de testes automatizados para a API Petstore, desenvolvidos utilizando Java e Rest Assured. O objetivo do projeto é demonstrar boas práticas de automação de testes de APIs, garantindo a validação dos endpoints por meio de testes funcionais, contrato e end-to-end.


## 📌 Tecnologias Utilizadas

* **Java** 17+
* **Rest Assured** para automação de testes de API
* **JUnit 5** para estruturação e execução dos testes
* **Maven** para gerenciamento de dependências
* **Allure Report** para geração de relatórios de execução


## 🚀 Rodando os testes

Clone o repositório:
```bash
git clone https://github.com/wesleysoares/petstore-restassured-test.git
```
Acesse o diretório do projeto:
```bash
cd petstore-restassured-test
```
Execute todos os testes via Maven:
```bash
mvn clean test
```
Para visualizar o relatório de execução (Allure):
```bash
mvn allure:serve target/surefire-reports
```

**Executando por tags (suites)**

| tag                    | comando                          |
|------------------------|----------------------------------|
| testes funcionais      | `mvn test -Dgroups="functional"` |
| testes de contrato     | `mvn test -Dgroups="contract"`   |
| testes e2e             | `mvn test -Dgroups="e2e"`        |
| testes das APIs "Pet"  | `mvn test -Dgroups="pet"`        |
| testes das APIs "Order"| `mvn test -Dgroups="order"`      |



## ⚙️ Pipeline - GitHub Actions

Os testes automatizados são executados automaticamente a cada push ou pull request, garantindo a qualidade contínua do projeto. O workflow do GitHub Actions está configurado para:

* Instalar dependências do projeto
* Executar os testes utilizando Maven
* Gerar e armazenar relatórios de execução
* Apresentar o relatório da execução (via Allure Report)

Exemplo de um dos relatórios gerados:
https://wesleysoares.github.io/petstore-restassured-test/31/index.html

Para visualizar os demais workflows, acesse Actions no repositório do GitHub.

## 🏗️ Estrutura do projeto

**src/main/java/client** → Essas classes são utilizadas para fazer requisições nos testes e2e

**src/main/java/factory** → Classes responsáveis pela criação dos dados necessários para os testes. Para isso, utiliza o JavaFaker, uma biblioteca que gera dados fictícios de forma aleatória, permitindo a simulação realista de diferentes cenários de teste.

**src/main/java/model** → Classes utilizadas para mapear objetos

**src/main/java/utils** → Classes responsáveis por padronizar os parâmetros das requisições e as tags utilizadas nas suítes de testes

**src/main/test/e2e** → Testes e2e

**src/main/test/pet** → Testes funcionais e de contrato do serviço /pet

**src/main/test/store** → Testes funcionais e de contrato do serviço /store

**src/main/test/resources/schemas** → Esquemas utilizados na validação dos testes de contrato

## 🧪 Cenários de testes

**/v2/pet - Testes funcionais**

✔️ `[POST] - status code 200`: Cadastrar novo PET

✔️ `[GET] - Status code 200`: Consultar PET cadastrado

✔️ `[GET] - Status code 404`: Validação do comportamento ao buscar PET não cadastrado

✔️ `[DELETE] - Status code 200`: Deletar PET cadastrado

✔️ `[DELETE] - Status code 404`: Validação do comportamento ao tentar deletar PET não cadastrado

**/v2/pet - Testes de contrato**

✔️ `[POST] - status code 200`: Cadastrar novo PET - Testes de contrato utilizando JSON Schema

✔️ `[GET] - status code 200`: Consultar PET cadastrado - Testes de contrato utilizando JSON Schema

**/v2/store/order - Testes de contrato**

✔️ `[POST] - status code 200`: Gerar novo Pedido - Testes de contrato utilizando JSON Schema

**/v2/store/order - Testes e2e**

Gerar um novo pedido utilizando o cadastro prévio de PET, dado necessário para a criação do pedido

Endpoints validados:

✔️ `[POST] - status code 200`: Cadastrar novo PET

✔️ `[POST] - status code 200`: Gerar novo Pedido

