create database tgbiblioteca;
use tgbiblioteca;
create table aluno(
id int(7) primary key auto_increment,
nome varchar(70) not null,
rg varchar(9) not null,
ra varchar(11) not null,
email varchar(56),
telefone varchar(11),
curso varchar(50),
semestre int(2),
periodo int(1)
);

create table livro(
id int(7) primary key auto_increment,
titulo varchar(70) not null,
autor varchar(70) not null,
editora varchar(70) not null,
quantidade int(2) not null,
edicao int(2)
);
create table emprestimo(
id int(7) primary key auto_increment,
aluno int(7),
livro1 int(7),
livro2 int(7),
pendentes int(1),
dataRealizacao varchar(8),
dataDevolucao varchar(8) not null,
multa int(2) default 0,
dataPagamento varchar(8) default '',
foreign key (livro1) references livro(id) on delete cascade,
foreign key (livro2) references livro(id) on delete cascade,
foreign key (aluno) references aluno(id) on delete cascade
);
create table reserva(
id int(7) primary key auto_increment,
aluno int(7),
livro1 int(7),
livro2 int(7),
dataRealizacao varchar(8) not null,
dataDevolucao varchar(8),
foreign key (livro1) references livro(id) on delete cascade,
foreign key (livro2) references livro(id) on delete cascade,
foreign key (aluno) references aluno(id) on delete cascade
);

create table professor(
id int(7)primary key auto_increment,
nome varchar(70)
);
create table livrosprofessor(
id int(7) primary key auto_increment,
idprofessor int(7),
idlivro int(7),
dataRealizacao varchar(8),
devolvido boolean default false,
foreign key (idprofessor) references professor(id) on delete cascade,
foreign key (idlivro) references livro(id) on delete cascade
);


alter table emprestimo modify column aluno int(7);
alter table emprestimo modify column livro1 int(7);
alter table emprestimo modify column livro2 int(7);
alter table reserva modify column aluno int(7);
alter table reserva modify column livro1 int(7);
alter table reserva modify column livro2 int(7);
alter table reserva add column vencida int(1) default 0;
alter table livro modify column titulo varchar(400);
alter table livro modify column autor varchar(200);
alter table livrosprofessor add column dataDevolucao varchar(8) default '';
update livrosprofessor set dataDevolucao='06112017' where devolvido=true;
alter table livrosprofessor drop column devolvido;
##select a.nome, c.liv1,c.liv2,c.dr,c.dd from aluno a right join 
##(select c.ida as idaluno,c.til1 as liv1, l.titulo as liv2,c.rea as dr,c.dev as dd from livro l right join 
##(select e.aluno as ida,l.titulo as til1 ,e.livro2 as id2,e.dataRealizacao as rea,e.dataDevolucao as dev from livro l inner join emprestimo e where e.livro1=l.id and e.dataRealizacao like '01%')
## as c on l.id=id2)
##as c on c.idaluno=a.id;


#select l.titulo as titulo,e.dataRealizacao as dr from livro l inner join livrosprofessor e on e.idlivro=l.id  and e.idprofessor=2;