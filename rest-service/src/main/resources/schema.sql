CREATE TABLE IF NOT EXISTS Run (
  id INT PRIMARY KEY,
  title varchar(255) NOT NULL,
  start timestamp NOT NULL,
  completed timestamp NOT NULL,
  miles INT NOT NULL,
  location varchar(255) NOT NULL,
  version INT
);