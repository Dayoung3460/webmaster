<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.yedam.vo.BoardVO"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<div class="p-3">
<h3>글 목록</h3>


<%
List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList");
SearchDTO search = (SearchDTO) request.getAttribute("search");
PageDTO paging = (PageDTO) request.getAttribute("paging");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<form class="row g-3 mt-2 mb-4" action="boardList.do" method="get">
<div class="col-md-4">
    <select name="searchCondition" class="form-select">
      <option value="" <%=search.getSearchCondition().equals("") ? "selected" : "" %> >선택하세요</option>
      <option value="title" <%=search.getSearchCondition().equals("title") ? "selected" : "" %>>제목</option>
      <option value="writer" <%=search.getSearchCondition().equals("writer") ? "selected" : "" %>>작성자</option>
      <option value="titleAndWriter" <%=search.getSearchCondition().equals("titleAndWriter") ? "selected" : "" %>>제목 & 작성자</option>
    </select>
  </div>
  <div class="col-md-2">
    <input type="text" class="form-control" name="keyword" value="<%=search.getKeyword()%>">
  </div>
  <div class="col-md-2">
    <button type="submit" class="btn btn-primary">조회</button>
  </div>
  <!--  
  <div class="col-md-2">
    <button type="submit" class="btn btn-warning">검색 초기화</button>
  </div>
  -->
</form>


<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
	</thead>
	<tbody>
		<%
		for (BoardVO board : boardList) {
			String wdate = sdf.format(board.getWriteDate());
		%>
		<tr>
			<td><%=board.getBoardNo()%></td>
			<td><a href="board.do?bno=<%=board.getBoardNo()%>&currentPage=<%=paging.getCurrentPage() %>&searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword()%>"><%=board.getTitle()%></a></td>
			<td><%=board.getWriter()%></td>
			<td><%=wdate%></td>
			<td>
			</td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
  <%if(paging.isPrev()){ %>
    <li class="page-item">
      <a class="page-link" href="boardList.do?currentPage=<%=paging.getStartPage() - 1 %>&searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword()%>">Previous</a>
    </li>
     <%} else {%>
     <li class="page-item disabled">
      <a class="page-link">Previous</a>
    </li>
     <%}%>
     
    <%for (int p = paging.getStartPage(); p <= paging.getEndPage(); p++) {
    	if(paging.getCurrentPage() == p) {
    %>
    <li class="page-item active" aria-current="page"><a class="page-link" href="boardList.do?currentPage=<%=p%>&searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword()%>"><%=p%></a></li>
    <%} else { %> 
    <li class="page-item"><a class="page-link" href="boardList.do?currentPage=<%=p%>&searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword()%>"><%=p%></a></li>
    	<%} %> 
    <%} %> 
    
    <%if(paging.isNext()){ %>
    <li class="page-item">
      <a class="page-link" href="boardList.do?currentPage=<%=paging.getEndPage() + 1 %>&searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword()%>">Next</a>
    </li>
     <%} else {%>
     <li class="page-item disabled">
      <a class="page-link">Next</a>
    </li>
     <%}%>
    
  </ul>
</nav>
</div>
<jsp:include page="../includes/footer.jsp"></jsp:include>