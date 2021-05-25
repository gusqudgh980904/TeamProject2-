package Admin;

/**
 * 관리자의 룩북 게시글 상세조회 클래스
 * @author sist
 */
public class AdminLBDetailVO {
	private String lb_title;
	private String lb_content;
	private String lb_img;
	
	public AdminLBDetailVO() {
		super();
	}

	public AdminLBDetailVO(String lb_title, String lb_content, String lb_img) {
		super();
		this.lb_title = lb_title;
		this.lb_content = lb_content;
		this.lb_img = lb_img;
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

	public String getLb_img() {
		return lb_img;
	}

	public void setLb_img(String lb_img) {
		this.lb_img = lb_img;
	}
	
	
}//class
