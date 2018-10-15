<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />

Projects list:

<br>

<table border="1">
	<tr>
		<th>title</th>
		<th>director</th>
		<th>people</th>
		<th>date</th>
	</tr>
	<c:forEach items="${projects}" var="project">
		<tr>
			<td>${project.title}</td>
			<td>${project.director}</td>
			<td>${project.people}</td>
			<td>From: ${project.fromDate} to ${project.toDate}</td>
		</tr>
	</c:forEach>
</table>

<portlet:renderURL var="addProjectURL">
	<portlet:param name="mvcPath" value="/addProject.jsp" />
</portlet:renderURL>

<br>

<a href="${addProjectURL}">Add project</a>