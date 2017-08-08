package net.giri.onlineshoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.giri.onlineshoppingbackend.dao.CategoryDao;
import net.giri.onlineshoppingbackend.dto.Category;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static List<Category> categoryList = new ArrayList<Category>();
    static {

	Category category = new Category();
	category.setId(123);
	categoryList.add(category);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getAllCategory() {
	String selectActiveCategory = "FROM Category";
	List<Category> list = sessionFactory.getCurrentSession().createQuery(selectActiveCategory).list();	
	return list;
    }

    @Override
    public Category get(long id) {

	Category category = null;
	try {
	    category = (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return category;
    }

    @Override
    public boolean add(Category category) {
	try {
	    sessionFactory.getCurrentSession().persist(category);
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return false;

	}
	return true;
    }

    @Override
    public boolean update(Category category) {
	try {
	    sessionFactory.getCurrentSession().update(category);
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return false;

	}
	return true;
    }

    @Override
    public boolean remove(long id) {
	try {
	    Session session = sessionFactory.getCurrentSession();
	    Category category = (Category) session.get(Category.class, id);
	    category.setActive(false);
	    session.update(category);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return true;
    }
}
