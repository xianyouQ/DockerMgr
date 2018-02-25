DROP TABLE IF EXISTS `permission`;
    CREATE TABLE IF NOT EXISTS `permission` (
        `id` INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `comment` varchar(100) NOT NULL DEFAULT '' ,
		 `name` varchar(100) NOT NULL DEFAULT '' ,
        `url` varchar(100) NOT NULL DEFAULT '',
        `cross_service` bool NOT NULL DEFAULT false
    ) ENGINE=InnoDB;
	
    DROP TABLE IF EXISTS `base_role`;
    CREATE TABLE IF NOT EXISTS `base_role` (
        `id` INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `name` varchar(100) NOT NULL DEFAULT '' ,
        `available` bool NOT NULL DEFAULT true ,
        `cross_service` bool NOT NULL DEFAULT false
    ) ENGINE=InnoDB;

    DROP TABLE IF EXISTS `role`;
    CREATE TABLE IF NOT EXISTS `role` (
        `id` INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `name` varchar(100),
        `base_role_id` bigint NOT NULL,
        `service_id` integer
    ) ENGINE=InnoDB;
	

   DROP TABLE IF EXISTS `role_user`;
    CREATE TABLE IF NOT EXISTS `role_user` (
        `id` INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `role_id` INTEGER NOT NULL,
        `user_id` INTEGER NOT NULL
    ) ENGINE=InnoDB;
	
	
	

    DROP TABLE IF EXISTS `user`;
    CREATE TABLE IF NOT EXISTS `user` (
        `id` INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `username` varchar(32) NOT NULL DEFAULT ''  UNIQUE,
        `password` varchar(32) NOT NULL DEFAULT '' ,
        `email` varchar(32) NOT NULL DEFAULT '' ,
        `last_login_time` datetime,
        `create_time` datetime NOT NULL
    ) ENGINE=InnoDB;
	

    DROP TABLE IF EXISTS `idc`;
    CREATE TABLE IF NOT EXISTS `idc` (
        `id` INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `name` varchar(30) NOT NULL DEFAULT ''  UNIQUE,
        `code` varchar(30) NOT NULL DEFAULT ''  UNIQUE,
		`available` bool NOT NULL DEFAULT true ,
        `marathon_id` integer UNIQUE
    ) ENGINE=InnoDB;
	

    DROP TABLE IF EXISTS `cidr`;
    CREATE TABLE IF NOT EXISTS `cidr` (
        `id` integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `name` varchar(20) NOT NULL DEFAULT ''  UNIQUE,
        `start_ip` varchar(20) NOT NULL DEFAULT '' ,
        `end_ip` varchar(20) NOT NULL DEFAULT '' ,
        `idc_id` integer NOT NULL
    ) ENGINE=InnoDB;
	
	
    DROP TABLE IF EXISTS `ip`;
    CREATE TABLE IF NOT EXISTS `ip` (
        `id` integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `cidr_id` integer NOT NULL,
        `ip` varchar(20) NOT NULL DEFAULT ''  UNIQUE,
        `mac` varchar(20) NOT NULL DEFAULT ''  UNIQUE,
        `allocated` bool NOT NULL DEFAULT false 
    ) ENGINE=InnoDB;
	
	    DROP TABLE IF EXISTS `instance`;
    CREATE TABLE IF NOT EXISTS `instance` (
        `id` integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `ip_id` integer NOT NULL,
		 `service_id` integer NOT NULL,
        `hostname` varchar(100) NOT NULL DEFAULT '' ,
		 `ip` varchar(20) NOT NULL DEFAULT '' ,
        `mac` varchar(20) NOT NULL DEFAULT '' 
    ) ENGINE=InnoDB;


    DROP TABLE IF EXISTS `marathon`;
    CREATE TABLE IF NOT EXISTS `marathon` (
        `id` integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `server` varchar(50) NOT NULL DEFAULT ''  UNIQUE,
        `http_basic_auth_user` varchar(50) NOT NULL DEFAULT '' ,
        `http_basic_password` varchar(50) NOT NULL DEFAULT ''
    ) ENGINE=InnoDB;
	

    DROP TABLE IF EXISTS `release`;
    CREATE TABLE IF NOT EXISTS `release` (
        `id` integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `release_conf_id` integer NOT NULL,
        `release_time` datetime NOT NULL,
        `operation_time` datetime,
        `service_id` integer NOT NULL,
        `version` varchar(20) NOT NULL DEFAULT '' ,
        `release_user_id` bigint,
        `operation_user_id` bigint,
        `review_user_id` bigint,
        `review_time` datetime,
        `task_status` integer NOT NULL DEFAULT 0 ,
        `cancel_user_id` integer,
        `release_detail` longtext ,
        `release_result` longtext ,
        `release_msg` longtext ,
		`idc_list` varchar(200) 
    ) ENGINE=InnoDB;
	

    DROP TABLE IF EXISTS `release_conf`;
    CREATE TABLE IF NOT EXISTS `release_conf` (
        `id` integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `service_id` integer NOT NULL,
        `fault_tolerant` integer NOT NULL DEFAULT 1 ,
        `idc_paralle` integer NOT NULL DEFAULT 1 ,
        `idc_inner_paralle` integer NOT NULL DEFAULT 1 ,
        `time_out` integer NOT NULL DEFAULT 0
    ) ENGINE=InnoDB;


    DROP TABLE IF EXISTS `service`;
	    CREATE TABLE IF NOT EXISTS `service` (
        `id` integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `name` varchar(20) NOT NULL DEFAULT ''  UNIQUE,
        `code` varchar(20) NOT NULL DEFAULT ''  UNIQUE,
        `release_ver_id` integer,
        `marathon_conf` longtext NOT NULL
    ) ENGINE=InnoDB;

    DROP TABLE IF EXISTS `base_role_permission`;


    CREATE TABLE IF NOT EXISTS `base_role_permission` (
        `id` integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
        `base_role_id` bigint NOT NULL,
        `permission_id` bigint NOT NULL
    ) ENGINE=InnoDB;




  



