package sk.cyklosoft.eshop.dao.impl;

import java.sql.SQLException;

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

import sk.cyklosoft.eshop.dao.SizeDao;
import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.domain.Size;

@Repository("sizeDao")
public class SizeDaoImpl implements SizeDao{
    
    private HibernateTemplate hibernateTemplate = null;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }


    @Override
    public void save(final Size size) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.save(size);
                return null;
            }
        });
    }

    @Override
    public void delete(final Product product) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String hql = "delete from Size where product = :product";
                Query query = session.createQuery(hql);
                query.setEntity("product", product);
                query.executeUpdate();
                return null;
            }
        });

        
    }


    @Override
    public Size findSizeByValue(final String value, final Product product) {
        Size result = hibernateTemplate.execute(new HibernateCallback<Size>() {
            @Override
            public Size doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(Size.class);
                criteria.add(Restrictions.eq("value", value));
                criteria.add(Restrictions.eq("product", product));
                return (Size)criteria.uniqueResult();
            }
        });

        return result;

    }

}
