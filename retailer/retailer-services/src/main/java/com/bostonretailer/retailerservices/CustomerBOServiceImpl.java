/**
 * 
 */
package com.bostonretailer.retailerservices;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.bostonretailer.retailercommon.Address;
import com.bostonretailer.retailercommon.Customer;
import com.bostonretailer.retailercommon.CustomerPaymentOption;
import com.bostonretailer.retailercommon.Invoice;
import com.bostonretailer.retailercommon.Order;
import com.bostonretailer.retailercommon.OrderItems;
import com.bostonretailer.retailercommon.Payment;
import com.bostonretailer.retailercommon.Product;
import com.bostonretailer.retailercommon.RefOrderStatus;
import com.bostonretailer.retailercommon.ShoppingCart;
import com.bostonretailer.retailercommon.ShoppingCartProduct;
import com.bostonretailer.retailercommon.WishList;
import com.bostonretailer.retailercommon.WishListProduct;
import com.bostonretailer.retailerdao.AddressDao;
import com.bostonretailer.retailerdao.CustomerDao;
import com.bostonretailer.retailerdao.CustomerPaymentOptionDao;
import com.bostonretailer.retailerdao.InvoiceDao;
import com.bostonretailer.retailerdao.OrderDao;
import com.bostonretailer.retailerdao.OrderItemsDao;
import com.bostonretailer.retailerdao.PaymentDao;
import com.bostonretailer.retailerdao.ProductDao;
import com.bostonretailer.retailerdao.ShoppingCartDao;
import com.bostonretailer.retailerdao.ShoppingCartProductDao;
import com.bostonretailer.retailerdao.WishListDao;
import com.bostonretailer.retailerdao.WishListProductDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */

public class CustomerBOServiceImpl implements CustomerBOService {
	private CustomerDao customerDao;
	private CustomerPaymentOptionDao customerPaymentOptionDao;
	private ShoppingCartDao shoppingCartDao;
	private ShoppingCartProductDao shoppingCartProductDao;
	private WishListDao wishListDao;
	private WishListProductDao wishListProductDao;
	private OrderDao orderDao;
	private InvoiceDao invoiceDao;
	private OrderItemsDao orderItemsDao;
	private PaymentDao paymentDao;
	private ProductDao productDao;
	private AddressDao addressDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.CustomerDao#createCustomer(com.bostonretailer
	 * .retailercommon.Customer)
	 */
	@Override
	public void createCustomer(Customer customer) {
		customerDao.save(customer);
		shoppingCartDao.save(new ShoppingCart(customer));
		wishListDao.save(new WishList(customer));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.CustomerDao#deleteCustomer(com.bostonretailer
	 * .retailercommon.Customer)
	 */
	@Override
	public void deleteCustomer(Customer customer) {
		// Deletion of Customer Payment Option
		for (CustomerPaymentOption customerPaymentOption : customer
				.getCustomerPaymentOption()) {
			customerPaymentOptionDao.delete(customerPaymentOption);
		}
		// Deletion of Shopping Cart Products
		for (ShoppingCartProduct shoppingCartProduct : customer
				.getShoppingCart().getShoppingCartProducts()) {
			shoppingCartProductDao.delete(shoppingCartProduct);
		}
		// Deletion of Shopping Cart
		shoppingCartDao.delete(customer.getShoppingCart());

		for (WishListProduct wishListProduct : customer.getWishList()
				.getWishListProducts()) {
			wishListProductDao.delete(wishListProduct);
		}

		wishListDao.delete(customer.getWishList());
		customerDao.delete(customer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.CustomerDao#deleteCustomer(com.bostonretailer
	 * .retailercommon.Customer)
	 */
	@Override
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.CustomerDao#deleteCustomer(com.bostonretailer
	 * .retailercommon.Customer)
	 */
	@Override
	public Customer findByCustomerId(Long customerId) {
		return customerDao.findCustomer(customerId);
	}

	@Override
	public void createCustomerPaymentOption(
			CustomerPaymentOption customerPaymentOption) {
		customerPaymentOptionDao.save(customerPaymentOption);

	}

	@Override
	public void deleteCustomerPaymentOption(
			CustomerPaymentOption customerPaymentOption) {

		customerPaymentOptionDao.delete(customerPaymentOption);
	}

	@Override
	public void updateCustomerPaymentOption(
			CustomerPaymentOption customerPaymentOption) {

		customerPaymentOptionDao.update(customerPaymentOption);
	}

	@Override
	public ShoppingCart findShoppingCart(Long shoppingCartId) {
		return shoppingCartDao.findShoppingCart(shoppingCartId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerservices.ShoppingCartProductBOService#
	 * addShoppingCartProduct
	 * (com.bostonretailer.retailercommon.ShoppingCartProduct)
	 */
	@Override
	public void addShoppingCartProduct(Long shoppingCartId, Long productId,
			Integer quantity) {
		ShoppingCart shoppingCart = shoppingCartDao
				.findShoppingCart(shoppingCartId);
		ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(
				shoppingCart, productDao.findProductById(productId), quantity);
		shoppingCartProductDao.save(shoppingCartProduct);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerservices.ShoppingCartProductBOService#
	 * removeShoppingCartProduct
	 * (com.bostonretailer.retailercommon.ShoppingCartProduct)
	 */
	@Override
	public void removeShoppingCartProduct(Long shoppingCartProductId) {
		shoppingCartProductDao.delete(shoppingCartProductDao
				.findShoppingCartProduct(shoppingCartProductId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerservices.ShoppingCartProductBOService#
	 * updateShoppingCartProduct
	 * (com.bostonretailer.retailercommon.ShoppingCartProduct)
	 */
	@Override
	public void updateShoppingCartProduct(Long shoppingCartProductId,
			Integer quantity) {
		ShoppingCartProduct shoppingCartProduct = shoppingCartProductDao
				.findShoppingCartProduct(shoppingCartProductId);
		shoppingCartProduct.setQuantity(quantity);
		shoppingCartProductDao.update(shoppingCartProduct);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerservices.ShoppingCartProductBOService#
	 * findShoppingCartProduct(java.lang.Long)
	 */
	@Override
	public ShoppingCartProduct findShoppingCartProduct(
			Long shoppingCartProductId) {
		return shoppingCartProductDao
				.findShoppingCartProduct(shoppingCartProductId);
	}

	@Override
	public WishList findWishList(Long wishListId) {
		return wishListDao.findWishList(wishListId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerservices.WishListProductBOService#
	 * addWishListProduct(com.bostonretailer.retailercommon.WishListProduct)
	 */
	@Override
	public void addWishListProduct(Long wishListId, Long productId) {
		WishList wishList = wishListDao.findWishList(wishListId);
		WishListProduct wishListProduct = new WishListProduct(wishList,
				productDao.findProductById(productId));
		wishListProductDao.save(wishListProduct);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerservices.WishListProductBOService#
	 * removeWishListProduct(com.bostonretailer.retailercommon.WishListProduct)
	 */
	@Override
	public void removeWishListProduct(Long wishListProductId) {
		wishListProductDao.delete(wishListProductDao
				.findWishListProduct(wishListProductId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerservices.WishListProductBOService#
	 * findWishListProduct(java.lang.Long)
	 */
	@Override
	public WishListProduct findWishListProduct(Long wishListProductId) {
		return wishListProductDao.findWishListProduct(wishListProductId);
	}

	@Override
	public void createAddress(Address address) {
		addressDao.save(address);
	}

	@Override
	public void removeAddress(Address address) {
		addressDao.delete(address);
	}

	@Override
	public void updateAddress(Address address) {
		addressDao.update(address);
	}

	@Override
	public Address findByAddressId(Long addressId) {
		return addressDao.findAddress(addressId);
	}

	@Override
	public List<Product> searchProducts(String productName) {
		return productDao.findProductsByQueryString(productName);
	}

	@Override
	public void customerAddToCart(Long customerId, Long productId, int quantity) {
		Customer customer = customerDao.findCustomer(customerId);
		Product product = productDao.findProductById(productId);
		ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(
				customer.getShoppingCart(), product, quantity);
		shoppingCartProductDao.save(shoppingCartProduct);
	}

	@Override
	public void customerPlaceOrder(Long customerId,
			Long customerPaymentOptionId, Long addressId) throws Exception {
		Customer customer = customerDao.findCustomer(customerId);

		// TODO : Write web service for customer payment authentication

		if (!validateShoppingCart(customer.getShoppingCart())) {
			throw new Exception("Invalid quantities for products");
		}

		/* Get the Address object */
		Address address = addressDao.findAddress(addressId);

		/* Get the delivery date which is 10 days from today's date */
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 10);
		Date expectedDeliveryDate = calendar.getTime();

		RefOrderStatus refOrderStatus = RefOrderStatus.PENDING;

		Order order = new Order(customer, refOrderStatus, expectedDeliveryDate,
				address);
		orderDao.save(order);

		// TODO : Send a mail with order details
		/* Order Item Creation */
		Float totalOrderPrice = 0F;

		List<ShoppingCartProduct> shoppingCartProducts = customer
				.getShoppingCart().getShoppingCartProducts();
		for (ShoppingCartProduct shoppingCartProduct : shoppingCartProducts) {

			Product product = shoppingCartProduct.getProduct();
			int quantity = shoppingCartProduct.getQuantity();
			Float productPrice = quantity * product.getProductPrice();
			totalOrderPrice += productPrice;

			OrderItems orderItem = new OrderItems(order, product, quantity,
					productPrice);
			orderItemsDao.save(orderItem);
		}

		/* Invoice Creation */
		Invoice invoice = new Invoice();
		String invoiceDetail = "This is a new invoice for this order. The invoice number is: "
				+ invoice.getInvoiceNumber();
		invoice.setOrder(order);
		invoice.setInvoiceDate(new Date());
		invoice.setInvoiceDetails(invoiceDetail);
		invoiceDao.save(invoice);

		/* Payment Creation */
		Payment payment = new Payment();
		payment.setInvoice(invoice);
		payment.setPaymentDate(new Date());
		payment.setPaymentAmount(totalOrderPrice);
		paymentDao.save(payment);

		invoice.setPayment(payment);
		invoiceDao.save(invoice);

		order.setInvoice(invoice);
		orderDao.save(order);

	}

	private boolean validateShoppingCart(ShoppingCart shoppingCart) {
		Boolean isValid = true;
		for (ShoppingCartProduct shoppingCartProduct : shoppingCart
				.getShoppingCartProducts()) {

			// TODO : Give the specific product out of stock info
			int stockQuantity = shoppingCartProduct.getProduct()
					.getProductQuantity();
			int customerQuantity = shoppingCartProduct.getQuantity();
			if (customerQuantity > stockQuantity)
				isValid = false;
		}
		return isValid;
	}

	/** Getter and Setter methods **/ 
	
	/**
	 * @return the customerDao
	 */
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	/**
	 * @param customerDao
	 *            the customerDao to set
	 */
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	/**
	 * @return the customerPaymentOptionDao
	 */
	public CustomerPaymentOptionDao getCustomerPaymentOptionDao() {
		return customerPaymentOptionDao;
	}

	/**
	 * @param customerPaymentOptionDao
	 *            the customerPaymentOptionDao to set
	 */
	public void setCustomerPaymentOptionDao(
			CustomerPaymentOptionDao customerPaymentOptionDao) {
		this.customerPaymentOptionDao = customerPaymentOptionDao;
	}

	/**
	 * @return the shoppingCartDao
	 */
	public ShoppingCartDao getShoppingCartDao() {
		return shoppingCartDao;
	}

	/**
	 * @param shoppingCartDao
	 *            the shoppingCartDao to set
	 */
	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
	}

	/**
	 * @return the shoppingCartProductDao
	 */
	public ShoppingCartProductDao getShoppingCartProductDao() {
		return shoppingCartProductDao;
	}

	/**
	 * @param shoppingCartProductDao
	 *            the shoppingCartProductDao to set
	 */
	public void setShoppingCartProductDao(
			ShoppingCartProductDao shoppingCartProductDao) {
		this.shoppingCartProductDao = shoppingCartProductDao;
	}

	/**
	 * @return the wishListDao
	 */
	public WishListDao getWishListDao() {
		return wishListDao;
	}

	/**
	 * @param wishListDao
	 *            the wishListDao to set
	 */
	public void setWishListDao(WishListDao wishListDao) {
		this.wishListDao = wishListDao;
	}

	/**
	 * @return the wishListProductDao
	 */
	public WishListProductDao getWishListProductDao() {
		return wishListProductDao;
	}

	/**
	 * @param wishListProductDao
	 *            the wishListProductDao to set
	 */
	public void setWishListProductDao(WishListProductDao wishListProductDao) {
		this.wishListProductDao = wishListProductDao;
	}

	/**
	 * @return the orderDao
	 */
	public OrderDao getOrderDao() {
		return orderDao;
	}

	/**
	 * @param orderDao
	 *            the orderDao to set
	 */
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	/**
	 * @return the invoiceDao
	 */
	public InvoiceDao getInvoiceDao() {
		return invoiceDao;
	}

	/**
	 * @param invoiceDao
	 *            the invoiceDao to set
	 */
	public void setInvoiceDao(InvoiceDao invoiceDao) {
		this.invoiceDao = invoiceDao;
	}

	/**
	 * @return the orderItemsDao
	 */
	public OrderItemsDao getOrderItemsDao() {
		return orderItemsDao;
	}

	/**
	 * @param orderItemsDao
	 *            the orderItemsDao to set
	 */
	public void setOrderItemsDao(OrderItemsDao orderItemsDao) {
		this.orderItemsDao = orderItemsDao;
	}

	/**
	 * @return the paymentDao
	 */
	public PaymentDao getPaymentDao() {
		return paymentDao;
	}

	/**
	 * @param paymentDao
	 *            the paymentDao to set
	 */
	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	/**
	 * @return the productDao
	 */
	public ProductDao getProductDao() {
		return productDao;
	}

	/**
	 * @param productDao
	 *            the productDao to set
	 */
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * @return the addressDao
	 */
	public AddressDao getAddressDao() {
		return addressDao;
	}

	/**
	 * @param addressDao
	 *            the addressDao to set
	 */
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	
}
