API de Cadastro de Clientes com Padrões de Projeto

Este projeto é uma API REST para cadastro de clientes, desenvolvida com Spring Boot. O seu principal objetivo é demonstrar a aplicação prática de Padrões de Projeto (Design Patterns), como Strategy, Facade e Singleton, em um cenário real.A API gerencia clientes e seus respectivos endereços, com uma funcionalidade interessante: ao cadastrar um cliente com um CEP, o sistema consome a API externa do ViaCEP para preencher e salvar automaticamente os dados do endereço.

Funcionalidades

CRUD completo para a entidade Cliente.
•Integração com a API ViaCEP para busca automática de endereços.
•Persistência de dados em banco de dados relacional.
•Documentação da API gerada automaticamente com Swagger (OpenAPI).

🛠️ Tecnologias Utilizadas
•Java 17
•Spring Boot
•Spring Data JPA
•Spring Web
•Spring Cloud OpenFeign (para consumo da API externa)
•H2 Database (banco de dados em memória)
•Maven (gerenciador de dependências)
•Springdoc OpenAPI (Swagger) (para documentação da API)

Padrões de Projeto Aplicado

•Strategy: A camada de serviço (ClienteService) é desacoplada de sua implementação (ClienteServiceImpl), permitindo a troca de estratégias de negócio sem impactar o controller.
•Facade: O ClienteService atua como uma fachada, simplificando a interação do controller com a complexidade de múltiplos repositórios e serviços externos.
•Singleton: Os componentes do Spring (@Service, @Repository) são gerenciados como Singletons por padrão, garantindo uma única instância por toda a aplicação.
