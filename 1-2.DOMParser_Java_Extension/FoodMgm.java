package hw;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class FoodMgm implements ActionListener {
	private ArrayList<Food> foods;
	private ArrayList<FoodNutri> nuts;
	private JFrame f;
	private JLabel jl;
	private JTextArea ta;
	private JPanel p1;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	
	public FoodMgm() {
		foods = new ArrayList<>();
		nuts = new ArrayList<>();
		createGUI();
		parse();
	}

	private void parse() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = dbf.newDocumentBuilder();
			Document foodinfo = parser.parse(new File("xml/foodInfo.xml"));
			Document foodnutri = parser.parse(new File("xml/FoodNutritionInfo.xml"));
			Element foodroot = foodinfo.getDocumentElement();
			Element nutriroot = foodnutri.getDocumentElement();
			// foodinfo.xml parsing
			NodeList now = foodroot.getElementsByTagName("food");
			for (int i = 0; i < now.getLength(); i++) {
				Food here = new Food();
				for (Node ch = now.item(i).getFirstChild(); ch != null; ch = ch.getNextSibling()) {
					if (ch.getNodeName().equals("code"))
						here.setCode(Integer.parseInt(ch.getFirstChild().getNodeValue()));
					else if (ch.getNodeName().equals("name"))
						here.setName(ch.getFirstChild().getNodeValue());
					else if (ch.getNodeName().equals("maker"))
						here.setMaker(ch.getFirstChild().getNodeValue());
					else if (ch.getNodeName().equals("material"))
						here.setMaterial(ch.getFirstChild().getNodeValue());
					else if (ch.getNodeName().equals("image"))
						here.setImg(ch.getFirstChild().getNodeValue());
				}
				foods.add(here);
			}
			// FoodNutritioninfo parsing
			NodeList now2 = nutriroot.getElementsByTagName("item");
			for (int i = 0; i < now2.getLength(); i++) {
				FoodNutri heres = new FoodNutri();
				for (Node ch = now2.item(i).getFirstChild(); ch != null; ch = ch.getNextSibling()) {
					String na = "0";
					boolean not = false;
					// N/A 예외처리
					if (ch.getFirstChild().getNodeValue().equals("N/A"))
						not = true;

					if (ch.getNodeName().equals("DESC_KOR"))
						heres.setName(ch.getFirstChild().getNodeValue());
					else if (ch.getNodeName().equals("SERVING_WT")) {
						if (not)
							heres.setWt(Integer.parseInt(na));
						else
							heres.setWt(Integer.parseInt(ch.getFirstChild().getNodeValue()));
					} else if (ch.getNodeName().equals("NUTR_CONT1")) {
						if (not)
							heres.setKal(Double.parseDouble(na));
						else
							heres.setKal(Double.parseDouble(ch.getFirstChild().getNodeValue()));
					} else if (ch.getNodeName().equals("NUTR_CONT2")) {
						if (not)
							heres.setTansu(Double.parseDouble(na));
						else
							heres.setTansu(Double.parseDouble(ch.getFirstChild().getNodeValue()));
					} else if (ch.getNodeName().equals("NUTR_CONT3")) {
						if (not)
							heres.setProtein(Double.parseDouble(na));
						else
							heres.setProtein(Double.parseDouble(ch.getFirstChild().getNodeValue()));
					} else if (ch.getNodeName().equals("NUTR_CONT4")) {
						if (not)
							heres.setFat(Double.parseDouble(na));
						else
							heres.setFat(Double.parseDouble(ch.getFirstChild().getNodeValue()));
					} else if (ch.getNodeName().equals("NUTR_CONT5")) {
						if (not)
							heres.setDang(Double.parseDouble(na));
						else
							heres.setDang(Double.parseDouble(ch.getFirstChild().getNodeValue()));
					} else if (ch.getNodeName().equals("NUTR_CONT6")) {
						if (not)
							heres.setNat(Double.parseDouble(na));
						else
							heres.setNat(Double.parseDouble(ch.getFirstChild().getNodeValue()));
					} else if (ch.getNodeName().equals("NUTR_CONT7")) {
						if (not)
							heres.setColle(Double.parseDouble(na));
						else
							heres.setColle(Double.parseDouble(ch.getFirstChild().getNodeValue()));
					} else if (ch.getNodeName().equals("NUTR_CONT8")) {
						if (not)
							heres.setBigfat(Double.parseDouble(na));
						else
							heres.setBigfat(Double.parseDouble(ch.getFirstChild().getNodeValue()));
					} else if (ch.getNodeName().equals("NUTR_CONT9")) {
						if (not)
							heres.setTransfat(Double.parseDouble(na));
						else
							heres.setTransfat(Double.parseDouble(ch.getFirstChild().getNodeValue()));
					} else if (ch.getNodeName().equals("ANIMAL_PLANT"))
						heres.setCountry(ch.getFirstChild().getNodeValue());
				}
				nuts.add(heres);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createGUI() {
		f = new JFrame("안전 먹거리 Project!");
		f.setBounds(40, 40, 600, 400);
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jl = new JLabel("SAFE FOOD",JLabel.CENTER);
		f.add(jl, BorderLayout.NORTH);
		
		ta = new JTextArea(); // 출력되는 창
		ta.setEditable(false);
		f.add(ta, BorderLayout.CENTER);
		
		p1 = new JPanel(); // 아래쪽 패널
		p1.setLayout(new BorderLayout()); 
		
		p2 = new JPanel(); // 버튼 패널
		p2.setLayout(new BorderLayout());
		b1 = new JButton("식품명 검색");
		b2 = new JButton("제조사 검색");
		b3 = new JButton("원재료 검색");
		b4 = new JButton("이름순 정렬");
		b5 = new JButton("제조사 정렬");
		p2.add(b1, BorderLayout.NORTH);
		p2.add(b2, BorderLayout.CENTER);
		p2.add(b3, BorderLayout.SOUTH);
		p1.add(p2, BorderLayout.EAST);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		p3 = new JPanel(); // 입력패널
		p3.setLayout(new BorderLayout());
		tf1 = new JTextField(100);
		tf2 = new JTextField(100);
		tf3 = new JTextField(100);
		p3.add(tf1, BorderLayout.NORTH);
		p3.add(tf2, BorderLayout.CENTER);
		p3.add(tf3, BorderLayout.SOUTH);
		p1.add(p3, BorderLayout.CENTER);
		
		p4 = new JPanel();
		p4.setLayout(new BorderLayout());
		jl1 = new JLabel("식  품  명");
		jl2 = new JLabel("제  조  사");
		jl3 = new JLabel("원  재   료");
		p4.add(jl1, BorderLayout.NORTH);
		p4.add(jl2, BorderLayout.CENTER);
		p4.add(jl3, BorderLayout.SOUTH);
		
		JPanel p5 = new JPanel();
		p5.add(b4);
		p5.add(b5);
		p1.add(p5, BorderLayout.SOUTH);
		
		p1.add(p4, BorderLayout.WEST);
		
		
		f.add(p1, BorderLayout.SOUTH);
		
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("식품명 검색") ) {
			String str = tf1.getText();
			tf1.setText("");
			String result = searchByName(str).toString();
			ta.setText("");
			ta.append(result);
		}
		else if (e.getActionCommand().equals("제조사 검색")) {
			String str = tf2.getText();
			tf2.setText("");
			String result = searchByMaker(str).toString();
			ta.setText("");
			ta.append(result);
		}
		else if (e.getActionCommand().equals("원재료 검색")) {
			String str = tf3.getText();
			tf3.setText("");
			ArrayList<Food> list = searchByMaterial(str);
			ta.setText("");
			for (int i = 0; i < list.size(); i++) {
				ta.append(list.get(i).toString());
				ta.append("\n");
			}
		}
		else if (e.getActionCommand().equals("이름순 정렬")) {
			sortByName();
			ta.setText("");
			for (int i = 0; i < foods.size(); i++) {
				ta.append(foods.get(i).toString());
				ta.append("\n");
			}
		}
		else if (e.getActionCommand().equals("제조사 정렬")) {
			sortByMaker();
			ta.setText("");
			for (int i = 0; i < foods.size(); i++) {
				ta.append(foods.get(i).toString());
				ta.append("\n");
			}
		}
		
	}

	public Food searchByName(String name) {
		if (foods.isEmpty()) {
			return null;
		} else {
			for (Food food : foods) {
				if (food.getName().equals(name))
					return food;
			}
		}
		return null;
	}

	public Food searchByMaker(String maker) {
		if (foods.isEmpty()) {
			return null;
		} else {
			for (Food food : foods) {
				if (food.getMaker().equals(maker))
					return food;
			}
		}
		return null;
	}
	
	public ArrayList<Food> searchByMaterial(String material){
		if (foods.isEmpty()) {
			return null;
		} else {
			ArrayList<Food> re = new ArrayList<>();
			for (Food food : foods) {
				if (food.getMaterial().contains(material))
					re.add(food);
			}
			if (re.isEmpty())
				return null;
			return re;
		}
	}
	
	public void sortByName() {
		if (foods.isEmpty()) return;
		foods.sort(new Comparator<Food>() {
			public int compare(Food o1, Food o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}
	
	public void sortByMaker() {
		if (foods.isEmpty()) return;
		foods.sort(new Comparator<Food>() {
			public int compare(Food o1, Food o2) {
				return o1.getMaker().compareTo(o2.getMaker());
			}
		});
	}

	public ArrayList<Food> getFoods() {
		return foods;
	}

	public ArrayList<FoodNutri> getNuts() {
		return nuts;
	}

	public static void main(String[] args) {
		new FoodMgm();
	}
} // end of class
