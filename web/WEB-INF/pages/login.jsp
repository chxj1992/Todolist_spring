<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="public/header.jsp" %>

</head>
<body>

    <div class="container">

        <div class="row">
            <div class="col-md-2 col-md-offset-5 page-header">
                <h1> Todos </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <strong> Login Or </strong> &nbsp;
                        <button id="noLogin" class="btn btn-warning">
                            Not <span class="glyphicon glyphicon-log-in"></span>
                        </button>
                    </div>
                    <div class="panel-body">
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label for="userName" class="control-label col-md-3">Username:</label>
                                <div class="col-md-7">
                                    <input id="userName" type="text" class="form-control" placeholder="root" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="control-label col-md-3">Password:</label>
                                <div class="col-md-7">
                                    <input id="password" type="text" class="form-control" placeholder="123" />
                                </div>
                            </div>
                            <div class="form-group">
                                <button id="doLogin" class="btn btn-primary col-md-offset-8">Login</button>
                            </div>
                            <div id="login-alert" class="hide">
                                <div class="alert alert-danger col-md-10">
                                    <strong>登陆失败:</strong> <span id="login-error-info"></span>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <script>
        seajs.use(['jquery','<c:url value="/js/user" />']);
    </script>

<%@include file="public/footer.jsp" %>
