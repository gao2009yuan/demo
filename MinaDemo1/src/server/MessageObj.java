package server;

import java.io.Serializable;

public class MessageObj implements Serializable{

	
	private int id = 0;
	
	private String name = null;

	public MessageObj(int i, String string) {
		
		this.id = i;
		this.name = string;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
