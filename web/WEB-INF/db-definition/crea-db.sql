/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  pc
 * Created: 28-giu-2019
 */

CREATE TABLE Autori (
id SERIAL,
nome VARCHAR(128),
cognome VARCHAR(128),
email VARCHAR(128),
password VARCHAR(128),
foto VARCHAR(128)
);


CREATE TABLE Organizzatori (
id SERIAL,
nome VARCHAR(128),
cognome VARCHAR(128),
email VARCHAR(128),
password VARCHAR(128)
);


CREATE TABLE Articoli (
id SERIAL,
titolo VARCHAR(128),
data_articolo DATE,
testo VARCHAR(1024),
categorie VARCHAR(128),
stato VARCHAR(128)
);


CREATE TABLE Valutazioni (
id SERIAL,
articolo_id BIGINT UNSIGNED,
valutatore_id BIGINT UNSIGNED,
voto INTEGER,
comm_autori VARCHAR(1024),
comm_organizzatori VARCHAR(1024)
);
ALTER TABLE Valutazioni ADD FOREIGN KEY Articoli_fk (articolo_id)
REFERENCES Articoli (id) ON UPDATE CASCADE;
ALTER TABLE Valutazioni ADD FOREIGN KEY Organizzatori_fk (valutatore_id)
REFERENCES Organizzatori (id) ON UPDATE CASCADE;


CREATE TABLE Registro (
articolo_id BIGINT UNSIGNED,
autore_id BIGINT UNSIGNED,
valutatore_id BIGINT UNSIGNED,
valutazione_id BIGINT UNSIGNED
);

ALTER TABLE Registro ADD FOREIGN KEY Articoli_fk (articolo_id)
REFERENCES Articoli (id) ON UPDATE CASCADE;
ALTER TABLE Registro ADD FOREIGN KEY Autori_fk (autore_id)
REFERENCES Autori (id) ON UPDATE CASCADE;
ALTER TABLE Registro ADD FOREIGN KEY Organizzatori_fk (valutatore_id)
REFERENCES Organizzatori (id) ON UPDATE CASCADE;
ALTER TABLE Registro ADD FOREIGN KEY Valutazioni_fk (valutazione_id)
REFERENCES Valutazioni (id) ON UPDATE CASCADE;

/**Nomi ironici random **/
INSERT INTO Autori
(id, nome, cognome, email, password, foto)
VALUES
( default, "Giovanni",
"Muchacha", "muchacha@gmail.com",
"muchacha", default
);

INSERT INTO Autori
(id, nome, cognome, email, password, foto)
VALUES
( default, "Giampiero",
"belnome", "addio@gmail.com",
"salvino", default
);

INSERT INTO Organizzatori
(id, nome, cognome, email, password)
VALUES
( default, "Ottavio",
"SSettei", "setteotto@gmail.com",
"numeriii");

INSERT INTO Organizzatori
(id, nome, cognome, email, password)
VALUES
( default, "Conte",
"Conti", "tornano@gmail.com",
"cagliariii");

INSERT INTO Articoli
(id, titolo, data_articolo, testo, categorie, stato)
VALUES
( default,"Server-Side programmation", '2018-04-04',
 "Ci sono delle tecniche particolari per ...",
default, "Aperto");

INSERT INTO Articoli
(id, titolo, data_articolo, testo, categorie, stato)
VALUES
( default,"Il linguaggio Java", '2018-04-01',
 "E' un linguaggio di programmazione a oggetti ...",
default, "Da Valutare");

INSERT INTO Articoli
(id, titolo, data_articolo, testo, categorie, stato)
VALUES
( default, "Il Server Web", '2018-04-03',
 "Non è cosi fondamentale per lo sviluppo di applicazioni web ...",
default, "Rifiutato");

INSERT INTO Articoli
(id, titolo, data_articolo, testo, categorie, stato)
VALUES
( default, "MetaInfo", '2018-04-30',
 "Sarebbe utile lavorare sulla validazione delle pagine web ...",
default, "Da Valutare");


INSERT INTO Valutazioni
(id , articolo_id, valutatore_id, voto, comm_autori, comm_organizzatori)
VALUES
( default, 1, 2, 4, default, default),
( default, 3, 1, 3, default, default);

INSERT INTO Registro
(articolo_id, autore_id, valutatore_id, valutazione_id)
VALUES
( 1, 1, 2, 1),
( 1, 2, 2, 1),
( 2, 1, 2, default),
( 3, 1, 1, 2),
( 3, 2, 1, 2),
( 4, 2, 1, default);




