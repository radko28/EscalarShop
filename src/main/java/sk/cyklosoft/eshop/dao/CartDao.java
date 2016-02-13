package sk.cyklosoft.eshop.dao;

import sk.cyklosoft.eshop.domain.Cart;
import sk.cyklosoft.eshop.domain.User;


public interface CartDao {
    
    public void remove(Cart cart);

    public Cart findCartById(String cartId);

    public Cart findCartByUser(User user);

    public void save(Cart cart);

}
