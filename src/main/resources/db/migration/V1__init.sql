CREATE TABLE customer (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    data_of_birth DATE NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    cpf_cnpj VARCHAR(20) NOT NULL,
    fone VARCHAR(20) NOT NULL,
    createAt TIMESTAMP NOT NULL,
    updateAt TIMESTAMP NOT NULL
);