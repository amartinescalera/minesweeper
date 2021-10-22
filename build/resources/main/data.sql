DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS (
  id VARCHAR(250) PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL UNIQUE
);

INSERT INTO USERS (id, password, name, email) VALUES
('amartinescalera', 'amartinescalera', 'Antonio Fake', 'fakemail_1@gmail.com'),
('user', 'user', 'This User is Fake', 'fakemail_2@gmail.com');
