/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     31.03.2016 23:00:42                          */
/*==============================================================*/


drop table if exists Admin;

drop table if exists Balance;

drop table if exists BalanceTransaction;

drop table if exists Bet;

drop table if exists Bot;

drop table if exists Chance;

drop table if exists ChatMessage;

drop table if exists Game;

drop table if exists Item;

drop table if exists Ticket;

drop table if exists TicketMessage;

drop table if exists User;

/*==============================================================*/
/* Table: Admin                                                 */
/*==============================================================*/
create table Admin
(
   adminId              int not null auto_increment,
   adminLogin           varchar(64) not null,
   adminPassword        varchar(64) not null,
   primary key (adminId)
);

/*==============================================================*/
/* Table: Balance                                               */
/*==============================================================*/
create table Balance
(
   balanceId            int not null auto_increment,
   userId               int not null,
   balanceValue         float not null,
   primary key (balanceId)
);

/*==============================================================*/
/* Table: BalanceTransaction                                    */
/*==============================================================*/
create table BalanceTransaction
(
   balanceTransactionId int not null auto_increment,
   balanceId            int,
   balanceTransactionType varchar(128) not null,
   balanceTransactionValue float not null,
   balanceTransactionNewBalance float,
   balanceTransactionDate datetime not null,
   balanceTransactionAdditionalInfo varchar(256),
   primary key (balanceTransactionId)
);

/*==============================================================*/
/* Table: Bet                                                   */
/*==============================================================*/
create table Bet
(
   betId                int not null auto_increment,
   betValue             float,
   betRarity            varchar(64) default 'COMMON',
   betGameType          varchar(64),
   primary key (betId)
);

/*==============================================================*/
/* Table: Bot                                                   */
/*==============================================================*/
create table Bot
(
   botId                int not null auto_increment,
   botName              varchar(64),
   primary key (botId)
);

/*==============================================================*/
/* Table: Chance                                                */
/*==============================================================*/
create table Chance
(
   chanceId             int not null auto_increment,
   betId                int,
   chanceValue          float,
   chanceRarity         varchar(64) default 'COMMON',
   primary key (chanceId)
);

/*==============================================================*/
/* Table: ChatMessage                                           */
/*==============================================================*/
create table ChatMessage
(
   chatMessageId        int not null auto_increment,
   userId               int,
   chatMessageMessage   varchar(128) not null,
   chatMessageDate      datetime,
   primary key (chatMessageId)
);

/*==============================================================*/
/* Table: Game                                                  */
/*==============================================================*/
create table Game
(
   gameId               int not null auto_increment,
   userId               int,
   itemId               int,
   gameNumber           int,
   gameTime             datetime,
   gameDescription      varchar(128),
   gameBet              float not null,
   primary key (gameId)
);

/*==============================================================*/
/* Table: Item                                                  */
/*==============================================================*/
create table Item
(
   itemId               int not null auto_increment,
   adminId              int not null,
   userId               int,
   botId                int,
   gameId               int,
   itemName             varchar(128),
   itemType             varchar(128),
   itemRarity           varchar(64) default 'COMMON',
   primary key (itemId)
);

/*==============================================================*/
/* Table: Ticket                                                */
/*==============================================================*/
create table Ticket
(
   ticketId             int not null auto_increment,
   userId               int not null,
   adminId              int,
   ticketNumber         int,
   ticketDateCreation   datetime,
   ticketStatus         varchar(256),
   ticketCategory       varchar(256),
   ticketAdditionalInfo varchar(256),
   primary key (ticketId)
);

/*==============================================================*/
/* Table: TicketMessage                                         */
/*==============================================================*/
create table TicketMessage
(
   ticketMessageId      int not null auto_increment,
   ticketId             int not null,
   userId               int,
   adminId              int,
   ticketMessageDate    datetime,
   ticketMessageMessage varchar(256) not null,
   primary key (ticketMessageId)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   userId               int not null auto_increment,
   balanceId            int,
   userSteamLogin       varchar(256) not null,
   userChatLogin        varchar(32),
   userSteamId          varchar(32) not null,
   primary key (userId)
);

alter table Balance add constraint FK_UserBalance2 foreign key (userId)
      references User (userId) on delete restrict on update restrict;

alter table BalanceTransaction add constraint FK_BalanceTransaction foreign key (balanceId)
      references Balance (balanceId) on delete restrict on update restrict;

alter table Chance add constraint FK_BetChance foreign key (betId)
      references Bet (betId) on delete restrict on update restrict;

alter table ChatMessage add constraint FK_UserChat foreign key (userId)
      references User (userId) on delete restrict on update restrict;

alter table Game add constraint FK_GameItem foreign key (itemId)
      references Item (itemId) on delete restrict on update restrict;

alter table Game add constraint FK_UserGame foreign key (userId)
      references User (userId) on delete restrict on update restrict;

alter table Item add constraint FK_AdminItem foreign key (adminId)
      references Admin (adminId) on delete restrict on update restrict;

alter table Item add constraint FK_BotItem foreign key (botId)
      references Bot (botId) on delete restrict on update restrict;

alter table Item add constraint FK_GameItem2 foreign key (gameId)
      references Game (gameId) on delete restrict on update restrict;

alter table Item add constraint FK_UserItem foreign key (userId)
      references User (userId) on delete restrict on update restrict;

alter table Ticket add constraint FK_AdminTicket foreign key (adminId)
      references Admin (adminId) on delete restrict on update restrict;

alter table Ticket add constraint FK_UserTicket foreign key (userId)
      references User (userId) on delete restrict on update restrict;

alter table TicketMessage add constraint FK_AdminTicketMessage foreign key (adminId)
      references Admin (adminId) on delete restrict on update restrict;

alter table TicketMessage add constraint FK_TicketTicketMessage foreign key (ticketId)
      references Ticket (ticketId) on delete restrict on update restrict;

alter table TicketMessage add constraint FK_UserTicketMessage foreign key (userId)
      references User (userId) on delete restrict on update restrict;

alter table User add constraint FK_UserBalance foreign key (balanceId)
      references Balance (balanceId) on delete restrict on update restrict;

