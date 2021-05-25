package LookBook;

/**
 * 게시글 작성
 * @author sist
 */
public class LBWriteVO {
	private String lbw_id;
	private int lbw_num;
	private String lbw_title;
	private String lbw_content;
	private String lbw_img;
	
	public LBWriteVO() {
		super();
	}

	public LBWriteVO(String lbw_id, int lbw_num, String lbw_title, String lbw_content, String lbw_img) {
		super();
		this.lbw_id = lbw_id;
		this.lbw_num = lbw_num;
		this.lbw_title = lbw_title;
		this.lbw_content = lbw_content;
		this.lbw_img = lbw_img;
	}

	public String getLbw_id() {
		return lbw_id;
	}

	public void setLbw_id(String lbw_id) {
		this.lbw_id = lbw_id;
	}

	public int getLbw_num() {
		return lbw_num;
	}

	public void setLbw_num(int lbw_num) {
		this.lbw_num = lbw_num;
	}

	public String getLbw_title() {
		return lbw_title;
	}

	public void setLbw_title(String lbw_title) {
		this.lbw_title = lbw_title;
	}

	public String getLbw_content() {
		return lbw_content;
	}

	public void setLbw_content(String lbw_content) {
		this.lbw_content = lbw_content;
	}

	public String getLbw_img() {
		return lbw_img;
	}

	public void setLbw_img(String lbw_img) {
		this.lbw_img = lbw_img;
	}
	
	
}//class
