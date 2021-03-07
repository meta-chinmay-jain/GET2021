package com.store.shoppingcart;

import java.util.Map;
import java.util.Scanner;

/**
 * Creates a command-line User Interface.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-02-25
 */
public class Menu {
	private static Scanner input;
	private Cart cart = new Cart();

	/**
	 * This is method takes input from user.
	 * 
	 * @return Integer This is the number entered by user.
	 */
	public static Integer getUserInput() {
		Integer ch = null;

		input = new Scanner(System.in);

		try {
			ch = Integer.parseInt(input.nextLine());
		} catch (Exception e) {
			System.out.println("\nInvalid input!");
		}

		return ch;
	}

	/**
	 * This is the main method which makes use of Menu class.
	 * 
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.getMainMenu();
	}

	/**
	 * This method displays Main Menu on standard output.
	 */
	private void getMainMenu() {
		Integer choice;

		// Showing Main Menu until user chooses to exit
		do {
			System.out.println("\nMENU\n");
			System.out.println("1. Display Store Items");
			System.out.println("2. Display Cart");
			System.out.println("3. Generate Bill");
			System.out.println("4. Exit");

			System.out.print("\nEnter your choice: ");
			choice = getUserInput();

			if (choice != null) {
				switch (choice) {
				case 1:
					cartOperations();
					break;
				case 2:
					showCart();
					break;
				case 3:
					cart.generateBilling();
					break;
				case 4:
					System.exit(0);
					break;
				default:
					break;
				}
			} else {
				choice = 0; // converting null value to valid integer
			}
		} while (choice != 4);
	}

	/**
	 * This method shows the Inner Menu with options for Cart Operations.
	 */
	private void cartOperations() {
		Integer choice;

		// Showing Inner Menu until user chooses to checkout
		do {
			displayStoreItems();
			getInnerMenu();

			System.out.print("\nEnter your choice: ");
			choice = getUserInput();

			if (choice != null) {
				switch (choice) {
				case 1:
					addItemToCart();
					showCart();
					break;
				case 2:
					updateItemQuantity();
					showCart();
					break;
				case 3:
					removeItemFromCart();
					showCart();
					break;
				default:
					break;
				}
			} else {
				choice = 0; // converting null value to valid integer
			}
		} while (choice != 4);
	}

	/**
	 * This method displays list of Store Items on standard output.
	 */
	private void displayStoreItems() {
		System.out.println("\nStore Items:\n");
		System.out.println("CODE\tNAME\t\t\tPRICE\t STOCK");
		System.out.println("----------------------------------------------");

		Map<String, Item> items = cart.getStoreItems();

		for (String key : items.keySet()) {
			Item item = items.get(key);
			System.out.println(item.getCode() + "\t" + item.getName() + "\t\t" + String.format("%.2f", item.getPrice())
					+ "\t " + item.getAvailableStock());
		}
	}

	/**
	 * This method displays Inner Menu on standard output.
	 */
	private void getInnerMenu() {
		System.out.println("\nOptions:\n");
		System.out.println("1. Add item to Cart");
		System.out.println("2. Update item Quantity");
		System.out.println("3. Remove item from Cart");
		System.out.println("4. Checkout");
	}

	/**
	 * This method adds a new item to the Cart.
	 */
	private void addItemToCart() {
		System.out.print("Enter Item Code: ");
		String code = input.nextLine();

		// Checking whether Cart already has this item
		if (!cart.getCartItems().containsKey(code)) {
			cart.addItemByCode(code);
		} else {
			System.out.println("\nItem already exists in cart!");
		}
	}

	/**
	 * This methods updates the quantity of an existing item in the Cart.
	 */
	private void updateItemQuantity() {
		// Checking whether Cart has some items to update
		if (!cart.getCartItems().isEmpty()) {
			System.out.print("Enter Item Code: ");
			String code = input.nextLine();

			// Checking whether Cart has this item or not
			if (cart.getCartItems().containsKey(code)) {
				cart.updateItemQuantityInCart(code);
			} else {
				System.out.println("\nItem not found in cart!");
			}
		}
	}

	/**
	 * This method removes an item from the Cart.
	 */
	private void removeItemFromCart() {
		// Checking whether Cart has some items to remove
		if (!cart.getCartItems().isEmpty()) {
			System.out.print("Enter Item Code: ");
			String code = input.nextLine();

			cart.removeItemByCode(code);
		}
	}

	/**
	 * This method displays the contents of Cart.
	 */
	private void showCart() {
		cart.printCartItems();
	}
}
