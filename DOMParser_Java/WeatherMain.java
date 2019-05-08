package weather;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class WeatherMain {
	JFrame f;
	JButton b;
	JList li;
	WeatherDAO dao;

	public WeatherMain() {
		dao = WeatherDAO.getInstance();
		createGUI();
		addEvent();
	}

	private void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
	}

	protected void showList() {
		// dao....
		dao.connectXML();
		List<Weather> list = dao.getWeatherList();
		li.setListData(list.toArray());

	}

	private void createGUI() {
		f = new JFrame("Weathers Info");
		b = new JButton("call Weathers");

		li = new JList();
		JScrollPane pane = new JScrollPane(li);
		Container c = f.getContentPane();

		c.add(b, "North");
		c.add(pane, "Center");

		f.setSize(1200, 1200);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new WeatherMain();
	}

}
