package com.ian.onlinemall.dao.impl;

import java.util.List;

import com.ian.onlinemall.dao.AddressDao;
import com.ian.onlinemall.dao.BaseDao;
import com.ian.onlinemall.domain.Address;
import com.ian.onlinemall.domain.User;

public class AddressDaoImpl extends BaseDao implements AddressDao{

	public List<Address> findItemByUser(User user) {
		List<Address> addresses = getResultList(Address.class
				, "where o.user = ?1"
				, null
				, user);
		if (addresses != null && addresses.size() > 0) {
			return addresses;
		}
		return null;
	}

}
