package Member;

/**
 * 회원가입 시 입력해야하는 정보를 저장하는 클래스
 * @author sist
 */
public class MemberVO {
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_phone;
	private String member_email;
	private int member_zipcode;
	private String member_addr;
	private String member_detailedAddr;
	private String member_gender;
	private String member_birth;
	private String member_signDate;
	private String member_withdrawsal;
	
	
	public MemberVO() {
		super();
	}


	public MemberVO(String member_id, String member_pw, String member_name, String member_phone, String member_email,
			int member_zipcode, String member_addr, String member_detailedAddr, String member_gender,
			String member_birth, String member_signDate, String member_withdrawsal) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_phone = member_phone;
		this.member_email = member_email;
		this.member_zipcode = member_zipcode;
		this.member_addr = member_addr;
		this.member_detailedAddr = member_detailedAddr;
		this.member_gender = member_gender;
		this.member_birth = member_birth;
		this.member_signDate = member_signDate;
		this.member_withdrawsal = member_withdrawsal;
	}


	/**
	 * @return the member_id
	 */
	public String getMember_id() {
		return member_id;
	}


	/**
	 * @param member_id the member_id to set
	 */
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	/**
	 * @return the member_pw
	 */
	public String getMember_pw() {
		return member_pw;
	}


	/**
	 * @param member_pw the member_pw to set
	 */
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}


	/**
	 * @return the member_name
	 */
	public String getMember_name() {
		return member_name;
	}


	/**
	 * @param member_name the member_name to set
	 */
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


	/**
	 * @return the member_phone
	 */
	public String getMember_phone() {
		return member_phone;
	}


	/**
	 * @param member_phone the member_phone to set
	 */
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}


	/**
	 * @return the member_email
	 */
	public String getMember_email() {
		return member_email;
	}


	/**
	 * @param member_email the member_email to set
	 */
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}


	/**
	 * @return the member_zipcode
	 */
	public int getMember_zipcode() {
		return member_zipcode;
	}


	/**
	 * @param member_zipcode the member_zipcode to set
	 */
	public void setMember_zipcode(int member_zipcode) {
		this.member_zipcode = member_zipcode;
	}


	/**
	 * @return the member_addr
	 */
	public String getMember_addr() {
		return member_addr;
	}


	/**
	 * @param member_addr the member_addr to set
	 */
	public void setMember_addr(String member_addr) {
		this.member_addr = member_addr;
	}


	/**
	 * @return the member_detailedAddr
	 */
	public String getMember_detailedAddr() {
		return member_detailedAddr;
	}


	/**
	 * @param member_detailedAddr the member_detailedAddr to set
	 */
	public void setMember_detailedAddr(String member_detailedAddr) {
		this.member_detailedAddr = member_detailedAddr;
	}


	/**
	 * @return the member_gender
	 */
	public String getMember_gender() {
		return member_gender;
	}


	/**
	 * @param member_gender the member_gender to set
	 */
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}


	/**
	 * @return the member_birth
	 */
	public String getMember_birth() {
		return member_birth;
	}


	/**
	 * @param member_birth the member_birth to set
	 */
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}


	/**
	 * @return the member_signDate
	 */
	public String getMember_signDate() {
		return member_signDate;
	}


	/**
	 * @param member_signDate the member_signDate to set
	 */
	public void setMember_signDate(String member_signDate) {
		this.member_signDate = member_signDate;
	}


	/**
	 * @return the member_withdrawsal
	 */
	public String getMember_withdrawsal() {
		return member_withdrawsal;
	}


	/**
	 * @param member_withdrawsal the member_withdrawsal to set
	 */
	public void setMember_withdrawsal(String member_withdrawsal) {
		this.member_withdrawsal = member_withdrawsal;
	}

	
}//class
