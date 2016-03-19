package commercehub.main.function;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import commercehub.controller.InventoryImplementation;
import commercehub.model.*;

public class MainFunction {
	public static Lock lock = new ReentrantLock();
	public static InventoryImplementation inventoryImplement = new InventoryImplementation();

	public static void main(String args[]) {
		inventoryImplement = ProductEntries.addProductEntries(inventoryImplement);
		new Thread(new runner()).start();
	}

	static class runner implements Runnable {
		public void run(){
			int input = 0;
			System.out.println("Inventory Management System");
			Scanner in = new Scanner(System.in);
			while (input != 5) {

				System.out.println("Choose from the below Options");
				System.out.println("1.View an item\n2. Restocking Item\n3.Pick an Item Out\n4.View all items\n5.Exit");

				try {
					input = Integer.parseInt(in.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid input");
				}
				inventoryImplement = primaryfunction(input);
			}
		} 
	}


	public static InventoryImplementation primaryfunction(int input){

		String productid;
		int itemsToRestock,itemsToPick;
		lock.lock();
		try {
			switch (input) {
			case 1:
				productid = CheckProductEntry(inventoryImplement);
				inventoryImplement.displayItems(productid);
				break;

			case 2:
				productid = CheckProductEntry(inventoryImplement);
				itemsToRestock = itemsToAdd();
				RestockingResult itemRestocked = inventoryImplement.restockNewProduct(productid,itemsToRestock);
				System.out.println("No of " + itemRestocked.getProduct().getName() + "'s in WareHouse are "
						+ itemRestocked.getProduct().getQuantity());
				System.out.println(itemRestocked.getProduct().getName() + "and They are located at  " +
						itemRestocked.getProduct().getlocation());
				inventoryImplement.displayAllItems();
				break;
			case 3:
				productid = CheckProductEntry(inventoryImplement);
				itemsToPick = checkAvailabeItems(productid, inventoryImplement);
				PickingResult itemPicked = inventoryImplement.pickNewProduct(productid, itemsToPick);
				System.out.println("No of " + itemPicked.getProduct().getName() + "'s in WareHouse are " + itemPicked.getProduct().getQuantity());
				System.out.println(itemPicked.getProduct().getName() + " and They are located at " + itemPicked.getProduct().getlocation());
				inventoryImplement.displayAllItems();
				break;

			case 4:
				inventoryImplement.displayAllItems();
				System.out.println("*******************************************************************************************************************");
				break;
			case 5:
				System.out.println("System is shutting down!");
				System.exit(0);
			}
		}
		finally {
			lock.unlock();
		}

		return inventoryImplement;
	}


	public static String CheckProductEntry(InventoryImplementation inventoryImplement){
		Scanner input = new Scanner(System.in);
		boolean flag=true;
		String productid = null;

		while (flag) {
			System.out.println("Enter Product id");
			productid = input.nextLine();
			if(inventoryImplement.getProductID(productid)){
				flag = false;
				System.out.println("Product found");
			} else {
				System.out.println("Product not in the Warehouse");
			}
		}
		return productid;
	}

	public static int checkAvailabeItems(String productid,InventoryImplementation inventoryImplement){
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		ProductInfo product = inventoryImplement.getProduct().get(productid);

		while (flag) {
			System.out.println("Enter no of Units");
			String itemsToPick = input.nextLine();

			int itemsToPickout = Integer.parseInt(itemsToPick);
			if (itemsToPickout <= product.getQuantity()) {
				return itemsToPickout;
			} else {
				System.out.println("Not enough " + product.getName() + "Hence ,order can not be placed");
				System.out.println("Enter it again ");
			}

		}
		return -1;
	}

	public static int itemsToAdd(){
		Scanner input = new Scanner(System.in);
		boolean flag = true;

		while (flag) {
			System.out.println("Enter no of items you want to restock");
			String itemsToRestock = input.nextLine();
			return Integer.parseInt(itemsToRestock);
		}
		return -1;
	}
}
