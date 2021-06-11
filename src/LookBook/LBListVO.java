package LookBook;


/**
 * 사용자가 보는 룩북게시판 전체 리스트
 * @author sist
 */
public class LBListVO {
	private int lb_num;
	private String lb_title;
	private String lb_content;
	private String lb_writeDate;
	private String member_id;
	
	public LBListVO() {
		super();
	}

	public LBListVO(int lb_num, String lb_title, String lb_content, String lb_writeDate, String member_id) {
		super();
		this.lb_num = lb_num;
		this.lb_title = lb_title;
		this.lb_content = lb_content;
		this.lb_writeDate = lb_writeDate;
		this.member_id = member_id;
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

	public String getLb_content() {
		return lb_content;
	}

	public void setLb_content(String lb_content) {
		this.lb_content = lb_content;
	}

	public String getLb_writeDate() {
		return lb_writeDate;
	}

	public void setLb_writeDate(String lb_writeDate) {
		this.lb_writeDate = lb_writeDate;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


}//class
