<%--
  Created by IntelliJ IDEA.
  User: gksql
  Date: 2021-09-28
  Time: 오전 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Deli!</h1>

    <h2><sec:authentication property="principal"></sec:authentication></h2>
    <h2><sec:authentication property="principal.mname"></sec:authentication></h2>
    <h2><sec:authentication property="principal.mid"></sec:authentication></h2>
    <h2><sec:authentication property="principal.maddress"></sec:authentication></h2>
    <h2><sec:authentication property="principal.memail"></sec:authentication></h2>
    <h2><sec:authentication property="principal.mphone"></sec:authentication></h2>

</body>
</html>
