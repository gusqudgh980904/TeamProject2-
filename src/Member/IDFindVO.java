package Member;


/**
 * 아이디 찾기에 성공했을 때 제공할 데이터를 저장하는 VO
 * @author sist
 */
public class  IDFindVO{
	private String member_id;
	private String member_signDate;
	
	public IDFindVO() {
		super();
	}
	
	public IDFindVO(String member_id, String member_signDate) {
		super();
		this.member_id = member_id;
		this.member_signDate = member_signDate;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_signDate() {
		return member_signDate;
	}

	public void setMember_signDate(String member_signDate) {
		this.member_signDate = member_signDate;
	}
	
	
}//class
