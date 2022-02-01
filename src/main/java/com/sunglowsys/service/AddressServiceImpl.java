package com.sunglowsys.service;

import com.sunglowsys.domain.Address;
import com.sunglowsys.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses;
    }

    @Override
    public Address findById(Integer id) {
        Optional<Address> optional = addressRepository.findById(id);
        Address address = null;
        if (optional.isPresent()){
            address = optional.get();
        }
        else {
            throw new RuntimeException("Address not found for id:"+id);
        }
        return address;
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }
}
