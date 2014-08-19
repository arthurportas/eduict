<%@ page import="com.eduict.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt">

    <head>
    
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="EduICT - Plataforma de Auto-avaliação no ensino das TIC">
        <meta name="author" content="Arthur Portas">
    
        <title>.:Eduict:.</title>
    
        <!-- Bootstrap Core CSS -->
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    
        <!-- Custom CSS -->
        <link href="<c:url value="/resources/css/shop-item.css" />" rel="stylesheet">
    
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    
    </head>
    
    <body>
    
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
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
                    %>
                    <li>
                        <a class="login-menu" href="" title="Login">Login</a>
                    </li>
                    <%
                    } else {
                        user = (User) session.getAttribute("user");
                        String email = user.getEmail();
                    %>
                    <li>
                        <a class="user-menu" href="/personal?email=<%=email %>" title="Área pessoal de <%=email %>"><%=email %>
                        </a>
                    </li>
                    <li>
                        <a class="user-logout" href="/logout" title="Logout">Logout</a>
                    </li>
                    <%}%>
                    <li>
                        <a class="" href="/index.jsp" title="Home">Home</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <!--###################################################################-->
    <!-- Page Content -->
    <div class="container">
    
        <div class="row">
    
            <div class="col-md-3">
                <p class="lead">Eduict</p>
    
                <div class="list-group">
                    <a href="#" class="list-group-item active">Nível 1</a>
                    <a href="#" class="list-group-item ">Nível 2</a>
                    <a href="#" class="list-group-item ">Nível 3</a>
                </div>
                
                <div>
                    <canvas id="canvas" height="450" width="450"></canvas>
                </div>
            </div>
    
            <div class="col-md-9">
    
                <div class="thumbnail">
                    <!--<img class="img-responsive" src="http://placehold.it/800x300" alt="">-->
                    <!--  iterate on the member list @named attribute and display name,email and phone number -->
                    <c:forEach items="${quizzes}" var="quiz">
                        <!--<h4><c:out value="${quiz.description}"/></h4>-->
                        <c:forEach items="${quiz.levels}" var="level" varStatus="levelIndex">
                            <div class="alert alert-info level">
                                <h4><c:out value="Nível ${level.id} - ${level.description}"/></h4>
                            </div>
                            <c:forEach items="${level.domains}" var="domain" varStatus="domainIndex">
                                <div class="alert alert-success domain">
                                    <h4><c:out value="Domínio ${domain.id} - ${domain.description}"/></h4>
                                </div>
                                <c:forEach items="${domain.questions}" var="question" varStatus="questionIndex">
                                    <div class="question-container question-wrapper-${question.id}">
                                        <div class="alert alert-warning question">
                                            <h4>Questão</h4>
    
                                            <p><c:out value="${question.question}"/></p>
                                        </div>
                                        <div class="answer-container answer-wrapper-${question.id} ">
                                            <h4>Respostas</h4>
                                            <c:forEach items="${question.responses}" var="response" varStatus="responseIndex">
                                                <div class="radio">
                                                    <label>

                                                        <input type="radio" name="response-radios"
                                                               value="${response.response}" 
                                                               ${responseIndex.first ? 'checked' : ''}><c:out value="${response.response}" escapeXml="false"/>/>
                                                    </label>
                                                </div>
                                            </c:forEach>
                                            <button class="btn btn-lg btn-primary btn-block response" title="Selecionar a resposta e avançar">Selecionar a resposta e avançar</button>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
    
    
                    <div class="caption-full">
                        <h4 class="pull-right">$24.99</h4>
                        <h4><a href="#">Product Name</a>
                        </h4>
    
                        <p>See more snippets like these online store reviews at <a target="_blank"
                                                                                   href="http://bootsnipp.com">Bootsnipp -
                            http://bootsnipp.com</a>.</p>
    
                        <p>Want to make these reviews work? Check out
                            <strong><a
                                    href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">this
                                building a review system tutorial</a>
                            </strong>over at maxoffsky.com!</p>
    
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                            voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat
                            non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
                    </div>
                    <div class="ratings">
                        <p class="pull-right">3 reviews</p>
    
                        <p>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star-empty"></span>
                            4.0 stars
                        </p>
                    </div>
                </div>
    
                <div class="well">
    
                    <div class="text-right">
                        <a class="btn btn-success">Leave a Review</a>
                    </div>
    
                    <hr>
    
                    <div class="row">
                        <div class="col-md-12">
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star-empty"></span>
                            Anonymous
                            <span class="pull-right">10 days ago</span>
    
                            <p>This product was great in terms of quality. I would definitely buy another!</p>
                        </div>
                    </div>
    
                    <hr>
    
                    <div class="row">
                        <div class="col-md-12">
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star-empty"></span>
                            Anonymous
                            <span class="pull-right">12 days ago</span>
    
                            <p>I've alredy ordered another one!</p>
                        </div>
                    </div>
    
                    <hr>
    
                    <div class="row">
                        <div class="col-md-12">
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star"></span>
                            <span class="glyphicon glyphicon-star-empty"></span>
                            Anonymous
                            <span class="pull-right">15 days ago</span>
    
                            <p>I've seen some better than this, but not at this price. I definitely recommend this item.</p>
                        </div>
                    </div>
    
                </div>
    
            </div>
    
        </div>
    
    </div>
    <!-- /.container -->
    
    <div class="container">
    
        <hr>
    
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p class="copyright text-muted small">Copyright &copy; EduIct 2014. Todos os Direitos Reservados</p>
                </div>
            </div>
        </footer>
    
    </div>
    <!-- /.container -->
    
    <!-- jQuery Version 1.11.0 -->
    <script src="<c:url value="/resources/js/jquery-1.11.0.js" />"></script>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    
    <!-- Charts Core JavaScript -->
    <script src="<c:url value="/resources/js/Chart.js" />"></script>
    
    <script>
        var radarChartData = {
            labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
            datasets: [
                {
                    label: "My First dataset",
                    fillColor: "rgba(220,220,220,0.2)",
                    strokeColor: "rgba(220,220,220,1)",
                    pointColor: "rgba(220,220,220,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(220,220,220,1)",
                    data: [65, 59, 90, 81, 56, 55, 40]
                },
                {
                    label: "My Second dataset",
                    fillColor: "rgba(151,187,205,0.2)",
                    strokeColor: "rgba(151,187,205,1)",
                    pointColor: "rgba(151,187,205,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(151,187,205,1)",
                    data: [28, 48, 40, 19, 96, 27, 100]
                }
            ]
        };
    
        window.onload = function () {
            window.myRadar = new Chart(document.getElementById("canvas").getContext("2d")).Radar(radarChartData, {
                responsive: true
            });
        }
    
    </script>
    </body>

</html>
