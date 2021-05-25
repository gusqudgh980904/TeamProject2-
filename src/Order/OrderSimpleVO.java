package Order;

/**
 * 주문 간단 내역
 * @author sist
 */
public class OrderSimpleVO {
	private int order_num;
	private String prod_name;
	private int prod_price;
	private int prod_quantity;
	
	public OrderSimpleVO() {
		super();
	}

	public OrderSimpleVO(int order_num, String prod_name, int prod_price, int prod_quantity) {
		super();
		this.order_num = order_num;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_quantity = prod_quantity;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
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
