package LookBookComment;

import java.util.Date;

/**
 * 댓글에 대한 정보
 * @author sist
 */
public class LBCommentVO {
	private int cmt_num;
	private String cmt_id;
	private String cmt_comment;
	private Date cmt_date;
	
	public LBCommentVO() {
		super();
	}

	public LBCommentVO(int cmt_num, String cmt_id, String cmt_comment, Date cmt_date) {
		super();
		this.cmt_num = cmt_num;
		this.cmt_id = cmt_id;
		this.cmt_comment = cmt_comment;
		this.cmt_date = cmt_date;
	}

	public int getCmt_num() {
		return cmt_num;
	}

	public void setCmt_num(int cmt_num) {
		this.cmt_num = cmt_num;
	}

	public String getCmt_id() {
		return cmt_id;
	}

	public void setCmt_id(String cmt_id) {
		this.cmt_id = cmt_id;
	}

	public String getCmt_comment() {
		return cmt_comment;
	}

	public void setCmt_comment(String cmt_comment) {
		this.cmt_comment = cmt_comment;
	}

	public Date getCmt_date() {
		return cmt_date;
	}

	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}
	
	
}//class
