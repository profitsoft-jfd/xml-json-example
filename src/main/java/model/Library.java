package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonAutoDetect
@JacksonXmlRootElement(localName = "library")
public class Library {

	@JacksonXmlProperty(isAttribute = true, localName = "id")
	private String ident;

	private String name;
	@JacksonXmlElementWrapper(localName = "books")
	@JacksonXmlProperty(localName = "book")
	private List<Book> books = new ArrayList<>();

	@JsonIgnore
	private String location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Library{" +
				"ident='" + ident + '\'' +
				", name='" + name + '\'' +
				", books=" + books.stream().map(b -> b.toString()).collect(Collectors.joining("\n")) +
				", location='" + location + '\'' +
				'}';
	}
}
