var main = {

    init : function () {
        var _this = this;
        $('#btn-update').on('click', function (){
            _this.update();
        });
    },

    update : function () {
        var data = {
            title : $('#title').val(),
            content : $('#content').val(),
            fileID : $('#file').val(),
            locID : $('#loc').val()
        };
        var id = $('#id').val();

        $.ajax({
            type : 'POST',
            url : '/api/posts/update/'+id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data),

            success : function () {
                alert('성공적으로 수정되었습니다.');
                window.location.href = '/board';
            },
            error : function (error) {
                alert(JSON.stringify(error));
            }
        });
    }
}

main.init();