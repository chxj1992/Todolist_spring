//content
define('content',['jquery','bootstrap','user','utils/datetime'],function(require, exports, module) {


    var $ = require('jquery');
    var user = require('user');
    var datetime = require('datetime');

    $(document).ready(function(){

        $('#logout').click(function(){
            user.logout();
        });

        $("#new-content").keypress(function (event){
            if( event.keyCode == 13 && $("#new-content").val != "" )
                addContent();
        });

        $(".remove-content").click(function(){
            var contentId = $(this).val();
            removeContent(contentId);
        });

        $(".content-context").dblclick(function(){
            $(this).hide();
            var contentInput = $("#content-"+$(this).attr("content-id")+"-input > input");
            //好像是个浏览器BUG ...
            contentInput.val(contentInput.val());
            contentInput.parent().show();
            contentInput.focus();
        });

        $(".content-input > input").blur(function(){
            var contentId = $(this).parent().attr("content-id");
            if ( $(this).val().trim() != $("#content-"+contentId+"-context > span").text().trim() )
                updateContent(contentId, $(this).val());

            $(this).parent().hide();
            $("#content-"+contentId+"-context").show();
        });

    });

    function addContent() {
         $.ajax({
            url:'/content/add',
            method:'POST',
            dataType:'Json',
            data:{
                'content':$("#new-content").val()
            },
            success:function(data){

                if (data.status == 1){
                    window.location.reload();
                } else {
                    $("#content-alert").fadeIn();
                    $("#content-error-info").text(data.info);
                    setTimeout(function(){
                        $("#content-alert").fadeOut();
                    },3000);
                }
            }
        });
    }

    function removeContent(contentId) {

        $.ajax({
            url:'/content/remove',
            method:'POST',
            dataType:'Json',
            data:{
                'contentId': contentId
            },
            success:function(data){
                if (data.status == 1){
                    $("#content-"+contentId).fadeOut();
                } else {
                    $("#content-alert").fadeIn();
                    $("#content-error-info").text(data.info);
                    setTimeout(function(){
                        $("#content-alert").fadeOut();
                    },3000);
                }
            }
        });
    }

    function updateContent(contentId, content) {
        $.ajax({
            url:'/content/update',
            method:'POST',
            dataType:'Json',
            data:{
                'contentId': contentId,
                'content': content
            },
            success:function(data){

                if (data.status == 1){
                    $("#content-"+contentId+"-context > span").text(content);
                    $("#content-"+contentId+"-context > small").text(datetime.format('yyyy-MM-dd HH:mm:ss'));
                } else {
                    $("#content-alert").fadeIn();
                    $("#content-error-info").text(data.info);
                    setTimeout(function(){
                        $("#content-alert").fadeOut();
                    },3000);
                }
            }
        });
    }


});

