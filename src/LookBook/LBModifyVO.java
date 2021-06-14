package LookBook;

public class LBModifyVO {
	private String lbw_id;
	private int lbw_num;
	private String lbw_title;
	private String lbw_content;
	private String lbw_write_date;
	
	public LBModifyVO() {
		super();
	}

	public LBModifyVO(String lbw_id, int lbw_num, String lbw_title, String lbw_content, String lbw_write_date) {
		super();
		this.lbw_id = lbw_id;
		this.lbw_num = lbw_num;
		this.lbw_title = lbw_title;
		this.lbw_content = lbw_content;
		this.lbw_write_date = lbw_write_date;
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

	public String getLbw_write_date() {
		return lbw_write_date;
	}

	public void setLbw_write_date(String lbw_write_date) {
		this.lbw_write_date = lbw_write_date;
	}

	
	
}
