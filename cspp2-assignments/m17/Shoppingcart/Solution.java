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
		this.quantity -= entity;
	}
	public void incrementQuantity(int q) {
		this.quantity += q;
	}
}

class ShoppingCart {
	private List<Item>catalogObj;
	private List<Item>cartObj;
	private float discount;
	private float tax;
	private int flag = 0;
	public ShoppingCart() {
		catalogObj = new List<Item>();
		cartObj = new List<Item>();
		discount = 0;
	}

	public void addToCatalog(Item itemObj) {
		catalogObj.add(itemObj);
	}
	public void addToCart(Item item) {
		// int index = cartObj.indexOf(item.getProduct());
		// if (index == -1) {
		for (int i = 0; i < catalogObj.size(); i++) {
			if (item.getProduct().equals(catalogObj.get(i).getProduct())
				&& item.getQuantity() <= catalogObj.get(i).getQuantity()) {
				for (int j = 0; j < cartObj.size(); j++) {
					if (cartObj.get(j).getProduct().equals(item.getProduct())) {
						cartObj.get(j).incrementQuantity(item.getQuantity());
						return;
					}
				}
				cartObj.add(item);
		        catalogObj.get(i).setQuantity(item.getQuantity());
		        return;
			}
		}
		}


	public void removeFromCart(Item item) {
		for (int i = 0; i < cartObj.size(); i++) {
			if (item.getProduct().equals(cartObj.get(i).getProduct())) {
				if (cartObj.get(i).getQuantity() == item.getQuantity()) {
					cartObj.remove(i);
				} else {
				cartObj.get(i).setQuantity(item.getQuantity());
				}
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
		// float tax = ((getTotalAmount()/100) * 15);
		float payableAmount = getTotalAmount();
		float discountAmount = ((payableAmount / 100) * discount);
		float total = payableAmount - discountAmount;
		tax = ((total/100) * 15);
		total += tax;
		return total;
	}

	public void applyCoupon(String code) {
		if (code.equals("IND10") && flag == 0) {
			discount = 10;
			flag = 1;
		} else if (code.equals("IND20") && flag == 0) {
			discount = 20;
			flag = 1;
		} else if (code.equals("IND30") && flag == 0) {
			discount = 30;
			flag = 1;
		}
		else if (code.equals("IND50")&& flag == 0) {
			discount = 50;
			flag = 1;
		} else if (flag == 0) {
			System.out.println("Invalid coupon");
		}
		return;
	}

	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < cartObj.size(); i++) {
			for (int j = 0; j < catalogObj.size(); j++) {
				if (cartObj.get(i).getProduct().equals(catalogObj.get(j).getProduct())) {
				System.out.println(cartObj.get(i).getProduct() + " "+ cartObj.get(i).getQuantity() + " " + catalogObj.get(j).getPrice());
				}
			}
		}
		System.out.println("Total:"+ getTotalAmount());
		System.out.println("Disc%:" + (getTotalAmount() * (discount/100)));
		System.out.println("Tax:"+ tax);
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
				System.out.println("Payable amount: " + shopObj.getPayableAmount());
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
