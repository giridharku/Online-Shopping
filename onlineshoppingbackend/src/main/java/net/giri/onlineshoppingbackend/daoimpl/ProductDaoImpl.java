/**
 * 
 */
package net.giri.onlineshoppingbackend.daoimpl;

import java.util.List;

import net.giri.onlineshoppingbackend.dao.ProductDao;
import net.giri.onlineshoppingbackend.dto.Product;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author giridhar
 *
 */
@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     * (non-Javadoc)
     * 
     * @see net.giri.onlineshoppingbackend.dao.ProductDao#getAllProducts()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllProducts() {
	List<Product> productList = sessionFactory.getCurrentSession().createQuery("FROM Product").list();
	return productList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.giri.onlineshoppingbackend.dao.ProductDao#get(long)
     */
    @Override
    public Product get(int id) {
	Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
	return product;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.giri.onlineshoppingbackend.dao.ProductDao#add(net.giri.onlineshoppingbackend.dto.Product)
     */
    @Override
    public boolean add(Product product) {
	try {
	    sessionFactory.getCurrentSession().persist(product);

	} catch (Exception ex) {
	    return false;

	}
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.giri.onlineshoppingbackend.dao.ProductDao#update(net.giri.onlineshoppingbackend.dto.Product)
     */
    @Override
    public boolean update(Product product) {
	try {
	    sessionFactory.getCurrentSession().update(product);

	} catch (Exception ex) {
	    return false;

	}
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.giri.onlineshoppingbackend.dao.ProductDao#remove(long)
     */
    @Override
    public boolean remove(int id) {
	try {
	    Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
	    product.setActive(false);
	    sessionFactory.getCurrentSession().update(product);

	} catch (Exception ex) {
	    return false;

	}
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.giri.onlineshoppingbackend.dao.ProductDao#getAllActiveProducts()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllActiveProducts() {
	return sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active = :active")
		.setParameter("active", true).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.giri.onlineshoppingbackend.dao.ProductDao#getActiveProductsByCategory(long)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getActiveProductsByCategory(int categoryId) {
	String productByCategory = " FROM Product where active = :active and categoryId = :categoryId";
	org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(productByCategory);
	query.setParameter("active", true);
	query.setParameter("categoryId", categoryId);
	return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getLatestActiveProducts(int count) {
	String productByCategory = " FROM Product where active = :active ORDER BY Id";
	org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(productByCategory);
	query.setParameter("active", true);
	query.setFirstResult(0);
	query.setMaxResults(count);

	return query.list();
    }

}
