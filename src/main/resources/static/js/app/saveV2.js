const Editor = toastui.Editor;
const editor = new Editor({
    el: document.querySelector('#editor'),
    height: '600px',
    initialEditType: 'wysiwyg',
    previewHighlight: false,
    previewStyle: 'vertical',
    hooks: {
        addImageBlobHook: (blob, callback) => {
            const formData = new FormData();
            formData.append('image', blob);
            let url='/images/';

            $.ajax({
                type: 'POST',
                enctype: 'multipart/form-data',
                data: formData,
                dataType: 'json',
                processData: false,
                contentType: false,
                cache: false,
                success: function (data) {
                    url += data.filename;
                    callback(url, '사진 대체 텍스트 입력');
                },
                error: function(error) {
                    callback('image_load_fail', '사진 대체 텍스트 입력');
                }
            });
        }
    }
});

var main = {

    init : function () {
        var _this = this;

        $('#btn-save').on('click', function (){
            _this.save();
        })
    },

    save : function () {
        var data = {
            title: $('#title').val(),
            clubID: $('#club').val(),
            fileID: $('#fileID').val(),
            locID: $('#locID').val(),
            content: editor.getMarkdown()
        };

        $.ajax({
            type: "POST",
            url: "/api/posts",
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),

            success: function(){
                alert('글이 등록되었습니다.');
                window.location.href = "/board";
            },
            error: function (error) {
                alert(JSON.stringify(error));
            }
        });
    }
}

main.init();