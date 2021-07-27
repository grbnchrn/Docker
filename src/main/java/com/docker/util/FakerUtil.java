package com.docker.util;


import com.docker.model.Address;
import com.github.javafaker.Faker;

public class FakerUtil {

    public static final Faker faker = Faker.instance();

    public static Faker getFakerInstance(){
        return faker;
    }

    public static String getName(){
        return faker.name().fullName();
    }

    public static Address getAddress(){
        com.github.javafaker.Address fAdd = faker.address();
        return new Address(fAdd.streetName(), fAdd.streetAddressNumber(),
                fAdd.cityName(),fAdd.state(),fAdd.zipCode(),fAdd.country());

    }

    public static int getId(){
        return faker.number().numberBetween(0, Integer.MAX_VALUE);
    }




}
