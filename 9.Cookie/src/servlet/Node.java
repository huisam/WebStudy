package servlet;

public class Node {
	private String productName;
	private String price;
	private String content;

	public Node() {
		this("","","");
	}

	public Node(String productName, String price, String content) {
		this.productName = productName;
		this.price = price;
		this.content = content;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Node [productName=" + productName + ", price=" + price + ", content=" + content + "]";
	}
	
}
