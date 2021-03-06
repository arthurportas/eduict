<%@ page import="com.eduict.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt">

    <head>
    
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Arthur Portas">
    
        <title>.:EduICT:.</title>
    
        <!-- Bootstrap Core CSS -->
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    
        <!-- Custom CSS -->
        <link href="<c:url value="/resources/css/landing-page.css" />" rel="stylesheet">
    
        <!-- Custom Fonts -->
        <link href="/resources/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet"
              type="text/css">
    
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    
        <!-- Bootstrap Select CSS -->
        <link href="<c:url value="/resources/css/bootstrap-select.min.css" />" rel="stylesheet">
    
    </head>
    
    <body>
    
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="" title="EduIct">EduIct</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <%
                        //session exists
                        User user = null;
                        if (session.getAttribute("user") == null) {
                            response.sendRedirect("index.jsp");
    
                        } else {
                            user = (User) session.getAttribute("user");
                            String email = user.getEmail();
                    %>
                    <li>
                        <a class="user-menu" href="" title="<%=email %>"><%=email %></a>
                    </li>
                    <li>
                        <a class="user-profile" href="" title="Perfil">Perfil</a>
                    </li>
                    <li>
                        <a class="user-logout" href="/logout" title="Logout">Logout</a>
                    </li>
                    <%}%>
                    <li>
                        <a class="developer-credits" href="" title="Developer">Developer</a>
                    </li>
                    <li>
                        <a class="contacts" href="" title="Contatos">Contatos</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <!-- Page Content -->
    <div class="content-section-a developer hidden">
    
        <div class="container bordered">
            <div class="row">
                <div class="container" id="formDeveloperContainer">
                    <form class="form-signin" id="developer" role="form">
                        <h3 class="form-signin-heading">Email</h3>
                    
                        <div class="form-group">
                            <label for="developer-email" class="sr-only col-sm-2 control-label">Email</label>
                            <input type="email" class="form-control" name="developer-email" id="login-email"
                                   placeholder="Email" required autofocus>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
                    </form>
                </div>
                <!-- /container -->
            </div>
        </div>
        <!-- /.container -->
    </div>
    <!-- /.content-section-a -->
    
    <div class="content-section-a user-personal hidden">
        <div class="container bordered">
            <div class="row">
                <div class="container" id="formPersonalDataContainer">
                    <form class="form-signin" id="personal-form" role="form">
                        <h3 class="form-signin-heading">Perfil</h3>
                            <div class="form-group">
                                <label for="register-firstName" class="col-sm-2 control-label">Nome</label>
                                <input type="text" class="form-control" name="register-firstName" id="register-firstName"
                                   placeholder="Nome" required autofocus value="<c:out value="${user.firstName}"/>"/>
                            </div>
                            
                            <div class="form-group">
                                <label for="register-lastName" class="col-sm-2 control-label">Apelido</label>
                                <input type="text" class="form-control" name="register-lastName" id="register-lastName"
                                       placeholder="Apelido" required value="<c:out value="${user.lastName}"/>"/>
                            </div>
                        
                            <div class="form-group">
                                <label for="register-email" class="col-sm-2 control-label">Email</label>
                                <input type="email" class="form-control" name="register-email" id="register-email"
                                   placeholder="Email" required value="<c:out value="${user.email}"/>"/>
                            </div>
    
                            <div class="form-group">
                                <label for="register-age" class="col-sm-2 control-label register-age">Idade</label>
                                <br/>
        
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="age-radios" id="age-radios-until25" value="until25" checked>
                                        Até 25 anos
                                    </label>
                                </div>
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="age-radios" id="age-radios-26until35" value="26until35">
                                        26 a 35 anos
                                    </label>
                                </div>
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="age-radios" id="age-radios-36until45" value="36until45">
                                        36 a 45 anos
                                    </label>
                                </div>
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="age-radios" id="age-radios-46until55" value="46until55">
                                        46 a 55 anos
                                    </label>
                                </div>
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="age-radios" id="age-radios-56ormore" value="56ormore">
                                        56 ou mais anos
                                    </label>
                                </div>
                            </div>
    
                            <div class="form-group">
                                <label for="register-gender" class="col-sm-2 control-label gender">Sexo</label>
                                <br/>
        
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="gender-radios" id="gender-radios-male" value="male" checked>
                                        Masculino
                                    </label>
                                </div>
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="gender-radios" id="gender-radios-female" value="female">
                                        Feminino
                                    </label>
                                </div>
                            </div>
    
                            <div class="form-group">
                                <label for="academic-degree" class="col-sm-2 control-label">Grau Académico</label>
                                <select class=" selectpicker academic-degree">
                                    <option value="graduate">Licenciatura</option>
                                    <option value="master">Mestrado</option>
                                    <option value="post-graduate">Pós-Graduação</option>
                                    <option value="doctoral">Doutoramento</option>
                                </select>
                            </div>
    
                            <div class="form-group">
                                <label for="recruitment-group" class="col-sm-2 control-label">Grupo de Recrutamento</label>
                                <select class="selectpicker recruitment-group">
                                    <optgroup label="Pré-Escolar e 1ºCiclo do Ensino Básico">
                                        <option value="100 - Educação Pré-Escolar">100 - Educação Pré-Escolar</option>
                                        <option value="110 - 1º Ciclo do Ensino Básico">110 - 1º Ciclo do Ensino Básico</option>
                                    </optgroup>
                                    <optgroup label="2º Ciclo do Ensino Básico">
                                        <option value="200 - Português e Estudos Sociais-História">200 - Português e Estudos
                                            Sociais-História
                                        </option>
                                        <option value="210 - Português e Francês">210 - Português e Francês</option>
                                        <option value="220 - Português e Inglês"></option>
                                        <option value="230 - Matemática e Ciências da Natureza">230 - Matemática e Ciências da
                                            Natureza
                                        </option>
                                        <option value="250 - Educação Musical">250 - Educação Musical</option>
                                        <option value="220 - Português e Inglês">220 - Português e Inglês</option>
                                    </optgroup>
                                    <optgroup label="Educação Especial">
                                        <option value="910 - Educação Especial 1">910 - Educação Especial 1</option>
                                        <option value="920 - Educação Especial 2">920 - Educação Especial 2</option>
                                        <option value="930 - Educação Especial 3">930 - Educação Especial 3</option>
                                    </optgroup>
                                    <optgroup label="3º Ciclo do Ensino Básico e Secundário">
                                        <option value="300 – Português">300 – Português</option>
                                        <option value="310 - Latim e Grego">310 - Latim e Grego</option>
                                        <option value="320 – Francês">320 – Francês</option>
                                        <option value="330 – Inglês">330 – Inglês</option>
                                        <option value="350 – Espanhol">350 – Espanhol</option>
                                        <option value="400 – História">400 – História</option>
                                        <option value="410 – Filosofia">410 – Filosofia</option>
                                        <option value="420 – Geografia">420 – Geografia</option>
                                        <option value="430 - Economia e Contabilidade">430 - Economia e Contabilidade</option>
                                        <option value="500 – Matemática">500 – Matemática</option>
                                        <option value="510 - Física e Química">510 - Física e Química</option>
                                        <option value="520 - Biologia e Geologia">520 - Biologia e Geologia</option>
                                        <option value="540 - Eletrotecnia">540 - Eletrotecnia</option>
                                        <option value="550 - Informática">550 - Informática</option>
                                        <option value="560 - Ciências Agropecuárias">560 - Ciências Agropecuárias</option>
                                        <option value="600 - Artes Visuais">600 - Artes Visuais</option>
                                        <option value="620 - Educação Física">620 - Educação Física</option>
                                    </optgroup>
                                </select>
                            </div>
    
                            <div class="form-group current-year-teching-level">
                                <label for="register-current-year-teching-level" class="col-sm-2 control-label current-year-teching-level">
                                    No presente ano letivo leciona em que nível de ensino?
                                </label>
                                <br/>
        
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="current-year-teching-level-radios"
                                               id="current-year-teching-level-radios-1cicle" value="1º Ciclo" checked>
                                        1º Ciclo
                                    </label>
                                </div>
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="current-year-teching-level-radios"
                                               id="current-year-teching-level-radios-2cicle" value="2º Ciclo">
                                        2º Ciclo
                                    </label>
                                </div>
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="current-year-teching-level-radios"
                                               id="current-year-teching-level-radios-3cicle" value="3º Ciclo">
                                        3º Ciclo
                                    </label>
                                </div>
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="current-year-teching-level-radios"
                                               id="current-year-teching-level-radios-secondary" value="Secundário">
                                        Secundário
                                    </label>
                                </div>
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="current-year-teching-level-radios"
                                               id="current-year-teching-level-radios-3cicle-secondary"
                                               value="3ºciclo/Secundário">
                                        3ºciclo/Secundário
                                    </label>
                                </div>
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="current-year-teching-level-radios"
                                               id="current-year-teching-level-radios-professional" value="Profissional">
                                        Profissional
                                    </label>
                                </div>
                                <div class="radio">
                                    <label class="radio-inline">
                                        <input type="radio" name="current-year-teching-level-radios"
                                               id="current-year-teching-level-radios-noschool" value="Sem escola">
                                        Sem escola
                                    </label>
                                </div>
                            </div>
        
                            <div class="form-group">
                                <label for="service-time" class="col-sm-2 control-label">Tempo de Serviço</label>
                                <select class="selectpicker service-time">
                                    <option value="Menos de 5 anos">Menos de 5 anos</option>
                                    <option value="6 a 15 anos">6 a 15 anos</option>
                                    <option value="16 a 25 anos">16 a 25 anos</option>
                                    <option value="mais de 25 anos">mais de 25 anos</option>
                                </select>
                            </div>
                        
                            <div class="form-group">
                                <label for="work-region" class="col-sm-2 control-label">Concelho</label>
                                <select class="selectpicker work-region">
                                    <option value="Porto">Porto</option>
                                </select>
                            </div>
    
                            <div class="form-group">
                                <label for="work-school" class="col-sm-2 control-label">Escola</label>
                                <select class="selectpicker work-school">
                                    <option value="XXX">YYY</option>
                                </select>
                            </div>
                        
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Gravar</button>
                    </form>
    
                </div>
                <!-- /container -->
            </div>
        </div>
        <!-- /.container -->
    </div>
    <!-- /.content-section-a -->
    
    <div class="content-section-a contact hidden">
    
        <div class="container bordered">
            <div class="row">
                <div class="col-md-12">
                    <small><i></i>Add alerts if form ok... success, else error.</i></small>
                    
                </div>
                <form role="form" action="/contact" method="POST">
                    <div class="col-lg-6">
    
                        <div class="form-group">
                            <label for="InputName">Nome</label>
    
                            <div class="input-group">
                                <input type="text" class="form-control" name="InputName" id="InputName" placeholder="Nome"
                                       required>
                            </div>
                        </div>
    
                        <div class="form-group">
                            <label for="InputEmail">Email</label>
    
                            <div class="input-group">
                                <input type="email" class="form-control" id="InputEmail" name="InputEmail"
                                       placeholder="Email" required>
                            </div>
                        </div>
    
                        <div class="form-group">
                            <label for="InputMessage">Mensagem</label>
    
                            <div class="input-group">
                                <textarea name="InputMessage" id="InputMessage" class="form-control" rows="5"
                                          required></textarea>
                            </div>
                        </div>
    
                        <input type="submit" name="contact-submit" id="contact-submit" value="Enviar"
                               class="btn btn-info pull-right">
                    </div>
                </form>
            </div>
        </div>
        <!-- /.container -->
    </div>
    <!-- /.content-section-a -->
    
    <div class="banner">
    
        <div class="container">
    
            <div class="row">
                <div class="col-lg-6">
                    <h2>EduIct nas Redes Sociais</h2>
                </div>
                <div class="col-lg-6">
                    <ul class="list-inline banner-social-buttons">
                        <li>
                            <a href="#" class="btn btn-default btn-lg" title="Twitter"><i class="fa fa-twitter fa-fw"></i>
                                <span class="network-name">Twitter</span></a>
                        </li>
                        <li>
                            <a href="#" class="btn btn-default btn-lg" title="Facebook"><i class="fa fa-facebook fa-fw"></i>
                                <span class="network-name">Facebook</span></a>
                        </li>
                    </ul>
                </div>
            </div>
    
        </div>
        <!-- /.container -->
    
    </div>
    <!-- /.banner -->
    
    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <ul class="list-inline">
                        <li>
                            <a href="">Referências WEB</a>
                        </li>
                    </ul>
                    <p class="copyright text-muted small">Copyright &copy; EduIct 2014. Todos os Direitos Reservados</p>
                </div>
            </div>
        </div>
    </footer>
    <!-- jQuery Version 1.11.0 -->
    <script src="<c:url value="/resources/js/jquery-1.11.0.js" />"></script>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    
    <!-- Bootstrap Select JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap-select.min.js" />"></script>
    
    <!-- Login JavaScript -->
    <script src="<c:url value="/resources/js/login/login.js" />"></script>
    
    <!-- Register JavaScript -->
    <script src="<c:url value="/resources/js/login/register.js" />"></script>
    
    <!-- Developer JavaScript -->
    <script src="<c:url value="/resources/js/developer/developer.js" />"></script>
    
    <!-- Contact JavaScript -->
    <script src="<c:url value="/resources/js/contact/contact.js" />"></script>
    
    <!-- Login JavaScript -->
    <script src="<c:url value="/resources/js/login/recover-password.js" />"></script>
    
    <!-- About JavaScript -->
    <script src="<c:url value="/resources/js/about/about.js" />"></script>
    
    <!-- Personal JavaScript -->
    <script src="<c:url value="/resources/js/personal/personal.js" />"></script>
    
    <!-- References JavaScript -->
    <script src="<c:url value="/resources/js/references/references.js" />"></script>
        
    <script>
        $('.selectpicker').selectpicker();
    </script>
    </body>

</html>
