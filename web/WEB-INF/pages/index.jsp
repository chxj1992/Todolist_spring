<%@include file="public/header.jsp" %>

    <link rel="stylesheet" href="<c:url value="/css/bs-callout.css" />"/>
</head>

<body>
    <div class="container">

        <div class="row page-header">
            <div class="col-md-2 col-md-offset-5">
                <h1> Todos </h1>
            </div>

            <div class="col-md-3 col-md-offset-1">
                <button id="logout" class="btn btn-danger pull-right">
                    Logout <span class="glyphicon glyphicon-log-out"></span>
                </button>
                <strong style="margin: 10px;" class="pull-right">${user.userName}</strong>
                <div class="pull-right" style="width:32px;">
                    <img class="img-responsive" src="<c:url value="/img/avatar.jpg" />" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <input style="font-size:20px;" class="form-control" type="text" placeholder=" Write new context here ..." />
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div>
                    <%
                        String[] css = {"danger","warning","info"};
                        pageContext.setAttribute("css",css);
                    %>
                    <c:forEach var="content" items="${contents}" varStatus="status">
                        <div class="bs-callout bs-callout-${css[status.index%3]}">
                            ${content.context} : ${content.updateTime}
                            <input name="contentId" type="hidden" value=${content.contentId} />
                            <button type="button" class="close">&times;</button>
                        </div>
                    </c:forEach>
                </div>

            </div>
        </div>

    </div>

    <script>
        seajs.use(['jquery','<c:url value="/js/index" />']);
    </script>

<%@include file="public/footer.jsp" %>
