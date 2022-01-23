package dewaSB;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
public class Product {
	
    private @Id @GeneratedValue Integer id;
    private String firstname;
    private String lastname;
    private float price;
    
	public Integer getId() {
		return id;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.firstname + " " + this.lastname;
	}

	public void setName(String name) {
		String[] parts = name.split(" ");
		this.firstname = parts[0];
		this.lastname = parts[1];
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", price=" + price + "]";
	}
 
     
}
