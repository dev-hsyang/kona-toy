function renderPagination(currentPage, bottomSize, listSize, totalPage) {

    // currentPage: 현재 선택된 페이지
    // bottomSize: 하단 네비게이션에 표시될 칸 수
    // listSize: 1개 페이지(화면)에 표시될 게시물 수
    // totalPage: 총 게시물 수
    if(totalPage <= listSize)
        return;

    var totalPageSize = Math.ceil(totalPage / listSize); // 총 페이지 수
    var pageGroup = Math.ceil(currentPage/bottomSize);

    var last = pageGroup * bottomSize;
    if(last > totalPageSize)
        last = totalPageSize;
    var first = last - (bottomSize - 1) <= 0 ? 1 : last - (bottomSize - 1);

    const fragmentPage = document.createDocumentFragment();




}