<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />

Add new project:

<br>

<portlet:actionURL name="addProject" var="saveURL">
</portlet:actionURL>

<div>
	<form action="${saveURL}" method="post">
		<div>Title: <input type="text" name="title" /></div>
		<div>Description: <input type="text" name="description" /></div>
		<div>Director: <input type="text" name="director" /></div>
		<div>People: <input type="text" name="people" /></div>
		<div>Comments: <input type="text" name="comments" /></div>
		<br>
		<input type="submit" />
	</form>
</div>
