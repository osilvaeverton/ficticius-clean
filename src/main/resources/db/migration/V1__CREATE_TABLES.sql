
CREATE TABLE veiculos (
     id BIGINT auto_increment NOT NULL,
     nome varchar(100) NOT NULL,
     marca varchar(100) NOT NULL,
     modelo varchar(100) NOT NULL,
     data_fabricacao DATE NOT NULL,
     consumo_medio_cidade DOUBLE NOT NULL,
     consumo_medio_rodovia DOUBLE NOT NULL,
     CONSTRAINT veiculos_PK PRIMARY KEY (id)
);
