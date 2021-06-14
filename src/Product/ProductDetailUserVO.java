package Product;

/**
 * 사용자가 보는 상세 상품정보
 * @author sist
 */
public class ProductDetailUserVO {
	
	private String prod_num;
	private String prod_name;
	private String prod_price;
	private String prod_explain;
	private String prod_img;

	
	public ProductDetailUserVO() {
		super();
	}


	public ProductDetailUserVO(String prod_num, String prod_name, String prod_price, String prod_explain,
			String prod_img) {
		super();
		this.prod_num = prod_num;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_explain = prod_explain;
		this.prod_img = prod_img;
	}


	public String getProd_num() {
		return prod_num;
	}


	public void setProd_num(String prod_num) {
		this.prod_num = prod_num;
	}


	public String getProd_name() {
		return prod_name;
	}


	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}


	public String getProd_price() {
		return prod_price;
	}


	public void setProd_price(String prod_price) {
		this.prod_price = prod_price;
	}


	public String getProd_explain() {
		return prod_explain;
	}


	public void setProd_explain(String prod_explain) {
		this.prod_explain = prod_explain;
	}


	public String getProd_img() {
		return prod_img;
	}


	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}

	
}//class
