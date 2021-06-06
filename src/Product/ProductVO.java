package Product;

/**
 * 상품을 추가/수정할 때 필요한 정보를 저장하는 클래스
 * @author sist
 */
public class ProductVO {
   private String prod_num;
   private String prod_cat;
   private String prod_name;
   private String prod_price;
   private String prod_detail;
   private String prod_delete;
   private String prod_img;
   private String prod_add_date;
   public ProductVO() {
      super();
   }
   public ProductVO(String prod_num, String prod_cat, String prod_name, String prod_price, String prod_detail,
         String prod_delete, String prod_img, String prod_add_date) {
      super();
      this.prod_num = prod_num;
      this.prod_cat = prod_cat;
      this.prod_name = prod_name;
      this.prod_price = prod_price;
      this.prod_detail = prod_detail;
      this.prod_delete = prod_delete;
      this.prod_img = prod_img;
      this.prod_add_date = prod_add_date;
   }
   public String getProd_num() {
      return prod_num;
   }
   public void setProd_num(String prod_num) {
      this.prod_num = prod_num;
   }
   public String getProd_cat() {
      return prod_cat;
   }
   public void setProd_cat(String prod_cat) {
      this.prod_cat = prod_cat;
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
   public String getProd_img() {
      return prod_img;
   }
   public void setProd_img(String prod_img) {
      this.prod_img = prod_img;
   }
   public String getProd_add_date() {
      return prod_add_date;
   }
   public void setProd_add_date(String prod_add_date) {
      this.prod_add_date = prod_add_date;
   }
   
   
}//class