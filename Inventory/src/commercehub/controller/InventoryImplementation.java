package commercehub.controller;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Set;

import commercehub.model.*;

public class InventoryImplementation {

	private Hashtable<String, ProductInfo>productList;
	public  InventoryImplementation() {
		productList = new Hashtable<String, ProductInfo>();
	}

	public InventoryImplementation addNewProduct(ProductInfo product){
		productList.put(product.getProductid(), product);
		return this;
	}

	public boolean getProductID(String productid){
		Set<String> keys = productList.keySet();
		boolean found = false;
		for(String key: keys){
			if(key.equals(productid+""))
				found=true;
		}
		return found;
	}

	public Hashtable<String, ProductInfo> getProduct(){
		return this.productList;
	}

	public PickingResult pickNewProduct(String productid, int itemsToPick){
		ProductInfo product = productList.get(productid);
		product.substractItems(itemsToPick);
		PickingResult pickingResult = new PickingResult(product);
		return pickingResult;
	}

	public RestockingResult restockNewProduct(String productid, int itemsToAdd){
		ProductInfo product = productList.get(productid);
		product.addItems(itemsToAdd);
		RestockingResult restockingResult = new RestockingResult(product);
		return restockingResult;
	}

	public void displayItems(String productId){
		ProductInfo product = this.productList.get(productId);
		System.out.println(product.getName() + " has " + product.getQuantity() + " copies left at " +
				product.getlocation());
	}

	public void displayAllItems(){
		String[] keys = (String[]) productList.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		for(String key : keys) {
			ProductInfo pi = productList.get(key);
			System.out.println("ID: "+ key + " Product: "+ pi.getName()+", Quantity: "+pi.getQuantity()+", Located at: "+pi.getlocation()+"\n");
		}
	}
}
