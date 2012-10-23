package no.conduct.web;

import no.conduct.domain.core.Product;
import no.conduct.domain.core.ProductRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
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
public class HomeController {

    @Inject
    private Logger log;

    @Inject
    private ProductRepository productRepository;

    @Inject
    private FacesContext facesContext;

    @Inject
    private ProductHolder productHolder;

    private Product newProduct;

    public void edit(final Product product)
    {
        log.info("Redigerer " + product);
        productHolder.setCurrent(product);
    }

    public void delete(final Product product)
    {
        log.info("Sletter " + product);
        productRepository.remove(product);
    }

    public void save()
    {
        log.info("Lagrer " + productHolder.getCurrent());
        productRepository.save(productHolder.getCurrent());
        productHolder.setCurrent(new Product());
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
