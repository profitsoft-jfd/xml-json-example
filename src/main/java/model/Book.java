package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JsonAutoDetect
@JsonPropertyOrder({"bookname", "year", "annotation"})
public class Book {
	@JsonProperty("bookname")
	private String bookName;
	@JacksonXmlText
	@JacksonXmlCData
	private String annotation;
	private int year;

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book{" +
				"bookName='" + bookName + '\'' +
				", annotation='" + annotation + '\'' +
				", year=" + year +
				'}';
	}
}
