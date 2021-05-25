package Product;

import java.util.List;

/**
 * 사용자가 보는 상세 상품정보
 * @author sist
 */
public class ProductDetailUserVO {
	private String prod_name;
	private int prod_price;
	private List<String> prod_size;
	private String prod_img;
	private int prod_quantity;
	
	public ProductDetailUserVO() {
		super();
	}

	public ProductDetailUserVO(String prod_name, int prod_price, List<String> prod_size, String prod_img,
			int prod_quantity) {
		super();
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_size = prod_size;
		this.prod_img = prod_img;
		this.prod_quantity = prod_quantity;
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

	public List<String> getProd_size() {
		return prod_size;
	}

	public void setProd_size(List<String> prod_size) {
		this.prod_size = prod_size;
	}

	public String getProd_img() {
		return prod_img;
	}

	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}

	public int getProd_quantity() {
		return prod_quantity;
	}

	public void setProd_quantity(int prod_quantity) {
		this.prod_quantity = prod_quantity;
	}
	
	
}//class
