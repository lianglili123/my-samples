package my.sample.helloworld.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "writer")
public class Writer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8248780413571363443L;
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;

	public Writer() {
	};

	public void write() {
		System.out.println("HelloWorld, I am " + name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public my.sample.helloworld.writer.Writer getWsWriter(Writer writer) {
		my.sample.helloworld.writer.Writer wsw = new my.sample.helloworld.writer.Writer();
		wsw.setId(Integer.toString(writer.getId()));
		wsw.setName(writer.getName());
		wsw.setEmail(writer.getEmail());
		return wsw;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
