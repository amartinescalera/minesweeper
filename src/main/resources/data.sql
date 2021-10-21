DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS (
  id VARCHAR(250) PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL UNIQUE
);

INSERT INTO USERS (id, name, email) VALUES
('amartinescalera', 'Antoni Fake', 'fakemail_1@gmail.com'),
('fakeUser2', 'This User is Fake', 'fakemail_2@gmail.com');