package com.apex.shipstation;

import com.apex.shipstation.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
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
    public void testListTags() throws IOException, InterruptedException {

        List<Tag> carriers = api.listTags();

        assertEquals(carriers.get(0).getTagId(), 8362);
        assertEquals(carriers.get(0).getName(), "Backorder");
        assertEquals(carriers.get(0).getColor(), "#800080");

        assertEquals(carriers.get(1).getTagId(), 8324);
        assertEquals(carriers.get(1).getName(), "Canada");
        assertEquals(carriers.get(1).getColor(), "#ff0000");

    }

    @Test
    public void testListCarriers() throws IOException, InterruptedException {

        List<Carrier> carriers = api.listCarriers();

        assertEquals(carriers.get(0).getName(), "Express 1");
        assertEquals(carriers.get(0).getCode(), "express_1");
        assertEquals(carriers.get(0).getAccountNumber(), "fe71c33f");
        assertEquals(carriers.get(0).isRequiresFundedAccount(), true);
        assertEquals(carriers.get(0).getBalance(), 0.27, 0.01);

    }

    @Test
    public void testGetCarrier() throws IOException, InterruptedException {

        Carrier carrier = api.getCarrier("stamps_com");

        assertEquals(carrier.getName(), "Stamps.com");
        assertEquals(carrier.getCode(), "stamps_com");
        assertEquals(carrier.getAccountNumber(), "SS123");
        assertEquals(carrier.isRequiresFundedAccount(), true);
        assertEquals(carrier.getBalance(), 24.14, 0.01);
    }

    @Test
    public void testAddFund() throws IOException, InterruptedException {

        Fund fund = new Fund();
        fund.setCarrierCode("fedex");
        fund.setAmount(20.0);

        Carrier carrier = api.addFunds(fund);

        assertEquals(carrier.getName(), "Stamps.com");
        assertEquals(carrier.getCode(), "stamps_com");
        assertEquals(carrier.getAccountNumber(), "SS123");
        assertEquals(carrier.isRequiresFundedAccount(), true);
        assertEquals(carrier.getBalance(), 24.14, 0.01);

    }

    /*
    @Test
    public void testListPackages() throws IOException, InterruptedException {

        Package p = api.listPackages();

        assertEquals(carrier.getName(), "Stamps.com");
        assertEquals(carrier.getCode(), "stamps_com");
        assertEquals(carrier.getAccountNumber(), "SS123");
        assertEquals(carrier.isRequiresFundedAccount(), true);
        assertEquals(carrier.getBalance(), 24.14, 0.01);
    }
*/
    @Test
    public void testListServices() throws IOException, InterruptedException {

        List<Service> services = api.listServices("fedex");

        assertEquals(services.get(0).getCarrierCode(), "fedex");
        assertEquals(services.get(0).getCode(), "fedex_ground");
        assertEquals(services.get(0).getName(), "FedEx Ground®");
        assertEquals(services.get(0).isDomestic(), true);
        assertEquals(services.get(0).isInternational(), false);
    }

    @Test
    public void testGetCustomer() throws IOException, InterruptedException {

        Customer customer = api.getCustomer("12345678");

        //   assertEquals(customer.getCustomerId(), 12345678);
        assertEquals(customer.getCreateDate(), "2014-11-18T10:33:01.1900000");
        assertEquals(customer.getModifyDate(), "2014-11-18T10:33:01.1900000");
        assertEquals(customer.getName(), "Cam Newton");
        assertEquals(customer.getCompany(), "Test Company");
        assertEquals(customer.getStreet1(), "123 War Eagle Lane");
        assertEquals(customer.getStreet2(), "");
        assertEquals(customer.getCity(), "Auburn");
        assertEquals(customer.getState(), "AL");

        assertEquals(customer.getPostalCode(), "36830");
        assertEquals(customer.getCountryCode(), "US");
        assertEquals(customer.getPhone(), "555-555-5555");
        assertEquals(customer.getEmail(), "supermancam@example.com");
        assertEquals(customer.getAddressVerified(), "Verified");

        List<MarketplaceUsername> marketplaceUsernames = customer.getMarketplaceUsernames();

        assertEquals(marketplaceUsernames.get(0).getCustomerUserId(), 67195020);
        assertEquals(marketplaceUsernames.get(0).getCustomerId(), 12345678);
        assertEquals(marketplaceUsernames.get(0).getCreateDate(), "2015-04-27T12:35:03.8300000");
        assertEquals(marketplaceUsernames.get(0).getModifyDate(), "2015-05-14T08:16:15.2700000");
        assertEquals(marketplaceUsernames.get(0).getMarketplaceId(), 0);
        assertEquals(marketplaceUsernames.get(0).getMarketplace(), "ShipStation");
        assertEquals(marketplaceUsernames.get(0).getUsername(), "camtheman@gmail.com");

        List<Tag> tags = customer.getTags();
        assertEquals(tags.get(0).getTagId(), 1234);
        assertEquals(tags.get(0).getName(), "Expedited");
        assertEquals(tags.get(1).getTagId(), 9725);
        assertEquals(tags.get(1).getName(), "00 BULK ORDERED");

    }

    @Test
    public void testListCustomers() throws IOException, InterruptedException {

        ListCustomers listCustomer = api.listCustomers();

        Customer customer = listCustomer.getCustomers().get(0);

        //   assertEquals(customer.getCustomerId(), 12345678);
        assertEquals(customer.getCreateDate(), "2014-11-18T10:33:01.1900000");
        assertEquals(customer.getModifyDate(), "2014-11-18T10:33:01.1900000");
        assertEquals(customer.getName(), "Cam Newton");
        assertEquals(customer.getCompany(), "Test Company");
        assertEquals(customer.getStreet1(), "123 War Eagle Lane");
        assertEquals(customer.getStreet2(), "");
        assertEquals(customer.getCity(), "Auburn");
        assertEquals(customer.getState(), "AL");

        assertEquals(customer.getPostalCode(), "36830");
        assertEquals(customer.getCountryCode(), "US");
        assertEquals(customer.getPhone(), "555-555-5555");
        assertEquals(customer.getEmail(), "supermancam@example.com");
        assertEquals(customer.getAddressVerified(), "Verified");

        List<MarketplaceUsername> marketplaceUsernames = customer.getMarketplaceUsernames();

        assertEquals(marketplaceUsernames.get(0).getCustomerUserId(), 67195020);
        assertEquals(marketplaceUsernames.get(0).getCustomerId(), 12345678);
        assertEquals(marketplaceUsernames.get(0).getCreateDate(), "2015-04-27T12:35:03.8300000");
        assertEquals(marketplaceUsernames.get(0).getModifyDate(), "2015-05-14T08:16:15.2700000");
        assertEquals(marketplaceUsernames.get(0).getMarketplaceId(), 0);
        assertEquals(marketplaceUsernames.get(0).getMarketplace(), "ShipStation");
        assertEquals(marketplaceUsernames.get(0).getUsername(), "camtheman@gmail.com");

        List<Tag> tags = customer.getTags();
        assertEquals(tags.get(0).getTagId(), 1234);
        assertEquals(tags.get(0).getName(), "Expedited");
        assertEquals(tags.get(1).getTagId(), 9725);
        assertEquals(tags.get(1).getName(), "00 BULK ORDERED");

        assertEquals(listCustomer.getTotal(), 2);
        assertEquals(listCustomer.getPage(), 1);
        assertEquals(listCustomer.getPages(), 1);
    }


}

