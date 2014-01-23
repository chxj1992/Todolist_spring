<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="public/header.jsp" %>

<div class="container">

    <div class="row">
        <div class="col-md-4 col-md-offset-4 page-header">
            <h1> Todo List </h1>
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
                    <form class="form-horizontal" action="/user/doLogin" method="post">
                        <div class="form-group">
                            <label for="userName" class="control-label col-md-3">Username:</label>
                            <div class="col-md-7">
                                <input id="userName" name="userName" type="text" class="form-control" placeholder="root" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="control-label col-md-3">Password:</label>
                            <div class="col-md-7">
                                <input id="password" name="password" type="text" class="form-control" placeholder="123" />
                            </div>
                        </div>
                        <input class="btn btn-primary col-md-offset-8" type="submit" value="Login" />
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>

<div id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Modal title</h4>
            </div>
            <div class="modal-body">
                <p>One fine body&hellip;</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>

    seajs.use(['jquery','<c:url value="/js/login" />'],function($,login){

        $(document).ready(function(){

            $('#noLogin').click(function(){
                login.noLogin();
            });

        });

    });

</script>

<%@include file="public/footer.jsp" %>
