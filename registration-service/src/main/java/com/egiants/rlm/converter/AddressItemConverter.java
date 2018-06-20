package com.egiants.rlm.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.egiants.rlm.entity.Address;

import java.util.Optional;

public class AddressItemConverter implements DynamoDBTypeConverter<String, Address> {

    @Override
    public String convert(Address source) {
        return Optional.ofNullable(String.format("%s x %s x %s x %s x %s",
                source.getLine1(), source.getLine2(), source.getCity(),
                source.getState(), source.getPostalcode()))
                .orElse(null);
    }

    @Override
    public Address unconvert(String s) {
        //TODO: need to find a better way to convert this string to object
        return null;
    }
}
