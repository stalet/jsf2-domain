package no.conduct.domain.core;

import javax.persistence.*;

/**
 * @author Ståle Tomten
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
    private String configuration;

    public Product(final String description, final String configuration) {
        this.description = description;
        this.configuration = configuration;
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

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }
}
