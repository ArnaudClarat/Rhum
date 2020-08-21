--
-- Base de données :  `vitrinerhum`
--

CREATE DATABASE IF NOT EXISTS `vitrinerhum` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `vitrinerhum`;

-- --------------------------------------------------------

--
-- Structure de la table `t_marque`
--

DROP TABLE IF EXISTS `t_marques`;
CREATE TABLE IF NOT EXISTS `t_marques` (
    `id_marque` int(11) NOT NULL AUTO_INCREMENT,
    `nom_marque` varchar(250) NOT NULL,
    PRIMARY KEY (`id_marque`)
);

--
-- Déchargement de la table `t_marque`
--

INSERT INTO `t_marques` (`nom_marque`) VALUES
('Bacardi'),
('Captain Morgan'),
('Havana Club'),
('Kraken'),
('Saint-James');
COMMIT;


--
-- Structure de la table `t_origines`
--

DROP TABLE IF EXISTS `t_origines`;
CREATE TABLE IF NOT EXISTS `t_origines` (
    `id_origine` int(11) NOT NULL AUTO_INCREMENT,
    `nom_origine` varchar(250) NOT NULL,
    PRIMARY KEY (`id_origine`)
);


--
-- Déchargement de la table `t_origines`
--

INSERT INTO `t_origines` (`nom_origine`) VALUES
('Cuba'),
('Jamaïque'),
('Trinité-et-Tobago'),
('Martinique');
COMMIT;

--
-- Structure de la table `t_rhums`
--

DROP TABLE IF EXISTS `t_rhums`;
CREATE TABLE IF NOT EXISTS `t_rhums` (
    `id_rhum` int(11) NOT NULL AUTO_INCREMENT,
    `nom_rhum` varchar(250) NOT NULL,
    `details_rhum` varchar(2048) NOT NULL,
    `prix_rhum` decimal(4,2) NOT NULL,
    `marque_rhum` int(11) NOT NULL,
    `origine_rhum` int (11) NOT NULL,
    PRIMARY KEY (`id_rhum`),
    FOREIGN KEY (`marque_rhum`) REFERENCES `t_marques` (`id_marque`),
    FOREIGN KEY (`origine_rhum`) REFERENCES `t_origines` (`id_origine`)
);


--
-- Déchargement de la table `t_rhums`
--

INSERT INTO `t_rhums` (`nom_rhum`, `details_rhum`, `prix_rhum`, `marque_rhum`, `origine_rhum`) VALUES
('Carta Blancha', 'Rhum blanc, 37,5°, 100cl', 22, 1, 1),
('Oakheart', 'Rhum arrangé, 35°, 70cl', 24, 1, 1),
('Spicegold', 'Rhum arrangé, 35°, 70cl', 13, 2, 2),
('3 ans', 'Rhum blanc, 40°, 70cl', 16, 3, 1),
('7 ans', 'Rhum ambré, 40°, 70cl', 23, 3, 1),
('', 'Rhum noir, 40°, 70cl', 30, 4, 3),
('Vieux Agricole', 'Rhum ambré, 42°, 70cl', 21, 5, 4),
('Royal Ambré', 'Rhum ambré, 45°, 70cl', 13, 5, 4);
COMMIT;