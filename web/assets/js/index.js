//主页
define('index',['jquery','bootstrap','user'],function(require, exports, module) {


    var $ = require('jquery');
    var user = require('user');

    $(document).ready(function(){

        $('#logout').click(function(){
            user.logout();
        });

    });

});

