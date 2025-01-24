-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 17 jan. 2025 à 15:30
-- Version du serveur : 8.2.0
-- Version de PHP : 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tp8-javafinal-moviedb`
--

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

DROP TABLE IF EXISTS `genre`;
CREATE TABLE IF NOT EXISTS `genre` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `genre` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `genre`
--

INSERT INTO `genre` (`id`, `genre`) VALUES
(1, 'Action'),
(2, 'Horror'),
(3, 'Mystery'),
(4, 'Romance'),
(5, 'Adventure'),
(6, 'Comedy'),
(7, 'Animation'),
(8, 'Thriller'),
(9, 'Crime'),
(10, 'Fantasy'),
(11, 'Sci-Fi'),
(12, 'Drama');

-- --------------------------------------------------------

--
-- Structure de la table `movie`
--

DROP TABLE IF EXISTS `movie`;
CREATE TABLE IF NOT EXISTS `movie` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cast` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `director` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `length` int NOT NULL,
  `poster` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `releasedate` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `revenue` double NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `panoramic_poster` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `movie`
--

INSERT INTO `movie` (`id`, `cast`, `description`, `director`, `length`, `poster`, `releasedate`, `revenue`, `title`, `panoramic_poster`) VALUES
(1, 'Amy Adams, Jake Gyllenhaal, Michael Shannon, Aaron Taylor-Johnson, Isla Fisher', 'A wealthy art gallery owner is haunted by her ex-husband\'s novel, a violent thriller she interprets as a symbolic revenge tale.', 'Tom Ford', 116, '/images/test.jpg', 'January 04 2017', 30311857, 'Nocturnal Animals', '/images/noctMorn2.jpg'),
(2, 'Al Pacino, Chris O\'Donnell, James Rebhorn, Gabrielle Anwar, Philip Seymour Hoffman', 'A prep school student needing money agrees to \"babysit\" a blind man, but the job is not at all what he anticipated.', ' Martin Brest', 156, '/images/scentOfWoman.jpg', ' January 8 1993', 134095253, 'Scent of a woman', '/images/scentOfWoman2.jpg'),
(3, 'Timothée Chalamet, Rebecca Ferguson, Dave Bautista, Stellan Skarsgård, Charlotte Rampling', 'A noble family becomes embroiled in a war for control over the galaxy\'s most valuable asset while its heir becomes troubled by visions of a dark future.', ' Denis Villeneuve', 155, '/images/dune-p1102585.jpg', 'October 22 2021', 407573628, 'Dune', '/images/dune2.avif'),
(4, 'Tom Cruise, Nicole Kidman, Madison Eginton, Jackie Sawiris, Sydney Pollack', 'A Manhattan doctor embarks on a bizarre, night-long odyssey after his wife\'s admission of unfulfilled longing.', 'Stanley Kubrick', 159, '/images/eyesWideShut.jpg', 'July 16,1999 ', 162260377, 'Eyes wide shut', '/images/eyesWideShut2.jpg'),
(5, 'Seth MacFarlane, Charlize Theron, Liam Neeson, Amanda Seyfried, Neil Patrick Harris', 'As a cowardly farmer begins to fall for the mysterious new woman in town, he must put his newly found courage to the test when her husband, a notorious gun-slinger, announces his arrival', ' Seth MacFarlane', 116, '/images/millionWays.jpg', 'May 30 2014 ', 87189756, 'A Million ways to die in the west', '/images/millionWays2.webp'),
(6, 'Jackie Chan, Chris Tucker, Ken Leung, Tom Wilkinson, Tzi Ma', 'A loyal and dedicated Hong Kong Inspector teams up with a reckless and loudmouthed L.A.P.D. detective to rescue the Chinese Consul\'s kidnapped daughter, while trying to arrest a dangerous crime lord along the way.', ' Brett Ratner', 98, '/images/rushHour.webp', 'September 9 1998', 244721064, 'Rush Hour 2', '/images/rushHour2.jpg'),
(7, 'Rumi Hiiragi, Miyu Irino, Mari Natsuki, Bunta Sugawara, Yumi Tamai', 'During her family\'s move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches and spirits, and where humans are changed into beasts.', ' Hayao Miyazaki', 125, '/images/spiritedAway.jpg', ' March 28 2003 ', 357561772, 'Spirited Away', '/images/spiritedAway2.jpg'),
(8, 'Bradley Cooper, Ed Helms, Zach Galifianakis, Justin Bartha, Ken Jeong', 'When one of their own is kidnapped by an angry gangster, the Wolf Pack must track down Mr. Chow, who has escaped from prison and is on the run.', 'Todd Phillips', 100, '/images/hoIII.jpg', 'May 23 2013', 362000072, 'The Hangover Part III', '/images/hoIII2.jpg'),
(9, 'Bradley Cooper, Ed Helms, Zach Galifianakis, Justin Bartha, Ken Jeong', 'Two years after the bachelor party in Las Vegas, Phil, Stu, Alan, and Doug jet to Thailand for Stu\'s wedding. Stu\'s plan for a subdued pre-wedding brunch, however, goes seriously awry.', 'Todd Phillips', 102, '/images/hoII.jpg', 'May 26 2011', 586764305, 'The Hangover Part II', '/images/hoII2.jpg'),
(12, ' Marlon Brando, Al Pacino, James Caan', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son', 'Francis Ford Coppola', 175, '/images/theGodFather.jpg', '1972', 190000000, 'The Godfather', '/images/theGodFather2.jpg'),
(15, 'Jonathan Nolan, Christopher Nolan, David S. Goyer', 'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.', 'Christopher Nolan', 152, '/images/TheDarkNight.jpeg', '2008', 200000000, 'The Dark Knight', '/images/theDarkNight2.jpeg'),
(33, 'christian bale', 'overRated movie', 'chris nolan', 300, '/images/p10543523_p_v8_as.jpg', 'may 03 2008', 325, 'Interstellar', '/images/interstellar.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `movie-genre`
--

DROP TABLE IF EXISTS `movie-genre`;
CREATE TABLE IF NOT EXISTS `movie-genre` (
  `movie_id` bigint NOT NULL,
  `genre_id` bigint NOT NULL,
  KEY `FKi8e8jjgtqeklgl7r5qo3p5jhy` (`genre_id`),
  KEY `FKlb3jfe1rc30dfr56ulnk0233s` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `movie-genre`
--

INSERT INTO `movie-genre` (`movie_id`, `genre_id`) VALUES
(1, 3),
(1, 8),
(1, 9),
(3, 1),
(3, 5),
(3, 11),
(4, 3),
(4, 4),
(4, 8),
(4, 12),
(5, 1),
(5, 5),
(5, 6),
(6, 1),
(6, 6),
(7, 5),
(7, 7),
(7, 10),
(7, 12),
(8, 1),
(8, 6),
(8, 9),
(9, 1),
(9, 6),
(9, 9),
(12, 9),
(12, 12),
(15, 1),
(15, 9),
(15, 12),
(33, 1),
(33, 3),
(33, 4);

-- --------------------------------------------------------

--
-- Structure de la table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `movie_1_id` bigint DEFAULT NULL,
  `movie_2_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK282q7imjgug93crnadkin1e3n` (`movie_1_id`),
  KEY `FKnnmquso3vp1ipc088sq4e1jvh` (`movie_2_id`),
  KEY `FK7ky67sgi7k0ayf22652f7763r` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `post`
--

INSERT INTO `post` (`id`, `comment`, `movie_1_id`, `movie_2_id`, `user_id`) VALUES
(1, 'Both are excellent, but it depends on your mood!\r\nGo for Nocturnal Animals if you want a visually striking and emotionally intense thriller.\r\nChoose Eyes Wide Shut if you’re in the mood for a slow, deep dive into human psychology and desire.', 1, 4, 1),
(2, 'Hey everyone! If you’re a fan of Rush Hour and its hilarious buddy-cop antics, I’ve got a great recommendation for you: The Hangover.\r\nWhy you’ll love it:\r\nNon-stop laughs: Just like Rush Hour, The Hangover is packed with laugh-out-loud moments.\r\nCrazy ad', 6, 9, 2);

-- --------------------------------------------------------

--
-- Structure de la table `rating`
--

DROP TABLE IF EXISTS `rating`;
CREATE TABLE IF NOT EXISTS `rating` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rating` int NOT NULL,
  `movie_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlqsvmdlh3ep1boo7in23xe86y` (`movie_id`),
  KEY `FKf68lgbsbxl310n0jifwpfqgfh` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `rating`
--

INSERT INTO `rating` (`id`, `rating`, `movie_id`, `user_id`) VALUES
(27, 2, 1, 5),
(28, 5, 4, 5),
(29, 4, 7, 5),
(30, 4, 9, 5),
(31, 2, 5, 6),
(32, 5, 15, 7),
(33, 4, 4, 7),
(34, 5, 15, 5),
(35, 5, 6, 5),
(36, 5, 15, 9),
(37, 4, 6, 9),
(38, 5, 8, 9),
(39, 5, 2, 9);

-- --------------------------------------------------------

--
-- Structure de la table `review`
--

DROP TABLE IF EXISTS `review`;
CREATE TABLE IF NOT EXISTS `review` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `review` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `movie_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8378dhlpvq0e9tnkn9mx0r64i` (`movie_id`),
  KEY `FK6cpw2nlklblpvc7hyt7ko6v3e` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `review`
--

INSERT INTO `review` (`id`, `review`, `movie_id`, `user_id`) VALUES
(15, 'Perfect movie', 1, 5),
(16, 'Perfect movie', 4, 5),
(17, 'DBVBSDVSDJVKSDKVKSDKVKSDVKSDKVKSD', 7, 5),
(18, 'Best movie evaaaaa', 9, 5),
(19, 'Best movie ever', 15, 7),
(20, 'ReviewReviewReviewReviewReviewReview', 6, 9),
(21, 'best movie best movie best movie best movie best movie best movie ', 2, 9);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN'),
(3, 'ROLE_ADMIN'),
(4, 'ROLE_ADMIN'),
(5, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `f_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `l_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `f_name`, `l_name`, `email`, `password`) VALUES
(1, 'Yasmine', 'Znatn', 'Jass@gmail.com', '123456789'),
(2, 'Saad', 'Boukili', 'Saad@gmail.com', '123456789'),
(3, 'Hamza', 'Berraho', 'Mizu@gmail.com', '123456789'),
(4, 'Mohammed Amine', 'Farah', 'Amine@gmail.com', '123456789'),
(5, 'saad', 'boukili', 'saadboukili66@gmail.com', '$2a$10$P6WqImRelt5hBncjpOT6je1LN8lPyI4bRNCF5ioLOVW5HFeS2HHLe'),
(6, 'Yasmine', 'znatn', 'znatni.yasmine@gmail.com', '$2a$10$G1IiBUiWRXEZt.OlkUp8U.te6HLB3evuWWpc5fC2D5A9djWkMGOYm'),
(7, 'adminName', 'adminLastname', 'admin@gmail.com', '$2a$10$jywdSFdONk866t7swd7gB.J1BaTgrr7dDukX8sd3AN2WBCk5mKpFK'),
(8, 'saad2', 'boukili', 'saad@hotmail.com', '$2a$10$KrEGp6xGO2QzS5M9T5G33O8x6V57vN2oYyGdR9Uh275/ejQdgLZCK'),
(9, 'rania', 'bouabid', 'rania@gmail.com', '$2a$10$aRNE1FPrqBRommBfj3V0GucfS05yHbb.IWfjwh9tkNRXPIhvnEe5C');

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(5, 1),
(6, 2),
(7, 3),
(8, 4),
(9, 5);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `movie-genre`
--
ALTER TABLE `movie-genre`
  ADD CONSTRAINT `FKi8e8jjgtqeklgl7r5qo3p5jhy` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  ADD CONSTRAINT `FKlb3jfe1rc30dfr56ulnk0233s` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`);

--
-- Contraintes pour la table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK282q7imjgug93crnadkin1e3n` FOREIGN KEY (`movie_1_id`) REFERENCES `movie` (`id`),
  ADD CONSTRAINT `FK7ky67sgi7k0ayf22652f7763r` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKnnmquso3vp1ipc088sq4e1jvh` FOREIGN KEY (`movie_2_id`) REFERENCES `movie` (`id`);

--
-- Contraintes pour la table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `FKf68lgbsbxl310n0jifwpfqgfh` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKlqsvmdlh3ep1boo7in23xe86y` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`);

--
-- Contraintes pour la table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `FK6cpw2nlklblpvc7hyt7ko6v3e` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FK8378dhlpvq0e9tnkn9mx0r64i` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`);

--
-- Contraintes pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
