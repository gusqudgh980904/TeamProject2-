package Order;

/**
 * 주문 상세내역
 * @author sist
 */
public class OrderDetailVO {
	private int prod_num;
	private String prod_name;
	private int prod_price;
	private int order_num;
	private String order_size;
	private int order_quantity;
	
	public OrderDetailVO() {
		super();
	}

	public OrderDetailVO(int prod_num, String prod_name, int prod_price, int order_num, String order_size,
			int order_quantity) {
		super();
		this.prod_num = prod_num;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.order_num = order_num;
		this.order_size = order_size;
		this.order_quantity = order_quantity;
	}

	public int getProd_num() {
		return prod_num;
	}

	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
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

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public String getOrder_size() {
		return order_size;
	}

	public void setOrder_size(String order_size) {
		this.order_size = order_size;
	}

	public int getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	
	
}//class
