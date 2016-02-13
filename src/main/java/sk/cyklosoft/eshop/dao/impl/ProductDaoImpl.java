package sk.cyklosoft.eshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sk.cyklosoft.eshop.dao.ProductDao;
import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.domain.ProductCategory;

/**
 * 
 * @author radko28
 * 
 */
@Repository("productDao")
// @Transactional
public class ProductDaoImpl implements ProductDao {

    private HibernateTemplate hibernateTemplate = null;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }


    @Override
    public Product findProductById(final String id) {
        @SuppressWarnings("unchecked")
        Product result = hibernateTemplate.execute(new HibernateCallback<Product>() {

            @Override
            public Product doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(Product.class);
                criteria.add(Restrictions.eq("productId", id));
                return (Product)criteria.uniqueResult();
            }
        });

        return result;
    }

    @Transactional
    @Override
    public void save(final Product product) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.save(product);
                return null;
            }
        });
    }

    @Override
    public void remove(final Product product) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.delete(product);
                return null;
            }
        });

    }

    @Override
    public List<Product> findProductByCat(final ProductCategory productCategory) {
        @SuppressWarnings("unchecked")
        List<Product> result = hibernateTemplate.execute(new HibernateCallback<List<Product>>() {

            @Override
            public List<Product> doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer hql = new StringBuffer();
                hql.append("FROM Product p where p.productCategory = :productCategory");
                Query query = session.createQuery(hql.toString());
                query.setEntity("productCategory", productCategory);
                return (List<Product>)query.list();
            }
        });

        return result;
    }


    @Override
    public void update(final Product product) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.update(product);
                return null;
            }
        });

    }

}
