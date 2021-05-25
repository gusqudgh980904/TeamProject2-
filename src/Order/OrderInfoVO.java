package Order;

/**
 * 주문을 할때 입력하는 정보
 * @author sist
 */
public class OrderInfoVO {
	private int prod_num;
	private String member_id;
	private String[] prod_size;
	private int prod_price;
	private int prod_quantity;
	
	public OrderInfoVO() {
		super();
	}

	public OrderInfoVO(int prod_num, String member_id, String[] prod_size, int prod_price, int prod_quantity) {
		super();
		this.prod_num = prod_num;
		this.member_id = member_id;
		this.prod_size = prod_size;
		this.prod_price = prod_price;
		this.prod_quantity = prod_quantity;
	}

	public int getProd_num() {
		return prod_num;
	}

	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String[] getProd_size() {
		return prod_size;
	}

	public void setProd_size(String[] prod_size) {
		this.prod_size = prod_size;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}

	public int getProd_quantity() {
		return prod_quantity;
	}

	public void setProd_quantity(int prod_quantity) {
		this.prod_quantity = prod_quantity;
	}

	
	
}//class
