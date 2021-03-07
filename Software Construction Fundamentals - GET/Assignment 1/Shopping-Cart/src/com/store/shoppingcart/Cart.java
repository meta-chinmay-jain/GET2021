package com.store.shoppingcart;

import java.util.HashMap;
import java.util.Map;

/**
 * The Cart class provides the methods for Cart Operations.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-02-25
 */
public class Cart {
	private final static Map<String, Item> storeItems = new HashMap<String, Item>();
	private final Map<String, Item> cartItems = new HashMap<String, Item>();

	public Cart() {
		initStoreItems();
	}

	/**
	 * Initializing the list of Items available in Store.
	 */
	public static void initStoreItems() {
		String[] names = { "Dettol Soap", "Nirma Detergent", "Parle Cookies", "Instant Coffee", "Face-cream" };
		Double[] prices = { 25.75, 30.50, 19.85, 15.25, 10.00 };
		Integer[] availableStocks = { 10, 8, 20, 5, 15 };

		for (int i = 0; i < names.length; i++) {
			storeItems.put(String.valueOf(i + 1),
					new Item(String.valueOf(i + 1), names[i], prices[i], availableStocks[i]));
		}
	}

	/**
	 * This method adds an Item to the Cart.
	 * 
	 * @param code Unique code of the Item.
	 */
	public void addItemByCode(String code) {
		Item item = storeItems.get(code);

		if (item != null) {
			System.out.print("Enter Quantity: ");
			Integer itemQuantity = Menu.getUserInput();

			if (isValidQuantity(itemQuantity)) {
				int availableStock = item.getAvailableStock();

				if (availableStock >= itemQuantity) {
					// Updating the Item Stock after adding the Item to the Cart
					cartItems.put(item.getCode(),
							new Item(item.getCode(), item.getName(), item.getPrice(), itemQuantity));
					item.setAvailableStock(availableStock - itemQuantity);
					System.out.println("\nItem added successfully.");
				} else {
					System.out.println("\nInsufficient Stock!");
				}
			}
		} else {
			System.out.println("\nInvalid item code!");
		}
	}

	/**
	 * This method updates the quantity of an existing item of Cart.
	 * 
	 * @param code Unique code of the Item.
	 */
	public void updateItemQuantityInCart(String code) {
		System.out.print("Enter New Quantity: ");
		Integer newQuantity = Menu.getUserInput();

		if (isValidQuantity(newQuantity)) {
			Item item = storeItems.get(code);
			int availableStock = item.getAvailableStock();
			int oldQuantity = cartItems.get(code).getAvailableStock();
			int deltaQuantity = newQuantity - oldQuantity;

			if (availableStock >= deltaQuantity) {
				// Updating the Item Stock after updating the Item quantity in Cart
				cartItems.get(code).setAvailableStock(newQuantity);
				item.setAvailableStock(availableStock - deltaQuantity);
				System.out.println("\nQuantity updated successfully.");
			} else {
				System.out.println("\nInsufficient Stock!");
			}
		}
	}

	/**
	 * This method removes an Item from the Cart.
	 * 
	 * @param code Unique code of the Item.
	 */
	public void removeItemByCode(String code) {
		// Checking whether the item to remove exists in the Cart
		if (cartItems.containsKey(code)) {
			Item item = storeItems.get(code);
			int availableStock = item.getAvailableStock();
			int itemQuantity = cartItems.get(code).getAvailableStock();
			cartItems.remove(code);

			// Updating the Item Stock after removing the Item from Cart
			item.setAvailableStock(availableStock + itemQuantity);
			System.out.println("\nItem removed successfully.");
		} else {
			System.out.println("\nItem not found in cart!");
		}
	}

	/**
	 * This method displays the list of Items in the Cart.
	 */
	public void printCartItems() {
		// Checking whether Cart has some Items to display
		if (!cartItems.isEmpty()) {
			System.out.println("\nCART:");
			System.out.println("\nItem\t\t\tQuantity");
			System.out.println("--------------------------------");

			for (String key : cartItems.keySet()) {
				System.out.println(cartItems.get(key).getName() + "\t\t" + cartItems.get(key).getAvailableStock());
			}
		} else {
			System.out.println("\nCart is empty!");
		}
	}

	/**
	 * This method returns the updated list of Items according to the current state
	 * of Cart.
	 * 
	 * @return List<Item> Updated List of Items according to current state of Cart.
	 */
	public Map<String, Item> getStoreItems() {
		return storeItems;
	}

	/**
	 * This method returns the Cart.
	 * 
	 * @return Map<Integer, Integer> HashMap with Item Code as key and Item Quantity
	 *         as value.
	 */
	public Map<String, Item> getCartItems() {
		return cartItems;
	}

	/**
	 * This method displays the Billing for the Items in the Cart.
	 */
	public void generateBilling() {
		// Checking whether the Cart has any items for which the bill can be generated
		if (!getCartItems().isEmpty()) {
			System.out.println("\nBilling:\n");
			System.out.println("CODE\tNAME\t\t\tRATE\tQUANTITY\tAMOUNT");
			System.out.println("--------------------------------------------------------------");

			Double totalAmount = 0.0;

			for (String key : cartItems.keySet()) {
				String code = key;
				int quantity = cartItems.get(key).getAvailableStock();
				Item billingItem = cartItems.get(key);
				Double rate = billingItem.getPrice();
				Double amount = rate * quantity;
				System.out.println(" " + code + "\t" + billingItem.getName() + "\t\t" + String.format("%.2f", rate)
						+ "\t" + quantity + "\t\t" + String.format("%.2f", amount));
				totalAmount += amount;
			}
			System.out.println("\nTOTAL BILL AMOUNT: " + String.format("%.2f", totalAmount));
		} else {
			System.out.println("\nCart is empty!");
		}
	}

	/**
	 * This method checks whether the user entered quantity of an Item is a positive
	 * integer.
	 * 
	 * @param quantity Quantity entered by user for an Item.
	 * @return boolean True if it is a valid quantity, False otherwise.
	 */
	private boolean isValidQuantity(Integer quantity) {
		if (quantity != null) {
			if (quantity > 0) {
				return true;
			} else {
				System.out.println("\nInvalid Quantity!");
			}
		}
		return false;
	}
}
