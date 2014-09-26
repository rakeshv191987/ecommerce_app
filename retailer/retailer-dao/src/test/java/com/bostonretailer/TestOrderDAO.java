/**
 * 
 */
package com.bostonretailer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.bostonretailer.retailercommon.Address;
import com.bostonretailer.retailercommon.Customer;
import com.bostonretailer.retailercommon.Invoice;
import com.bostonretailer.retailercommon.Order;
import com.bostonretailer.retailercommon.OrderItems;
import com.bostonretailer.retailercommon.Payment;
import com.bostonretailer.retailercommon.Product;
import com.bostonretailer.retailercommon.RefOrderStatus;
import com.bostonretailer.retailercommon.Shipment;
import com.bostonretailer.retailerdao.AddressDao;
import com.bostonretailer.retailerdao.CustomerDao;
import com.bostonretailer.retailerdao.InvoiceDao;
import com.bostonretailer.retailerdao.OrderDao;
import com.bostonretailer.retailerdao.OrderItemsDao;
import com.bostonretailer.retailerdao.PaymentDao;
import com.bostonretailer.retailerdao.ProductDao;
import com.bostonretailer.retailerdao.ShipmentDao;

/**
 * @author Rakesh_Viswanathan
 * 
 */

@Transactional
public class TestOrderDAO extends TestCase {

	@Test
	public void test() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"retailer-dao-application-context.xml");

		OrderDao orderDao = (OrderDao) appContext.getBean("orderDao");
		CustomerDao customerDao = (CustomerDao) appContext
				.getBean("customerDao");
		AddressDao addressDao = (AddressDao) appContext.getBean("addressDao");
		InvoiceDao invoiceDao = (InvoiceDao) appContext.getBean("invoiceDao");
		ShipmentDao shipmentDao = (ShipmentDao) appContext
				.getBean("shipmentDao");
		OrderItemsDao orderItemsDao = (OrderItemsDao) appContext
				.getBean("orderItemsDao");
		ProductDao productDao = (ProductDao) appContext.getBean("productDao");
		PaymentDao paymentDao = (PaymentDao) appContext.getBean("paymentDao");

		try {
			/** Create Order **/
			Order order = new Order();

			Customer customer = (Customer) customerDao.findCustomer(1L);
			Address address = (Address) addressDao.findAddress(28L);
			/** Create new Invoice **/
			Invoice invoice = new Invoice();
			invoice.setOrder(order);
			invoice.setInvoiceDate(new Date());
			/** Create new Payment **/
			Payment payment = new Payment();
			payment.setInvoice(invoice);
			payment.setPaymentAmount(1000F);
			payment.setPaymentDate(new Date());
			paymentDao.save(payment);
			/** Payment created **/
			invoice.setPayment(payment);
			invoiceDao.save(invoice);
			/** Invoice created **/
			/** Create new Shipment **/
			Shipment shipment = new Shipment();
			shipment.setOrder(order);
			shipment.setShipmentDate(new Date());
			shipment.setDateOrderDelivered(new Date());
			shipmentDao.save(shipment);
			/** Shipment created **/
			/** Create new Order Items **/
			OrderItems orderItem1 = new OrderItems();
			orderItem1.setOrder(order);
			/** Create new Product **/
			Product product = (Product) productDao.findProductById(5L);
			/** Product created **/
			orderItem1.setItem(product);
			orderItem1.setOrderItemQuantity(2);
			orderItem1.setOrderItemPrice(80F);
			orderItemsDao.save(orderItem1);
			/** Order Items created **/
			List<OrderItems> orderItems = new ArrayList<OrderItems>();
			orderItems.add(orderItem1);

			order.setCustomer(customer);
			order.setRefOrderStatus(RefOrderStatus.PENDING);
			order.setDateOrderPlaced(new Date());
			order.setDateOrderExpectedDelivery(new Date());
			order.setDateOrderDelivery(new Date());
			order.setOrderAddress(address);
			order.setInvoice(invoice);
			order.setShipment(shipment);
			order.setOrderItem(orderItems);
			orderDao.save(order);
			assertNotNull(order);
			/** Order created **/

			/** Find Order **/
			Order order1 = (Order) orderDao.findOrder(order.getOrderId());
			assertNotNull(order1);

			/** Update Order **/
			Order order2 = (Order) orderDao.findOrder(order.getOrderId());
			order.setRefOrderStatus(RefOrderStatus.SHIPPED);
			orderDao.update(order);
			assertEquals(order2.getInvoice().getInvoiceNumber(),
					invoice.getInvoiceNumber());
			assertEquals(order2.getShipment().getShipmentTrackingNumber(),
					shipment.getShipmentTrackingNumber());

			/** Delete Order **/
			Order order3 = null;
			Long orderId2 = order2.getOrderId();
			orderDao.delete(order2);
			order3 = orderDao.findOrder(orderId2);
			assertNull(order3);

		} finally {
			((AbstractApplicationContext) appContext).close();
		}
	}

}
