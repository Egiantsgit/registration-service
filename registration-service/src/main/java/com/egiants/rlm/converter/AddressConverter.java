package com.egiants.rlm.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.egiants.rlm.entity.Address;

public class AddressConverter implements DynamoDBTypeConverter<String, Address> {

    @Override
    public String convert(Address source) {

        if (source != null) {
            return String.format("%s x %s x %s x %s x %s",
                    source.getLine1(), source.getLine2(),
                    source.getCity(), source.getState(),
                    source.getPostalcode());
        }
        return null;
    }

    @Override
    public Address unconvert(String s) {
        // TODO: need to find a better way to convert this string to object
        Address address = new Address();

        if (s != null && s.length() != 0) {
            String[] data = s.split("x");
            address.setLine1(data[0].trim());
            address.setLine2(data[1].trim());
            address.setCity(data[2].trim());
            address.setState(data[3].trim());
            address.setPostalcode(data[4].trim());
        }
        return address;
    }
}
