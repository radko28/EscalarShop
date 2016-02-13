package sk.cyklosoft.eshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import sk.cyklosoft.eshop.dao.UserDao;
import sk.cyklosoft.eshop.domain.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    
    private HibernateTemplate hibernateTemplate = null;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }


    @Override
    public User findUserById(final String userId) {
        @SuppressWarnings("unchecked")
        User result = hibernateTemplate.execute(new HibernateCallback<User>() {

            @Override
            public User doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(User.class);
                criteria.add(Restrictions.eq("userId", userId));
                return (User)criteria.uniqueResult();
            }
        });

        return result;
    }

    @Override
    public void save(final User user) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.save(user);
                return null;
            }
        });
    }

    @Override
    public void remove(final User user) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.delete(user);
                return null;
            }
        });
    }

    @Override
    public void update(final User user) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.update(user);
                return null;
            }
        });
        
    }


    @Override
    public List<User> findAllUsers() {
        @SuppressWarnings("unchecked")
        List<User> result = hibernateTemplate.execute(new HibernateCallback<List<User>>() {

            @Override
            public List<User> doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(User.class);
                return (List<User>)criteria.list();
            }
        });

        return result;
    }


    @Override
    public User findUserByUsername(final String username) {
        @SuppressWarnings("unchecked")
        User result = hibernateTemplate.execute(new HibernateCallback<User>() {

            @Override
            public User doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(User.class);
                criteria.add(Restrictions.eq("username", username));
                return (User)criteria.uniqueResult();
            }
        });

        return result;
    }

}
