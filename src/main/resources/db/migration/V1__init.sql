CREATE TABLE customer (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    cpf_cnpj VARCHAR(20) NOT NULL,
    fone VARCHAR(20) NOT NULL,
    deleted BOOLEAN DEFAULT FALSE,
    create_at TIMESTAMP,
    update_at TIMESTAMP);