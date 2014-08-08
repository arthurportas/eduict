-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212');
--Level
INSERT INTO LEVEL (LEVEL_ID, DESCRIPTION) VALUES (1, 'Alfabetização Tecnológica');
INSERT INTO LEVEL (LEVEL_ID, DESCRIPTION) VALUES (2, 'Aprofundamento do Conhecimento');
INSERT INTO LEVEL (LEVEL_ID, DESCRIPTION) VALUES (3, 'Criação de Conhecimento');

--LEVEL 1 - DOMAINS
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (1, 'Compreensão das TIC na educação', 1);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (2, 'Currículo e Avaliação', 1);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (3, 'Pedagogia', 1);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (4, 'TIC', 1);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (5, 'Organização e Administração', 1);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (6, 'Desenvolvimento Profissional Docente', 1);
--LEVEL 2 - DOMAINS
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (7, 'Compreensão das TIC na educação', 2);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (8, 'Currículo e Avaliação', 2);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (9, 'Pedagogia', 2);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (10, 'TIC', 2);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (11, 'Organização e Administração', 2);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (12, 'Desenvolvimento Profissional Docente', 2);
--LEVEL 3 - DOMAINS
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (13, 'Compreensão das TIC na educação', 3);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (14, 'Currículo e Avaliação', 3);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (15, 'Pedagogia', 3);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (16, 'TIC', 3);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (17, 'Organização e Administração', 3);
INSERT INTO DOMAIN (DOMAIN_ID, DESCRIPTION, LEVEL_ID_FK) VALUES (18, 'Desenvolvimento Profissional Docente', 3);


--##LEVEL 1-'Alfabetização Tecnológica'
--Domain 1 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (1, 'Capaz de identificar as principais características das práticas de sala de aula e especificar como essas características servem para implementar as polÌticas de integração das TIC em contexto de sala de aula', 1);
--Domain 2 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (2, 'Capaz de combinar padrões curriculares específicos com pacotes de software específicos e aplicações informáticas e descrever como esses padrões são sustentados por essas aplicações', 2);
--Domain 3 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (3, 'Sou capaz de descrever como o ensino didático e as TIC podem ser utilizados para apoiar na aquisição de conhecimentos escolar sobre a disciplina', 3);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (4, 'Sou capaz de incorporar atividades  apropriadas de TIC em planos de aula, de modo a apoiar a aquisição de conhecimentos escolar sobre a disciplina', 3);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (5, 'Utilizo software de apresentação e recursos digitais para apoiar as aulas', 3);
--Domain 4 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (6, 'Sou capaz de descrever e demonstrar a utilização de hardware comum', 4);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (7, 'Descrever e demonstrar as tarefas básicas e aplicações de processadores de texto, como a entrada de texto, edição de texto, formataão de texto e impressão', 4);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (8, 'Descrever e demonstrar a finalidade e características básicas do software de apresentação e outros recursos digitais', 4);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (9, 'Descrever o propósito e a função básica do software gráfico e usar um pacote de software de gráficos para criar um display gráfico simples', 4);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (10, 'Descrever a Internet e a World Wide Web, refletir sobre os seus usos, descrever como funciona um browser e usar uma URL para aceder a um site', 4);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (11, 'Utilizar um motor de busca', 4);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (12, 'Criar uma conta de e-mail e utilizá-la para criar uma cadeia de correspondência de e-mails', 4);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (13, 'Descrever as funcionalidades e os propósito dos tutoriais e software de treino e a forma como apoia os alunos na aquisição de conhecimentos escolares sobre a disciplina', 4);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (14, 'Localizar pacotes de software educacional e recursos da web prontos para serem utilizados, avaliá-los no que diz respeito à sua precisão e alinhamento com os padrões curriculares e combiná-los com as necessidades específicas dos alunos', 4);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (15, 'Usar software online de manutenção de registros para marcar presenças, submeter notas e manter os registos dos alunos', 4);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (16, 'Usar tecnologias de colaboração e comunicação, tais como mensagens de texto, videoconferância e colaboração baseada na web e em ambientes sociais', 4);
--Domain 5 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (17, 'Integrar o uso de um laboratório de informática em atividades de ensino em curso', 5);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (18, 'Gerir o uso de recursos suplementares de TIC com indivíduos e pequenos grupos de alunos em sala de aula regular, de modo a não perturbar outras atividades de ensino na turma', 5);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (19, 'Identificar as organizações sociais apropriadas e inapropriadas para o uso de várias tecnologias', 5);
--Domain 6 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (20, 'Usar os recursos TIC para melhorar a sua produtividade', 6);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (21, 'Usar os recursos TIC para apoiar a sua própria aquisição de matéria e de conhecimento pedagógico', 6);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (22, 'Identificar e gerir problemas de segurança da Internet', 6);
--##LEVEL 2-'Aprofundamento do Conhecimento'
--Domain 1 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (23, 'Capaz de explicar e analisar os princípios de utilização das TIC na educação, descrevendo como esses princípios podem ser postos em prática no ensino, e analisa os problemas que surgem na implementação desses princípios e como podem ser resolvidos', 7);
--Domain 2 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (24, 'Identificar os principais conceitos e processos nas áreas de conteúdo; descrever a função e o propósito das ferramentas específicas das disciplinas e  de que forma  podem ajudar no entendimento, por parte dos alunos, desses conceitos-chave e processos e sua aplicação ao mundo fora da sala de aula', 8);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (25, 'O professor é capaz de desenvolver e aplicar regras com base em conhecimento e desempenho que permitam que os professores avaliem  a compreensão dos alunos sobre conceitos-chave das matérias, competências e processos', 8);
--Domain 3 
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (26, 'Descrever a forma como a aprendizagem colaborativa baseada em projectos e as TIC podem apoiar o pensamento e a interacão social dos alunos, já que os alunos compreendem conceitos-chave, processos e competências na disciplina e utilizam-nos para resolver problemas do mundo real', 9);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (27, 'Identificar ou elaborar  problemas complexos do mundo real e estruturá-los de uma forma a incorporar os principais conceitos da matéria e servir como base para projetos do aluno', 9);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (28, 'Elaborar materiais on-line que apoiem o melhor entendimento dos alunos sobre os principais conceitos e sua aplicação no mundo real', 9);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (29, 'Elaborar planos de aula e actividades em sala de aula para que os alunos se envolvam na discussão, debate e no uso dos principais conceitos da matéria enquanto colaboram para compreender, representar e solucionar problemas complexos do mundo real, assim como reflectir sobre as soluções e informá-las', 9);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (30, 'Estruturar planificações e actividades de sala de aula de modo que as ferramentas abertas e aplicativos específicos da matéria ajudem os alunos na discussão, debate e no uso dos conceitos da disciplina e dos processos, enquanto colaboram para solucionar problemas complexos', 9);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (31, 'Implementar planificações e actividades em sala de aula colaborativas e com base em projecto, enquanto orientam os alunos à boa finalização e profundo entendimento dos seus projectos e conceitos-chave', 9);
--Domain 4
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (32, 'Operar vários pacotes de software abertos/livres apropriados à área da disciplina, tais como visualizações, análise de dados, simulações e referÍncias on-line', 10);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (33, 'Avaliar a exactidão e utilidade dos recursos da web no apoio à aprendizagem baseada em projetos de uma determinada disciplina', 10);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (34, 'Utilizar um ambiente de criação ou ferramentas tutoriais para elaborar os materiais on-line', 10);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (35, 'Usar uma rede e um programa adequado para gerir, monitorizar e avaliar o progresso de diversos projectos de alunos', 10);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (36, 'Utilizar as TIC para comunicar e colaborar com alunos, colegas, pais e a comunidade em geral, a fim de estimular a aprendizagem do aluno', 10);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (37, 'Usar a Internet para apoiar a colaboração do aluno dentro e fora da sala de aula', 10);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (38, 'Utilizar motores de busca, bases de dados on-line e e-mail para encontrar pessoas e recursos para projetos colaborativos', 10);
--Domain 5
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (39, 'Colocar e organizar os computadores e outros recursos digitais na sala de aula, de modo a apoiar e reforçar as actividades de aprendizagem e interações sociais', 11);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (40, 'Gerenciar as atividades de aprendizagem dos alunos, com base no projeto, num ambiente de tecnologia avançada', 11);
--Domain 6
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (41, 'Usar as TIC para aceder e partilhar recursos em apoio ás suas actividades e ao seu próprio desenvolvimento profissional', 12);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (42, 'Utilizar as TIC para aceder a peritos externos (tutores) e a comunidades de aprendizagem em apoio ás suas atividades e ao seu proprio desenvolvimento profissional', 12);
INSERT INTO QUESTION (QUESTION_ID, QUESTION) VALUES (43, 'Utilizar as TIC para pesquisar, gerir, analisar, integrar e avaliar as informaÁıes que possam ser usadas para apoiar o seu desenvolvimento profissional', 12);
--##LEVEL 3-'Criação de Conhecimento'
--Domain 1 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (44, 'Capaz de elaborar, implementar e modificar os programas da reforma do ensino ao nível de escola que implementam os elementos-chave das políticas nacionais da reforma do ensino', 13);
--Domain 2 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (45, 'Capaz de identificar e discutir como os alunos aprendem e demonstram competências cognitivas complexas, tais como a gestão de informações, resolução de problemas, colaboração e pensamento crítico', 14);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (46, 'Capaz de ajudar os alunos a utilizarem as TIC para adquirirem as competências de pesquisa, gestão, análise, avaliação e utilização da informação', 14);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (47, 'Capaz de elaborar planificações e atividades de sala de aula que integrem várias ferramentas e dispositivos TIC para ajudar os alunos a adquirirem as competências de raciocínio, planeamento, aprendizagem reflexiva, construção do conhecimento e comunicação', 14);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (48, 'Capaz de ajudar os alunos a utilizarem as TIC para desenvolver competências de comunicação e colaboração', 14);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (49, 'Capaz de ajudar os alunos a desenvolverem regras baseadas em conhecimento e em desempenho e a aplicá-las para avaliar o seu próprio entendimento do assunto principal, assim como de competências em TIC. Ajudar os alunos a usar essas regras para avaliar o trabalho dos outros alunos', 14);
--Domain 3 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (50, 'Simula explicitamente o seu próprio raciocínio, resolução de problemas e criação de conhecimento, enquanto ensinam aos alunos', 15);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (51, 'Elaborar materiais e actividades on-line que envolvam os alunos na solução colaborativa de problemas, pesquisas ou criação artística', 15);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (52, 'Ajudar os alunos a elaborarem materiais e actividades on-line que os envolvam na solução colaborativa de problemas, pesquisas ou criação artística', 15);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (53, 'Ajudar os alunos a incorporarem a produção multimédia, a produção da web e as tecnologias de publicação nos seus projectos, de modo a dar suporte à produção contínua de conhecimento e comunicação com outros públicos', 15);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (54, 'Ajudar os alunos a reflectirem sobre a sua própria aprendizagem', 15);
--Domain 4 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (55, 'Descrever a função e a finalidade das ferramentas e recursos de produção de TIC (gravadora de multimédia e equipamento de produção, ferramentas de edição, programa de publicação, ferramentas de elaboração de web) e usá-las como apoio à inovação e conhecimento dos alunos', 16);
--Domain 5 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (56, 'Descrever a função e a finalidade dos ambientes virtuais e de construção de conhecimento (KBEs) e usá-los para dar suporte ao maior conhecimento e entendimento da disciplina e o desenvolvimento de comunidades de aprendizagem on-line e presenciais', 17);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (57, 'Descrever a função e a finalidade do planeamento e de pensar ferramentas usando-as para apoiar a criação e o planeamento, dos estudantes, das suas próprias actividades de aprendizagem e o seu contínuo pensamento e aprendizagem reflexivos', 17);
--Domain 6 - QUESTIONs
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (58, 'Desempenhar papel de liderança na criação de uma visão de como a escola seria com as TIC integradas ao currículo e práticas em sala de aula', 18);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (59, 'Desempenhar papel de liderança no apoio à inovação na sua escola e ao aprendizagem contínuo entre os seus colegas', 18);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (60, 'Avaliar continuamente e reflectir sobre a prática profissional para envolvimento na inovação e melhoria contínuas', 18);
INSERT INTO QUESTION (QUESTION_ID, QUESTION, DOMAIN_ID_FK) VALUES (61, 'Usar os recursos de TIC para participar nas comunidades profissionais e partilhar e discutir as melhores práticas de ensino', 18);