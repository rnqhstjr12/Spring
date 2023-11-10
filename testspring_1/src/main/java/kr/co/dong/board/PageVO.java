package kr.co.dong.board;

import lombok.Data;

@Data
public class PageVO {
   
   //화면에서 넘어오는 페이징 내용
   private int pageNum;
   private int countPerPage;
   
   //검색
   private String keyword;
   private String condition;

   public PageVO() {
      this.pageNum = 1;
      this.countPerPage = 10;
   }
}