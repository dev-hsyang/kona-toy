var main = {

    init : function () {
        var _this = this;
        $('#btn-deleteUser').on('click', function (){
            _this.delete();
        });
    },

    delete : function () {
        var id = $('#userID').val();

        $.ajax({
            type: 'POST',
            url: "/api/mypage/delete/" + id,

            success : function () {
                alert('회원탈퇴 성공했습니다.');
                window.location.href = '/board';
            },
            error : function (error){
                alert(JSON.stringify(error));
            }
        })
    }
}
main.init();