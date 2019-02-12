package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class ListItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private	int	id;
	@Column(name="STORE")
	private	String	store;
	@Column(name="ITEM")
	private	String	item;
	
	// Constructors
	public	ListItem() {
	}
	
	public	ListItem(String	store,	String	item) {
		this.store	=	store;
		this.item	=	item;
	}
	
	// Getters and setters
	public int getId() {
		return id;
	}

	public String getStore() {
		return store;
	}

	public String getItem() {
		return item;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public void setItem(String item) {
		this.item = item;
	}

	// helper methods
	public String returnItemDetails() {
		return store + ":	" + item;
	}

	@Override
	public String toString() {
		return "ListItem [id=" + id + ", store=" + store + ", item=" + item + "]";
	}

}
