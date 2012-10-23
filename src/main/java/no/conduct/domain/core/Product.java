package no.conduct.domain.core;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * @author stalet@conduct.no
 */
@Entity
@Cacheable
@NamedQueries({
        @NamedQuery(name = "getAllProducts", query = "SELECT p from Product p"),
        @NamedQuery(name = "getProductById", query = "SELECT p from Product p where p.id = :id")
})
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String description;

    @NotNull
    @Column(unique = true, nullable = false)
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "Kan kun inneholde bokstaver, tall og space   ")
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
