package hw;

public class FoodNutri {
	private String name;
	private int wt;
	private double kal;
	private double tansu;
	private double protein;
	private double fat;
	private double dang;
	private double nat;
	private double colle;
	private double bigfat;
	private double transfat;
	private String country;

	public FoodNutri() {
	}

	public FoodNutri(String name, int wt, double kal, double tansu, double protein, double fat, double dang, double nat,
			double colle, double bigfat, double transfat, String country) {
		this.name = name;
		this.wt = wt;
		this.kal = kal;
		this.tansu = tansu;
		this.protein = protein;
		this.fat = fat;
		this.dang = dang;
		this.nat = nat;
		this.colle = colle;
		this.bigfat = bigfat;
		this.transfat = transfat;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWt() {
		return wt;
	}

	public void setWt(int wt) {
		this.wt = wt;
	}

	public double getKal() {
		return kal;
	}

	public void setKal(double kal) {
		this.kal = kal;
	}

	public double getTansu() {
		return tansu;
	}

	public void setTansu(double tansu) {
		this.tansu = tansu;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getDang() {
		return dang;
	}

	public void setDang(double dang) {
		this.dang = dang;
	}

	public double getNat() {
		return nat;
	}

	public void setNat(double nat) {
		this.nat = nat;
	}

	public double getColle() {
		return colle;
	}

	public void setColle(double colle) {
		this.colle = colle;
	}

	public double getBigfat() {
		return bigfat;
	}

	public void setBigfat(double bigfat) {
		this.bigfat = bigfat;
	}

	public double getTransfat() {
		return transfat;
	}

	public void setTransfat(double transfat) {
		this.transfat = transfat;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "FoodNutri [name=" + name + ", wt=" + wt + ", kal=" + kal + ", tansu=" + tansu + ", protein=" + protein
				+ ", fat=" + fat + ", dang=" + dang + ", nat=" + nat + ", colle=" + colle + ", bigfat=" + bigfat
				+ ", transfat=" + transfat + ", country=" + country + "]";
	}

}
