package Admin;


/**
 * 관리자의 룩북 게시글 상세조회 클래스
 * @author sist
 */
public class AdminLBDetailVO {
	private int lb_num;
	private String lb_title;
	private String lb_wirter;
	private String lb_content;
	
	public AdminLBDetailVO() {
	}

	public AdminLBDetailVO(int lb_num, String lb_title, String lb_wirter, String  lb_content) {
		this.lb_num = lb_num;
		this.lb_title = lb_title;
		this.lb_wirter = lb_wirter;
		this.lb_content = lb_content;
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

	public String getLb_wirter() {
		return lb_wirter;
	}

	public void setLb_wirter(String lb_wirter) {
		this.lb_wirter = lb_wirter;
	}

	public String  getLb_content() {
		return lb_content;
	}

	public void setLb_content(String  lb_content) {
		this.lb_content = lb_content;
	}


	
}//class
