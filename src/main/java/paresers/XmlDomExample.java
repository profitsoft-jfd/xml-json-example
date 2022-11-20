package paresers;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class XmlDomExample {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document;
			try (InputStream io = ClassLoader.getSystemResourceAsStream("bookstore.xml")) {
				document = builder.parse(io);
			}
			if (document != null) {
				System.out.println(document.getDocumentElement().getElementsByTagName("book").getLength());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
