create database biblioteca_informatica;

use biblioteca_informática;

create table autor(
    idautor char(8) not null,
    nombre varchar(40) not null,
    primary key(idautor)
);

create table libro(
   idlibro char(10) not null,
   titulo varchar(80) not null,
   isbn char(13) not null,
   editorial varchar(30) not null,
   paginas int not null,
   primary key(idlibro) 
);

create table autor_libro(
    idautor char(8) not null,
    idlibro char(10) not null,
    primary key(idautor,idlibro),
    foreign key(idautor) references autor(idautor),
    foreign key(idlibro) references libro(idlibro)
);

create table ejemplar(
   idejemplar char(10) not null,
   localizacion varchar(50) not null,
   idlibro char(10) not null,
   primary key(idejemplar),
   foreign key(idlibro) references libro(idlibro)
);

create table usuario(
    idusuario char(8) not null,
    nombre varchar(60) not null,
    telefono varchar(20) not null,
    direccion varchar(80) not null,
    primary key(idusuario)
);

create table usuario_ejemplar(
    idusuario char(8) not null,
    idejemplar char(10) not null,
    fechaprestamo datetime not null,
    fechadevolucion datetime not null,
    primary key(idusuario,idejemplar),
    foreign key(idusuario) references usuario(idusuario),
    foreign key (idejemplar) references ejemplar(idejemplar)
);
