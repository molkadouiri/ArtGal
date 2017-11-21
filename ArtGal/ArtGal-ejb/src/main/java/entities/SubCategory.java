package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SubCategories database table.
 * 
 */
@Entity
@Table(name="SubCategories")
@NamedQuery(name="SubCategory.findAll", query="SELECT s FROM SubCategory s")
public class SubCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SubCategoryId")
	private int subCategoryId;

	@Column(name="Name")
	private String name;

	//uni-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;

	public SubCategory() {
	}

	public int getSubCategoryId() {
		return this.subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}