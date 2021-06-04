package Product;

import java.util.Date;
import java.util.List;

/**
 * 상품 업데이트를 위한 VO
 * @author user
 */
public class ProductModifyVO {
	private int prod_num;
	private String prod_name;
	private int prod_price;
	private List<String> prod_size;
	private String prod_img;
	private String prod_detail;
	
	public ProductModifyVO() {
	}
	
	
	public ProductModifyVO(int prod_num, String prod_name, int prod_price, List<String> prod_size, String prod_img,
			String prod_detail) {
		super();
		this.prod_num = prod_num;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_size = prod_size;
		this.prod_img = prod_img;
		this.prod_detail = prod_detail;
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
	public String getProd_detail() {
		return prod_detail;
	}
	public void setProd_detail(String prod_detail) {
		this.prod_detail = prod_detail;
	}
	
	

}
