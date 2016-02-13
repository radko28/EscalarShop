package sk.cyklosoft.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sk.cyklosoft.eshop.dao.CartDao;
import sk.cyklosoft.eshop.dao.ProductDao;
import sk.cyklosoft.eshop.dao.UserDao;
import sk.cyklosoft.eshop.domain.Cart;
import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.domain.User;
import sk.cyklosoft.eshop.service.CartService;
import sk.cyklosoft.eshop.vo.CartVO;

@Service("cartService")
@Component
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ProductDao productDao;
    
    

    @Override
    public void deleteCart(String cartId) {
        Cart cart = cartDao.findCartById(cartId);
        cartDao.remove(cart);
        
    }

    @Override
    public CartVO findCartByUserId(String userId) {
        User user = userDao.findUserById(userId);
        Cart cart = cartDao.findCartByUser(user);
        CartVO cartVO = cart.copy();
        return cartVO;
    }

    @Override
    public void addCart(String productId, String userId) {
        User user = userDao.findUserById(userId);
        Product product = productDao.findProductById(productId);
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setAmount(1);
        cartDao.save(cart);
        
    }

    @Override
    public void updateCart(String cartId, int amount) {
        Cart cart = cartDao.findCartById(cartId);
        cart.setAmount(amount);
        cartDao.save(cart);        
    }

}
