<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="false" %>

<input type="text" name="${id}" id="${id}" <c:if test="not empty value">value="<fmt:formatDate value="${value}" pattern="dd/mm/yyyy" />"</c:if> />

<script type="text/javascript">
	$( "#${id}" ).datepicker({dateFormat: 'dd/mm/yy'})
</script>