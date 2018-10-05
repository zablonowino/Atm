-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2017 at 05:35 AM
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atm`
--
CREATE DATABASE IF NOT EXISTS `atm` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `atm`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `AccID` int(11) NOT NULL,
  `Acc_Type` varchar(20) NOT NULL,
  `PIN` int(4) NOT NULL,
  `Deposit` varchar(20) NOT NULL DEFAULT '$0.00',
  `Withdraw` varchar(11) NOT NULL DEFAULT '$0.00',
  `Balance` varchar(20) NOT NULL DEFAULT '$0.00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`AccID`, `Acc_Type`, `PIN`, `Deposit`, `Withdraw`, `Balance`) VALUES
(1, 'Basic', 1234, '$10000', '$0.00', '$0.00'),
(2, 'Basic', 1234, '$2110', '$0.00', '$0.00');

-- --------------------------------------------------------

--
-- Table structure for table `basic`
--

CREATE TABLE `basic` (
  `acc_type` varchar(20) NOT NULL,
  `account` varchar(20) NOT NULL,
  `AccountDetails` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `basic`
--

INSERT INTO `basic` (`acc_type`, `account`, `AccountDetails`) VALUES
('Basic Account', 'basic-001', 'No Facility for an overdraft. Begins with a $5 starter saver balance'),
('Acc', 'basic-002', 'vbbvvb'),
('Saver Account', 'saver-001', 'Offers a $250 overdraft. No starting balance'),
('Super Account', 'super-001', 'Offers Variable Overdraft(determined by owner)Gives 1% bonus to all deposited cash. Cannot withdraw until after 6 months');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_list`
--

CREATE TABLE `tbl_list` (
  `Username` varchar(20) NOT NULL,
  `Firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `NatID` int(12) NOT NULL DEFAULT '0',
  `Initial_Dep` int(11) NOT NULL,
  `AccBal` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_list`
--

INSERT INTO `tbl_list` (`Username`, `Firstname`, `lastname`, `password`, `NatID`, `Initial_Dep`, `AccBal`) VALUES
('125', 'Anthony', 'k', '1235', 0, 2, NULL),
('user', 'Edgar', 'David', 'njenga', 0, 1234, NULL),
('wanjo254', 'kenned', 'mwai', '123', 0, 1, NULL),
('Zab', 'Ondari', 'Zab', '1234', 0, 249, NULL),
('Zablon', 'Ondari', 'Zab', '1234', 0, 249, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Username` varchar(20) NOT NULL,
  `PIN` varchar(4) NOT NULL,
  `fName` varchar(20) NOT NULL,
  `mName` varchar(20) NOT NULL,
  `Surname` varchar(20) NOT NULL,
  `id` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Username`, `PIN`, `fName`, `mName`, `Surname`, `id`) VALUES
('awanjoh', '1234', '', '', '', 0),
('Bannie', '1234', '', '', '', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`AccID`);

--
-- Indexes for table `basic`
--
ALTER TABLE `basic`
  ADD PRIMARY KEY (`account`);

--
-- Indexes for table `tbl_list`
--
ALTER TABLE `tbl_list`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `AccID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
