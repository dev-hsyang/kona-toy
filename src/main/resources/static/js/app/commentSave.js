var main = {

    init : function() {
        var _this = this;
        $('#btn-comment-save').on('click', function (){
            _this.saveComment();
        });
    },

    saveComment : function () {

        var data = {
            content : $('#comment').val()
        }
        var postID = $('#postID').val();

        if(!data.content || data.content.trim() === ""){
            alert("공백 또는 입력하지 않은 부분이 있습니다.");
            return false;
        }

        $.ajax({
            type : 'POST',
            url :'/api/posts/' + postID + '/comments',
            dataType : 'text', // url과 매핑되는 컨트롤러에서 json타입을 던지지 않기에 parse error가 발생한다.
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data),

            success : function (data) {
                alert('댓글이 등록되었습니다.');
                window.location.reload();
            },
            error : function (error) {
                alert(JSON.stringify(error));
            }
        });
    }
}

main.init();