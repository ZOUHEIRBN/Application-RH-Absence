-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2022 at 08:40 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rh_pepsi`
--

-- --------------------------------------------------------

--
-- Table structure for table `absences`
--

CREATE TABLE `absences` (
  `id` bigint(20) NOT NULL,
  `matinor_apres_mididj` varchar(255) DEFAULT NULL,
  `matinor_apres_midipj` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `date_dernierj` datetime DEFAULT NULL,
  `date_premierj` datetime DEFAULT NULL,
  `date_retour` datetime DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  `nombrej` float NOT NULL,
  `responsable` varchar(255) DEFAULT NULL,
  `type_abs` varchar(255) DEFAULT NULL,
  `collaborateur_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `absences`
--

INSERT INTO `absences` (`id`, `matinor_apres_mididj`, `matinor_apres_midipj`, `commentaire`, `created_date`, `date_dernierj`, `date_premierj`, `date_retour`, `file`, `nombrej`, `responsable`, `type_abs`, `collaborateur_id`) VALUES
(3, NULL, NULL, 'okokokokokokokc', '2022-07-01 17:00:00', '2022-06-29 17:00:00', '2022-06-25 08:00:00', '2022-07-01 17:00:00', NULL, 4, 'user RH', 'Absence_Preavis', 2),
(4, NULL, NULL, 'okokokokokokokc', '2022-07-01 17:00:00', '2022-06-29 17:00:00', '2022-06-25 08:00:00', '2022-07-01 17:00:00', NULL, 4, 'user RH', 'Absence_Preavis', 2);

-- --------------------------------------------------------

--
-- Table structure for table `collaborateur`
--

CREATE TABLE `collaborateur` (
  `collaborateur_type` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `adresse` varchar(60) DEFAULT NULL,
  `cin` varchar(10) DEFAULT NULL,
  `date_borth` date DEFAULT NULL,
  `date_recrut` date DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `ncnss` varchar(10) DEFAULT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `sexe` varchar(6) DEFAULT NULL,
  `situation` varchar(11) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `collaborateur`
--

INSERT INTO `collaborateur` (`collaborateur_type`, `id`, `adresse`, `cin`, `date_borth`, `date_recrut`, `email`, `ncnss`, `nom`, `prenom`, `sexe`, `situation`, `tel`) VALUES
('Collaborateur', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('Collaborateur', 2, 'Tite melile', 'BH56667', '1999-08-17', '2020-06-15', 'mouaddamhi@gmail.com', 'LB234', 'damahi', 'mouad', 'Male', 'Celibataire', '+212694533546');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absences`
--
ALTER TABLE `absences`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKotmltc5hgpwm2yhne12ypqick` (`collaborateur_id`);

--
-- Indexes for table `collaborateur`
--
ALTER TABLE `collaborateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_2f8dwr0w9j37nio9xk0b4p1bg` (`cin`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absences`
--
ALTER TABLE `absences`
  ADD CONSTRAINT `FKotmltc5hgpwm2yhne12ypqick` FOREIGN KEY (`collaborateur_id`) REFERENCES `collaborateur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
