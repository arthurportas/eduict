-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212');

--Domain 1
INSERT INTO Question (id, question) VALUES (1, 'Capaz de identificar as principais características das práticas de sala de aula e especificar como essas características servem para implementar as polÌticas de integração das TIC em contexto de sala de aula');
INSERT INTO Question (id, question) VALUES (2, 'Capaz de combinar padrões curriculares específicos com pacotes de software específicos e aplicações informáticas e descrever como esses padrões são sustentados por essas aplicações');
INSERT INTO Question (id, question) VALUES (3, 'Sou capaz de descrever como o ensino didático e as TIC podem ser utilizados para apoiar na aquisição de conhecimentos escolar sobre a disciplina');
INSERT INTO Question (id, question) VALUES (4, 'Sou capaz de incorporar atividades  apropriadas de TIC em planos de aula, de modo a apoiar a aquisição de conhecimentos escolar sobre a disciplina');
INSERT INTO Question (id, question) VALUES (5, 'Utilizo software de apresentação e recursos digitais para apoiar as aulas');

INSERT INTO Domain (DOMAIN_ID, description, DOMAIN_QUESTIONS) VALUES (1, 'Compreensão das TIC na educação', 1);
INSERT INTO Domain (DOMAIN_ID, description, DOMAIN_QUESTIONS) VALUES (2, 'Currículo e Avaliação', 1);
INSERT INTO Domain (DOMAIN_ID, description, DOMAIN_QUESTIONS) VALUES (3, 'Pedagogia', 1);
INSERT INTO Domain (DOMAIN_ID, description, DOMAIN_QUESTIONS) VALUES (4, 'TIC', 1);
INSERT INTO Domain (DOMAIN_ID, description, DOMAIN_QUESTIONS) VALUES (5, 'Organização e Administração', 1);
INSERT INTO Domain (DOMAIN_ID, description, DOMAIN_QUESTIONS) VALUES (6, 'Desenvolvimento Profissional Docente', 1);

--Domain 2
--INSERT INTO Question (id, question) VALUES (6, '');
--INSERT INTO Question (id, question) VALUES (7, '');
--INSERT INTO Question (id, question) VALUES (8, '');
--INSERT INTO Question (id, question) VALUES (9, '');
--INSERT INTO Question (id, question) VALUES (10, '');


