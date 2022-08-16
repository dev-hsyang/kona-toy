var main = {

    init : function(){
        var _this = this;
        $('#btn-signUp').on('click', function(){
            _this.signUp();
        });
        $('#btn-save').on('click', function (){
            alert("btn-save clicked");
            _this.save();
        });
    },

    signUp : function () {
        var data = {
            username : $('#username').val(),
            password : $('#password').val(),
            nickname : $('#nickname').val()
        };

        $.ajax({
            type: "POST",
            url: '/api/join',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (){
            alert('Sign Up Complete.');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },

    save : function () {
        var data = {
            title: $('#title').val(),
            clubID: $('#club').val(),
            fileID: $('#fileID').val(),
            locID: $('#locID').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: "POST",
            url: "/api/posts",
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (){
            alert('글이 등록되었습니다.');
            window.location.href = "/board";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();