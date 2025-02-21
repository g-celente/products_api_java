create table produtos (
    id varchar(255) primary key not null,
    nome varchar(50) not null,
    descricao varchar(300),
    preco numeric(18,2)
);