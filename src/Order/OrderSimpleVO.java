package Order;

/**
 * 주문 간단 내역
 * @author sist
 */
public class OrderSimpleVO {
	private String Member_id;
	private int prod_num;
	private String order_size;
	private int order_price;
	private int order_quantity;
	
	public OrderSimpleVO() {
		super();
	}

	public OrderSimpleVO(String member_id, int prod_num, String order_size, int order_price, int order_quantity) {
		super();
		Member_id = member_id;
		this.prod_num = prod_num;
		this.order_size = order_size;
		this.order_price = order_price;
		this.order_quantity = order_quantity;
	}

	public String getMember_id() {
		return Member_id;
	}

	public void setMember_id(String member_id) {
		Member_id = member_id;
	}

	public int getProd_num() {
		return prod_num;
	}

	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}

	public String getOrder_size() {
		return order_size;
	}

	public void setOrder_size(String order_size) {
		this.order_size = order_size;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	public int getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}

	
	
}//class
