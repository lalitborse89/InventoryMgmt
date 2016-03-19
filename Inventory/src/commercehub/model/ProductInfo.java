package commercehub.model;
public class ProductInfo  {
	private String productid;
	private String prodname;
	private int quantity;
	private String location;

	public ProductInfo(){}

	public ProductInfo(String productid, String prodname, int quantity, String location) {
		super();
		this.productid = productid;
		this.prodname = prodname;
		this.quantity = quantity;
		this.location = location;
	}

	public ProductInfo(String prodname, int quantity, String location) {
		super();
		this.prodname = prodname;
		this.quantity = quantity;
		this.location = location;
	}

	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getName() {
		return prodname;
	}
	public void setName(String name) {
		this.prodname = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getlocation() {
		return location;
	}
	public void setlocation(String location) {
		this.location = location;
	}
	public void substractItems(int items){
		this.quantity -= items;
	}
	public void addItems(int items){
		this.quantity += items;
	}

	public int getProductQuantity(String productid){
		return quantity;
	}

	@Override
	public String toString() {
		return "Product: "+ this.getName()+", Quantity: "+this.getQuantity()+", Located at: "+this.getlocation()+"\n";
	}
}
