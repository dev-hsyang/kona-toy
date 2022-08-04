var main = {
    init : function(){
        var _this = this;
        $('#btn-signUp').on('click', function(){
            _this.signUp();
        });
    },

    signUp : function (){
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
    }
};

main.init();