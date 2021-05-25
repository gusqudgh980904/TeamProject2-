package Member;

/**
 * 회원정보 조회 클래스
 * @author sist
 */
public class MemberSearchVO {
	private String member_name;
	private String member_phone;
	private String member_email;
	private int member_zipcode;
	private String member_addr;
	private String member_detailedAddr;
	private String member_gender;
	private String member_birth;
	
	public MemberSearchVO() {
		super();
	}

	public MemberSearchVO(String member_name, String member_phone, String member_email, int member_zipcode,
			String member_addr, String member_detailedAddr, String member_gender, String member_birth) {
		super();
		this.member_name = member_name;
		this.member_phone = member_phone;
		this.member_email = member_email;
		this.member_zipcode = member_zipcode;
		this.member_addr = member_addr;
		this.member_detailedAddr = member_detailedAddr;
		this.member_gender = member_gender;
		this.member_birth = member_birth;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public int getMember_zipcode() {
		return member_zipcode;
	}

	public void setMember_zipcode(int member_zipcode) {
		this.member_zipcode = member_zipcode;
	}

	public String getMember_addr() {
		return member_addr;
	}

	public void setMember_addr(String member_addr) {
		this.member_addr = member_addr;
	}

	public String getMember_detailedAddr() {
		return member_detailedAddr;
	}

	public void setMember_detailedAddr(String member_detailedAddr) {
		this.member_detailedAddr = member_detailedAddr;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public String getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	
	
}//class
