<%@include file="public/header.jsp" %>

<strong> 用户名: </strong> ${user.userName}
<hr/>
<form action="/content/add" method="post">
    <input name="context" type="text" placeholder="write new context here" />
    <input type="submit" value="submit" />
</form>

<c:forEach var="content" items="${contents}">
    <form action="/content/remove" method="post">
        ${content.context} : ${content.updateTime}
        <input name="contentId" type="hidden" value=${content.contentId} />
        <input type="submit" value="remove" />
        <br />
    </form>
</c:forEach>


</body>


<script type="text/javascript">
    $(document).ready(function(){
        alert("test js");
    });
</script>

</html>
