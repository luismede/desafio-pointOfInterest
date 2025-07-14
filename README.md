# 📡 Point of Interest - Desafio Backend
Projeto realizado como parte de aprendizado de Spring Boot e JPA

## Sobre o Desafio
O desafio consiste em implementar uma API REST para cadastro e consulta de "Pontos de Interesse" (POIs – Points of Interest), onde cada ponto é representado por:

- `name`: nome do ponto (Ex: “Lanchonete”)
- `coordX`: coordenada X (inteiro não negativo)
- `coordY`: coordenada Y (inteiro não negativo)

**A API deve permitir:**

- Cadastrar novos pontos.
- Listar todos os pontos cadastrados.
- Buscar pontos próximos a uma coordenada específica, dentro de uma distância máxima.

## O que utilizei para realizar esse desafio?
```java
String[] tecnologias = {
    "Java 21",
    "Spring Boot",
    "Spring Data JPA",
    "Maven",
    "H2 Database (in-memory)",
    "Swagger UI"
};
```

## Funcionalidades da API
### **1. Cadastrar pontos de interesse (POI)**

**POST** `/points/create`

Exemplo de JSON enviado
```json
{
  "name": "Casa",
  "coordX": 13,
  "coordY": 21
}
```

**Retorno:** Status `201 Created` com o objeto cadastrado

### **2. Listar todos os Pontos de Interesse**

**GET** `/points`

**Retorno:**
```json
[
  {
    "name": "Lanchonete",
    "coordX": 27,
    "coordY": 12
  }
  ...
]
```

### **3. Buscar Pontos Próximos**

**GET** `/points/nearby?max_distance=10&position_x=20&position_y=10`

- `position_x`: posição X de referência
- `position_y`: posição Y de referência
- `max_distance`: distância máxima

**Retorno:**

Lista de pontos que estão dentro da distância ≤ `max_distance` em relação ao ponto (x, y).

#### Fórmula utilizada para localizar os pontos próximos:
$$
d = \sqrt{(x_1 - x_2)^2 + (y_1 - y_2)^2}
$$

## Teste e Banco H2
Durante o desenvolvimento, foi utilizado o banco H2 em memória com dados inseridos automaticamente via `CommandLineRunner`.
**Você pode acessar o console do H2 em:**
`http://localhost:3000/h2-console`

### Credenciais
- JDBC URL: `jdbc:h2:mem:db_xy`
- Username: `sa`
- Password: `(vazio)`

## Executando o Projeto
### Pré-Requisitos
- JDK 17+
- Maven
  
### Rodar localmente
```bash
git clone https://github.com/luismede/point-of-interest.git
cd point-of-interest
mvn spring-boot:run
```
A aplicação estará em: `http://localhost:3000/swagger-ui/index.html#`

---

## 🔗 Links Úteis
- [Desafio original no GitHub](https://github.com/backend-br/desafios/tree/master/points-of-interest)
- [Desafios Backend](https://github.com/backend-br/desafios/tree/master)
