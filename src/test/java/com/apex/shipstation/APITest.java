package com.apex.shipstation;

import com.apex.shipstation.model.*;
import com.apex.shipstation.model.Tag;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class APITest {
    private static API api;

    @BeforeClass
    public static void initCalculator() {
        api = new API("https://private-anon-6ac7877a1e-shipstation.apiary-mock.com", "key", "sec");
    }

    @Before
    public void beforeEachTest() {
        //  System.out.println("This is executed before each Test");
    }

    @After
    public void afterEachTest() {
        // System.out.println("This is exceuted after each Test");
    }

    @Test
    public void testListTags() {

        try {
            List<Tag> carriers = api.listTags();

            assertEquals(carriers.get(0).getTagId(), 8362);
            assertEquals(carriers.get(0).getName(), "Backorder");
            assertEquals(carriers.get(0).getColor(), "#800080");

            assertEquals(carriers.get(1).getTagId(), 8324);
            assertEquals(carriers.get(1).getName(), "Canada");
            assertEquals(carriers.get(1).getColor(), "#ff0000");


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Test
    public void testListCarriers() {

        try {
            List<Carrier> carriers = api.listCarriers();

            assertEquals(carriers.get(0).getName(), "Express 1");
            assertEquals(carriers.get(0).getCode(), "express_1");
            assertEquals(carriers.get(0).getAccountNumber(), "fe71c33f");
            assertEquals(carriers.get(0).isRequiresFundedAccount(), true);
            assertEquals(carriers.get(0).getBalance(), 0.27, 0.01);


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Test
    public void testGetCarrier() {

        try {
            Carrier carrier = api.getCarrier("stamps_com");

            assertEquals(carrier.getName(), "Stamps.com");
            assertEquals(carrier.getCode(), "stamps_com");
            assertEquals(carrier.getAccountNumber(), "SS123");
            assertEquals(carrier.isRequiresFundedAccount(), true);
            assertEquals(carrier.getBalance(), 24.14, 0.01);


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Test
    public void testAddFund() {

        try {

            Fund fund = new Fund();
            fund.setCarrierCode("fedex");
          //  fund.setAmount(20.0);
            api.addFunds(fund);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}

