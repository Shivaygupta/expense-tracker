create table  if not exists expense(
    id INTEGER(11) UNSIGNED NOT NULL  AUTO_INCREMENT,
    commodityName VARCHAR(255),
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    place varchar(255),
    modeOfPayment varchar(255),
    billNo INTEGER(20),
    PRIMARY KEY(id));

