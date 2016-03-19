package commercehub.model;

import commercehub.model.ProductInfo;

public class RestockingResult {
	private ProductInfo product;

	public RestockingResult(ProductInfo product) {
		this.product = product;
	}

	public ProductInfo getProduct() {
		return product;
	}

}
