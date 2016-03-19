package junitTest;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Test;

import commercehub.controller.InventoryImplementation;
import commercehub.model.*; 
import commercehub.controller.*;
public class Testone {

	@Test
	public void ktest() {
		/// JUnit test to confirm quantity for productid 2
		System.out.println("JUNIT TEST");
		InventoryImplementation inventoryImplement = new InventoryImplementation();
		inventoryImplement = ProductEntries.addProductEntries(inventoryImplement);
		Hashtable<String, ProductInfo> tab = inventoryImplement.getProduct();		
		assertEquals(100,tab.get("2").getQuantity());
	}

}