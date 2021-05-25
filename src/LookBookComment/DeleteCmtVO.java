package LookBookComment;

/**
 * 댓글을 삭제할 때 필요한 클래스
 * @author sist
 */
public class DeleteCmtVO {
	private int cmt_num;
	private String cmt_id;
	
	public DeleteCmtVO() {
		super();
	}

	public DeleteCmtVO(int cmt_num, String cmt_id) {
		super();
		this.cmt_num = cmt_num;
		this.cmt_id = cmt_id;
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
	
	
}//class
