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

import sk.cyklosoft.eshop.dao.ColorTypeDao;
import sk.cyklosoft.eshop.domain.ColorType;

@Repository("colorTypeDao")
public class ColorTypeDaoImpl implements ColorTypeDao {
    
    private HibernateTemplate hibernateTemplate = null;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }


    @Override
    public List<ColorType> findAllColorTypes() {
        List<ColorType> result = hibernateTemplate.execute(new HibernateCallback<List<ColorType>>() {
        @Override
        public List<ColorType> doInHibernate(Session session) throws HibernateException, SQLException {
            Criteria criteria = session.createCriteria(ColorType.class);
            return (List<ColorType>)criteria.list();
        }
    });

    return result;
        
    }


    @Override
    public ColorType findColorTypeById(final String colorTypeId) {
        @SuppressWarnings("unchecked")
        ColorType result = hibernateTemplate.execute(new HibernateCallback<ColorType>() {

            @Override
            public ColorType doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(ColorType.class);
                criteria.add(Restrictions.eq("id", colorTypeId));
                return (ColorType)criteria.uniqueResult();
            }
        });

        return result;

    }

}
