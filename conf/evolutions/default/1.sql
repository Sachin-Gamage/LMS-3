# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table author (
  isbn                          integer auto_increment not null,
  name                          varchar(255),
  constraint pk_author primary key (isbn)
);

create table author_books (
  author_isbn                   integer not null,
  books_isbn                    varchar(255) not null,
  constraint pk_author_books primary key (author_isbn,books_isbn)
);

create table books (
  isbn                          varchar(255) not null,
  title                         varchar(255),
  sector                        varchar(255),
  publicationdate               varchar(255),
  borroweddate                  varchar(255),
  borrowedtime                  varchar(255),
  publisher                     varchar(255),
  totalnumberofpages            integer not null,
  currentreader                 integer not null,
  author                        varchar(255),
  constraint pk_books primary key (isbn)
);

create table dvds (
  isbn                          varchar(255) not null,
  title                         varchar(255),
  sector                        varchar(255),
  publicationdate               varchar(255),
  borroweddate                  varchar(255),
  borrowedtime                  varchar(255),
  languages                     varchar(255),
  subtitles                     varchar(255),
  producer                      varchar(255),
  actors                        varchar(255),
  currentreader                 integer not null,
  constraint pk_dvds primary key (isbn)
);

create table currentreader (
  id                            integer auto_increment not null,
  name                          varchar(255),
  mobilenumber                  varchar(255),
  email                         varchar(255),
  constraint pk_currentreader primary key (id)
);

alter table author_books add constraint fk_author_books_author foreign key (author_isbn) references author (isbn) on delete restrict on update restrict;
create index ix_author_books_author on author_books (author_isbn);

alter table author_books add constraint fk_author_books_books foreign key (books_isbn) references books (isbn) on delete restrict on update restrict;
create index ix_author_books_books on author_books (books_isbn);


# --- !Downs

alter table author_books drop foreign key fk_author_books_author;
drop index ix_author_books_author on author_books;

alter table author_books drop foreign key fk_author_books_books;
drop index ix_author_books_books on author_books;

drop table if exists author;

drop table if exists author_books;

drop table if exists books;

drop table if exists dvds;

drop table if exists currentreader;

