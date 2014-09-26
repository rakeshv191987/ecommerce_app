/**
 * 
 */
package com.bostonretailer.retailerdao;

import org.hibernate.Query;

import com.bostonretailer.retailercommon.Address;

/**
 * @author Rakesh_Viswanathan
 * 
 */
public class AddressDaoImpl extends DAOSupport implements AddressDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.AddressDao#save(com.bostonretailer.
	 * retailercommon.Address)
	 */
	@Override
	public void save(Address address) {
		try {
			begin();
			getSession().save(address);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.AddressDao#delete(com.bostonretailer.
	 * retailercommon.Address)
	 */
	@Override
	public void delete(Address address) {
		try {
			begin();
			getSession().delete(address);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bostonretailer.retailerdao.AddressDao#update(com.bostonretailer.
	 * retailercommon.Address)
	 */
	@Override
	public void update(Address address) {
		try {
			begin();
			getSession().update(address);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bostonretailer.retailerdao.AddressDao#findAddress(java.lang.Long)
	 */
	@Override
	public Address findAddress(Long addressId) {
		try {
			Query q = getSession().createQuery(
					"from Address where addressId = :addressId");
			q.setLong("addressId", addressId);
			Address address = (Address) q.uniqueResult();
			return address;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}

}
