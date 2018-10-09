<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: boromir
  Date: 04/10/18
  Time: 00:31
  To change this template use File | Settings | File Templates.
--%>

<%-- Ajout projet  --%>
<form:form action="addProjet" method="post" modelAttribute="projet">
    <fieldset>
        <legend>Creer un projet</legend>
        <form:label path="intituleP">Intitule: </form:label>
        <form:input path="intituleP"/><br/>
        <form:label path="descriptionP">Description: </form:label>
        <form:input path="descriptionP"/><br/>

        <div id="c-projetCompetences">
            <form:checkboxes path="competencesRequises" element="li" items="${competences}"/><br>
        </div>
        <form:hidden path="dirigeant" value="${loginCourant}"/>
        <form:errors cssStyle="color:red;"/><br/>
        <form:button type="submit">Ajouter</form:button>
    </fieldset>
</form:form>


<%-- Afficher projets  --%>
<div id="w-projets" class="col-md-8">
    <h4>Projets</h4>
    <select id="selectProjets">
        <option value="0" selected>Tous</option>
        <option value="1">Diriges</option>
        <option value="2">Participe</option>
        <option value="3">competences</option>
    </select>
    <table id="tableProjets">
        <thead>
        <tr>
            <th>Intitule</th>
            <th>Description</th>
            <th>Competences</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${projets}" var="par">
            <tr
                    data-competence="<c:out value="${dataTableProjets[par.intituleP]['hasCompetences']}"/>"
                    data-dirigeant="<c:out value="${dataTableProjets[par.intituleP]['isDirigeant']}"/>"
                    data-participant="<c:out value="${dataTableProjets[par.intituleP]['isParticipant']}"/>"
            >
                <td>${par.intituleP}</td>
                <td>${par.descriptionP}</td>
                <td>
                    <c:forEach items="${par.competencesRequises}" var="parComp">
                        ${parComp.intituleC}&nbsp;
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>