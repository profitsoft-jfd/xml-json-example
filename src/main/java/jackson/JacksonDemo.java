package jackson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import jaxb.JaxbDemo;
import model.Book;
import model.Library;
import model.MessageStore;

public class JacksonDemo {

	public static void main(String[] args) {
		//jabxAnnotation2Json();
		//jacksonAnnotation2Xml();
		//jacksonAnnotation2Json();
		jacksonAnnotationFromJson();
		//onlyXml2Json();
	}

	private static void jabxAnnotation2Json() {
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			File file = new File("./in/messages.json");
			MessageStore ms = jsonMapper.readValue(file, MessageStore.class);
			System.out.println(ms.toString());
			ms.setCategory("Changed category");
			ms.getMessages().get(1).setHeader("Changed header 2");
			jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonMapper.writeValue(new File("./out/messages_changed.json"), ms);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void jacksonAnnotation2Xml() {
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			xmlMapper.writeValue(new File("./out/library.xml"), getLibrary());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void jacksonAnnotation2Json() {
		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			jsonMapper.writeValue(new File("./out/library.json"), getLibrary());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void jacksonAnnotationFromJson() {
		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			Library l = jsonMapper.readValue(new File("./in/library_in.json"), Library.class);
			System.out.println(l.toString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void onlyXml2Json() {
		XmlMapper xmlMapper = new XmlMapper();
		File file = new File("./in/messages1.xml");
		try {
			MessageStore ms = xmlMapper.readValue(file, MessageStore.class);
			System.out.println(ms.toString());
			ObjectMapper jsonMapper = new ObjectMapper();
			jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonMapper.writeValue(new File("./out/messages1.json"), ms);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	private static Library getLibrary() {
		Library l = new Library();
		l.setName("Main Library");
		l.setLocation("ignored location");
		l.setIdent("007");
		Book b1 = new Book();
		b1.setAnnotation("Annotation <Book1> text");
		b1.setBookName("Book1");
		b1.setYear(2001);

		Book b2 = new Book();
		b2.setAnnotation("Annotation <Book2> text");
		b2.setBookName("Book2");
		b2.setYear(2002);
		l.getBooks().add(b1);
		l.getBooks().add(b2);

		return l;
	}

}
