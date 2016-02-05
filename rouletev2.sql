/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     05.12.2015 17:45:33                          */
/*==============================================================*/


drop table if exists Balance;

drop table if exists Game;

drop table if exists Transaction;

drop table if exists User;

/*==============================================================*/
/* Table: Balance                                               */
/*==============================================================*/
create table Balance
(
   balanceId            int not null,
   userId               int not null,
   balanceValue         float not null,
   primary key (balanceId)
);

/*==============================================================*/
/* Table: Game                                                  */
/*==============================================================*/
create table Game
(
   gameId               int not null,
   userId               int,
   gameNumber           int not null,
   gameStartTime        datetime not null,
   gameResult           varchar(16) not null,
   gameBet              float not null,
   primary key (gameId)
);

/*==============================================================*/
/* Table: Transaction                                           */
/*==============================================================*/
create table Transaction
(
   transactionId        int not null,
   balanceId            int,
   transactionType      varchar(16) not null,
   transactionValue     float not null,
   transactionNewBalance float not null,
   primary key (transactionId)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   userId               int not null,
   balanceId            int,
   userLogin            varchar(32) not null,
   userPassword         varchar(64) not null,
   userMail             varchar(128) not null,
   primary key (userId)
);

alter table Balance add constraint FK_UserBalance2 foreign key (userId)
      references User (userId) on delete restrict on update restrict;

alter table Game add constraint FK_UserGame foreign key (userId)
      references User (userId) on delete restrict on update restrict;

alter table Transaction add constraint FK_BalanceTransaction foreign key (balanceId)
      references Balance (balanceId) on delete restrict on update restrict;

alter table User add constraint FK_UserBalance foreign key (balanceId)
      references Balance (balanceId) on delete restrict on update restrict;

