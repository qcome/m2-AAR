<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: o2122505
  Date: 04/10/18
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <h3 class="ml-auto mr-auto mb-5 mt-3">TD 3 AAR</h3>
    </div>
    <div class="row">
        <form:form action="/inscription/" method="post" cssClass="ml-auto mr-auto" modelAttribute="membre">
            <div class="form-group">
                <form:label path="login">Login</form:label>
                <form:input cssClass="form-control" path="login"/>
                <spring:bind path="login">
                    <c:if test="${status.error}">
                        <form:errors path="login" cssStyle="color:red;"/><br/>
                    </c:if>
                </spring:bind>
            </div>
            <div class="form-group">
                <form:label path="motdepasse">Mot de passe</form:label>
                <form:input cssClass="form-control" type="password" path="motdepasse"/>
                <spring:bind path="motdepasse">
                    <c:if test="${status.error}">
                        <form:errors path="motdepasse" cssStyle="color:red;"/><br/>
                    </c:if>
                </spring:bind>
            </div>
                <div class="form-group">
                <form:label path="surnom">Surnom</form:label>
                <form:input cssClass="form-control" path="surnom"/>
                <spring:bind path="surnom">
                    <c:if test="${status.error}">
                        <form:errors path="surnom" cssStyle="color:red;"/><br/>
                    </c:if>
                </spring:bind>
            </div>
            <button type="submit">Inscription</button>
            <a class="ml-auto mr-auto" href="/">Connexion</a>
        </form:form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>

</html>
