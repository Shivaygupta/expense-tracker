create table if not exists DueEntity(
      id INTEGER(11) NOT NULL AUTO_INCREMENT,
      name VARCHAR(255),
      repaymentDate DATE,
      amount INTEGER,
      PRIMARY KEY(id));
)