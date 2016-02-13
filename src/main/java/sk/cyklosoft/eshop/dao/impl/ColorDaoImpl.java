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

import sk.cyklosoft.eshop.dao.ColorDao;
import sk.cyklosoft.eshop.domain.Color;
import sk.cyklosoft.eshop.domain.Product;

@Repository("colorDao")
public class ColorDaoImpl implements ColorDao {
    
    private HibernateTemplate hibernateTemplate = null;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }




    @Override
    public void save(final Color color) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.save(color);
                return null;
            }
        });
    }


    @Override
    public void delete(final Product product) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String hql = "delete from Color where product = :product";
                Query query = session.createQuery(hql);
                query.setEntity("product", product);
                query.executeUpdate();
                return null;
            }
        });
        
    }




    @Override
    public Color findColorByCode(final String code, final Product product) {
        Color result = hibernateTemplate.execute(new HibernateCallback<Color>() {
            @Override
            public Color doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(Color.class);
                criteria.add(Restrictions.eq("code", code));
                criteria.add(Restrictions.eq("product", product));
                return (Color)criteria.uniqueResult();
            }
        });

        return result;

    }

}
