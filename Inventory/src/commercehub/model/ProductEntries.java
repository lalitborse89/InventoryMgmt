package commercehub.model;

import commercehub.model.ProductInfo;
import commercehub.controller.InventoryImplementation;;

public class ProductEntries {

	public static InventoryImplementation addProductEntries(InventoryImplementation inventoryImplement){
		InventoryImplementation inventory =new InventoryImplementation();

		ProductInfo prod1 = new ProductInfo("1","iPhone_6s", 50, "First Block");
		ProductInfo prod2 = new ProductInfo("2","JBL_Speakers", 100, "First Block");
		ProductInfo prod3 = new ProductInfo("3","Denim_Jeans", 70, "Second Block");
		ProductInfo prod4 = new ProductInfo("4","Beats_Headphones", 50, "Second Block");

		inventory.addNewProduct(prod1);
		inventory.addNewProduct(prod2);
		inventory.addNewProduct(prod3);
		inventory.addNewProduct(prod4);

		return inventory;

	}
}
