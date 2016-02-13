package sk.cyklosoft.eshop.dao;

import sk.cyklosoft.eshop.domain.Authority;


public interface AuthorityDao {
    
    public void remove(Authority authority);

    public void save(Authority authority);

    public void update(Authority authority);

}
