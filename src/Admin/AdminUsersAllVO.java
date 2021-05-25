package Admin;

import java.util.Date;

/**
 * 관리자가 보는 회원정보 리스트를 저장하는 클래스
 * @author sist
 */
public class AdminUsersAllVO {
	private String member_id;
	private String member_name;
	private String member_gender;
	private Date member_signDate;
	private String member_withdrawal;
	
	public AdminUsersAllVO() {
	}

	public AdminUsersAllVO(String member_id, String member_name, String member_gender, Date member_signDate,
			String member_withdrawal) {
		this.member_id = member_id;
		this.member_name = member_name;
		this.member_gender = member_gender;
		this.member_signDate = member_signDate;
		this.member_withdrawal = member_withdrawal;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public Date getMember_signDate() {
		return member_signDate;
	}

	public void setMember_signDate(Date member_signDate) {
		this.member_signDate = member_signDate;
	}

	public String getMember_withdrawal() {
		return member_withdrawal;
	}

	public void setMember_withdrawal(String member_withdrawal) {
		this.member_withdrawal = member_withdrawal;
	}
	
	
}//class
