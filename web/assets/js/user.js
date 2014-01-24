//登陆模块
define('user',['jquery','bootstrap'],function(require, exports, module) {
    
    var $ = require('jquery');

    $(document).ready(function(){

        $('#noLogin').click(function(){
            noLogin();
        });

        $("#doLogin").click(function(){
            login();
        });

        $("#password").keypress(function (event){
            if( event.keyCode == 13 && $("#userName").val != "" && $("#password").val() != "" )
                login();
        });

    });

    // Functions
    function noLogin() {
        $.ajax({
            url:'/user/noLogin',
            method:'POST',
            dataType:'Json',
            success:function(){
                window.location.reload();
            }
        });
    }

    function login(){
         $.ajax({
            url:'/user/doLogin',
            method:'POST',
            dataType:'Json',
            data:{
                'userName':$("#userName").val(),
                'password':$("#password").val()
            },
            success:function(data){
                if (data.status == 1){
                    window.location.reload();
                } else {
                    $("#login-alert").removeClass();
                    $("#login-error-info").text(data.info);
                }
            }
        });
    }

    exports.logout = function(){
        $.ajax({
            url:'/user/logout',
            method:'POST',
            dataType:'Json',
            success:function(){
                window.location.reload();
            }
        });
    }

});
