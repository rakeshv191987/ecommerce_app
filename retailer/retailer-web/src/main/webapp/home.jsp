<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
  <head>
	  <title>Example :: Spring Application</title>
	  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	  <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
	  <script src="js/bootstrap.js"></script>
	  <script src="css/bootstrap.css"></script>
  </head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <h3>Products</h3>
    <c:forEach items="${model.products}" var="prod">
      <c:out value="${prod.productName}"/> <i>$<c:out value="${prod.productPrice}"/></i><br><br>
    </c:forEach>
  </body>
</html>
