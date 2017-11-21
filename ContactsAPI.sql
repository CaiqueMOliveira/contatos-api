USE contatos_api;

CREATE TABLE tbl_contato(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(500) NOT NULL,
telefone VARCHAR(255));

INSERT INTO contatos (nome, telefone) VALUES('Gleyver', '(11) 12345678');
INSERT INTO contatos (nome, telefone) VALUES('Caíque', '(15) 5646543');
INSERT INTO contatos (nome, telefone) VALUES('Caio', '.(21) 94.64654');
INSERT INTO contatos (nome, telefone) VALUES('Lucas', '(11) 65684646');
INSERT INTO contatos (nome, telefone) VALUES('Ricardo', '(13) 64546565');

SELECT * FROM tbl_contato;


/* ADD COLUNA DE IMAGEM */
ALTER TABLE tbl_contato ADD COLUMN imagem VARCHAR(255);
