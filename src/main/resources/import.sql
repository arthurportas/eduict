-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212');

INSERT INTO Domain (DOMAIN_ID, DESCRIPTION) VALUES (1, 'Compreensão das TIC na educação');
INSERT INTO Domain (DOMAIN_ID, DESCRIPTION) VALUES (2, 'Currículo e Avaliação');
INSERT INTO Domain (DOMAIN_ID, DESCRIPTION) VALUES (3, 'Pedagogia');
INSERT INTO Domain (DOMAIN_ID, DESCRIPTION) VALUES (4, 'TIC');
INSERT INTO Domain (DOMAIN_ID, DESCRIPTION) VALUES (5, 'Organização e Administração');
INSERT INTO Domain (DOMAIN_ID, DESCRIPTION) VALUES (6, 'Desenvolvimento Profissional Docente');

--Domain 1
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (1, 'Capaz de identificar as principais características das práticas de sala de aula e especificar como essas características servem para implementar as polÌticas de integração das TIC em contexto de sala de aula', 1);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (2, 'Capaz de combinar padrões curriculares específicos com pacotes de software específicos e aplicações informáticas e descrever como esses padrões são sustentados por essas aplicações', 1);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (3, 'Sou capaz de descrever como o ensino didático e as TIC podem ser utilizados para apoiar na aquisição de conhecimentos escolar sobre a disciplina', 1);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (4, 'Sou capaz de incorporar atividades  apropriadas de TIC em planos de aula, de modo a apoiar a aquisição de conhecimentos escolar sobre a disciplina', 1);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (5, 'Utilizo software de apresentação e recursos digitais para apoiar as aulas', 1);



--Domain 2
--INSERT INTO Question (id, question) VALUES (6, '');
--INSERT INTO Question (id, question) VALUES (7, '');
--INSERT INTO Question (id, question) VALUES (8, '');
--INSERT INTO Question (id, question) VALUES (9, '');
--INSERT INTO Question (id, question) VALUES (10, '');


