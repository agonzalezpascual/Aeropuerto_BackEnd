CREATE TABLE vuelo (
   id UUID not NULL PRIMARY KEY,
   piloto VARCHAR(50) NOT NULL,
   numPas integer,
   origen VARCHAR(50) NOT NULL,
   destino VARCHAR(50) NOT NULL
);
CREATE EXTENSION "uuid-ossp";
