<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    댓글 목록 <br>
  <table class="table">
   <form>
   <div class="form-group1">
   <c:forEach var="boardreply" items="${list}">
      <tr>
         <td>작성자 : ${boardreply.rewriter}    작성일자 : ${boardreply.redate} </td>
      </tr>
      <tr>
         <td><textarea name="rememo" rows="5" cols="40"
            readonly="readonly" class="form-control1">${boardreply.rememo}</textarea>
            <input type="hidden" name="bno" value="${boardreply.bno }" />
         </td>
         <td>
         	<a href="replyupdate?reno=${boardreply.reno}">댓글수정</a>   
			<a href="replyDelete?reno=${boardreply.reno}&bno=${boardreply.bno}">댓글삭제</a>
		</td>
         <button class="btn btn-defalut">댓글수정</button>
         <script>
         $(function(){
            //댓글수정 버튼을 눌렀을 때 처리
            $(".btn-defalut").click(function(){
               location.href="replyupdate?reno=" + ${boardreply.reno}; 
            });
         })      
         </script>
         </td>
      </tr>
   </c:forEach>
   </table>
   </div>
         

</form>   
    </section>