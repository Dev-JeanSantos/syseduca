INSERT INTO tb_institution ( name, cnpj, inep , address, postal_code, email, city, uf, complement, phone) VALUES ('E M IASMIM GONZAGA ARANTES','222222227/0001-25', '33158681', 'RUA VER. MANOEL DE MACEDO, 1040 CENTRO', '000000-001', 'emiasmimgonzagaarantes@gmail.com', 'Tanguá', 'RJ', 'S/C', '(21) 2747-1941');
INSERT INTO tb_institution ( name, cnpj, inep , address, postal_code, email, city, uf, complement, phone) VALUES ('E M FERNANDA SUELLEN DA SILVA GRIPP SAMPAIO','222222227/0001-24', '33125759', 'RUA EPITACIO PEREIRA RANGEL, LT. 02, QD 19. CHACARAS PINHAO', '000000-001', 'fernanadasuellen@gmail.com', 'Tanguá', 'RJ', 'S/C', '(21) 2747-4124');
INSERT INTO tb_institution ( name, cnpj, inep , address, postal_code, email, city, uf, complement, phone) VALUES ('E M MANOEL JOAO GONCALVES','222222227/0001-26', '33052263', 'RODOVIA BR 101 KM 280, S/N DUQUES.', '000000-001', 'manoeljoao@gmail.com', 'Tanguá', 'RJ', 'S/C', '(21) 3637-4462');
INSERT INTO tb_institution ( name, cnpj, inep , address, postal_code, email, city, uf, complement, phone) VALUES ('E M PADRE THOMAS PIETERS','222222227/0001-27', '33118710', 'AVENIDA PREFEITO JOAO BAPTISTA CAFFARO, LT 17 QD 06. VILA CORTES', '000000-001', 'padrethomas@gmail.com', 'Tanguá', 'RJ', 'S/C', ' (21) 2747-4126');
INSERT INTO tb_institution ( name, cnpj, inep , address, postal_code, email, city, uf, complement, phone) VALUES ('E M PROF DEARINA SILVA MACHADO','222222227/0001-28', '33052379', 'RUA EUCLIDES DA SILVA, QD 21. PINHAO', '000000-001', 'dearinamachado@gmail.com', 'Tanguá', 'RJ', 'S/C', ' (21) 2747-4118');
INSERT INTO tb_institution ( name, cnpj, inep , address, postal_code, email, city, uf, complement, phone) VALUES ('E M PROFESSORA PAULINA PORTO','222222227/0001-30', '33052298', 'PRACA PALMIRA PACHECO, S/N POSSE DOS COUTINHOS', '000000-001', 'paulinaporto@gmail.com', 'Tanguá', 'RJ', 'S/C', ' (21) 2747-4129');
INSERT INTO tb_institution ( name, cnpj, inep , address, postal_code, email, city, uf, complement, phone) VALUES ('E M VEREADOR ANTONIO DUARTE LOPES','222222227/0001-31', '33052417', 'RUA JOAO DIAS, 251 VILA CORTES', '000000-001', 'vereadroantonioduarte@gmail.com', 'Tanguá', 'RJ', 'S/C', '(21) 2747-4119');
INSERT INTO tb_institution ( name, cnpj, inep , address, postal_code, email, city, uf, complement, phone) VALUES ('E M VEREADOR MANOEL NOVIS DA SILVA','222222227/0001-32', '33052395', 'AVENIDA DO CONTORNO, 25 BANDEIRANTES I', '000000-001', 'manoelnovis@gmail.com', 'Tanguá', 'RJ', 'S/C', '(21) 2747-4117');
INSERT INTO tb_institution ( name, cnpj, inep , address, postal_code, email, city, uf, complement, phone) VALUES ('INSTITUTO EDUCACIONAL CASTELINHO ENCANTADO','222222227/0001-33', '33099944', 'RUA MANOEL JOAO GONCALVES, 571 CENTRO', '000000-001', 'castelinho@gmail.com', 'Tanguá', 'RJ', 'S/C', ' (21) 2747-1375');

INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (1,'MATERNAL',4,'BIMESTRE','WAITING','CHILD_EDUCATION');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (1,'PRIMEIRO PERIODO',4,'BIMESTRE', 'WAITING','CHILD_EDUCATION');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (1,'SEGUNDO PERIODO',4,'BIMESTRE', 'WAITING','CHILD_EDUCATION');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (1,'PRIMEIRO ANO',4,'BIMESTRE', 'WAITING','CHILD_EDUCATION');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (1,'PRIMEIRO ANO',4,'BIMESTRE', 'WAITING','FIRST_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (1,'SEGUNDO ANO',4,'BIMESTRE', 'WAITING','FIRST_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (1,'TERCEIRO ANO',4,'BIMESTRE', 'WAITING','FIRST_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (1,'QUARTO ANO',4,'BIMESTRE', 'WAITING','FIRST_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (1,'QUINTO ANO',4,'BIMESTRE', 'WAITING','FIRST_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (1,'SEXTO ANO',4,'BIMESTRE', 'WAITING','SECOUND_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (1,'SETIMO ANO',4,'BIMESTRE', 'WAITING','SECOUND_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (1,'OITAVO ANO',4,'BIMESTRE', 'WAITING','SECOUND_SEGMENT');

INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (2,'MATERNAL',4,'BIMESTRE', 'WAITING','CHILD_EDUCATION');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (2,'PRIMEIRO PERIODO',4,'BIMESTRE', 'WAITING','CHILD_EDUCATION');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (2,'SEGUNDO PERIODO',4,'BIMESTRE', 'WAITING','CHILD_EDUCATION');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (2,'PRIMEIRO ANO',4,'BIMESTRE', 'WAITING','FIRST_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (2,'PRIMEIRO ANO',4,'BIMESTRE', 'WAITING','FIRST_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (2,'SEGUNDO ANO',4,'BIMESTRE', 'WAITING','FIRST_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (2,'TERCEIRO ANO',4,'BIMESTRE', 'WAITING','FIRST_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (2,'QUARTO ANO',4,'BIMESTRE', 'WAITING','FIRST_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (2,'QUINTO ANO',4,'BIMESTRE', 'WAITING','FIRST_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (2,'SEXTO ANO',4,'BIMESTRE', 'WAITING','SECOUND_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (2,'SETIMO ANO',4,'BIMESTRE', 'WAITING','SECOUND_SEGMENT');
INSERT INTO tb_course ( institution_id, name, duration, periodicity, status, segment) VALUES (2,'OITAVO ANO',4,'BIMESTRE', 'WAITING','SECOUND_SEGMENT');

-- Consultas:
--SELECT i.name Escola, c.name Cursos FROM TB_INSTITUTION  i inner join tb_course c on i.id = c.institution_id
--SELECT i.name Escola, c.name Cursos FROM TB_INSTITUTION  i inner join tb_course c on i.id = c.institution_id  WHERE c.name = 'MATERNAL'