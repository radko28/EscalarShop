package sk.cyklosoft.eshop.service;

import sk.cyklosoft.eshop.vo.CartVO;


public interface CartService {

    void deleteCart(String cartId);

    CartVO findCartByUserId(String userId);

    void addCart(String productId, String userId);

    void updateCart(String cartId, int amount);

}
