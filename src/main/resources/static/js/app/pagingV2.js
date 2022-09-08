function renderPagination(currentPage, bottomSize, listSize, totalPost) {

    // currentPage: 현재 선택된 페이지
    // bottomSize: 하단 네비게이션에 표시될 칸 수
    // listSize: 1개 페이지(화면)에 표시될 게시물 수
    // totalPage: 총 게시물 수
    if (totalPost <= listSize)
        return;

    var totalPageSize = Math.ceil(totalPost / listSize); // 총 페이지 수
    var pageGroup = Math.ceil(currentPage / bottomSize); // 하단에 표시될 페이징 그룹 예) 1~5 일지, 6~10일지
    var last = pageGroup * bottomSize;
    if (last > totalPageSize)
        last = totalPageSize;
    var first = last - (bottomSize - 1) <= 0 ? 1 : last - (bottomSize - 1);
    var next = last + 1;
    var prev = first - 1;

    const fragmentPage = document.createDocumentFragment();

    if (prev > 0) {
        var toFirstPage = document.createElement('li');
        toFirstPage.insertAdjacentHTML("beforeend", `<a class="page-link" href='#js-bottom' id='toFirst'>&lt;&lt;</a>`);
        var toPrev = document.createElement('li');
        toPrev.insertAdjacentHTML("beforeend",`<a class="page-link" href='#js-bottom' id='toPrev'>&lt;</a>`);

        toFirstPage.classList.add("page-item");
        toPrev.classList.add("page-item");

        fragmentPage.appendChild(toFirstPage);
        fragmentPage.appendChild(toPrev);
    }

    for (var i = first; i <= last; i++) {
        const paging = document.createElement("li");

        paging.insertAdjacentHTML("beforeend", `<a class="page-link" href='#js-bottom' id='page-${i}' data-num='${i}'>${i}</a>`);

        paging.classList.add("page-item");

        fragmentPage.appendChild(paging);
    }

    if (last < totalPageSize) {
        var toEndPage = document.createElement("li");
        toEndPage.insertAdjacentHTML("beforeend", `<a class="page-link" href='#js-bottom'  id='toEnd'>&gt;&gt;</a>`);

        var toNext = document.createElement("li");
        toNext.insertAdjacentHTML("beforeend", `<a class="page-link" href='#js-bottom'  id='toNext'>&gt;</a>`);

        toEndPage.classList.add("page-item");
        toNext.classList.add("page-item");

        fragmentPage.appendChild(toNext);
        fragmentPage.appendChild(toEndPage);
    }

    document.getElementById('pagination').appendChild(fragmentPage);

    $(`#pagination a`).removeClass("active");
    $(`#pagination a#page-${currentPage}`).addClass("active");

    // 페이지네이션 페이지를 클릭했을 때 이벤트를 등록해 페이지 숫자를 서버로 넘긴다.
    $('#pagination a').click(function(e) {
        e.preventDefault();
        var $item = $(this);
        var $id = $item.attr("id");
        var selectedPage = $item.text();

        if ($id == "toNext") selectedPage = next;
        if ($id == "toPrev") selectedPage = prev;
        if ($id == "toFirst") selectedPage = 1;
        if ($id == "toEnd") selectedPage = totalPageSize;

        renderPagination(selectedPage, 5, 3, 30);//페이지네이션 그리는 함수
        list.search(selectedPage);//페이지 그리는 함수
    });
};

renderPagination(1, 5, 3, 30);
