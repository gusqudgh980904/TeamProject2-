package Product;

/**
 * 상품 메인, 상하의 화면
 * @author sist
 */
public class ProductMainVO {
	private int prod_num;
	private String prod_name;
	private String prod_img;
	private int prod_price;
	
	public ProductMainVO() {
		super();
	}

	public ProductMainVO(int prod_num, String prod_name, String prod_img, int prod_price) {
		super();
		this.prod_num = prod_num;
		this.prod_name = prod_name;
		this.prod_img = prod_img;
		this.prod_price = prod_price;
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

	public String getProd_img() {
		return prod_img;
	}

	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	
	
}//class
