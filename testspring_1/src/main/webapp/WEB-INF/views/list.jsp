<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ page session="false" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<%@ include file="include/head.jsp" %>
<%@ include file="include/plug_in.jsp" %>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  
  <%@ include file="include/main_header.jsp" %>
  
  <!-- Left side column. contains the logo and sidebar -->

  <%@ include file="include/left_column.jsp" %>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1> Page Header
        <div class="box">
      <div class="box-header with-border">
         <a href="${contextPath}/board/register"><h3 class="box-title">게시판 글쓰기</h3></a>
      </div>
      </div>
        <small>Optional description</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">
       <div class="box-header with-border">
         <c:if test="${user==null }">
         <a href="${contextPath}/board/login"> <h3 class="box-title">로그인</h3></a>
         </c:if>
         <c:if test="${user!=null }">
         ${user.name }님 환영합니다. <br />
         <a href="${contextPath}/board/logOut"> <h3 class="box-title">로그아웃</h3></a>
         </c:if>
      </div>
      <div>${msg}</div>
      <div class="table-responsive">
        <table class="table">
        <tr>
           <td>글번호</td>
           <td>제목</td>
           <td>작성일</td>
           <td>작성자</td>
           <td>조회수</td>
        </tr>
      <c:forEach var="board" items="${list }">
          <tr>
          <td>${board.bno}</td>
          <td><a href="detail?bno=${board.bno}"> ${board.title} </a></td>
          <td>${board.regdate}</td>
          <td>${board.id}</td>
          <td><span class="badge">${board.readcnt }</span></td>
          </tr>
      </c:forEach>
      <tr>
         <td colspan="5" align="center">
            <input class="btn btn-success" type="button" value="메인으로"   id="main" />      
         </td>
      </tr>
        </table>
           
      </div>
      
       <!-- 페이징 -->
        
         <div class="paging">
               <form action="<c:url value='/board/list' />" name="pageForm">
                           <div class="text-center clearfix">
                               <ul class="pagination" id="pagination">
                                  <c:if test="${pc.prev}">
                                      <li class="page-item "><a  class="page-link" href="#" data-pageNum="${pc.beginPage-1}">Prev</a></li>
                                   </c:if>
                                   
                                   <c:forEach var="num" begin="${pc.beginPage}" end="${pc.endPage}">
                                      <li class="${pc.paging.pageNum == num ? 'age-item active' : ''}" page-item><a class="page-link" href="#" data-pageNum="${num}">${num}</a></li>
                                   </c:forEach>
                                   
                                   <c:if test="${pc.next}">
                                        <li class="page-item"><a class="page-link" href="#" data-pageNum="${pc.endPage+1}">Next</a></li>
                                   </c:if>
                               </ul>
                               
                               <!-- 페이지 관련 버튼을 클릭 시 같이 숨겨서 보낼 값 -->
                               <input type="hidden" name="pageNum" value="${pc.paging.pageNum}">
                               <input type="hidden" name="countPerPage" value="${pc.paging.countPerPage}">
             
                               
                           </div>
                        </form>
         </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<script>
   $(function() {
      $('.whyBtn').click(function() {
         location.href = '<c:url value="/board/list"/>';
      })
      $('#pagination').on('click', 'a', function(e) {
         e.preventDefault();
         console.log($(this));
         const value = $(this).data('pagenum');
         console.log(value);
         document.pageForm.pageNum.value = value;
         document.pageForm.submit();
      });
      
   })
</script>
  <!-- Main Footer -->
  <%@ include file="include/main_footer.jsp" %>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane active" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="pull-right-container">
                    <span class="label label-danger pull-right">70%</span>
                  </span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
</body>
</html>