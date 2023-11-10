/*
table : board
columns :
bno int AI PK 
title varchar(45) 
content varchar(45) 
id varchar(45) 
regdate datetime 
readcnt int 
etc varchar(45)
 */

package kr.co.dong.board;

import lombok.Data;

@Data
public class BoardDTO {
	
	private int bno;
	private String title;
	private String content;
	private String id;
	private String regdate;
	private int readcnt;
	private String etc;
	private int del;
	
}
