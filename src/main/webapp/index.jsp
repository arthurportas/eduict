<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

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
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    
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
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">EduIct</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">Login</a>
                        </li>  
                        <li>
                            <a href="#">Registar</a>
                        </li> 
                        <li>
                            <a href="#">Developer</a>
                        </li>
                        <li>
                            <a href="#">Contatos</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>
    
        <!-- Header -->
        <div class="intro-header">
    
            <div class="container">
    
                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message">
                            <h1>EduICT</h1>
                            <h3>Sobre o Projeto</h3>
                            <hr class="intro-divider">
                            <ul class="list-inline intro-social-buttons">
                                <!--<li>-->
                                    <!--<a href="#" class="btn btn-default btn-lg"><i class="fa-fw"></i> <span class="network-name">Login</span></a>-->
                                    <!--<a class="btn btn-default btn-lg" data-toggle="modal" href="#login-modal" >
                                        <span class="network-name">Login</span>
                                    </a>
                                </li>-->
                                <li>
                                    <a href="/quiz.jsp" class="btn btn-default btn-lg"><i class="fa-fw"></i> <span class="network-name">Questionário</span></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
    
            </div>
            <!-- /.container -->
    
        </div>
        <!-- /.intro-header -->
    
        <!-- Page Content -->

        <div class="content-section-a login">
    
            <div class="container">
            	<div class="row">
                	<div class="container" id="formContainer">
                      <form class="form-signin" id="login" role="form">
                        <h3 class="form-signin-heading">Login</h3>
                        <a href="#" id="flipToRecover" class="flipLink">
                          <div id="triangle-topright"></div>
                        </a>
                        <input type="email" class="form-control" name="login-email" id="login-email" 
                            placeholder="Email" required autofocus>
                        <input type="password" class="form-control" name="login-password" id="login-password" 
                        placeholder="Password" required>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
                      </form>
                    </div> <!-- /container -->
            	</div>
            </div>
            <!-- /.container -->
        </div>
        <!-- /.content-section-a -->    
        
        <div class="content-section-a recover-password">
            <div class="container">
            	<div class="row">
                	<div class="container" id="formRecoverContainer">
                      <form class="form-signin" id="recover" role="form">
                        <h3 class="form-signin-heading">Email</h3>
                        <a href="#" id="flipToLogin" class="flipLink">
                          <div id="triangle-topleft"></div>
                        </a>
                        <input type="email" class="form-control" name="recover-email" id="recover-email" 
                        placeholder="Email" required autofocus>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Recuperar password</button>
                      </form>
            
                    </div> <!-- /container -->
            	</div>
            </div>
            <!-- /.container -->
        </div>
        <!-- /.content-section-a --> 
        
        <div class="content-section-a register">
            <div class="container">
            	<div class="row">
                	<div class="container" id="formRegisterContainer">
                      <form class="form-signin" id="register" role="form" action="register" method="GET">
                        <h3 class="form-signin-heading">Novo utilizador</h3>
                        <div class="form-group">
                            <label for="register-firstName" class="col-sm-2 control-label">Nome</label>
                            <input type="text" class="form-control" name="register-firstName" id="register-firstName" 
                                placeholder="Firstname" required autofocus />
                        </div>
                        <div class="form-group">
                            <label for="register-lastName" class="col-sm-2 control-label">Apelido</label>
                            <input type="text" class="form-control" name="register-lastName" id="register-lastName" 
                            placeholder="Lastname" required />
                        </div>
                       
                        <div class="form-group">
                            <label for="register-email" class="col-sm-2 control-label">Email</label>
                            <input type="email" class="form-control" name="register-email" id="register-email" 
                                placeholder="Email address" required />
                        </div>
                        
                        <div class="form-group">
                            <label for="register-password" class="col-sm-2 control-label">Password</label>
                            <input type="password" class="form-control" name="register-password" id="register-password" 
                            placeholder="Password" required />
                        </div>
                        
                        <div class="form-group">
                            <label for="register-age" class="col-sm-2 control-label">Idade</label>
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
                            <label for="register-gender" class="col-sm-2 control-label">Sexo</label>
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
                                <optgroup label="Pré-Escolar e 1ºCiclo do Ensino Básico" >
                                  <option>100 - Educação Pré-Escolar</option>
                                  <option>110 - 1º Ciclo do Ensino Básico</option>
                                </optgroup>
                                <optgroup label="2º Ciclo do Ensino Básico">
                                  <option>200 - Português e Estudos Sociais-História</option>
                                  <option>210 - Português e Francês</option>
                                  <option>220 - Português e Inglês</option>
                                  <option>230 - Matemática e Ciências da Natureza</option>
                                  <option>250 - Educação Musical</option>
                                  <option>220 - Português e Inglês</option>
                                </optgroup>
                            </select>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Registar</button>
                      </form>
                    </div> <!-- /container -->
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
                                <a href="#" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter</span></a>
                            </li>
                            <li>
                                <a href="#" class="btn btn-default btn-lg"><i class="fa fa-linkedin fa-fw"></i> <span class="network-name">Linkedin</span></a>
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
                                <a href="#home">Home</a>
                            </li>
                            <li class="footer-menu-divider">&sdot;</li>
                            <li>
                                <a href="#about">About</a>
                            </li>
                            <li class="footer-menu-divider">&sdot;</li>
                            <li>
                                <a href="#services">Services</a>
                            </li>
                            <li class="footer-menu-divider">&sdot;</li>
                            <li>
                                <a href="#contact">Contact</a>
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
        
        <!-- Login JavaScript -->
        <script src="<c:url value="/resources/js/login/recover-password.js" />"></script>
        
        <script>
            $('.selectpicker').selectpicker();
        </script>    
    </body>

</html>
