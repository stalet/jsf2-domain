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

    @Produces
    @Named
    public Product getNewProduct()
    {
        return newProduct;
    }

    public void registerProduct()
    {
        log.info("Registrerer nytt produkt:" + newProduct);
        productRepository.add(newProduct);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful"));
    }

    @PostConstruct
    public void initNewMember() {
        newProduct = new Product();

    }

}
