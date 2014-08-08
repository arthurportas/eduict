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
--Domain 2
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (2, 'Capaz de combinar padrões curriculares específicos com pacotes de software específicos e aplicações informáticas e descrever como esses padrões são sustentados por essas aplicações', 2);
--Domain 3
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (3, 'Sou capaz de descrever como o ensino didático e as TIC podem ser utilizados para apoiar na aquisição de conhecimentos escolar sobre a disciplina', 3);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (4, 'Sou capaz de incorporar atividades  apropriadas de TIC em planos de aula, de modo a apoiar a aquisição de conhecimentos escolar sobre a disciplina', 3);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (5, 'Utilizo software de apresentação e recursos digitais para apoiar as aulas', 3);
--Domain 4
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (6, 'Sou capaz de descrever e demonstrar a utilização de hardware comum', 4);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (7, 'Descrever e demonstrar as tarefas básicas e aplicações de processadores de texto, como a entrada de texto, edição de texto, formataão de texto e impressão', 4);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (8, 'Descrever e demonstrar a finalidade e características básicas do software de apresentação e outros recursos digitais', 4);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (9, 'Descrever o propósito e a função básica do software gráfico e usar um pacote de software de gráficos para criar um display gráfico simples', 4);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (10, 'Descrever a Internet e a World Wide Web, refletir sobre os seus usos, descrever como funciona um browser e usar uma URL para aceder a um site', 4);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (11, 'Utilizar um motor de busca', 4);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (12, 'Criar uma conta de e-mail e utilizá-la para criar uma cadeia de correspondência de e-mails', 4);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (13, 'Descrever as funcionalidades e os propósito dos tutoriais e software de treino e a forma como apoia os alunos na aquisição de conhecimentos escolares sobre a disciplina', 4);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (14, 'Localizar pacotes de software educacional e recursos da web prontos para serem utilizados, avaliá-los no que diz respeito à sua precisão e alinhamento com os padrões curriculares e combiná-los com as necessidades específicas dos alunos', 4);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (15, 'Usar software online de manutenção de registros para marcar presenças, submeter notas e manter os registos dos alunos', 4);
INSERT INTO Question (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (16, 'Usar tecnologias de colaboração e comunicação, tais como mensagens de texto, videoconferância e colaboração baseada na web e em ambientes sociais', 4);
--Domain 5

--Domain 6



--INSERT INTO Question (id, question) VALUES (6, '');
--INSERT INTO Question (id, question) VALUES (7, '');
--INSERT INTO Question (id, question) VALUES (8, '');
--INSERT INTO Question (id, question) VALUES (9, '');
--INSERT INTO Question (id, question) VALUES (10, '');


