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

import sk.cyklosoft.eshop.dao.SizeTypeDao;
import sk.cyklosoft.eshop.domain.SizeType;

@Repository("sizeTypeDao")
public class SizeTypeDaoImpl implements SizeTypeDao {
    
    private HibernateTemplate hibernateTemplate = null;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }


    @Override
    public List<SizeType> findSizeTypes() {
        List<SizeType> result = hibernateTemplate.execute(new HibernateCallback<List<SizeType>>() {
            @Override
            public List<SizeType> doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(SizeType.class);
                return (List<SizeType>)criteria.list();
            }
        });

        return result;
    }

    @Override
    public SizeType findSizeTypeById(final String sizeTypeId) {
        @SuppressWarnings("unchecked")
        SizeType result = hibernateTemplate.execute(new HibernateCallback<SizeType>() {

            @Override
            public SizeType doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(SizeType.class);
                criteria.add(Restrictions.eq("id", sizeTypeId));
                return (SizeType)criteria.uniqueResult();
            }
        });

        return result;

    }

}
