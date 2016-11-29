package by.fpmi.pharmacy.domain;

public class Message {
	String name;
	String text;
	String address;

	public Message(){
		
	}
	
	public Message(String name, String text, String address) {
		this.name = name;
		this.text = text;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}

	public String getAddress() {
		return address;
	}
}
