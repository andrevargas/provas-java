create table prova (
    id integer auto_increment primary key,
    nome varchar(255) not null
);

create table questao (
    id integer auto_increment primary key,
    id_prova integer not null,
    enunciado text not null,
    id_alternativa_correta integer not null,
    alternativa_1 text not null,
    alternativa_2 text not null,
    alternativa_3 text not null,
    alternativa_4 text not null,
    alternativa_5 text not null
);

alter table questao add foreign key (id_prova) references prova(id);

