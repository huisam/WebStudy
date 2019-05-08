package weather;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDAO {
	private List<Weather> list;
	private static WeatherDAO singleton;
	
	private WeatherDAO() {
		
	}

	public static WeatherDAO getInstance() {
		if (singleton == null)
			singleton = new WeatherDAO();
		return singleton;
	}
	
	public void connectXML() {
		list = new ArrayList<>();
		String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = dbf.newDocumentBuilder();
			Document doc = parser.parse(url);
			
			Element root = doc.getDocumentElement();
			NodeList nodes = root.getElementsByTagName("data");
			int length = nodes.getLength();

			for (int i = 0; i < length; i++) {
				Node nows = nodes.item(i);
				NodeList child = nows.getChildNodes();
				int hour = 0;
				double temp = 0;
				String wdKor = null;
				int ref = 0;
				for (int j = 0; j < child.getLength(); j++) {
					Node now = child.item(j);
					if (now.getNodeName().equals("hour"))
						hour = Integer.parseInt(now.getFirstChild().getNodeValue());
					else if(now.getNodeName().equals("temp"))
						temp = Double.parseDouble(now.getFirstChild().getNodeValue());
					else if(now.getNodeName().equals("wdKor"))
						wdKor = now.getFirstChild().getNodeValue();
					else if(now.getNodeName().equals("reh"))
						ref = Integer.parseInt(now.getFirstChild().getNodeValue());
				}
				list.add(new Weather(hour, temp, wdKor, ref));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public List<Weather> getWeatherList() {
		return list;
	}

}
