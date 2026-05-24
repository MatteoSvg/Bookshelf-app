-- ===============================================
-- DATI DI ESEMPIO
-- Eseguito da Spring dopo la creazione dello schema Hibernate
-- (spring.jpa.defer-datasource-initialization=true)
-- ===============================================

-- CATEGORIE
INSERT INTO categoria (nome, descrizione) VALUES ('Romanzo', 'Opere di narrativa di ampio respiro');
INSERT INTO categoria (nome, descrizione) VALUES ('Fantascienza', 'Narrativa di ambientazione futuristica e tecnologica');
INSERT INTO categoria (nome, descrizione) VALUES ('Saggistica', 'Opere divulgative e di approfondimento');
INSERT INTO categoria (nome, descrizione) VALUES ('Giallo', 'Romanzi polizieschi e thriller');

-- AUTORI
INSERT INTO autore (nome, cognome, nazionalita) VALUES ('Italo', 'Calvino', 'Italiana');
INSERT INTO autore (nome, cognome, nazionalita) VALUES ('Isaac', 'Asimov', 'Statunitense');
INSERT INTO autore (nome, cognome, nazionalita) VALUES ('Umberto', 'Eco', 'Italiana');
INSERT INTO autore (nome, cognome, nazionalita) VALUES ('Agatha', 'Christie', 'Britannica');

-- LIBRI
INSERT INTO libro (titolo, isbn, anno_pubblicazione, disponibile, autore_id, categoria_id)
VALUES ('Il barone rampante', '9788804668374', 1957, TRUE, 1, 1);
INSERT INTO libro (titolo, isbn, anno_pubblicazione, disponibile, autore_id, categoria_id)
VALUES ('Le citta'' invisibili', '9788804668381', 1972, TRUE, 1, 1);
INSERT INTO libro (titolo, isbn, anno_pubblicazione, disponibile, autore_id, categoria_id)
VALUES ('Io, robot', '9788804703456', 1950, FALSE, 2, 2);
INSERT INTO libro (titolo, isbn, anno_pubblicazione, disponibile, autore_id, categoria_id)
VALUES ('Il nome della rosa', '9788845292613', 1980, TRUE, 3, 4);
INSERT INTO libro (titolo, isbn, anno_pubblicazione, disponibile, autore_id, categoria_id)
VALUES ('Assassinio sull''Orient Express', '9788804703463', 1934, TRUE, 4, 4);

-- PRESTITI
INSERT INTO prestito (nome_utente, data_prestito, data_restituzione, libro_id)
VALUES ('Mario Rossi', DATE '2026-05-02', NULL, 3);
INSERT INTO prestito (nome_utente, data_prestito, data_restituzione, libro_id)
VALUES ('Luca Bianchi', DATE '2026-04-15', DATE '2026-05-10', 1);
INSERT INTO prestito (nome_utente, data_prestito, data_restituzione, libro_id)
VALUES ('Giulia Verdi', DATE '2026-05-18', NULL, 5);
