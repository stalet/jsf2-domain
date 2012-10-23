package no.conduct.web;

import no.conduct.domain.core.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author stalet@conduct.no
 */
@Named
@SessionScoped
public class ProductHolder implements Serializable {

    private Product current = new Product();

    public Product getCurrent() {
        return current;
    }

    public void setCurrent(Product current) {
        this.current = current;
    }
}
