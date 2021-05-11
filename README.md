# ficticius-clean

Banco de dados:

A aplicação foi construída usando o banco em memória h2.

Execução:

$ mvn clean package

$ java -jar target/ficticius-clean-0.0.1-SNAPSHOT.jar

Swagger:

http://localhost:8080/ficticiusclean/api/v1/swagger-ui.html


# Exemplos para ultilização dos serviços:

Criação de veiculo

curl --location --request POST 'localhost:8080/ficticiusclean/api/v1/veiculos' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome": "Carro 1",
    "marca": "Ford",
    "modelo": "Fiesta",
    "dataFabricacao": "2020-05-15",
    "consumoMedioCidade": 10,
    "consumoMedioRodovia": 12
}'

Calculo de previsão

curl --location --request GET 'localhost:8080/ficticiusclean/api/v1/veiculos/previsao?precoGasolina=5.37&kmPercorridoCidade=10&kmPercorridoRodovia=20'

Lista de veículos

curl --location --request GET 'localhost:8080/ficticiusclean/api/v1/veiculos'
