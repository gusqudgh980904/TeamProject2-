package LookBook;

/**
 * 사용자가 보는 룩북게시판 전체 리스트
 * @author sist
 */
public class LBListVO {
	private int lb_num;
	private String lb_title;
	private String lb_img;
	
	public LBListVO() {
		super();
	}

	public LBListVO(int lb_num, String lb_title, String lb_img) {
		super();
		this.lb_num = lb_num;
		this.lb_title = lb_title;
		this.lb_img = lb_img;
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

	public String getLb_img() {
		return lb_img;
	}

	public void setLb_img(String lb_img) {
		this.lb_img = lb_img;
	}
	
	
}//class
