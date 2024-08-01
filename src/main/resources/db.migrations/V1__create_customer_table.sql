CREATE TABLE customer (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    data_of_birth DATE NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    cpf_cnpj VARCHAR(20) NOT NULL UNIQUE CHECK (cpf_cnpj ~ '^[0-9A-Za-z]{11,14}$'),
    fone VARCHAR(20) NOT NULL
);