-- phpMyAdmin SQL Dump
-- version 4.4.13.1deb1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Мар 31 2016 г., 22:28
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
-- Структура таблицы `Balance`
--
-- Создание: Фев 10 2016 г., 13:24
--

CREATE TABLE IF NOT EXISTS `Balance` (
  `balanceId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `balanceValue` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Balance`:
--   `userId`
--       `User` -> `userId`
--

--
-- Дамп данных таблицы `Balance`
--

INSERT INTO `Balance` (`balanceId`, `userId`, `balanceValue`) VALUES
(1, 1, 44);

-- --------------------------------------------------------

--
-- Структура таблицы `Bet`
--
-- Создание: Фев 11 2016 г., 14:17
--

CREATE TABLE IF NOT EXISTS `Bet` (
  `betId` int(11) NOT NULL,
  `betValue` double DEFAULT NULL,
  `betRarity` varchar(64) DEFAULT 'COMMON',
  `betGameType` varchar(64) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Bet`:
--

--
-- Дамп данных таблицы `Bet`
--

INSERT INTO `Bet` (`betId`, `betValue`, `betRarity`, `betGameType`) VALUES
(1, 2, 'COMMON', 'NORMAL'),
(3, 5, 'UNCOMMON', 'NORMAL'),
(4, 12, 'RARE', 'NORMAL'),
(5, 25, 'MYTHICAL', 'NORMAL');

-- --------------------------------------------------------

--
-- Структура таблицы `Bot`
--
-- Создание: Фев 10 2016 г., 13:24
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
(1, 'bot1'),
(2, 'bot2');

-- --------------------------------------------------------

--
-- Структура таблицы `Chance`
--
-- Создание: Фев 10 2016 г., 13:24
--

CREATE TABLE IF NOT EXISTS `Chance` (
  `chanceId` int(11) NOT NULL,
  `betId` int(11) DEFAULT NULL,
  `chanceValue` double DEFAULT NULL,
  `chanceRarity` varchar(64) DEFAULT 'COMMON'
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

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
(22, 4, 0.01, 'ARCANA');

-- --------------------------------------------------------

--
-- Структура таблицы `Chat`
--
-- Создание: Фев 10 2016 г., 13:24
--

CREATE TABLE IF NOT EXISTS `Chat` (
  `chatId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Chat`:
--

-- --------------------------------------------------------

--
-- Структура таблицы `Game`
--
-- Создание: Фев 10 2016 г., 13:24
--

CREATE TABLE IF NOT EXISTS `Game` (
  `gameId` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `gameNumber` int(11) NOT NULL,
  `gameStartTime` datetime DEFAULT NULL,
  `gameDescription` varchar(128) DEFAULT NULL,
  `gameBet` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Game`:
--   `userId`
--       `User` -> `userId`
--

--
-- Дамп данных таблицы `Game`
--

INSERT INTO `Game` (`gameId`, `userId`, `gameNumber`, `gameStartTime`, `gameDescription`, `gameBet`) VALUES
(1, 1, 1, '2016-02-10 00:00:00', 'Mythical', 2),
(2, 1, 2, '2016-02-11 00:00:00', 'Common', 20),
(3, 1, 3, '2016-02-11 00:00:00', 'Immortal', 2),
(4, 1, 4, '2016-02-11 00:00:00', 'Immortal', 2),
(5, 1, 5, '2016-02-13 00:00:00', 'Mythical', 25),
(6, 1, 6, '2016-02-13 00:00:00', 'Mythical', 25),
(7, 1, 7, '2016-02-13 00:00:00', 'Mythical', 25),
(8, 1, 8, '2016-02-13 00:00:00', 'Legendary', 25),
(9, 1, 9, '2016-02-13 00:00:00', 'Rare', 12),
(10, 1, 10, '2016-02-13 00:00:00', 'Mythical', 12),
(11, 1, 11, '2016-02-13 00:00:00', 'Common', 2),
(12, 1, 12, '2016-02-13 00:00:00', 'Uncommon', 2),
(13, 1, 13, '2016-02-13 00:00:00', 'Uncommon', 2),
(14, 1, 14, '2016-02-13 00:00:00', 'Mythical', 25),
(15, 1, 15, '2016-02-13 00:00:00', 'Rare', 12),
(16, 1, 16, '2016-02-13 00:00:00', 'Immortal', 25),
(17, 1, 17, '2016-02-13 00:00:00', 'Rare', 2),
(18, 1, 18, '2016-02-13 00:00:00', 'Common', 2),
(19, 1, 19, '2016-02-16 00:00:00', 'Rare', 5),
(20, 1, 20, '2016-02-16 00:00:00', 'Mythical', 2),
(21, 1, 21, '2016-02-16 00:00:00', 'Rare', 2),
(22, 1, 22, '2016-02-16 00:00:00', 'Immortal', 2),
(23, 1, 23, '2016-02-26 00:00:00', 'Mythical', 2),
(24, 1, 24, '2016-03-19 00:00:00', 'Mythical', 2),
(25, 1, 25, '2016-03-27 00:00:00', 'Mythical', 5),
(26, 1, 26, '2016-03-27 00:00:00', 'Uncommon', 5),
(27, 1, 27, '2016-03-27 00:00:00', 'Uncommon', 5);

-- --------------------------------------------------------

--
-- Структура таблицы `Item`
--
-- Создание: Фев 10 2016 г., 13:24
--

CREATE TABLE IF NOT EXISTS `Item` (
  `itemId` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `botId` int(11) DEFAULT NULL,
  `gameId` int(11) DEFAULT NULL,
  `itemName` varchar(128) DEFAULT NULL,
  `itemType` varchar(128) DEFAULT NULL,
  `itemRarity` varchar(64) DEFAULT 'COMMON'
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `Item`:
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

INSERT INTO `Item` (`itemId`, `userId`, `botId`, `gameId`, `itemName`, `itemType`, `itemRarity`) VALUES
(1, 1, NULL, 12, 'Uncommon', 'item', 'UNCOMMON'),
(2, 1, NULL, 9, 'Rare', 'item', 'RARE'),
(3, 1, NULL, 1, 'Mythical', 'item', 'MYTHICAL'),
(4, 1, NULL, 3, 'Immortal', 'item', 'IMMORTAL'),
(5, 1, NULL, 8, 'Legendary', 'item', 'LEGENDARY'),
(6, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(7, 1, NULL, 2, 'Common', 'item', 'COMMON'),
(8, 1, NULL, 13, 'Uncommon', 'item', 'UNCOMMON'),
(9, 1, NULL, 15, 'Rare', 'item', 'RARE'),
(10, 1, NULL, 5, 'Mythical', 'item', 'MYTHICAL'),
(11, 1, NULL, 4, 'Immortal', 'item', 'IMMORTAL'),
(12, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(13, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(14, 1, NULL, 11, 'Common', 'item', 'COMMON'),
(15, 1, NULL, 26, 'Uncommon', 'item', 'UNCOMMON'),
(16, 1, NULL, 17, 'Rare', 'item', 'RARE'),
(17, 1, NULL, 6, 'Mythical', 'item', 'MYTHICAL'),
(18, 1, NULL, 16, 'Immortal', 'item', 'IMMORTAL'),
(19, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(20, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(21, 1, NULL, 18, 'Common', 'item', 'COMMON'),
(22, 1, NULL, 27, 'Uncommon', 'item', 'UNCOMMON'),
(23, 1, NULL, 19, 'Rare', 'item', 'RARE'),
(24, 1, NULL, 7, 'Mythical', 'item', 'MYTHICAL'),
(25, 1, NULL, 22, 'Immortal', 'item', 'IMMORTAL'),
(26, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(27, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(28, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(29, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(30, 1, NULL, 21, 'Rare', 'item', 'RARE'),
(31, 1, NULL, 10, 'Mythical', 'item', 'MYTHICAL'),
(32, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(33, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(34, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(35, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(36, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(37, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(38, 1, NULL, 14, 'Mythical', 'item', 'MYTHICAL'),
(39, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(40, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(41, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(42, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(43, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(44, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(45, 1, NULL, 20, 'Mythical', 'item', 'MYTHICAL'),
(46, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(47, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(48, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(49, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(50, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(51, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(52, 1, NULL, 23, 'Mythical', 'item', 'MYTHICAL'),
(53, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(54, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(55, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(56, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(57, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(58, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(59, 1, NULL, 24, 'Mythical', 'item', 'MYTHICAL'),
(60, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(61, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(62, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(63, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(64, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(65, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(66, 1, NULL, 25, 'Mythical', 'item', 'MYTHICAL'),
(67, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(68, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(69, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(70, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(71, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(72, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(73, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(74, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(75, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(76, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(77, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(78, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(79, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(80, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(81, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(82, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(83, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(84, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(85, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(86, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(87, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(88, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(89, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(90, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(91, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(92, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(93, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(94, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(95, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(96, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(97, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(98, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(99, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(100, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(101, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(102, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(103, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(104, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(105, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(106, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(107, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(108, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(109, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(110, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(111, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(112, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(113, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(114, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(115, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(116, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(117, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(118, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(119, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(120, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(121, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(122, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(123, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(124, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(125, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(126, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(127, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(128, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(129, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(130, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(131, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(132, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(133, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(134, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(135, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(136, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(137, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(138, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(139, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(140, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(141, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(142, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(143, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(144, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(145, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(146, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(147, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(148, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(149, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(150, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(151, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(152, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(153, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(154, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(155, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(156, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(157, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(158, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(159, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(160, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(161, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(162, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(163, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(164, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(165, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(166, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(167, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(168, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(169, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(170, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(171, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(172, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(173, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(174, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(175, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(176, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(177, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(178, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(179, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(180, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(181, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(182, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(183, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(184, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(185, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(186, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(187, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(188, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(189, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(190, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(191, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(192, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(193, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL'),
(194, NULL, NULL, NULL, 'Legendary', 'item', 'LEGENDARY'),
(195, NULL, NULL, NULL, 'Arcana', 'item', 'ARCANA'),
(196, NULL, NULL, NULL, 'Common', 'item', 'COMMON'),
(197, NULL, NULL, NULL, 'Uncommon', 'item', 'UNCOMMON'),
(198, NULL, NULL, NULL, 'Rare', 'item', 'RARE'),
(199, NULL, NULL, NULL, 'Mythical', 'item', 'MYTHICAL'),
(200, NULL, NULL, NULL, 'Immortal', 'item', 'IMMORTAL');

-- --------------------------------------------------------

--
-- Структура таблицы `ChatMessage`
--
-- Создание: Фев 10 2016 г., 13:24
--

CREATE TABLE IF NOT EXISTS `Message` (
  `messageId` int(11) NOT NULL,
  `chatId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `messageValue` varchar(128) NOT NULL,
  `messageDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `ChatMessage`:
--   `chatId`
--       `Chat` -> `chatId`
--   `userId`
--       `User` -> `userId`
--

-- --------------------------------------------------------

--
-- Структура таблицы `BalanceTransaction`
--
-- Создание: Фев 10 2016 г., 13:24
--

CREATE TABLE IF NOT EXISTS `Transaction` (
  `transactionId` int(11) NOT NULL,
  `balanceId` int(11) DEFAULT NULL,
  `transactionType` varchar(16) NOT NULL,
  `transactionValue` float NOT NULL,
  `transactionNewBalance` float NOT NULL,
  `transactionDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `BalanceTransaction`:
--   `balanceId`
--       `Balance` -> `balanceId`
--

-- --------------------------------------------------------

--
-- Структура таблицы `User`
--
-- Создание: Фев 10 2016 г., 13:24
--

CREATE TABLE IF NOT EXISTS `User` (
  `userId` int(11) NOT NULL,
  `balanceId` int(11) DEFAULT NULL,
  `userLogin` varchar(32) NOT NULL,
  `userPassword` varchar(64) DEFAULT NULL,
  `userMail` varchar(128) DEFAULT NULL,
  `userDateRegestration` date DEFAULT NULL,
  `userAlternativeLogin` varchar(32) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- СВЯЗИ ТАБЛИЦЫ `User`:
--   `balanceId`
--       `Balance` -> `balanceId`
--

--
-- Дамп данных таблицы `User`
--

INSERT INTO `User` (`userId`, `balanceId`, `userLogin`, `userPassword`, `userMail`, `userDateRegestration`, `userAlternativeLogin`) VALUES
(1, 1, 'q', '1', NULL, NULL, NULL),
(2, NULL, 'user', NULL, NULL, NULL, NULL);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `Balance`
--
ALTER TABLE `Balance`
  ADD PRIMARY KEY (`balanceId`),
  ADD KEY `FK_UserBalance2` (`userId`);

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
-- Индексы таблицы `Chat`
--
ALTER TABLE `Chat`
  ADD PRIMARY KEY (`chatId`);

--
-- Индексы таблицы `Game`
--
ALTER TABLE `Game`
  ADD PRIMARY KEY (`gameId`),
  ADD KEY `FK_UserGame` (`userId`);

--
-- Индексы таблицы `Item`
--
ALTER TABLE `Item`
  ADD PRIMARY KEY (`itemId`),
  ADD KEY `FK_BotItem` (`botId`),
  ADD KEY `FK_GameItem` (`gameId`),
  ADD KEY `FK_UserItem` (`userId`);

--
-- Индексы таблицы `ChatMessage`
--
ALTER TABLE `Message`
  ADD PRIMARY KEY (`messageId`),
  ADD KEY `FK_ChatMessage` (`chatId`),
  ADD KEY `FK_UserChat` (`userId`);

--
-- Индексы таблицы `BalanceTransaction`
--
ALTER TABLE `Transaction`
  ADD PRIMARY KEY (`transactionId`),
  ADD KEY `FK_BalanceTransaction` (`balanceId`);

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
-- AUTO_INCREMENT для таблицы `Balance`
--
ALTER TABLE `Balance`
  MODIFY `balanceId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT для таблицы `Bet`
--
ALTER TABLE `Bet`
  MODIFY `betId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT для таблицы `Bot`
--
ALTER TABLE `Bot`
  MODIFY `botId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `Chance`
--
ALTER TABLE `Chance`
  MODIFY `chanceId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT для таблицы `Chat`
--
ALTER TABLE `Chat`
  MODIFY `chatId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `Game`
--
ALTER TABLE `Game`
  MODIFY `gameId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT для таблицы `Item`
--
ALTER TABLE `Item`
  MODIFY `itemId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=201;
--
-- AUTO_INCREMENT для таблицы `ChatMessage`
--
ALTER TABLE `Message`
  MODIFY `messageId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `BalanceTransaction`
--
ALTER TABLE `Transaction`
  MODIFY `transactionId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `User`
--
ALTER TABLE `User`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `Balance`
--
ALTER TABLE `Balance`
  ADD CONSTRAINT `FK_UserBalance2` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);

--
-- Ограничения внешнего ключа таблицы `Chance`
--
ALTER TABLE `Chance`
  ADD CONSTRAINT `FK_BetChance` FOREIGN KEY (`betId`) REFERENCES `Bet` (`betId`);

--
-- Ограничения внешнего ключа таблицы `Game`
--
ALTER TABLE `Game`
  ADD CONSTRAINT `FK_UserGame` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);

--
-- Ограничения внешнего ключа таблицы `Item`
--
ALTER TABLE `Item`
  ADD CONSTRAINT `FK_BotItem` FOREIGN KEY (`botId`) REFERENCES `Bot` (`botId`),
  ADD CONSTRAINT `FK_GameItem` FOREIGN KEY (`gameId`) REFERENCES `Game` (`gameId`),
  ADD CONSTRAINT `FK_UserItem` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);

--
-- Ограничения внешнего ключа таблицы `ChatMessage`
--
ALTER TABLE `Message`
  ADD CONSTRAINT `FK_ChatMessage` FOREIGN KEY (`chatId`) REFERENCES `Chat` (`chatId`),
  ADD CONSTRAINT `FK_UserChat` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`);

--
-- Ограничения внешнего ключа таблицы `BalanceTransaction`
--
ALTER TABLE `Transaction`
  ADD CONSTRAINT `FK_BalanceTransaction` FOREIGN KEY (`balanceId`) REFERENCES `Balance` (`balanceId`);

--
-- Ограничения внешнего ключа таблицы `User`
--
ALTER TABLE `User`
  ADD CONSTRAINT `FK_UserBalance` FOREIGN KEY (`balanceId`) REFERENCES `Balance` (`balanceId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
