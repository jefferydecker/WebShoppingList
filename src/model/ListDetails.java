package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="TRIP_DATE")
	private LocalDate tripDate;

	@ManyToOne
	@JoinColumn(name="SHOPPER_ID")
	private Shopper shopper;

	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
	 (
	 name="ITEMS_ON_LIST",
	 joinColumns={
			 @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
	 inverseJoinColumns={
			 @JoinColumn(name="ITEM_ID", referencedColumnName="ID", unique=true) }
	 )
	private List<ListItem> listOfItems;
	
	public ListDetails() {
	}

	public ListDetails(int id, String listName,
			LocalDate tripDate, Shopper shopper, List<ListItem> listOfItems) {
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName,
			LocalDate tripDate, Shopper shopper, List<ListItem> listOfItems) {
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
		this.listOfItems = listOfItems;
	}

	public ListDetails(String listName,
			LocalDate tripDate, Shopper shopper) {
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
	}

	public int getId() {
		return id;
	}

	public String getListName() {
		return listName;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public Shopper getShopper() {
		return shopper;
	}

	public List<ListItem> getListOfItems() {
		return listOfItems;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public void setShopper(Shopper shopper) {
		this.shopper = shopper;
	}

	public void setListOfItems(List<ListItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", shopper=" + shopper
				+ ", listOfItems=" + listOfItems + "]";
	}

}
