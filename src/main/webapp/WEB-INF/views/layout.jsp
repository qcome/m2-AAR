<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <title><tiles:insertAttribute name="title" /></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <style type="text/css">

    </style>
</head>
<body>
<div class="wrapper">
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3>AAR</h3>
        </div>

        <ul class="list-unstyled components">
            <p>TP3</p>
            <li>
                <a href="/menu/">Home</a>
            </li>
            <li>
                <a href="/competences/">Competences</a>
            </li>
            <li>
                <a href="/projets/">Projets</a>
            </li>
            <li>
                <a href="/logout/">Deconnexion</a>
            </li>
        </ul>
    </nav>
    <div class="container" id="content">
        <div class="row" id="header">
            <h4><tiles:insertAttribute name="header"/></h4>
        </div>
        <tiles:insertAttribute name="body"/>
    </div>
</div>
</body>
</html>