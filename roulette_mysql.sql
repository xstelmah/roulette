-- phpMyAdmin SQL Dump
-- version 4.4.13.1deb1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Апр 20 2016 г., 16:29
-- Версия сервера: 5.6.28-0ubuntu0.15.10.1
-- Версия PHP: 5.6.11-1ubuntu3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `roulette`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Admin`
--
-- Создание: Мар 31 2016 г., 20:02
--

CREATE TABLE IF NOT EXISTS `Admin` (
  `adminId` int(11) NOT NULL,
  `adminLogin` varchar(64) NOT NULL,
  `adminPassword` varchar(64) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Admin`:
--

--
-- Дамп данных таблицы `Admin`
--

INSERT INTO `Admin` (`adminId`, `adminLogin`, `adminPassword`) VALUES
(1, 'admin007', 'root');

-- --------------------------------------------------------

--
-- Структура таблицы `Balance`
--
-- Создание: Апр 01 2016 г., 09:36
--

CREATE TABLE IF NOT EXISTS `Balance` (
  `balanceId` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `balanceValue` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Balance`:
--   `userId`
--       `User` -> `userId`
--

--
-- Дамп данных таблицы `Balance`
--

INSERT INTO `Balance` (`balanceId`, `userId`, `balanceValue`) VALUES
(5, 6, 263),
(6, 7, 8);

-- --------------------------------------------------------

--
-- Структура таблицы `BalanceTransaction`
--
-- Создание: Мар 31 2016 г., 20:02
--

CREATE TABLE IF NOT EXISTS `BalanceTransaction` (
  `balanceTransactionId` int(11) NOT NULL,
  `balanceId` int(11) DEFAULT NULL,
  `balanceTransactionType` varchar(128) NOT NULL,
  `balanceTransactionValue` float NOT NULL,
  `balanceTransactionNewBalance` float DEFAULT NULL,
  `balanceTransactionDate` datetime NOT NULL,
  `balanceTransactionAdditionalInfo` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `BalanceTransaction`:
--   `balanceId`
--       `Balance` -> `balanceId`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Bet`
--
-- Создание: Мар 31 2016 г., 20:02
--

CREATE TABLE IF NOT EXISTS `Bet` (
  `betId` int(11) NOT NULL,
  `betValue` float DEFAULT NULL,
  `betRarity` varchar(64) DEFAULT 'COMMON',
  `betGameType` varchar(64) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Bet`:
--

--
-- Дамп данных таблицы `Bet`
--

INSERT INTO `Bet` (`betId`, `betValue`, `betRarity`, `betGameType`) VALUES
(1, 5, 'COMMON', 'NORMAL'),
(3, 7, 'UNCOMMON', 'NORMAL'),
(4, 12, 'RARE', 'NORMAL'),
(5, 25, 'MYTHICAL', 'NORMAL'),
(6, 0, 'COMMON', 'TEST'),
(7, 0, 'UNCOMMON', 'TEST'),
(8, 0, 'RARE', 'TEST'),
(9, 0, 'MYTHICAL', 'TEST');

-- --------------------------------------------------------

--
-- Структура таблицы `Bot`
--
-- Создание: Мар 31 2016 г., 20:02
--

CREATE TABLE IF NOT EXISTS `Bot` (
  `botId` int(11) NOT NULL,
  `botName` varchar(64) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Bot`:
--

--
-- Дамп данных таблицы `Bot`
--

INSERT INTO `Bot` (`botId`, `botName`) VALUES
(1, 'castiel'),
(2, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `Chance`
--
-- Создание: Мар 31 2016 г., 20:02
--

CREATE TABLE IF NOT EXISTS `Chance` (
  `chanceId` int(11) NOT NULL,
  `betId` int(11) DEFAULT NULL,
  `chanceValue` float DEFAULT NULL,
  `chanceRarity` varchar(64) DEFAULT 'COMMON'
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Chance`:
--   `betId`
--       `Bet` -> `betId`
--

--
-- Дамп данных таблицы `Chance`
--

INSERT INTO `Chance` (`chanceId`, `betId`, `chanceValue`, `chanceRarity`) VALUES
(1, 1, 0.45, 'COMMON'),
(2, 1, 0.25, 'UNCOMMON'),
(3, 1, 0.1, 'RARE'),
(4, 1, 0.09, 'MYTHICAL'),
(5, 1, 0.06, 'IMMORTAL'),
(6, 1, 0.04, 'LEGENDARY'),
(7, 1, 0.01, 'ARCANA'),
(8, 5, 0.6, 'MYTHICAL'),
(9, 5, 0.25, 'IMMORTAL'),
(10, 5, 0.14, 'LEGENDARY'),
(11, 5, 0.01, 'ARCANA'),
(12, 3, 0.4, 'UNCOMMON'),
(13, 3, 0.25, 'RARE'),
(14, 3, 0.15, 'MYTHICAL'),
(15, 3, 0.13, 'IMMORTAL'),
(16, 3, 0.06, 'LEGENDARY'),
(17, 3, 0.01, 'ARCANA'),
(18, 4, 0.45, 'RARE'),
(19, 4, 0.35, 'MYTHICAL'),
(20, 4, 0.13, 'IMMORTAL'),
(21, 4, 0.06, 'LEGENDARY'),
(22, 4, 0.01, 'ARCANA'),
(23, 6, 0.45, 'COMMON'),
(24, 6, 0.25, 'UNCOMMON'),
(25, 6, 0.1, 'RARE'),
(26, 6, 0.09, 'MYTHICAL'),
(27, 6, 0.06, 'IMMORTAL'),
(28, 6, 0.04, 'LEGENDARY'),
(29, 6, 0.01, 'ARCANA'),
(30, 9, 0.6, 'MYTHICAL'),
(31, 9, 0.25, 'IMMORTAL'),
(32, 9, 0.14, 'LEGENDARY'),
(33, 9, 0.01, 'ARCANA'),
(34, 7, 0.4, 'UNCOMMON'),
(35, 7, 0.25, 'RARE'),
(36, 7, 0.15, 'MYTHICAL'),
(37, 7, 0.13, 'IMMORTAL'),
(38, 7, 0.06, 'LEGENDARY'),
(39, 7, 0.01, 'ARCANA'),
(40, 8, 0.45, 'RARE'),
(41, 8, 0.35, 'MYTHICAL'),
(42, 8, 0.13, 'IMMORTAL'),
(43, 8, 0.06, 'LEGENDARY'),
(44, 8, 0.01, 'ARCANA');

-- --------------------------------------------------------

--
-- Структура таблицы `ChatMessage`
--
-- Создание: Мар 31 2016 г., 20:02
--

CREATE TABLE IF NOT EXISTS `ChatMessage` (
  `chatMessageId` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `chatMessageMessage` varchar(128) NOT NULL,
  `chatMessageDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `ChatMessage`:
--   `userId`
--       `User` -> `userId`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Game`
--
-- Создание: Мар 31 2016 г., 20:02
--

CREATE TABLE IF NOT EXISTS `Game` (
  `gameId` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `itemId` int(11) DEFAULT NULL,
  `gameNumber` int(11) DEFAULT NULL,
  `gameTime` datetime DEFAULT NULL,
  `gameDescription` varchar(128) DEFAULT NULL,
  `gameBet` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Game`:
--   `itemId`
--       `Item` -> `itemId`
--   `userId`
--       `User` -> `userId`
--

--
-- Дамп данных таблицы `Game`
--

INSERT INTO `Game` (`gameId`, `userId`, `itemId`, `gameNumber`, `gameTime`, `gameDescription`, `gameBet`) VALUES
(6, 6, 22, 6, '2016-04-08 00:00:00', 'Cowl of the Malignant Corruption', 5),
(7, 6, 76, 7, '2016-04-08 00:00:00', 'Pudgling', 25),
(8, 6, 66, 8, '2016-04-08 00:00:00', 'Mace of the Fissured Soul', 7),
(9, 6, 50, 9, '2016-04-08 00:00:00', 'Cape of the Arsenal Magus', 12),
(10, 6, 67, 10, '2016-04-08 00:00:00', 'Mace of the Fissured Soul', 25),
(11, 6, 38, 11, '2016-04-13 00:00:00', 'Ball-n-Chains of the Black Death', 7),
(12, 7, 39, 12, '2016-04-14 00:00:00', 'Ball-n-Chains of the Black Death', 5),
(13, 7, 68, 13, '2016-04-14 00:00:00', 'Seismic Berserker Armor', 12),
(14, 6, 86, 14, '2016-04-15 00:00:00', 'Genuine Hell''s Usher', 7),
(15, 6, 77, 15, '2016-04-15 00:00:00', 'Pudgling', 25),
(16, 6, 87, 16, '2016-04-15 00:00:00', 'Genuine Hell''s Usher', 12),
(17, 6, 51, 17, '2016-04-15 00:00:00', 'Cape of the Arsenal Magus', 12),
(18, 6, 52, 18, '2016-04-15 00:00:00', 'Vestments of the Ten Plagues Helm', 5),
(19, 6, 23, 19, '2016-04-15 00:00:00', 'Cowl of the Malignant Corruption', 5),
(20, 6, 69, 20, '2016-04-15 00:00:00', 'Seismic Berserker Armor', 5),
(21, 6, 24, 21, '2016-04-15 00:00:00', 'Arms of Eternal Reign', 5),
(22, 6, 25, 22, '2016-04-15 00:00:00', 'Arms of Eternal Reign', 5),
(23, 6, 106, 23, '2016-04-15 00:00:00', 'Exalted Swine of the Sunken Galley', 7),
(24, 6, 78, 24, '2016-04-15 00:00:00', 'Rampant the Scaled Hunter', 5),
(25, 6, 26, 25, '2016-04-15 00:00:00', 'Belt of the Arsenal Magus', 5),
(26, 6, 40, 26, '2016-04-15 00:00:00', 'Lost Hills Helm', 5),
(27, 6, 27, 27, '2016-04-15 00:00:00', 'Belt of the Arsenal Magus', 5),
(28, 6, 53, 28, '2016-04-15 00:00:00', 'Vestments of the Ten Plagues Helm', 5),
(29, 6, 54, 29, '2016-04-15 00:00:00', 'Wrath of the Highborn', 5),
(30, 6, 28, 30, '2016-04-15 00:00:00', 'Death Shadow Boots', 5),
(31, 6, 29, 31, '2016-04-15 00:00:00', 'Death Shadow Boots', 5),
(32, 6, 30, 32, '2016-04-15 00:00:00', 'Starlight Finery', 5),
(33, 6, 79, 33, '2016-04-15 00:00:00', 'Rampant the Scaled Hunter', 12),
(34, 6, 41, 34, '2016-04-20 00:00:00', 'Lost Hills Helm', 7);

-- --------------------------------------------------------

--
-- Структура таблицы `Item`
--
-- Создание: Апр 20 2016 г., 13:25
--

CREATE TABLE IF NOT EXISTS `Item` (
  `itemId` int(11) NOT NULL,
  `adminId` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `botId` int(11) DEFAULT NULL,
  `gameId` int(11) DEFAULT NULL,
  `itemName` varchar(128) DEFAULT NULL,
  `itemType` varchar(128) DEFAULT NULL,
  `itemRarity` varchar(64) DEFAULT 'COMMON',
  `itemImage` varchar(512) DEFAULT NULL,
  `itemStatus` varchar(64) NOT NULL DEFAULT 'CLEAR'
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Item`:
--   `adminId`
--       `Admin` -> `adminId`
--   `botId`
--       `Bot` -> `botId`
--   `gameId`
--       `Game` -> `gameId`
--   `userId`
--       `User` -> `userId`
--

--
-- Дамп данных таблицы `Item`
--

INSERT INTO `Item` (`itemId`, `adminId`, `userId`, `botId`, `gameId`, `itemName`, `itemType`, `itemRarity`, `itemImage`, `itemStatus`) VALUES
(22, 1, 6, 1, 6, 'Cowl of the Malignant Corruption', NULL, 'COMMON', 'https://cdn.dota2.net/micro_360372379_0.png', 'CLEAR'),
(23, 1, 6, 1, 19, 'Cowl of the Malignant Corruption', NULL, 'COMMON', 'https://cdn.dota2.net/micro_360372379_0.png', 'CLEAR'),
(24, 1, 6, 1, 21, 'Arms of Eternal Reign', NULL, 'COMMON', 'https://cdn.dota2.net/micro_370178928_0.png', 'CLEAR'),
(25, 1, 6, 1, 22, 'Arms of Eternal Reign', NULL, 'COMMON', 'https://cdn.dota2.net/micro_370178928_0.png', 'CLEAR'),
(26, 1, 6, 1, 25, 'Belt of the Arsenal Magus', NULL, 'COMMON', 'https://cdn.dota2.net/micro_370172384_0.png', 'CLEAR'),
(27, 1, 6, 1, 27, 'Belt of the Arsenal Magus', NULL, 'COMMON', 'https://cdn.dota2.net/micro_370172384_0.png', 'CLEAR'),
(28, 1, 6, 1, 30, 'Death Shadow Boots', NULL, 'COMMON', 'https://cdn.dota2.net/micro_259977958_0.png', 'CLEAR'),
(29, 1, 6, 1, 31, 'Death Shadow Boots', NULL, 'COMMON', 'https://cdn.dota2.net/micro_259977958_0.png', 'CLEAR'),
(30, 1, 6, 1, 32, 'Starlight Finery', NULL, 'COMMON', 'https://cdn.dota2.net/micro_179233206_0.png', 'CLEAR'),
(31, 1, NULL, 1, NULL, 'Starlight Finery', NULL, 'COMMON', 'https://cdn.dota2.net/micro_179233206_0.png', 'CLEAR'),
(32, 1, NULL, 1, NULL, 'Girdle of the Dark Wraith', NULL, 'COMMON', 'https://cdn.dota2.net/micro_190098390_0.png', 'CLEAR'),
(33, 1, NULL, 1, NULL, 'Girdle of the Dark Wraith', NULL, 'COMMON', 'https://cdn.dota2.net/micro_190098390_0.png', 'CLEAR'),
(34, 1, NULL, 1, NULL, 'Staff o'' Wicked Badness', NULL, 'COMMON', 'https://cdn.dota2.net/micro_57944755_0.png', 'CLEAR'),
(35, 1, NULL, 1, NULL, 'Staff o'' Wicked Badness', NULL, 'COMMON', 'https://cdn.dota2.net/micro_57944755_0.png', 'CLEAR'),
(36, 1, NULL, 1, NULL, 'Face of Delicacies of Butchery', NULL, 'COMMON', 'https://cdn.dota2.net/micro_340880601_0.png', 'CLEAR'),
(37, 1, NULL, 1, NULL, 'Face of Delicacies of Butchery', NULL, 'COMMON', 'https://cdn.dota2.net/micro_340880601_0.png', 'CLEAR'),
(38, 1, 6, 1, 11, 'Ball-n-Chains of the Black Death', NULL, 'UNCOMMON', 'https://cdn.dota2.net/micro_390132117_390132162.png', 'CLEAR'),
(39, 1, 7, 1, 12, 'Ball-n-Chains of the Black Death', NULL, 'UNCOMMON', 'https://cdn.dota2.net/micro_390132117_390132162.png', 'CLEAR'),
(40, 1, 6, 1, 26, 'Lost Hills Helm', NULL, 'UNCOMMON', 'https://cdn.dota2.net/micro_172567530_0.png', 'CLEAR'),
(41, 1, 6, 1, 34, 'Lost Hills Helm', NULL, 'UNCOMMON', 'https://cdn.dota2.net/micro_172567530_0.png', 'CLEAR'),
(42, 1, NULL, 1, NULL, 'Ember Pauldrons of Prosperity', NULL, 'UNCOMMON', 'https://cdn.dota2.net/micro_329905065_0.png', 'CLEAR'),
(43, 1, NULL, 1, NULL, 'Ember Pauldrons of Prosperity', NULL, 'UNCOMMON', 'https://cdn.dota2.net/micro_329905065_0.png', 'CLEAR'),
(44, 1, NULL, 1, NULL, 'Vestments of the Ten Plagues Scythe', NULL, 'UNCOMMON', 'https://cdn.dota2.net/micro_230131869_0.png', 'CLEAR'),
(45, 1, NULL, 1, NULL, 'Vestments of the Ten Plagues Scythe', NULL, 'UNCOMMON', 'https://cdn.dota2.net/micro_230131869_0.png', 'CLEAR'),
(46, 1, NULL, 1, NULL, 'Heavenly Guardian Bow', NULL, 'UNCOMMON', 'https://cdn.dota2.net/micro_370170887_0.png', 'CLEAR'),
(47, 1, NULL, 1, NULL, 'Heavenly Guardian Bow', NULL, 'UNCOMMON', 'https://cdn.dota2.net/micro_370170887_0.png', 'CLEAR'),
(48, 1, NULL, 1, NULL, 'Staff of the Demon Stone', NULL, 'UNCOMMON', 'https://cdn.dota2.net/micro_329905046_0.png', 'CLEAR'),
(49, 1, NULL, 1, NULL, 'Staff of the Demon Stone', NULL, 'UNCOMMON', 'https://cdn.dota2.net/micro_329905046_0.png', 'CLEAR'),
(50, 1, 6, 1, 9, 'Cape of the Arsenal Magus', NULL, 'RARE', 'https://cdn.dota2.net/micro_370172383_0.png', 'CLEAR'),
(51, 1, 6, 1, 17, 'Cape of the Arsenal Magus', NULL, 'RARE', 'https://cdn.dota2.net/micro_370172383_0.png', 'CLEAR'),
(52, 1, 6, 1, 18, 'Vestments of the Ten Plagues Helm', NULL, 'RARE', 'https://cdn.dota2.net/micro_230131867_0.png', 'CLEAR'),
(53, 1, 6, 1, 28, 'Vestments of the Ten Plagues Helm', NULL, 'RARE', 'https://cdn.dota2.net/micro_230131867_0.png', 'CLEAR'),
(54, 1, 6, 1, 29, 'Wrath of the Highborn', NULL, 'RARE', 'https://cdn.dota2.net/micro_217224929_0.png', 'CLEAR'),
(55, 1, NULL, 1, NULL, 'Wrath of the Highborn', NULL, 'RARE', 'https://cdn.dota2.net/micro_217224929_0.png', 'CLEAR'),
(56, 1, NULL, 1, NULL, 'Phoenix Helm of Prosperity', NULL, 'RARE', 'https://cdn.dota2.net/micro_329905057_0.png', 'CLEAR'),
(57, 1, NULL, 1, NULL, 'Phoenix Helm of Prosperity', NULL, 'RARE', 'https://cdn.dota2.net/micro_329905057_0.png', 'CLEAR'),
(58, 1, NULL, 1, NULL, 'Gift of the Awakened', NULL, 'RARE', 'https://cdn.dota2.net/micro_247762045_0.png', 'CLEAR'),
(59, 1, NULL, 1, NULL, 'Gift of the Awakened', NULL, 'RARE', 'https://cdn.dota2.net/micro_247762045_0.png', 'CLEAR'),
(60, 1, NULL, 1, NULL, 'Flags of the Equine Emissary', NULL, 'RARE', 'https://cdn.dota2.net/micro_370181839_0.png', 'CLEAR'),
(61, 1, NULL, 1, NULL, 'Flags of the Equine Emissary', NULL, 'RARE', 'https://cdn.dota2.net/micro_370181839_0.png', 'CLEAR'),
(62, 1, NULL, 1, NULL, 'Primal Form of the Tentacular Timelord', NULL, 'RARE', 'https://cdn.dota2.net/micro_284952872_560542245.png', 'CLEAR'),
(63, 1, NULL, 1, NULL, 'Primal Form of the Tentacular Timelord', NULL, 'RARE', 'https://cdn.dota2.net/micro_284952872_560542245.png', 'CLEAR'),
(64, 1, NULL, 1, NULL, 'Top Hat of the Steam Chopper', NULL, 'RARE', 'https://cdn.dota2.net/micro_644964379_0.png', 'CLEAR'),
(65, 1, NULL, 1, NULL, 'Top Hat of the Steam Chopper', NULL, 'RARE', 'https://cdn.dota2.net/micro_644964379_0.png', 'CLEAR'),
(66, 1, 6, 1, 8, 'Mace of the Fissured Soul', NULL, 'MYTHICAL', 'https://cdn.dota2.net/micro_1506968168_0.png', 'CLEAR'),
(67, 1, 6, 1, 10, 'Mace of the Fissured Soul', NULL, 'MYTHICAL', 'https://cdn.dota2.net/micro_1506968168_0.png', 'CLEAR'),
(68, 1, 7, 1, 13, 'Seismic Berserker Armor', NULL, 'MYTHICAL', 'https://cdn.dota2.net/micro_1543942943_0.png', 'CLEAR'),
(69, 1, 6, 1, 20, 'Seismic Berserker Armor', NULL, 'MYTHICAL', 'https://cdn.dota2.net/micro_1543942943_0.png', 'CLEAR'),
(70, 1, NULL, 1, NULL, 'Cog of the Mechanised Pilgrim', NULL, 'MYTHICAL', 'https://cdn.dota2.net/micro_1506976131_0.png', 'CLEAR'),
(71, 1, NULL, 1, NULL, 'Cog of the Mechanised Pilgrim', NULL, 'MYTHICAL', 'https://cdn.dota2.net/micro_1506976131_0.png', 'CLEAR'),
(72, 1, NULL, 1, NULL, 'Arc of Manta', NULL, 'MYTHICAL', 'https://cdn.dota2.net/micro_200340050_0.png', 'CLEAR'),
(73, 1, NULL, 1, NULL, 'Arc of Manta', NULL, 'MYTHICAL', 'https://cdn.dota2.net/micro_200340050_0.png', 'CLEAR'),
(74, 1, NULL, 1, NULL, 'Crescent Bow', NULL, 'MYTHICAL', 'https://cdn.dota2.net/micro_502992366_0.png', 'CLEAR'),
(75, 1, NULL, 1, NULL, 'Crescent Bow', NULL, 'MYTHICAL', 'https://cdn.dota2.net/micro_502992366_0.png', 'CLEAR'),
(76, 1, 6, 1, 7, 'Pudgling', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_519295523_519297048.png', 'CLEAR'),
(77, 1, 6, 1, 15, 'Pudgling', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_519295523_519297048.png', 'CLEAR'),
(78, 1, 6, 1, 24, 'Rampant the Scaled Hunter', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_106611028_0.png', 'CLEAR'),
(79, 1, 6, 1, 33, 'Rampant the Scaled Hunter', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_106611028_0.png', 'CLEAR'),
(80, 1, NULL, 1, NULL, 'Form of the Great Grey', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_153090671_0.png', 'CLEAR'),
(81, 1, NULL, 1, NULL, 'Form of the Great Grey', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_153090671_0.png', 'CLEAR'),
(82, 1, NULL, 1, NULL, 'Thundergod''s Bare Chest', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_1441173255_0.png', 'CLEAR'),
(83, 1, NULL, 1, NULL, 'Thundergod''s Bare Chest', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_1441173255_0.png', 'CLEAR'),
(84, 1, NULL, 1, NULL, 'Waldi the Faithful', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_190098413_0.png', 'CLEAR'),
(85, 1, NULL, 1, NULL, 'Waldi the Faithful', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_190098413_0.png', 'CLEAR'),
(86, 1, 6, 1, 14, 'Genuine Hell''s Usher', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_771156330_230145964.png', 'CLEAR'),
(87, 1, 6, 1, 16, 'Genuine Hell''s Usher', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_771156330_230145964.png', 'CLEAR'),
(88, 1, NULL, 1, NULL, 'Almond the Frondillo', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_948149724_948149725.png', 'CLEAR'),
(89, 1, NULL, 1, NULL, 'Almond the Frondillo', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_948149724_948149725.png', 'CLEAR'),
(90, 1, NULL, 1, NULL, 'Basher of Mage Skulls', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_996695916_0.png', 'CLEAR'),
(91, 1, NULL, 1, NULL, 'Basher of Mage Skulls', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_996695916_0.png', 'CLEAR'),
(92, 1, NULL, 1, NULL, 'Moonfall', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_949858603_230145964.png', 'CLEAR'),
(93, 1, NULL, 1, NULL, 'Moonfall', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_949858603_230145964.png', 'CLEAR'),
(94, 1, NULL, 1, NULL, 'Genuine Fluttering Staff', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_771156213_560543057.png', 'CLEAR'),
(95, 1, NULL, 1, NULL, 'Genuine Fluttering Staff', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_771156213_560543057.png', 'CLEAR'),
(96, 1, NULL, 1, NULL, 'Rampant Outrage', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_497881591_673752344.png', 'CLEAR'),
(97, 1, NULL, 1, NULL, 'Rampant Outrage', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_497881591_673752344.png', 'CLEAR'),
(98, 1, NULL, 1, NULL, 'Yulsaria''s Glacier', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_497876665_560542551.png', 'CLEAR'),
(99, 1, NULL, 1, NULL, 'Yulsaria''s Glacier', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_497876665_560542551.png', 'CLEAR'),
(100, 1, NULL, 1, NULL, 'Fin King''s Charm', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_497884810_230145964.png', 'CLEAR'),
(101, 1, NULL, 1, NULL, 'Fin King''s Charm', NULL, 'IMMORTAL', 'https://cdn.dota2.net/micro_497884810_230145964.png', 'CLEAR'),
(102, 1, NULL, 1, NULL, 'Na''Vi''s Weaselcrow', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_103394996_0.png', 'CLEAR'),
(103, 1, NULL, 1, NULL, 'Na''Vi''s Weaselcrow', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_103394996_0.png', 'CLEAR'),
(104, 1, NULL, 1, NULL, 'Itsy', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_155159571_57944754.png', 'CLEAR'),
(105, 1, NULL, 1, NULL, 'Itsy', NULL, 'LEGENDARY', 'https://cdn.dota2.net/micro_155159571_57944754.png', 'CLEAR'),
(106, 1, 6, 1, 23, 'Exalted Swine of the Sunken Galley', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_582727006_1622395692.png', 'CLEAR'),
(107, 1, NULL, 1, NULL, 'Exalted Swine of the Sunken Galley', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_582727006_1622395692.png', 'CLEAR'),
(108, 1, NULL, 1, NULL, 'Frost Avalanche', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_1436498557_845703177.png', 'CLEAR'),
(109, 1, NULL, 1, NULL, 'Frost Avalanche', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_1436498557_845703177.png', 'CLEAR'),
(110, 1, NULL, 1, NULL, 'Exalted Manifold Paradox', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_644965194_648738190.png', 'CLEAR'),
(111, 1, NULL, 1, NULL, 'Exalted Manifold Paradox', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_644965194_648738190.png', 'CLEAR'),
(112, 1, NULL, 1, NULL, 'Fractal Horns of Inner Abysm', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_342651391_627978944.png', 'CLEAR'),
(113, 1, NULL, 1, NULL, 'Fractal Horns of Inner Abysm', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_342651391_627978944.png', 'CLEAR'),
(114, 1, NULL, 1, NULL, 'Demon Eater', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_1424870587_1633871299.png', 'CLEAR'),
(115, 1, NULL, 1, NULL, 'Demon Eater', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_1424870587_1633871299.png', 'CLEAR'),
(116, 1, NULL, 1, NULL, 'Exalted Tempest Helm of the Thundergod', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_1441176680_1654332459.png', 'CLEAR'),
(117, 1, NULL, 1, NULL, 'Exalted Tempest Helm of the Thundergod', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_1441176680_1654332459.png', 'CLEAR'),
(118, 1, NULL, 1, NULL, 'Blades of Voth Domosh', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_253037326_750576520.png', 'CLEAR'),
(119, 1, NULL, 1, NULL, 'Blades of Voth Domosh', NULL, 'ARCANA', 'https://cdn.dota2.net/micro_253037326_750576520.png', 'CLEAR'),
(120, 1, NULL, 1, NULL, 'Sleeves of the Enthaleen Dragon', NULL, 'MYTHICAL', 'https://cdn.dota2.net/micro_1509536415_0.png', 'CLEAR'),
(121, 1, NULL, 1, NULL, 'Sleeves of the Enthaleen Dragon', NULL, 'MYTHICAL', 'https://cdn.dota2.net/micro_1509536415_0.png', 'CLEAR');

-- --------------------------------------------------------

--
-- Структура таблицы `Ticket`
--
-- Создание: Мар 31 2016 г., 20:02
--

CREATE TABLE IF NOT EXISTS `Ticket` (
  `ticketId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `adminId` int(11) DEFAULT NULL,
  `ticketNumber` int(11) DEFAULT NULL,
  `ticketDateCreation` datetime DEFAULT NULL,
  `ticketStatus` varchar(256) DEFAULT NULL,
  `ticketCategory` varchar(256) DEFAULT NULL,
  `ticketAdditionalInfo` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Ticket`:
--   `adminId`
--       `Admin` -> `adminId`
--   `userId`
--       `User` -> `userId`
--

-- --------------------------------------------------------

--
-- Структура таблицы `TicketMessage`
--
-- Создание: Мар 31 2016 г., 20:02
--

CREATE TABLE IF NOT EXISTS `TicketMessage` (
  `ticketMessageId` int(11) NOT NULL,
  `ticketId` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `adminId` int(11) DEFAULT NULL,
  `ticketMessageDate` datetime DEFAULT NULL,
  `ticketMessageMessage` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `TicketMessage`:
--   `adminId`
--       `Admin` -> `adminId`
--   `ticketId`
--       `Ticket` -> `ticketId`
--   `userId`
--       `User` -> `userId`
--

-- --------------------------------------------------------

--
-- Структура таблицы `User`
--
-- Создание: Апр 08 2016 г., 22:44
--

CREATE TABLE IF NOT EXISTS `User` (
  `userId` int(11) NOT NULL,
  `balanceId` int(11) DEFAULT NULL,
  `userSteamLogin` varchar(256) NOT NULL,
  `userChatLogin` varchar(32) DEFAULT NULL,
  `userSteamId` varchar(32) NOT NULL,
  `userAvatar` varchar(512) DEFAULT NULL,
  `userSteamTradeUrl` varchar(256) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `User`:
--   `balanceId`
--       `Balance` -> `balanceId`
--

--
-- Дамп данных таблицы `User`
--

INSERT INTO `User` (`userId`, `balanceId`, `userSteamLogin`, `userChatLogin`, `userSteamId`, `userAvatar`, `userSteamTradeUrl`) VALUES
(6, 5, 'stelmah', 'qwe345', '76561198057361692', 'http://cdn.akamai.steamstatic.com/steamcommunity/public/images/avatars/f5/f589ea32279463a9e09b0301a619fad502e15576_full.jpg', 'https://steamcommunity.com/tradeoffer/new/?partner=97095964&token=bXR-yvrd'),
(7, 6, 'Ted Tris', NULL, '76561198080138231', 'http://cdn.akamai.steamstatic.com/steamcommunity/public/images/avatars/6b/6ba940e9783ec6b486e3e92ccb4376a73abd5ad1_full.jpg', NULL);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`adminId`);

--
-- Индексы таблицы `Balance`
--
ALTER TABLE `Balance`
  ADD PRIMARY KEY (`balanceId`),
  ADD KEY `FK_UserBalance2` (`userId`);

--
-- Индексы таблицы `BalanceTransaction`
--
ALTER TABLE `BalanceTransaction`
  ADD PRIMARY KEY (`balanceTransactionId`),
  ADD KEY `FK_BalanceTransaction` (`balanceId`);

--
-- Индексы таблицы `Bet`
--
ALTER TABLE `Bet`
  ADD PRIMARY KEY (`betId`);

--
-- Индексы таблицы `Bot`
--
ALTER TABLE `Bot`
  ADD PRIMARY KEY (`botId`);

--
-- Индексы таблицы `Chance`
--
ALTER TABLE `Chance`
  ADD PRIMARY KEY (`chanceId`),
  ADD KEY `FK_BetChance` (`betId`);

--
-- Индексы таблицы `ChatMessage`
--
ALTER TABLE `ChatMessage`
  ADD PRIMARY KEY (`chatMessageId`),
  ADD KEY `FK_UserChat` (`userId`);

--
-- Индексы таблицы `Game`
--
ALTER TABLE `Game`
  ADD PRIMARY KEY (`gameId`),
  ADD KEY `FK_GameItem` (`itemId`),
  ADD KEY `FK_UserGame` (`userId`);

--
-- Индексы таблицы `Item`
--
ALTER TABLE `Item`
  ADD PRIMARY KEY (`itemId`),
  ADD KEY `FK_AdminItem` (`adminId`),
  ADD KEY `FK_BotItem` (`botId`),
  ADD KEY `FK_GameItem2` (`gameId`),
  ADD KEY `FK_UserItem` (`userId`);

--
-- Индексы таблицы `Ticket`
--
ALTER TABLE `Ticket`
  ADD PRIMARY KEY (`ticketId`),
  ADD KEY `FK_AdminTicket` (`adminId`),
  ADD KEY `FK_UserTicket` (`userId`);

--
-- Индексы таблицы `TicketMessage`
--
ALTER TABLE `TicketMessage`
  ADD PRIMARY KEY (`ticketMessageId`),
  ADD KEY `FK_AdminTicketMessage` (`adminId`),
  ADD KEY `FK_TicketTicketMessage` (`ticketId`),
  ADD KEY `FK_UserTicketMessage` (`userId`);

--
-- Индексы таблицы `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`userId`),
  ADD KEY `FK_UserBalance` (`balanceId`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `Admin`
--
ALTER TABLE `Admin`
  MODIFY `adminId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT для таблицы `Balance`
--
ALTER TABLE `Balance`
  MODIFY `balanceId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT для таблицы `BalanceTransaction`
--
ALTER TABLE `BalanceTransaction`
  MODIFY `balanceTransactionId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `Bet`
--
ALTER TABLE `Bet`
  MODIFY `betId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT для таблицы `Bot`
--
ALTER TABLE `Bot`
  MODIFY `botId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `Chance`
--
ALTER TABLE `Chance`
  MODIFY `chanceId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT для таблицы `ChatMessage`
--
ALTER TABLE `ChatMessage`
  MODIFY `chatMessageId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `Game`
--
ALTER TABLE `Game`
  MODIFY `gameId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT для таблицы `Item`
--
ALTER TABLE `Item`
  MODIFY `itemId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=122;
--
-- AUTO_INCREMENT для таблицы `Ticket`
--
ALTER TABLE `Ticket`
  MODIFY `ticketId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `TicketMessage`
--
ALTER TABLE `TicketMessage`
  MODIFY `ticketMessageId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `User`
--
ALTER TABLE `User`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `Balance`
--
ALTER TABLE `Balance`
  ADD CONSTRAINT `FK_UserBalance2` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);

--
-- Ограничения внешнего ключа таблицы `BalanceTransaction`
--
ALTER TABLE `BalanceTransaction`
  ADD CONSTRAINT `FK_BalanceTransaction` FOREIGN KEY (`balanceId`) REFERENCES `Balance` (`balanceId`);

--
-- Ограничения внешнего ключа таблицы `Chance`
--
ALTER TABLE `Chance`
  ADD CONSTRAINT `FK_BetChance` FOREIGN KEY (`betId`) REFERENCES `Bet` (`betId`);

--
-- Ограничения внешнего ключа таблицы `ChatMessage`
--
ALTER TABLE `ChatMessage`
  ADD CONSTRAINT `FK_UserChat` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);

--
-- Ограничения внешнего ключа таблицы `Game`
--
ALTER TABLE `Game`
  ADD CONSTRAINT `FK_GameItem` FOREIGN KEY (`itemId`) REFERENCES `Item` (`itemId`),
  ADD CONSTRAINT `FK_UserGame` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);

--
-- Ограничения внешнего ключа таблицы `Item`
--
ALTER TABLE `Item`
  ADD CONSTRAINT `FK_AdminItem` FOREIGN KEY (`adminId`) REFERENCES `Admin` (`adminId`),
  ADD CONSTRAINT `FK_BotItem` FOREIGN KEY (`botId`) REFERENCES `Bot` (`botId`),
  ADD CONSTRAINT `FK_GameItem2` FOREIGN KEY (`gameId`) REFERENCES `Game` (`gameId`),
  ADD CONSTRAINT `FK_UserItem` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);

--
-- Ограничения внешнего ключа таблицы `Ticket`
--
ALTER TABLE `Ticket`
  ADD CONSTRAINT `FK_AdminTicket` FOREIGN KEY (`adminId`) REFERENCES `Admin` (`adminId`),
  ADD CONSTRAINT `FK_UserTicket` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);

--
-- Ограничения внешнего ключа таблицы `TicketMessage`
--
ALTER TABLE `TicketMessage`
  ADD CONSTRAINT `FK_AdminTicketMessage` FOREIGN KEY (`adminId`) REFERENCES `Admin` (`adminId`),
  ADD CONSTRAINT `FK_TicketTicketMessage` FOREIGN KEY (`ticketId`) REFERENCES `Ticket` (`ticketId`),
  ADD CONSTRAINT `FK_UserTicketMessage` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);

--
-- Ограничения внешнего ключа таблицы `User`
--
ALTER TABLE `User`
  ADD CONSTRAINT `FK_UserBalance` FOREIGN KEY (`balanceId`) REFERENCES `Balance` (`balanceId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
