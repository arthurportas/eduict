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
                        <h3 class="form-signin-heading">Please sign in</h3>
                        <a href="#" id="flipToRecover" class="flipLink">
                          <div id="triangle-topright"></div>
                        </a>
                        <input type="email" class="form-control" name="loginEmail" id="loginEmail" placeholder="Email address" required autofocus>
                        <input type="password" class="form-control" name="loginPass" id="loginPass" placeholder="Password" required>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                      </form>
                
                      <form class="form-signin" id="recover" role="form">
                        <h3 class="form-signin-heading">Enter email address</h3>
                        <a href="#" id="flipToLogin" class="flipLink">
                          <div id="triangle-topleft"></div>
                        </a>
                        <input type="email" class="form-control" name="loginEmail" id="loginEmail" placeholder="Email address" required autofocus>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Recover password</button>
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
    
    </body>

</html>
