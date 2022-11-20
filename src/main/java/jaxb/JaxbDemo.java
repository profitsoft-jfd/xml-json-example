package jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.Message;
import model.MessageStore;

public class JaxbDemo {

	public static void main(String[] args) {
		try {
			marshal();
			MessageStore ms = unmarshall("./in/messages1.xml");
			System.out.println(ms.toString());

			ms = unmarshall("./in/messages2.xml");
			System.out.println(ms.toString());

			ms = unmarshall("./in/messages3.xml");
			System.out.println(ms.toString());

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	private static MessageStore unmarshall(String source) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(MessageStore.class);
		return (MessageStore) context.createUnmarshaller()
				.unmarshal(new FileReader(source));
	}

	private static void marshal() throws JAXBException {
		MessageStore store = getTestMessageStore();
		JAXBContext context = JAXBContext.newInstance(MessageStore.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(store, new File("./out/public_message.xml"));
	}

	public static MessageStore getTestMessageStore() {
		MessageStore store = new MessageStore();
		store.setCategory("public");

		Message m = new Message();
		m.setHeader("Public H 1");
		m.setBody("Public body 1");
		m.setSize(BigInteger.valueOf(m.getBody().length()));
		m.setMessid("0001");

		store.getMessages().add(m);

		m = new Message();
		m.setHeader("Public H 2");
		m.setBody("Public bodyyyy 2");
		m.setSize(BigInteger.valueOf(m.getBody().length()));
		m.setMessid("0002");

		store.getMessages().add(m);
		return store;
	}
}
