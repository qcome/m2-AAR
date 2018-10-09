<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: boromir
  Date: 03/10/18
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Ajout compétences  --%>
<form:form action="addCompetenceMembre" method="post" modelAttribute="competenceMembre">
    <fieldset>
        <legend>Ajouter une compétence</legend>
        <form:label path="competence">Compétence disponibles: </form:label>
        <form:select path="competence" id="selectCompetence">
            <c:forEach items="${competencesDispo}" var="par">
                <form:option value="${par.intituleC}">
                    <c:out value="${par.intituleC}"/>
                </form:option>
            </c:forEach>
        </form:select><br/>
        <form:label path="niveau">Niveau: </form:label>
        <form:input path="niveau"/><br/>
        <form:label path="commentaire">Commentaire: </form:label>
        <form:input path="commentaire"/><br/>
        <form:errors path="commentaire" cssStyle="color:red;"/>
        <form:errors cssStyle="color:red;"/><br/>
        <form:button type="submit">Ajouter</form:button>
    </fieldset>
</form:form>


<%-- get compétences membre  --%>
<fieldset>
    <legend>Mes compétences</legend>
    <c:choose>
        <c:when test="${fn:length(competencesMembre) gt 0}">
            <table>
                <thead>
                <tr>
                    <th>Intitulé</th>
                    <th>Niveau</th>
                    <th>Commentaire</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${competencesMembre}" var="par">
                    <tr>
                        <td>${par.competence.intituleC}</td>
                        <td>${par.niveau}</td>
                        <td>${par.commentaire}</td>
                        <td><a href="/competences/delete/${par.competence.intituleC}">Supprimer</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            Aucune compétence enregistrée.
        </c:otherwise>
    </c:choose>
</fieldset>


