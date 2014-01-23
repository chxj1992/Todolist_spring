//登陆模块
define('login',['jquery','bootstrap'],function(require, exports, module) {
    
    var $ = require('jquery');

    exports.noLogin = function() {
        $('#noLogin').text("words Changed");
        $('#myModal').modal('show');
    }
   
});
