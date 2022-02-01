package com.sunglowsys.controller;

import com.sunglowsys.domain.Address;
import com.sunglowsys.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("address",addressService.findAll());
        return "index";
    }

    @GetMapping("/addAddress")
    public String addAddressForm(Model model){
        Address address = new Address();
        model.addAttribute("address",address);
        return "add_address";
    }

    @PostMapping("/saveAddress")
    public String saveAddress(@ModelAttribute("address") Address address){
        addressService.save(address);
        return "redirect:/";
    }

    @GetMapping("/updateAddress/{id}")
    public String updateAddressForm(@PathVariable("id") Integer id, Model model){
        Address address = addressService.findById(id);
        model.addAttribute("address",address);
        return "update_address";
    }

    @GetMapping("deleteAddress/{id}")
    public String deleteAddress(@PathVariable("id") Integer id){
        addressService.delete(id);
        return "redirect:/";
    }
}
