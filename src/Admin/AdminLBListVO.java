package Admin;

import java.util.Date;

/**
 * 관리자가 게시판관리를 눌렀을 때 보여줄 게시글 리스트 클래스
 * @author sist
 */
public class AdminLBListVO {
	private int lb_num;
	private String lb_title;
	private String lb_writer;
	private String lb_date;
	
	public AdminLBListVO() {
		super();
	}

	public AdminLBListVO(int lb_num, String lb_title, String lb_writer, String lb_date) {
		super();
		this.lb_num = lb_num;
		this.lb_title = lb_title;
		this.lb_writer = lb_writer;
		this.lb_date = lb_date;
	}

	public int getLb_num() {
		return lb_num;
	}

	public void setLb_num(int lb_num) {
		this.lb_num = lb_num;
	}

	public String getLb_title() {
		return lb_title;
	}

	public void setLb_title(String lb_title) {
		this.lb_title = lb_title;
	}

	public String getLb_writer() {
		return lb_writer;
	}

	public void setLb_writer(String lb_writer) {
		this.lb_writer = lb_writer;
	}

	public String getLb_date() {
		return lb_date;
	}

	public void setLb_date(String lb_date) {
		this.lb_date = lb_date;
	}

	
	
}//class
