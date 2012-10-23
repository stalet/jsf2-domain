package no.conduct.domain.core;

import javax.persistence.*;

/**
 * @author stalet@conduct.no
 */
@Entity
@Cacheable
@NamedQueries({
        @NamedQuery(name="getAllProducts", query = "SELECT p from Product p"),
        @NamedQuery(name="getProductById", query = "SELECT p from Product p where p.id = :id")
})
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String name;

    public Product(final String description, final String name) {
        this.description = description;
        this.name = name;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
