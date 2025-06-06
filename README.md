# 🌳 EcoGuard - Sistema Inteligente de Monitoramento de Queimadas

## 📋 Sobre o Projeto

EcoGuard é uma solução tecnológica inovadora desenvolvida para monitorar, prevenir e responder rapidamente a incêndios florestais, minimizando impactos ambientais e protegendo a saúde da população. O sistema integra drones inteligentes, IoT, IA e geolocalização para criar uma plataforma completa de gestão de queimadas.

### 🎯 Objetivos Principais

- Detecção rápida e precisa de focos de incêndio
- Antecipação de riscos ambientais e impactos na saúde
- Suporte inteligente para bombeiros, Defesa Civil e órgãos de saúde
- Monitoramento e proteção da fauna
- Análise preditiva baseada em dados ambientais

## 🛠 Tecnologias Utilizadas

- **Backend**: Java 17 com Spring Boot 3.5.0
- **Banco de Dados**: MySQL
- **Documentação**: Swagger/OpenAPI
- **Mapeamento**: MapStruct
- **Lombok**: Redução de boilerplate
- **Validação**: Spring Validation
- **Persistência**: Spring Data JPA

## 🚀 Como Executar o Projeto

### Pré-requisitos

- Java JDK 17
- Maven
- MySQL
- Git

### 🔧 Configuração

1. Clone o repositório:
```bash
git clone https://github.com/luyz-gusta/ForestFireAPI
cd gs-forest-fire
```

2. Configure o banco de dados no arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecoguard
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

3. Execute o projeto:
```bash
mvn spring-boot:run
```

## 📚 Documentação da API

A documentação completa da API está disponível através do Swagger UI.

### Acessando o Swagger

Após iniciar a aplicação, acesse:
```
http://localhost:8080/swagger-ui.html
```

## 🏗️ Arquitetura do Projeto

```
src/main/java/com/fiap/gs_forest_fire/
├── config/         # Configurações do Spring e Swagger
├── controllers/    # Controladores REST
├── domain/        # Entidades e DTOs
├── repositories/  # Repositórios JPA
├── service/       # Lógica de negócios
├── specs/         # Especificações de documentação
└── infra/         # Infraestrutura e configurações
```

## 🔐 Segurança

- Implementação de autenticação e autorização
- Validação de dados de entrada
- Proteção contra ataques comuns
- Logs de auditoria

## 📈 Funcionalidades dos Dashboards

- Mapa interativo com focos de incêndio
- Monitoramento de qualidade do ar
- Áreas de risco (mapa de calor)
- Localização de fauna em risco
- Dashboard para Defesa Civil e Bombeiros
- Dashboard para órgãos de saúde

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 👥 Equipe

- [Guilherme Oliveira Santana de Almeida](https://github.com/luyz-gusta/) - RM555180
- [Luiz Gustavo da Silva](https://github.com/luyz-gusta/) - RM558358
- [Vinicius Monteiro Araujo](https://github.com/luyz-gusta/) - RM555088

---

✨ **EcoGuard - Protegendo vidas, preservando o meio ambiente.** ✨ 