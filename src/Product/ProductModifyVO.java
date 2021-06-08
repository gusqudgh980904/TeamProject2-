package Product;

import java.util.Date;
import java.util.List;

/**
 * 상품 업데이트를 위한 VO
 * @author user
 */
public class ProductModifyVO {
	private String prod_num;
	private String prod_name;
	private String prod_price;
	private String prod_detail;
	private String prod_img;
	public ProductModifyVO() {
		super();
	}
	public ProductModifyVO(String prod_num, String prod_name, String prod_price, String prod_detail, String prod_img) {
		super();
		this.prod_num = prod_num;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_detail = prod_detail;
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
	public String getProd_detail() {
		return prod_detail;
	}
	public void setProd_detail(String prod_detail) {
		this.prod_detail = prod_detail;
	}
	public String getProd_img() {
		return prod_img;
	}
	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}
	
	
	

}
