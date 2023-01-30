package com.example.ApiAttornatus;

import com.example.ApiAttornatus.entities.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddressEntity {

    private Address address;

    @BeforeAll
    void setAddress(){
        this.address = new Address(
                3L,
                "Rua Paulista",
                "100011-11",
                "101",
                "São Carlos",
                true
        );
    }

    @Test
    void testAddress(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(3, address.getId()),
                () -> Assertions.assertEquals("Rua Paulista", address.getPlace()),
                () -> Assertions.assertEquals("100011-11", address.getCep()),
                () -> Assertions.assertEquals("101", address.getNumber()),
                () -> Assertions.assertEquals("São Carlos", address.getCity()),
                () -> Assertions.assertTrue(address.isMainAddress())

        );
    }
}
