package no.conduct.web;

import no.conduct.domain.core.Product;
import no.conduct.domain.core.ProductRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * @author stalet@conduct.no
 */
@Model
@Stateful
public class HomeController {

    @Inject
    private Logger log;

    @Inject
    private ProductRepository productRepository;

    @Inject
    private FacesContext facesContext;

    private Product newProduct;

    private Product current = new Product();


    private boolean edit;

    public boolean isEdit() {
        return edit;
    }

    public void edit(final Product product)
    {
        log.info("Redigerer " + product);
        this.current = product;
        edit = true;
    }

    public void delete(final Product product)
    {
        log.info("Sletter " + product);
        productRepository.remove(product);
    }

    public void save()
    {
        log.info("Lagrer " + current);
        productRepository.save(current);
        edit = false;
        current = new Product();
    }

    public Product getCurrent() {
        return current;
    }

    @Produces
    @Named
    public Product getNewProduct()
    {
        return newProduct;
    }

    public void registerProduct()
    {
        log.info("Registrerer nytt produkt:" + newProduct);
        productRepository.save(newProduct);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful"));
        initNewMember();
    }

    @PostConstruct
    public void initNewMember() {
        newProduct = new Product();

    }

}
