package hw;

public class Food {
	private int code;
	private String name;
	private String maker;
	private String material;
	private String img;

	public Food() {
	}

	public Food(int code, String name, String maker, String material, String img) {
		this.code = code;
		this.name = name;
		this.maker = maker;
		this.material = material;
		this.img = img;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Food [code=" + code + ", name=" + name + ", maker=" + maker + ", material=" + material + ", img=" + img
				+ "]";
	}

}
