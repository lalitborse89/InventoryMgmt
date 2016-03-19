package commercehub.model;

import commercehub.model.ProductInfo;


public class PickingResult {
	private ProductInfo product;
	
	public PickingResult(ProductInfo product) {
		this.product = product;
	}

	public ProductInfo getProduct() {
		return product;
	}
	
}
