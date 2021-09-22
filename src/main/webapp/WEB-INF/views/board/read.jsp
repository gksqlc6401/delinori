<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %> <!--헤더 붙여넣기( 앞으로 이거 긁어 쓰세요 ) -->

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">자유게시판</h1>
        <a href="/board/list?page=${pageRequestDTO.page}&size=${pageRequestDTO.size}" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i>list</a>
    </div>


    <div class="row">
        <!-- Area Chart -->
        <div class="col-xl-12 row-cols-lg-12 col-lg-12 ">
            <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div
                        class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Earnings Overview</h6>
                    <div class="dropdown no-arrow">
                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                             aria-labelledby="dropdownMenuLink">
                            <div class="dropdown-header">Dropdown Header:</div>
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </div>
                </div>
                <form id="form1">
                <!-- Card Body -->
                <div class="card-body">
                        <div class="form-group">
                            <label for="exampleInputEmail10">BNO</label>
                            <input type="text" name="bno" class="form-control" id="exampleInputEmail10" value="<c:out value="${boardDTO.bno}"></c:out>" readonly>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Title</label>
                            <input type="text" name="title" class="form-control" id="exampleInputEmail1" value="<c:out value="${boardDTO.title}"></c:out>" readonly>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail2">Writer</label>
                            <input type="text" name="writer" class="form-control" id="exampleInputEmail2" value="<c:out value="${boardDTO.writer}"></c:out>" readonly>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <!-- textarea -->
                                <div class="form-group">
                                    <label>Textarea</label>
                                    <textarea name="content" class="form-control" rows="3" disabled><c:out value="${boardDTO.content}"></c:out>
                                        </textarea>
                                </div>
                            </div>
                        </div>
                </div>

                <div class="card-footer">
                    <button type="submit" class="btn btn-danger btnDel">삭제</button>
                </div>
                </form>

            </div>
        </div>
    </div>
</div>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<form id="actionForm" action="/board/list" method="get">
    <input type="hidden" name="page" value="${pageRequestDTO.page}">
    <input type="hidden" name="size" value="${pageRequestDTO.size}">

<%--    <c:if test="${pageRequestDTO.type != null}">--%>
<%--        <input type="hidden" name="type" value="${pageRequestDTO.type}">--%>
<%--        <input type="hidden" name="keyword" value="${pageRequestDTO.keyword}">--%>
<%--    </c:if>--%>
    <%--    하단에 검색창에 보여지는것--%>
</form>

<%@ include file="../includes/footer.jsp" %> <!--푸터 붙여넣기( 앞으로 이거 긁어 쓰세요 ) -->
<script>

    const form = document.querySelector("#form1")

    document.querySelector(".btnDel").addEventListener("click",(e) => {

        e.preventDefault()
        e.stopPropagation()

        form.setAttribute("action", "/board/remove")
        form.setAttribute("method", "post")
        form.submit()

    },false);
</script>

</body>

</html>