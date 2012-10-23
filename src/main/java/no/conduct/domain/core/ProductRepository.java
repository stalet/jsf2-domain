package no.conduct.domain.core;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: stalet
 * Date: 10/22/12
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@Named
public class ProductRepository {

    @Inject
    private EntityManager entityManager;


    public List<Product> getAll() {
        return entityManager.createNamedQuery("getAllProducts", Product.class).getResultList();
    }

    public Product get(final Long id) {

        final Query query = entityManager.createNamedQuery("getProductById", Product.class);
        query.setParameter("id", id);
        return (Product) query.getSingleResult();
    }

    public void remove(Product product)
    {
        entityManager.remove(entityManager.merge(product));
    }

    public Product save(final Product product){
        return entityManager.merge(entityManager.merge(product));
    }

}
