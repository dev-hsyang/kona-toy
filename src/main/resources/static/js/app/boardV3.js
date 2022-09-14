var grid = new tui.Grid({
    el: document.getElementById('grid'),
    // el: $('#grid')[0],
    scrollX: true,
    scrollY: false,
    columns: [
        {
            header: 'No',
            name: 'id',
            width: 50
        },
        {
            header: '제 목',
            name: 'title',
            width: 700
        },
        {
            header: '작 성 자',
            name: 'userID',
            width: 150,
        },
        {
            header: '소 속',
            name: 'clubID'
        },
        {
            header: '조 회 수',
            name: 'hits',
            width: 100,
            // sortable: true
        },
        {
            header: '날 짜',
            name: 'createdate',
            width: 200,
            editor: {
                type: 'datePicker',
                options: {
                    format: 'yyyy-MM-dd'
                }
            }
            // sortable: true
        },
    ]
});
tui.Grid.applyTheme('striped');

var main = {
    init : function (){

        var _this = this;
        _this.pageDefault();
        _this.pageClick();
    },

    pageDefault : function() {
        var data = {

        }
        $.ajax({
            type: "POST",
            url: "/api/posts/paging",
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),

            success : function (data) {
                grid.resetData(data.content);
                renderPagination(1, 5, data.size, data.totalElements)
            },
            error : function (error) {
                alert(JSON.stringify(error));
            }
        });
    },

    pageClick : function () {
    }
};

grid.on('click', e => {
    let row = e.instance.getRow(e.rowKey);
    location.href = '/posts/view/' + row.id;
});

main.init();



