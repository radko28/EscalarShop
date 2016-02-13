package sk.cyklosoft.eshop.dao.impl;

import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import sk.cyklosoft.eshop.dao.CartDao;
import sk.cyklosoft.eshop.domain.Cart;
import sk.cyklosoft.eshop.domain.User;

@Repository("cartDao")
public class CartDaoImpl implements CartDao {
    
    private HibernateTemplate hibernateTemplate = null;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void remove(final Cart cart) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.delete(cart);
                return null;
            }
        });
    }

    @Override
    public Cart findCartById(final String cartId) {
        @SuppressWarnings("unchecked")
        Cart result = hibernateTemplate.execute(new HibernateCallback<Cart>() {

            @Override
            public Cart doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(Cart.class);
                criteria.add(Restrictions.eq("id", cartId));
                return (Cart)criteria.uniqueResult();
            }
        });

        return result;
    }

    @Override
    public Cart findCartByUser(final User user) {
        @SuppressWarnings("unchecked")
        Cart result = hibernateTemplate.execute(new HibernateCallback<Cart>() {

            @Override
            public Cart doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(Cart.class);
                criteria.add(Restrictions.eq("user", user));
                return (Cart)criteria.uniqueResult();
            }
        });

        return result;
    }

    @Override
    public void save(final Cart cart) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.save(cart);
                return null;
            }   
        });
        
    }

}
