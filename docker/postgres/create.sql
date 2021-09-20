CREATE TABLE CLIENTE(
    nome varchar (25), 
    cpf varchar (25),
    id serial,
    PRIMARY KEY (id)
);

CREATE TABLE PRODUTO(
    descricao varchar (25), 
    preco decimal,
    id serial,
    PRIMARY KEY (id)
);