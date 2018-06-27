package com.egiants.rlm.converter;

import com.egiants.rlm.entity.Address;
import com.egiants.rlm.entity.UserPersonalDetails;

import java.time.LocalDate;

public class RunMe {

    public static void main(String[] args) {
        /*Address address = new Address();
        address.setLine1("Line1");
        address.setLine2("Line2");
        address.setCity("KOP");
        address.setPostalcode("19406");
        address.setState("PA");
        AddressItemConverter addressItemConverter = new AddressItemConverter();
        String xyz = addressItemConverter.convert(null);
        Address address1 = addressItemConverter.unconvert(xyz);
        System.out.println("abc"+address1.toString());*/
        UserPersonalDetails userPersonalDetails = new UserPersonalDetails();
        String xyz = LocalDate.now().toString();
        System.out.println("abc"+ LocalDate.parse(xyz));

    }
}
