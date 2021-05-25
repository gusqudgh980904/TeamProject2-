package Order;

/**
 * 주문을 수정할 때 사용하는 클래스
 * @author sist
 */
public class OrderModifyVO {
	private String[] prod_size;
	private int prod_quantity;
	
	public OrderModifyVO() {
		super();
	}

	public OrderModifyVO(String[] prod_size, int prod_quantity) {
		super();
		this.prod_size = prod_size;
		this.prod_quantity = prod_quantity;
	}

	public String[] getProd_size() {
		return prod_size;
	}

	public void setProd_size(String[] prod_size) {
		this.prod_size = prod_size;
	}

	public int getProd_quantity() {
		return prod_quantity;
	}

	public void setProd_quantity(int prod_quantity) {
		this.prod_quantity = prod_quantity;
	}
	
	
}//class
