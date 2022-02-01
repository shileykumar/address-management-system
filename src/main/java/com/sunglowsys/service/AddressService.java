package com.sunglowsys.service;

import com.sunglowsys.domain.Address;

import java.util.List;

public interface AddressService {

    Address save(Address address);

    List<Address> findAll();

    Address findById(Integer id);

    void delete(Integer id);
}
