import java.util.Scanner;
import java.io.BufferedInputStream;

class Item {
	private String productName;
	private int quantity;
	private String price;
	public Item(String name, String quantity, String price) {
		this.productName = name;
		this.quantity = Integer.parseInt(quantity);
		this.price = price;
	}
	public Item(String name, String quantity) {
		this.productName = name;
		this.quantity = Integer.parseInt(quantity);
	}

	public String getProduct() {
		return productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public float getPrice() {
		return Float.parseFloat(price);
	}
	public void setQuantity(int entity) {
		quantity -= entity;
	}
}

class ShoppingCart {
	private List<Item>catalogObj;
	private List<Item>cartObj;
	private float discount;

	public ShoppingCart() {
		catalogObj = new List<Item>();
		cartObj = new List<Item>();
		discount = 0;
	}

	public void addToCatalog(Item itemObj) {
		catalogObj.add(itemObj);
	}
	public void addToCart(Item item) {
		for (int i = 0; i < catalogObj.size(); i++) {
			if (item.getProduct().equals(catalogObj.get(i).getProduct())
				&& item.getQuantity() <= catalogObj.get(i).getQuantity()) {
		        cartObj.add(item);
		        catalogObj.get(i).setQuantity(item.getQuantity());
			}
	    }
	}
	public void removeFromCart(Item item) {
		for (int i = 0; i < cartObj.size(); i++) {
			if (item.getProduct().equals(cartObj.get(i).getProduct())) {
				cartObj.get(i).setQuantity(item.getQuantity());
			}
		}
	}

	public void showCart() {
	   for (int i = 0; i < cartObj.size(); i++) {
	   	System.out.println(cartObj.get(i).getProduct() + " " + cartObj.get(i).getQuantity());
	   }
	}

	public void showCatalog() {
		for (int i = 0; i < catalogObj.size(); i++) {
			System.out.println(catalogObj.get(i).getProduct()
				+" "+catalogObj.get(i).getQuantity()+" "+catalogObj.get(i).getPrice());
		}
	}

	public float getTotalAmount() {
		float net = 0;
		for (int i = 0; i < cartObj.size(); i++) {
			for (int j = 0; j < catalogObj.size(); j++) {
				if (cartObj.get(i).getProduct().equals(catalogObj.get(j).getProduct())) {
					net += cartObj.get(i).getQuantity() * catalogObj.get(j).getPrice();
				}
			}
		}
		return net;
	}

	public float getPayableAmount() {
		float discountAmount = (getTotalAmount() * (discount/100));
		System.out.println(discount);
		System.out.println(discountAmount);
		float payableAmount = getTotalAmount() - discountAmount;
		float tax = (payableAmount * (15/100));
		System.out.println(tax);
		float total =  (payableAmount + tax);
		System.out.println(total);
		return total;
	}

	public void applyCoupon(String code) {
		if (code.equals("IND10")) {
			discount = 10;
		} if (code.equals("IND20")) {
			discount = 20;
		} if (code.equals("IND30")) {
			discount = 30;
		}
		if (code.equals("IND50")) {
			discount = 50;
		} else {
			discount = 0;
		}
	}

	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < cartObj.size(); i++) {
			for (int j = 0; j < catalogObj.size(); j++) {
				if (cartObj.get(i).getProduct().equals(catalogObj.get(j).getProduct())) {
				System.out.println(cartObj.get(i).getProduct()+"   "+cartObj.get(i).getQuantity()+" "+catalogObj.get(i).getPrice());
				}
			}
		}
		System.out.println("totalAmount: "+ getTotalAmount());
		System.out.println("total: "+ getTotalAmount());
		System.out.println("Disc%: " + (getTotalAmount() * (discount/100)));
		System.out.println("Tax: "+ (getTotalAmount() * 0.15));
		System.out.println("Payable amount: "+ getPayableAmount());
	}
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		ShoppingCart shopObj = new ShoppingCart();
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
		switch (tokens[0]) {
			case "Item":
				String[] items = tokens[1].split(",");
				Item itemObj = new Item(items[0],items[1],items[2]);
				shopObj.addToCatalog(itemObj);
				break;
			case "add":
				String[] product = tokens[1].split(",");
				itemObj = new Item(product[0], product[1]);
				shopObj.addToCart(itemObj);
				break;
			case "remove":
				String[] item = tokens[1].split(",");
				itemObj = new Item(item[0], item[1]);
				shopObj.removeFromCart(itemObj);
				break;
			case "catalog":
				shopObj.showCatalog();
				break;
			case "show":
				shopObj.showCart();
				break;
			case "totalAmount":
				System.out.println("totalAmount: " + shopObj.getTotalAmount());
				break;
			case "payableAmount":
				System.out.println("payableAmount: " + shopObj.getPayableAmount());
				break;
			case "print":
				shopObj.printInvoice();
				break;
			case "coupon":
				shopObj.applyCoupon(tokens[1]);
				break;
			default: break;
		}
	}
}
}
