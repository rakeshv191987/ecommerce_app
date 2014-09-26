/**
 * 
 */
package com.bostonretailer.retailerservices;

import java.util.List;

import com.bostonretailer.retailercommon.Address;
import com.bostonretailer.retailercommon.Customer;
import com.bostonretailer.retailercommon.CustomerPaymentOption;
import com.bostonretailer.retailercommon.Product;
import com.bostonretailer.retailercommon.ShoppingCart;
import com.bostonretailer.retailercommon.ShoppingCartProduct;
import com.bostonretailer.retailercommon.WishList;
import com.bostonretailer.retailercommon.WishListProduct;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public interface CustomerBOService {

	/* Customer Service Methods */

	public void createCustomer(Customer customer);

	public void deleteCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public Customer findByCustomerId(Long customerId);

	/* End of Customer Service Methods */

	/* Customer Payment Service Methods */

	public void createCustomerPaymentOption(
			CustomerPaymentOption customerPaymentOption);

	public void deleteCustomerPaymentOption(
			CustomerPaymentOption customerPaymentOption);

	public void updateCustomerPaymentOption(
			CustomerPaymentOption customerPaymentOption);

	/* End of Customer Payment Service Methods */

	/* Shopping Cart Service Methods */
	// TODO : Remove method if not necessary
	public ShoppingCart findShoppingCart(Long shoppingCartId);

	/* End of Shopping Cart Service Methods */

	/* Shopping Cart Product Service Methods */

	public void addShoppingCartProduct(Long shoppingCartId, Long productId,
			Integer quantity);

	public void removeShoppingCartProduct(Long shoppingCartProductId);

	public void updateShoppingCartProduct(Long shoppingCartProductId,
			Integer quantity);

	public ShoppingCartProduct findShoppingCartProduct(
			Long shoppingCartProductId);

	/* End of Shopping Cart Product Service Methods */

	/* Wish List Service Methods */

	public WishList findWishList(Long wishListId);

	/* End of Wish List Service Methods */

	/* Wish List Product Service Methods */

	public void addWishListProduct(Long wishListId, Long productId);

	public void removeWishListProduct(Long wishListProductId);

	public WishListProduct findWishListProduct(Long wishListProductId);

	/* End of Wish List Product Service Methods */

	/* Address Service Methods */

	public void createAddress(Address address);

	public void removeAddress(Address address);

	public void updateAddress(Address address);

	public Address findByAddressId(Long addressId);

	/* End of Address Service Methods */

	/* Product Search */

	public List<Product> searchProducts(String productName);

	/* Add to Cart Service Methods */

	public void customerAddToCart(Long customerId, Long productId, int quantity);

	/* End of Add to Cart Service Methods */

	/* Place Order Service Methods */

	public void customerPlaceOrder(Long customerId,
			Long customerPaymentOptionId, Long addressId) throws Exception;

	/* End of Place Order Service Methods */

}
