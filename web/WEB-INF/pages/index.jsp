<%@include file="public/header.jsp" %>

    <link rel="stylesheet" href="<c:url value="/css/bs-callout.css" />"/>
</head>

<body>
    <div class="container">

        <div class="row page-header">
            <div class="col-md-3 col-md-offset-5">
                <h1 class="col-md-offset-1"> Todos </h1>
                <h3><small>Double-click to edit a todo</small></h3>
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
                <div id="content-input">
                    <input id="new-content" style="font-size:20px;" class="form-control" type="text" placeholder=" What needs to be done?" />
                </div>
                <div id="content-alert" style="display: none;margin-top:10px;">
                    <div class="alert alert-danger col-md-10">
                        <strong>Error:</strong> <span id="content-error-info"></span>
                    </div>
                </div>

            </div>
        </div>

        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div id="contents">
                    <%
                        String[] css = {"danger","warning","info"};
                        pageContext.setAttribute("css",css);
                    %>
                    <c:forEach var="content" items="${contents}" varStatus="status">
                        <div id="content-${content.contentId}" class="bs-callout bs-callout-${css[status.index%3]}">
                            <button type="button" class="close remove-content" value="${content.contentId}">&times;</button>
                            <p class="content-context" id="content-${content.contentId}-context" content-id="${content.contentId}">
                                <span> ${content.context} </span>
                                <small class="text-muted" style="margin-left: 10px;">${content.updateTime}</small>
                            </p>
                            <div class="col-md-10 content-input" content-id="${content.contentId}" id="content-${content.contentId}-input" style="display: none;">
                                <input class="form-control" type="text" value="${content.context}" />
                            </div>
                            <div style="clear: both;"></div>
                        </div>
                    </c:forEach>
                </div>

            </div>
        </div>

    </div>

    <script>
        seajs.use(['jquery','<c:url value="/js/content" />']);
    </script>

<%@include file="public/footer.jsp" %>
