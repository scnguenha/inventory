
package mz.co.scn.inventory.model.brand;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Sidónio Goenha on Jun 4, 2020
 *
 */
@Entity
public class Brand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3633747433118977751L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;

	public Brand(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

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

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
