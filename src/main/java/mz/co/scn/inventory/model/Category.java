package mz.co.scn.inventory.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * 
 * @author Sidónio Goenha on May 20, 2020
 *
 */
@Entity
public class Category {
	private Long id;
	private String name;
	private String description;
	@OneToMany
	@JoinColumn(name="productId")
	private List<Product> products;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
