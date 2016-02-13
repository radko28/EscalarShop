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

import sk.cyklosoft.eshop.dao.ProductCategoryDao;
import sk.cyklosoft.eshop.domain.CategoryType;
import sk.cyklosoft.eshop.domain.ProductCategory;

@Repository("productCategoryDao")
public class ProductCategoryDaoImpl implements ProductCategoryDao {

    private HibernateTemplate hibernateTemplate = null;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }


    @Override
    public ProductCategory findProductCategoryById(final String id) {
        
        @SuppressWarnings("unchecked")
        ProductCategory result = hibernateTemplate.execute(new HibernateCallback<ProductCategory>() {

            @Override
            public ProductCategory doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(ProductCategory.class);
                criteria.add(Restrictions.eq("productCatId", id));
                return (ProductCategory)criteria.uniqueResult();
            }
        });

        return result;
    }

    @Override
    public void save(final ProductCategory productCategory) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.save(productCategory);
                return null;
            }   
        });
    }

    @Override
    public void remove(final ProductCategory productCategory) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.delete(productCategory);
                return null;
            }   
        });

    }

    @Override
    public List<ProductCategory> findAllCategories() {
        @SuppressWarnings("unchecked")
        List<ProductCategory> result = hibernateTemplate.execute(new HibernateCallback<List<ProductCategory>>() {

            @Override
            public List<ProductCategory> doInHibernate(Session session) throws HibernateException, SQLException {
                StringBuffer hql = new StringBuffer();
                hql.append("FROM ProductCategory pc");
                Query query = session.createQuery(hql.toString());
                // query.setEntity("user", user);
                return (List<ProductCategory>)query.list();
            }
        });

        return result;
    }

    @Override
    public void update(final ProductCategory productCategory) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {

                session.update(productCategory);
                return null;
            }
        });

    }


    @Override
    public ProductCategory findProductCategoryByCategoryType(final CategoryType categoryType) {
        @SuppressWarnings("unchecked")
        ProductCategory result = hibernateTemplate.execute(new HibernateCallback<ProductCategory>() {

            @Override
            public ProductCategory doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(ProductCategory.class);
                criteria.add(Restrictions.eq("categoryType", categoryType));
                return (ProductCategory)criteria.uniqueResult();
            }
        });

        return result;
    }
}
