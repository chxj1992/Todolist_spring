SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

DROP TABLE IF EXISTS `content`;

CREATE TABLE IF NOT EXISTS `content` (
  `content_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `context` varchar(255) NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`content_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='内容' AUTO_INCREMENT=28 ;

INSERT INTO `content` (`content_id`, `user_id`, `context`, `update_time`) VALUES
(1, 1, 'content1', '2014-01-10 02:57:46'),
(2, 1, 'content2', '2014-01-10 02:57:46'),
(3, 1, 'content3', '2014-01-10 02:57:47'),
(4, 2, 'content4', '2014-01-10 02:57:47');

DROP TABLE IF EXISTS `user`;

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户信息' AUTO_INCREMENT=4 ;

INSERT INTO `user` (`user_id`, `user_name`, `password`, `create_time`) VALUES
(1, 'test1', '202cb962ac59075b964b07152d234b70', '2014-01-10 02:56:19'),
(2, 'test2', '202cb962ac59075b964b07152d234b70', '2014-01-10 02:56:24'),
(3, 'test3', '202cb962ac59075b964b07152d234b70', '2014-01-10 02:56:32');
