package Product;

/**
 * 사용자가 보는 상품 전체 리스트
 * @author sist
 */
public class ProductListUserVO {
	private int prod_num;
	private String prod_name;
	private int prod_price;
	private String prod_img;
	
	public ProductListUserVO() {
		super();
	}

	public ProductListUserVO(int prod_num, String prod_name, int prod_price, String prod_img) {
		super();
		this.prod_num = prod_num;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_img = prod_img;
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

	public String getProd_img() {
		return prod_img;
	}

	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}
	
	
}//class
