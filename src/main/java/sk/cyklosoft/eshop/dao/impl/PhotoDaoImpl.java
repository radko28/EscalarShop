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

import sk.cyklosoft.eshop.dao.PhotoDao;
import sk.cyklosoft.eshop.domain.Photo;
import sk.cyklosoft.eshop.domain.PhotoType;
import sk.cyklosoft.eshop.domain.Product;

@Repository("photoDao")
public class PhotoDaoImpl implements PhotoDao {
    
    private HibernateTemplate hibernateTemplate = null;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Transactional
    @Override
    public void save(final Photo photo) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.save(photo);
                return null;
            }
        });
    }

    @Transactional
    @Override
    public void deletePhotos(final Product product) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String hql = "delete from Photo where product = :product";
                Query query = session.createQuery(hql);
                query.setEntity("product", product);
                query.executeUpdate();
                return null;
            }
        });
        
    }

    @Transactional
    @Override
    public List<Photo> findPhotosByProduct(final Product product) {
        @SuppressWarnings("unchecked")
        List<Photo> result = hibernateTemplate.execute(new HibernateCallback<List<Photo>>() {

            @Override
            public List<Photo> doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(Photo.class);
                criteria.add(Restrictions.eq("product", product));
                return (List<Photo>)criteria.list();
            }
        });        
        return result;

    }

    @Transactional
    @Override
    public Photo findPhotoByType(final Product product, final PhotoType photoType) {
        @SuppressWarnings("unchecked")
        Photo result = hibernateTemplate.execute(new HibernateCallback<Photo>() {

            @Override
            public Photo doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(Photo.class);
                criteria.add(Restrictions.eq("product", product));
                criteria.add(Restrictions.eq("photoType", photoType));
                return (Photo)criteria.uniqueResult();
            }
        });        
        return result;
    }

    @Transactional
    @Override
    public void update(final Photo photo) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.update(photo);
                return null;
            }
        });

        
    }
}
