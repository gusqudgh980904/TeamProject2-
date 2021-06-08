package Product;

/**
 * 包府磊 惑前包府 格废
 * @author sist
 */
public class ProductListAdminVO {
	private String prod_num;
	private String prod_name;
	private String prod_price;
	private String prod_detail;
	private String prod_delete;
	
	public ProductListAdminVO() {
		super();
	}

	public ProductListAdminVO(String prod_num, String prod_name, String prod_price, String prod_detail,
			String prod_delete) {
		super();
		this.prod_num = prod_num;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_detail = prod_detail;
		this.prod_delete = prod_delete;
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

	public String getProd_detail() {
		return prod_detail;
	}

	public void setProd_detail(String prod_detail) {
		this.prod_detail = prod_detail;
	}

	public String getProd_delete() {
		return prod_delete;
	}

	public void setProd_delete(String prod_delete) {
		this.prod_delete = prod_delete;
	}


	
	
}//class
