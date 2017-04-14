package com.apex.shipstation;

import com.apex.shipstation.model.*;
import org.junit.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class APITest {
    private static API api;

    @BeforeClass
    public static void initAPI() {
        api = new API("https://private-anon-6ac7877a1e-shipstation.apiary-mock.com", "key", "sec");
    }

    @Before
    public void beforeEachTest() {

    }

    @After
    public void afterEachTest() {

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

    @Test
    public void testListPackages() throws IOException, InterruptedException {

        List<com.apex.shipstation.model.Package> packages = api.listPackages("express_1");

        assertEquals(packages.get(0).getCarrierCode(), "express_1");
        assertEquals(packages.get(0).getCode(), "cubic");
        assertEquals(packages.get(0).getName(), "Cubic");
        assertEquals(packages.get(0).isDomestic(), true);
        assertEquals(packages.get(0).isInternational(), false);

        assertEquals(packages.get(1).getCarrierCode(), "express_1");
        assertEquals(packages.get(1).getCode(), "dvd_flat_rate_box");
        assertEquals(packages.get(1).getName(), "DVD Flat Rate Box");
        assertEquals(packages.get(1).isDomestic(), false);
        assertEquals(packages.get(1).isInternational(), true);

    }

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

        assertEquals(customer.getCustomerId(), 12345678);
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

        assertEquals(customer.getCustomerId(), 12345678);
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

    @Test
    public void testListFulfillments() throws IOException, InterruptedException {

        ListFulfillments fulfillments = api.listFulfillments();

        assertEquals(fulfillments.getFulfillments().get(0).getFulfillmentId(), 33974374);
        assertEquals(fulfillments.getFulfillments().get(0).getOrderId(), 191759016);
        assertEquals(fulfillments.getFulfillments().get(0).getOrderNumber(), "101");
        assertEquals(fulfillments.getFulfillments().get(0).getUserId(), "c9f06d74-95de-4263-9b04-e87095cababf");
        assertEquals(fulfillments.getFulfillments().get(0).getCustomerEmail(), "apisupport@shipstation.com");
        assertEquals(fulfillments.getFulfillments().get(0).getTrackingNumber(), "783408231234");
        assertEquals(fulfillments.getFulfillments().get(0).getCreateDate(), "2016-06-07T08:50:50.0670000");
        assertEquals(fulfillments.getFulfillments().get(0).getShipDate(), "2016-06-07T00:00:00.0000000");
        assertEquals(fulfillments.getFulfillments().get(0).getVoidDate(), null);
        assertEquals(fulfillments.getFulfillments().get(0).getDeliveryDate(), null);
        assertEquals(fulfillments.getFulfillments().get(0).getCarrierCode(), "USPS");
        assertEquals(fulfillments.getFulfillments().get(0).getFulfillmentProviderCode(), null);
        assertEquals(fulfillments.getFulfillments().get(0).getFulfillmentServiceCode(), null);
        assertEquals(fulfillments.getFulfillments().get(0).getFulfillmentFee(), 0, 0.01);
        assertEquals(fulfillments.getFulfillments().get(0).isVoidRequested(), false);
        assertEquals(fulfillments.getFulfillments().get(0).isVoided(), false);
        assertEquals(fulfillments.getFulfillments().get(0).isMarketplaceNotified(), true);
        assertEquals(fulfillments.getFulfillments().get(0).getNotifyErrorMessage(), null);

        assertEquals(fulfillments.getFulfillments().get(0).getShipTo().getName(), "Yoda");
        assertEquals(fulfillments.getFulfillments().get(0).getShipTo().getCompany(), null);
        assertEquals(fulfillments.getFulfillments().get(0).getShipTo().getStreet1(), "3800 N Lamar Blvd # 220");
        assertEquals(fulfillments.getFulfillments().get(0).getShipTo().getStreet2(), null);
        assertEquals(fulfillments.getFulfillments().get(0).getShipTo().getStreet3(), null);
        assertEquals(fulfillments.getFulfillments().get(0).getShipTo().getCity(), "AUSTIN");
        assertEquals(fulfillments.getFulfillments().get(0).getShipTo().getState(), "TX");
        assertEquals(fulfillments.getFulfillments().get(0).getShipTo().getPostalCode(), "78756");
        assertEquals(fulfillments.getFulfillments().get(0).getShipTo().getCountry(), "US");

        assertEquals(fulfillments.getFulfillments().get(0).getShipTo().getPhone(), "512-485-4282");
        assertEquals(fulfillments.getFulfillments().get(0).getShipTo().isResidential(), false); //null boolean is a false
        assertEquals(fulfillments.getFulfillments().get(0).getShipTo().getAddressVerified(), null);

    }

    @Test
    public void testGetOrder() throws IOException, InterruptedException {

        Order order = api.getOrder(123456789);

        assertEquals(order.getOrderId(), 94113592);
        assertEquals(order.getOrderNumber(), "TEST-ORDER-API-DOCS");
        assertEquals(order.getOrderKey(), "0f6bec18-9-4771-83aa-f392d84f4c74");
        assertEquals(order.getOrderDate(), "2015-06-29T08:46:27.0000000");
        assertEquals(order.getCreateDate(), "2015-07-16T14:00:34.8230000");
        assertEquals(order.getModifyDate(), "2015-09-08T11:03:12.3800000");
        assertEquals(order.getPaymentDate(), "2015-06-29T08:46:27.0000000");
        assertEquals(order.getShipByDate(), "2015-07-05T00:00:00.0000000");
        assertEquals(order.getOrderStatus(), "awaiting_shipment");
        assertEquals(order.getCustomerId(), 37701499);
        assertEquals(order.getCustomerUsername(), "headhoncho@whitehouse.gov");
        assertEquals(order.getBillTo().getName(), "The President");
        assertEquals(order.getBillTo().getCompany(), null);
        assertEquals(order.getBillTo().getStreet1(), null);
        assertEquals(order.getBillTo().getStreet2(), null);
        assertEquals(order.getBillTo().getStreet3(), null);
        assertEquals(order.getBillTo().getCity(), null);
        assertEquals(order.getBillTo().getState(), null);
        assertEquals(order.getBillTo().getPostalCode(), null);
        assertEquals(order.getBillTo().getPhone(), null);
        assertEquals(order.getBillTo().isResidential(), false);
        assertEquals(order.getBillTo().getState(), null);
        assertEquals(order.getBillTo().getAddressVerified(), null);

        assertEquals(order.getShipTo().getName(), "The President");
        assertEquals(order.getShipTo().getCompany(), "US Govt");
        assertEquals(order.getShipTo().getStreet1(), "1600 Pennsylvania Ave");
        assertEquals(order.getShipTo().getStreet2(), "Oval Office");
        assertEquals(order.getShipTo().getStreet3(), null);
        assertEquals(order.getShipTo().getCity(), "Washington");
        assertEquals(order.getShipTo().getState(), "DC");
        assertEquals(order.getShipTo().getPostalCode(), "20500");
        assertEquals(order.getShipTo().getPhone(), "555-555-5555");
        assertEquals(order.getShipTo().isResidential(), false);
        assertEquals(order.getShipTo().getState(), "DC");
        assertEquals(order.getShipTo().getAddressVerified(), "Address validation warning");

        List<OrderItem> items = order.getItems();

        assertEquals(items.get(0).getOrderItemId(), 128836912);
        assertEquals(items.get(0).getLineItemKey(), "vd08-MSLbtx");
        assertEquals(items.get(0).getSku(), "ABC123");
        assertEquals(items.get(0).getName(), "Test item #1");
        assertEquals(items.get(0).getImageUrl(), null);
        assertEquals(items.get(0).getWeight().getValue(), 24);
        assertEquals(items.get(0).getWeight().getUnits(), "ounces");
        assertEquals(items.get(0).getQuantity(), 2, 0.01);
        assertEquals(items.get(0).getUnitPrice(), 99.99, 0.01);
        assertEquals(items.get(0).getTaxAmount(), 0.0, 0.01); //null double is 0.0
        assertEquals(items.get(0).getShippingAmount(), 0.0, 0.01);//null double is 0.0
        assertEquals(items.get(0).getWarehouseLocation(), "Aisle 1, Bin 7");
        assertEquals(items.get(0).getOptions().get(0).getName(), "Size");
        assertEquals(items.get(0).getOptions().get(0).getValue(), "Large");
        assertEquals(order.getOrderTotal(), 194.43, 0.01);
        assertEquals(order.getAmountPaid(), 218.73, 0.01);
        assertEquals(order.getTaxAmount(), 5, 0.01);
        assertEquals(order.getShippingAmount(), 10, 0.01);
        assertEquals(order.getCustomerNotes(), "Thanks for ordering!");
        assertEquals(order.getInternalNotes(), "Customer called and would like to upgrade shipping");
        assertEquals(order.isGift(), true);
        assertEquals(order.getGiftMessage(), "Thank you!");
        assertEquals(order.getPaymentMethod(), "Credit Card");
        assertEquals(order.getRequestedShippingService(), "Priority Mail");
        assertEquals(order.getCarrierCode(), "fedex");
        assertEquals(order.getServiceCode(), "fedex_home_delivery");
        assertEquals(order.getPackageCode(), "package");
        assertEquals(order.getConfirmation(), "delivery");
        assertEquals(order.getShipDate(), "2015-07-02");
        assertEquals(order.getHoldUntilDate(), null);
        assertEquals(order.getWeight().getValue(), 48);
        assertEquals(order.getWeight().getUnits(), "ounces");
        assertEquals(order.getDimensions().getUnits(), "inches");
        assertEquals(order.getDimensions().getLength(), 7, 0.1);
        assertEquals(order.getDimensions().getWidth(), 5, 0.1);
        assertEquals(order.getDimensions().getHeight(), 6, 0.1);
        assertEquals(order.getInsuranceOptions().getProvider(), "carrier");
        assertEquals(order.getInsuranceOptions().isInsureShipment(), true);
        assertEquals(order.getInsuranceOptions().getInsuredValue(), 200, 0.01);
        assertEquals(order.getInternationalOptions().getContents(), null);
        assertEquals(order.getInternationalOptions().getCustomsItems(), null);
        assertEquals(order.getInternationalOptions().getNonDelivery(), null);
        assertEquals(order.getAdvancedOptions().getWarehouseId(), 24079);
        assertEquals(order.getAdvancedOptions().isNonMachinable(), false);
        assertEquals(order.getAdvancedOptions().isSaturdayDelivery(), false);
        assertEquals(order.getAdvancedOptions().isContainsAlcohol(), false);
        assertEquals(order.getAdvancedOptions().isMergedOrSplit(), false);
        assertEquals(order.getAdvancedOptions().getMergedIds().length, 0); //checking length, cant compare long[]
        assertEquals(order.getAdvancedOptions().getParentId(), null);
        assertEquals(order.getAdvancedOptions().getStoreId(), 26815);
        assertEquals(order.getAdvancedOptions().getCustomField1(), "Custom data that you can add to an order. See Custom Field #2 & #3 for more info!");
        assertEquals(order.getAdvancedOptions().getCustomField2(), "Per UI settings, this information can appear on some carrier's shipping labels. See link below");
        assertEquals(order.getAdvancedOptions().getCustomField3(), "https://help.shipstation.com/hc/en-us/articles/206639957");
        assertEquals(order.getAdvancedOptions().getSource(), "Webstore");
        assertEquals(order.getAdvancedOptions().getBillToParty(), null);
        assertEquals(order.getAdvancedOptions().getBillToAccount(), null);
        assertEquals(order.getAdvancedOptions().getBillToPostalCode(), null);
        assertEquals(order.getAdvancedOptions().getBillToCountryCode(), null);
        assertEquals(order.getTagIds(), null);
        assertEquals(order.getUserId(), null);
        assertEquals(order.isExternallyFulfilled(), false);
        assertEquals(order.getExternallyFulfilledBy(), null);

    }

    @Test
    public void testDeleteOrder() throws IOException, InterruptedException {

        SuccessResponse response = api.deleteOrder(123456789);

        assertEquals(response.isSuccess(), true);
        assertEquals(response.getMessage(), "The requested order has been deleted.");

    }

    @Test
    public void testAddTagToOrder() throws IOException, InterruptedException {

        SuccessResponse response = api.addTagToOrder(123456, 1234);

        assertEquals(response.isSuccess(), true);
        assertEquals(response.getMessage(), "Tag added successfully.");

    }

    @Test
    public void testAssignUserToOrder() throws IOException, InterruptedException {

        UserToOrderPayload payload = new UserToOrderPayload();
        long orderIds[] = {123456789, 12345679};
        payload.setOrderIds(orderIds);
        payload.setUserid("123456AB-ab12-3c4d-5e67-89f1abc1defa");

        SuccessResponse response = api.assignUserToOrder(payload);

        assertEquals(response.isSuccess(), true);
        assertEquals(response.getMessage(), "User assigned successfully.");

    }

    @Test
    public void testCreateLabelForOrder() throws IOException, InterruptedException {

        LabelForOrderPayload payload = new LabelForOrderPayload();
        payload.setOrderId(93348442);
        payload.setCarrierCode("fedex");
        payload.setServiceCode("fedex_2day");
        payload.setConfirmation(null);
        payload.setShipDate("2014-04-03");
        Weight weight = new Weight();
        weight.setValue(2);
        weight.setUnits("pounds");
        payload.setWeight(weight);
        payload.setTestLabel(false);

        Label label = api.createLabelForOrder(payload);

        assertEquals(label.getShipmentId(), 72513480);
        assertEquals(label.getShipmentCost(), 7.3, 0.01);
        assertEquals(label.getInsuranceCost(), 0, 0.01);
        assertEquals(label.getTrackingNumber(), "248201115029520");
        assertEquals(label.getLabelData(), "JVBERi0xLjQKJeLjz9MKMiAwIG9iago8PC9MZW5ndGggNjIvRmlsdGVyL0ZsYXRlRGVjb2RlPj5zdHJlYW0KeJwr5HIK4TI2UzC2NFMISeFyDeEK5CpUMFQwAEJDBV0jCz0LBV1jY0M9I4XkXAX9iDRDBZd8hUAuAEdGC7cKZW5kc3RyZWFtCmVuZG9iago0IDAgb2JqCjw8L1R5cGUvUGFnZS9NZWRpYUJveFswIDAgMjg4IDQzMl0vUmVzb3VyY2VzPDwvUHJvY1NldCBbL1BERiAvVGV4dCAvSW1hZ2VCIC9JbWFnZUMgL0ltYWdlSV0vWE9iamVjdDw8L1hmMSAxIDAgUj4+Pj4vQ29udGVudHMgMiAwIFIvUGFyZW50....");
        assertEquals(label.getFormData(), null);

    }

    @Test
    public void testOrderCreate() throws IOException, InterruptedException {

        Order order = new Order();
        order.setOrderId(140335319);
        order.setOrderNumber("TEST-ORDER-API-DOCS");

        Order reply = api.createOrder(order);

        assertEquals(reply.getOrderId(), 140335319);
        assertEquals(reply.getOrderNumber(), "TEST-ORDER-API-DOCS");
    }

    @Test
    public void testCreateOrders() throws IOException, InterruptedException {

        List<Order> orders = new ArrayList<Order>();

        Order order1 = new Order();
        order1.setOrderId(140335319);
        order1.setOrderNumber("TEST-ORDER-API-DOCS");
        orders.add(order1);

        Order order2 = new Order();
        order2.setOrderId(140335319);
        order2.setOrderNumber("TEST-ORDER-API-DOCS");
        orders.add(order2);

        BulkOrdersResponse reply = api.createOrders(orders);

        assertEquals(reply.isHasErrors(), false);
        assertEquals(reply.getResults().get(0).getOrderId(), 58345234);
        assertEquals(reply.getResults().get(0).getOrderNumber(), "TEST-ORDER-API-DOCS");
        assertEquals(reply.getResults().get(0).getOrderKey(), "0f6bec18-3e89-4881-83aa-f392d84f4c74");
        assertEquals(reply.getResults().get(0).isSuccess(), true);
        assertEquals(reply.getResults().get(0).getErrorMessage(), null);


    }

    @Test
    public void tesHoldOrderUntil() throws IOException, InterruptedException {

        SuccessResponse response = api.holdOrderUntil(1072467, "2014-12-01");

        assertEquals(response.isSuccess(), true);
        assertEquals(response.getMessage(), "Order held successfully.");

    }

    @Test
    public void testListOrder() throws IOException, InterruptedException {

        ListOrders listOrders = api.listOrders();

        Order order = listOrders.getOrders().get(0);

        assertEquals(order.getOrderId(), 987654321);
        assertEquals(order.getOrderNumber(), "Test-International-API-DOCS");
        assertEquals(order.getOrderKey(), "Test-International-API-DOCS");
        assertEquals(order.getOrderDate(), "2015-06-28T17:46:27.0000000");
        assertEquals(order.getCreateDate(), "2015-08-17T09:24:14.7800000");
        assertEquals(order.getModifyDate(), "2015-08-17T09:24:16.4800000");
        assertEquals(order.getPaymentDate(), "2015-06-28T17:46:27.0000000");
        assertEquals(order.getShipByDate(), "2015-07-05T00:00:00.0000000");
        assertEquals(order.getOrderStatus(), "awaiting_shipment");
        assertEquals(order.getCustomerId(), 63310475);
        assertEquals(order.getCustomerUsername(), "sholmes1854@methodsofdetection.com");
        assertEquals(order.getCustomerUsername(), "sholmes1854@methodsofdetection.com");

        assertEquals(order.getBillTo().getName(), "Sherlock Holmes");
        assertEquals(order.getBillTo().getCompany(), null);
        assertEquals(order.getBillTo().getStreet1(), null);
        assertEquals(order.getBillTo().getStreet2(), null);
        assertEquals(order.getBillTo().getStreet3(), null);
        assertEquals(order.getBillTo().getCity(), null);
        assertEquals(order.getBillTo().getState(), null);
        assertEquals(order.getBillTo().getPostalCode(), null);
        assertEquals(order.getBillTo().getPhone(), null);
        assertEquals(order.getBillTo().isResidential(), false);
        assertEquals(order.getBillTo().getState(), null);
        assertEquals(order.getBillTo().getAddressVerified(), null);

        assertEquals(order.getShipTo().getName(), "Sherlock Holmes");
        assertEquals(order.getShipTo().getCompany(), "");
        assertEquals(order.getShipTo().getStreet1(), "221 B Baker St");
        assertEquals(order.getShipTo().getStreet2(), "");
        assertEquals(order.getShipTo().getStreet3(), null);
        assertEquals(order.getShipTo().getCity(), "London");
        assertEquals(order.getShipTo().getState(), "");
        assertEquals(order.getShipTo().getPostalCode(), "NW1 6XE");
        assertEquals(order.getShipTo().getCountry(), "GB");
        assertEquals(order.getShipTo().getPhone(), null);
        assertEquals(order.getShipTo().isResidential(), true);
        assertEquals(order.getShipTo().getAddressVerified(), "Address not yet validated");

        List<OrderItem> items = order.getItems();

        assertEquals(items.get(0).getOrderItemId(), 136282568);
        assertEquals(items.get(0).getLineItemKey(), null);
        assertEquals(items.get(0).getSku(), "Ele-1234");
        assertEquals(items.get(0).getName(), "Elementary Disguise Kit");
        assertEquals(items.get(0).getImageUrl(), null);
        assertEquals(items.get(0).getWeight().getValue(), 12);
        assertEquals(items.get(0).getWeight().getUnits(), "ounces");
        assertEquals(items.get(0).getQuantity(), 2, 0.01);
        assertEquals(items.get(0).getUnitPrice(), 49.99, 0.01);
        assertEquals(items.get(0).getTaxAmount(), 0.0, 0.01);//null double is 0.0
        assertEquals(items.get(0).getShippingAmount(), 0.0, 0.01);//null double is 0.0
        assertEquals(items.get(0).getWarehouseLocation(), "Aisle 1, Bin 7");
        assertEquals(order.getOrderTotal(), 387.97, 0.01);
        assertEquals(order.getAmountPaid(), 412.97, 0.01);
        assertEquals(order.getTaxAmount(), 27.99, 0.01);
        assertEquals(order.getShippingAmount(), 35, 0.01);
        assertEquals(order.getCustomerNotes(), "Please be careful when packing the disguise kits in with the cane.");
        assertEquals(order.getInternalNotes(), "Mr. Holmes called to upgrade his shipping to expedited");
        assertEquals(order.isGift(), false);
        assertEquals(order.getGiftMessage(), null);
        assertEquals(order.getPaymentMethod(), null);
        assertEquals(order.getRequestedShippingService(), "Priority Mail Int");
        assertEquals(order.getCarrierCode(), "stamps_com");
        assertEquals(order.getServiceCode(), "usps_priority_mail_international");
        assertEquals(order.getPackageCode(), "package");
        assertEquals(order.getConfirmation(), "delivery");
        assertEquals(order.getShipDate(), "2015-04-25");
        assertEquals(order.getHoldUntilDate(), null);
        assertEquals(order.getWeight().getValue(), 104);
        assertEquals(order.getWeight().getUnits(), "ounces");
        assertEquals(order.getDimensions().getUnits(), "inches");
        assertEquals(order.getDimensions().getLength(), 40, 0.1);
        assertEquals(order.getDimensions().getWidth(), 7, 0.1);
        assertEquals(order.getDimensions().getHeight(), 5, 0.1);
        assertEquals(order.getInsuranceOptions().getProvider(), null);
        assertEquals(order.getInsuranceOptions().isInsureShipment(), false);
        assertEquals(order.getInsuranceOptions().getInsuredValue(), 0, 0.01);
        assertEquals(order.getInternationalOptions().getContents(), "merchandise");
        assertEquals(order.getInternationalOptions().getCustomsItems().get(0).getCustomsItemId(), "11558268");
        assertEquals(order.getInternationalOptions().getCustomsItems().get(0).getDescription(), "Fine White Oak Cane");
        assertEquals(order.getInternationalOptions().getCustomsItems().get(0).getQuantity(), 1);
        assertEquals(order.getInternationalOptions().getCustomsItems().get(0).getValue(), 225, 0.01);
        assertEquals(order.getInternationalOptions().getCustomsItems().get(0).getHarmonizedTariffCode(), null);
        assertEquals(order.getInternationalOptions().getCustomsItems().get(0).getCountryOfOrigin(), "US");
        assertEquals(order.getInternationalOptions().getCustomsItems().get(1).getCustomsItemId(), "11558267");
        assertEquals(order.getInternationalOptions().getCustomsItems().get(1).getDescription(), "Elementary Disguise Kit");
        assertEquals(order.getInternationalOptions().getCustomsItems().get(1).getQuantity(), 2);
        assertEquals(order.getInternationalOptions().getCustomsItems().get(1).getValue(), 49.99, 0.01);
        assertEquals(order.getInternationalOptions().getCustomsItems().get(1).getHarmonizedTariffCode(), null);
        assertEquals(order.getInternationalOptions().getCustomsItems().get(1).getCountryOfOrigin(), "US");
        assertEquals(order.getInternationalOptions().getNonDelivery(), "return_to_sender");

        assertEquals(order.getAdvancedOptions().getWarehouseId(), 98765);
        assertEquals(order.getAdvancedOptions().isNonMachinable(), false);
        assertEquals(order.getAdvancedOptions().isSaturdayDelivery(), false);
        assertEquals(order.getAdvancedOptions().isContainsAlcohol(), false);
        assertEquals(order.getAdvancedOptions().isMergedOrSplit(), false);
        assertEquals(order.getAdvancedOptions().getMergedIds().length, 0); //checking length, cant compare long[]
        assertEquals(order.getAdvancedOptions().getParentId(), null);
        assertEquals(order.getAdvancedOptions().getStoreId(), 12345);
        assertEquals(order.getAdvancedOptions().getCustomField1(), "SKU: CN-9876 x 1");
        assertEquals(order.getAdvancedOptions().getCustomField2(), "SKU: Ele-123 x 2");
        assertEquals(order.getAdvancedOptions().getCustomField3(), null);
        assertEquals(order.getAdvancedOptions().getSource(), null);
        assertEquals(order.getAdvancedOptions().getBillToParty(), null);
        assertEquals(order.getAdvancedOptions().getBillToAccount(), null);
        assertEquals(order.getAdvancedOptions().getBillToPostalCode(), null);
        assertEquals(order.getAdvancedOptions().getBillToCountryCode(), null);
        assertEquals(order.getTagIds(), null);
        assertEquals(order.getUserId(), null);
        assertEquals(order.isExternallyFulfilled(), false);
        assertEquals(order.getExternallyFulfilledBy(), null);

        assertEquals(listOrders.getTotal(), 2);
        assertEquals(listOrders.getPage(), 1);
        assertEquals(listOrders.getPages(), 0);

    }

    @Test
    public void testListOrderByTag() throws IOException, InterruptedException {

        ListOrders listOrders = api.listOrdersByTag("orderStatus=awaiting_payment");
        Order order = listOrders.getOrders().get(0);

        assertEquals(order.getOrderId(), 123456789);
        assertEquals(order.getOrderNumber(), "TEST-ORDER-API-DOCS");
        assertEquals(order.getOrderKey(), "0f6bec18-3e89-4881-83aa-f392d84f4c74");
        assertEquals(order.getOrderDate(), "2015-06-29T08:46:27.0000000");
        assertEquals(order.getCreateDate(), "2015-08-17T09:43:03.0500000");
        assertEquals(order.getModifyDate(), "2015-08-17T09:43:12.5500000");
        assertEquals(order.getPaymentDate(), "2015-06-29T08:46:27.0000000");
        assertEquals(order.getShipByDate(), "2015-07-05T00:00:00.0000000");
        assertEquals(order.getOrderStatus(), "awaiting_shipment");
        assertEquals(order.getCustomerId(), 37701499);
        assertEquals(order.getCustomerUsername(), "headhoncho@whitehouse.gov");
        assertEquals(order.getBillTo().getName(), "The President");
        assertEquals(order.getBillTo().getCompany(), null);
        assertEquals(order.getBillTo().getStreet1(), null);
        assertEquals(order.getBillTo().getStreet2(), null);
        assertEquals(order.getBillTo().getStreet3(), null);
        assertEquals(order.getBillTo().getCity(), null);
        assertEquals(order.getBillTo().getState(), null);
        assertEquals(order.getBillTo().getPostalCode(), null);
        assertEquals(order.getBillTo().getPhone(), null);
        assertEquals(order.getBillTo().isResidential(), false);
        assertEquals(order.getBillTo().getState(), null);
        assertEquals(order.getBillTo().getAddressVerified(), null);

        assertEquals(order.getShipTo().getName(), "The President");
        assertEquals(order.getShipTo().getCompany(), "US Govt");
        assertEquals(order.getShipTo().getStreet1(), "1600 Pennsylvania Ave");
        assertEquals(order.getShipTo().getStreet2(), "Oval Office");
        assertEquals(order.getShipTo().getStreet3(), null);
        assertEquals(order.getShipTo().getCity(), "Washington");
        assertEquals(order.getShipTo().getState(), "DC");
        assertEquals(order.getShipTo().getPostalCode(), "20500");
        assertEquals(order.getShipTo().getPhone(), "555-555-5555");
        assertEquals(order.getShipTo().isResidential(), false);
        assertEquals(order.getShipTo().getState(), "DC");
        assertEquals(order.getShipTo().getAddressVerified(), "Address validation warning");

        List<OrderItem> items = order.getItems();

        assertEquals(items.get(0).getOrderItemId(), 136289188);
        assertEquals(items.get(0).getLineItemKey(), "vd08-MSLbtx");
        assertEquals(items.get(0).getSku(), "ABC123");
        assertEquals(items.get(0).getName(), "Test item #1");
        assertEquals(items.get(0).getImageUrl(), null);
        assertEquals(items.get(0).getWeight().getValue(), 24);
        assertEquals(items.get(0).getWeight().getUnits(), "ounces");
        assertEquals(items.get(0).getQuantity(), 2, 0.01);
        assertEquals(items.get(0).getUnitPrice(), 99.99, 0.01);
        assertEquals(items.get(0).getTaxAmount(), 2.5, 0.01);
        assertEquals(items.get(0).getShippingAmount(), 5, 0.01);
        assertEquals(items.get(0).getWarehouseLocation(), "Aisle 1, Bin 7");
        assertEquals(items.get(0).getOptions().get(0).getName(), "Size");
        assertEquals(items.get(0).getOptions().get(0).getValue(), "Large");
        assertEquals(order.getOrderTotal(), 194.43, 0.01);
        assertEquals(order.getAmountPaid(), 218.73, 0.01);
        assertEquals(order.getTaxAmount(), 5, 0.01);
        assertEquals(order.getShippingAmount(), 10, 0.01);
        assertEquals(order.getCustomerNotes(), "Thanks for ordering!");
        assertEquals(order.getInternalNotes(), "Customer called and would like to upgrade shipping");
        assertEquals(order.isGift(), true);
        assertEquals(order.getGiftMessage(), "Thank you!");
        assertEquals(order.getPaymentMethod(), "Credit Card");
        assertEquals(order.getRequestedShippingService(), "Priority Mail");
        assertEquals(order.getCarrierCode(), "fedex");
        assertEquals(order.getServiceCode(), "fedex_2day");
        assertEquals(order.getPackageCode(), "package");
        assertEquals(order.getConfirmation(), "delivery");
        assertEquals(order.getShipDate(), "2015-07-02");
        assertEquals(order.getHoldUntilDate(), null);
        assertEquals(order.getWeight().getValue(), 48);
        assertEquals(order.getWeight().getUnits(), "ounces");
        assertEquals(order.getDimensions().getUnits(), "inches");
        assertEquals(order.getDimensions().getLength(), 7, 0.1);
        assertEquals(order.getDimensions().getWidth(), 5, 0.1);
        assertEquals(order.getDimensions().getHeight(), 6, 0.1);
        assertEquals(order.getInsuranceOptions().getProvider(), "carrier");
        assertEquals(order.getInsuranceOptions().isInsureShipment(), true);
        assertEquals(order.getInsuranceOptions().getInsuredValue(), 200, 0.01);
        assertEquals(order.getInternationalOptions().getContents(), null);
        assertEquals(order.getInternationalOptions().getCustomsItems(), null);
        assertEquals(order.getInternationalOptions().getNonDelivery(), null);
        assertEquals(order.getAdvancedOptions().getWarehouseId(), 98765);
        assertEquals(order.getAdvancedOptions().isNonMachinable(), false);
        assertEquals(order.getAdvancedOptions().isSaturdayDelivery(), false);
        assertEquals(order.getAdvancedOptions().isContainsAlcohol(), false);
        assertEquals(order.getAdvancedOptions().isMergedOrSplit(), false);
        assertEquals(order.getAdvancedOptions().getMergedIds().length, 0); //checking length, cant compare long[]
        assertEquals(order.getAdvancedOptions().getParentId(), null);
        assertEquals(order.getAdvancedOptions().getStoreId(), 12345);
        assertEquals(order.getAdvancedOptions().getCustomField1(), "Custom data that you can add to an order. See Custom Field #2 & #3 for more info!");
        assertEquals(order.getAdvancedOptions().getCustomField2(), "Per UI settings, this information can appear on some carrier's shipping labels. See link below");
        assertEquals(order.getAdvancedOptions().getCustomField3(), "https://help.shipstation.com/hc/en-us/articles/206639957");
        assertEquals(order.getAdvancedOptions().getSource(), "Webstore");
        assertEquals(order.getAdvancedOptions().getBillToParty(), null);
        assertEquals(order.getAdvancedOptions().getBillToAccount(), null);
        assertEquals(order.getAdvancedOptions().getBillToPostalCode(), null);
        assertEquals(order.getAdvancedOptions().getBillToCountryCode(), null);
        assertEquals(order.getTagIds()[0], 831);
        assertEquals(order.getUserId(), "b854f701-e0c2-4156-90fe-19c77cdef27c");
        assertEquals(order.isExternallyFulfilled(), false);
        assertEquals(order.getExternallyFulfilledBy(), null);

        assertEquals(listOrders.getTotal(), 1);
        assertEquals(listOrders.getPage(), 1);
        assertEquals(listOrders.getPages(), 1);
    }

    @Test
    public void testMarkAnOrderAsShipped() throws IOException, InterruptedException {

        OrderAsShippedPayload orderAsShippedPayload = new OrderAsShippedPayload();
        orderAsShippedPayload.setOrderId(93348442);
        orderAsShippedPayload.setCarrierCode("usps");
        orderAsShippedPayload.setShipDate("2014-04-01");
        orderAsShippedPayload.setTrackingNumber("913492493294329421");
        orderAsShippedPayload.setNotifyCustomer(true);
        orderAsShippedPayload.setNotifySalesChannel(true);

        OrderAsShippedResponse orderAsShippedResponse = api.markAnOrderAsShipped(orderAsShippedPayload);

        assertEquals(orderAsShippedResponse.getOrderId(), 123456789);
        assertEquals(orderAsShippedResponse.getOrderNumber(), "ABC123");

    }

    @Test
    public void testRemoveTagFromOrder() throws IOException, InterruptedException {

        SuccessResponse response = api.removeTagFromOrder(123456, 1234);
        assertEquals(response.isSuccess(), true);
        assertEquals(response.getMessage(), "Tag removed successfully.");

    }

    @Test
    public void testnRestoreOrderFromOnHold() throws IOException, InterruptedException {

        SuccessResponse response = api.restoreOrderFromOnHold(1234567);
        assertEquals(response.isSuccess(), true);
        assertEquals(response.getMessage(), "The requested order has been restored");

    }

    @Test
    public void testUnassignUserFromOrder() throws IOException, InterruptedException {

        List<String> orderIds = new ArrayList<String>();
        orderIds.add("123456789");
        orderIds.add("12345679");

        SuccessResponse response = api.unassignUserFromOrder(orderIds);
        assertEquals(response.isSuccess(), true);
        assertEquals(response.getMessage(), "User unassigned successfully.");

    }

    @Test
    public void testGetProduct() throws IOException, InterruptedException {

        Product product = api.getProduct(12345678);

        assertEquals(product.getProductId(), 12345678);
        assertEquals(product.getSku(), "1004");
        assertEquals(product.getName(), "Coffee Mug");
        assertEquals(product.getPrice(), 26, 0.01);
        assertEquals(product.getDefaultCost(), 0, 0.01);
        assertEquals(product.getLength(), 3, 0.01);
        assertEquals(product.getWidth(), 3, 0.01);
        assertEquals(product.getHeight(), 3, 0.01);
        assertEquals(product.getWeightOz(), 26, 0.01);
        assertEquals(product.getInternalNotes(), null);
        assertEquals(product.getFulfillmentSku(), "F1004");
        assertEquals(product.getCreateDate(), "2014-09-04T09:18:01.293");
        assertEquals(product.getModifyDate(), "2014-09-18T12:38:43.893");
        assertEquals(product.isActive(), true);
        assertEquals(product.getProductCategory().getCategoryId(), 9999);
        assertEquals(product.getProductCategory().getName(), "Door Closers");
        assertEquals(product.getProductType(), null);
        assertEquals(product.getWarehouseLocation(), "Bin 22");
        assertEquals(product.getDefaultCarrierCode(), "fedex");
        assertEquals(product.getDefaultServiceCode(), "fedex_home_delivery");
        assertEquals(product.getDefaultPackageCode(), "package");
        assertEquals(product.getDefaultIntlCarrierCode(), "ups");
        assertEquals(product.getDefaultIntlServiceCode(), "ups_worldwide_saver");
        assertEquals(product.getDefaultIntlPackageCode(), "package");
        assertEquals(product.getDefaultConfirmation(), "direct_signature");
        assertEquals(product.getDefaultIntlConfirmation(), "adult_signature");
        assertEquals(product.getCustomsDescription(), null);
        assertEquals(product.getCustomsValue(), 0.0, 0.01);//null double is 0.0
        assertEquals(product.getCustomsCountryCode(), null);
        assertEquals(product.isNoCustoms(), false);//null boolean is false
        assertEquals(product.getTags().get(0).getTagId(), 9180);
        assertEquals(product.getTags().get(0).getName(), "APItest");

    }

    @Test
    public void testUpdateProduct() throws IOException, InterruptedException {

        Product product = new Product();
        product.setProductId(123456789);
        product.setName("Beautiful");

        SuccessResponse response = api.updateProduct(product);
        assertEquals(response.isSuccess(), true);
        assertEquals(response.getMessage(), "The requested product has been updated");

    }

    @Test
    public void testListProducts() throws IOException, InterruptedException {

        ListProducts listProducts = api.listProducts();

        Product product = listProducts.getProducts().get(0);

        assertEquals(product.getProductId(), 7854008);
        assertEquals(product.getSku(), "1004");
        assertEquals(product.getName(), "Coffee Mug");
        assertEquals(product.getPrice(), 26, 0.01);
        assertEquals(product.getDefaultCost(), 0, 0.01);
        assertEquals(product.getLength(), 3, 0.01);
        assertEquals(product.getWidth(), 3, 0.01);
        assertEquals(product.getHeight(), 3, 0.01);
        assertEquals(product.getWeightOz(), 26, 0.01);
        assertEquals(product.getInternalNotes(), null);
        assertEquals(product.getFulfillmentSku(), "F1004");
        assertEquals(product.getCreateDate(), "2014-09-04T09:18:01.293");
        assertEquals(product.getModifyDate(), "2014-09-18T12:38:43.893");
        assertEquals(product.isActive(), true);
        assertEquals(product.getProductCategory().getCategoryId(), 9999);
        assertEquals(product.getProductCategory().getName(), "Door Closers");
        assertEquals(product.getProductType(), null);
        assertEquals(product.getWarehouseLocation(), "Bin 22");
        assertEquals(product.getDefaultCarrierCode(), "fedex");
        assertEquals(product.getDefaultServiceCode(), "fedex_home_delivery");
        assertEquals(product.getDefaultPackageCode(), "package");
        assertEquals(product.getDefaultIntlCarrierCode(), "ups");
        assertEquals(product.getDefaultIntlServiceCode(), "ups_worldwide_saver");
        assertEquals(product.getDefaultIntlPackageCode(), "package");
        assertEquals(product.getDefaultConfirmation(), "direct_signature");
        assertEquals(product.getDefaultIntlConfirmation(), "adult_signature");
        assertEquals(product.getCustomsDescription(), null);
        assertEquals(product.getCustomsValue(), 0.0, 0.01);//null double is 0.0
        assertEquals(product.getCustomsCountryCode(), null);
        assertEquals(product.isNoCustoms(), false);//null boolean is false
        assertEquals(product.getTags().get(0).getTagId(), 9180);
        assertEquals(product.getTags().get(0).getName(), "APItest");

        assertEquals(listProducts.getTotal(), 2);
        assertEquals(listProducts.getPage(), 1);
        assertEquals(listProducts.getPages(), 0);

    }

    @Test
    public void testListShipments() throws IOException, InterruptedException {

        ListShipments listShipments = api.listShipments();
        Shipment shipment = listShipments.getShipments().get(0);

        assertEquals(shipment.getShipmentId(), 33974374);
        assertEquals(shipment.getOrderId(), 43945660);
        assertEquals(shipment.getUserId(), "123456AB-ab12-3c4d-5e67-89f1abc1defa");
        assertEquals(shipment.getOrderNumber(), "100038-1");
        assertEquals(shipment.getCreateDate(), "2014-10-03T06:51:33.6270000");
        assertEquals(shipment.getShipDate(), "2014-10-03");
        assertEquals(shipment.getShipmentCost(), 1.93, 0.01);
        assertEquals(shipment.getInsuranceCost(), 0.0, 0.01);
        assertEquals(shipment.getTrackingNumber(), "9400111899561704681189");
        assertEquals(shipment.isReturnLabel(), false);
        assertEquals(shipment.getBatchNumber(), "100301");
        assertEquals(shipment.getCarrierCode(), "stamps_com");
        assertEquals(shipment.getServiceCode(), "usps_first_class_mail");
        assertEquals(shipment.getPackageCode(), "package");
        assertEquals(shipment.getConfirmation(), "delivery");
        assertEquals(shipment.getWarehouseId(), 16079);
        assertEquals(shipment.isVoided(), false);
        assertEquals(shipment.getVoidDate(), null);
        assertEquals(shipment.isMarketplaceNotified(), true);
        assertEquals(shipment.getNotifyErrorMessage(), null);
        assertEquals(shipment.getShipTo().getName(), "Yoda");
        assertEquals(shipment.getShipTo().getCompany(), "");
        assertEquals(shipment.getShipTo().getStreet1(), "12223 LOWDEN LN");
        assertEquals(shipment.getShipTo().getStreet2(), "");
        assertEquals(shipment.getShipTo().getStreet3(), null);
        assertEquals(shipment.getShipTo().getCity(), "MANCHACA");
        assertEquals(shipment.getShipTo().getState(), "TX");
        assertEquals(shipment.getShipTo().getPostalCode(), "78652-3602");
        assertEquals(shipment.getShipTo().getCountry(), "US");
        assertEquals(shipment.getShipTo().getPhone(), "2101235544");
        assertEquals(shipment.getShipTo().isResidential(), false);//null boolean is false
        assertEquals(shipment.getWeight().getValue(), 1);
        assertEquals(shipment.getWeight().getUnits(), "ounces");
        assertEquals(shipment.getDimensions(), null);
        assertEquals(shipment.getInsuranceOptions().getProvider(), null);
        assertEquals(shipment.getInsuranceOptions().getProvider(), null);
        assertEquals(shipment.getInsuranceOptions().isInsureShipment(), false);
        assertEquals(shipment.getInsuranceOptions().getInsuredValue(), 0, 0.01);
        assertEquals(shipment.getAdvancedOptions(), null);
        assertEquals(shipment.getShipmentItems().get(0).getOrderItemId(), 56568665);
        assertEquals(shipment.getShipmentItems().get(0).getLineItemKey(), null);
        assertEquals(shipment.getShipmentItems().get(0).getSku(), "SQ3785739");
        assertEquals(shipment.getShipmentItems().get(0).getName(), "Potato Kitten -");
        assertEquals(shipment.getShipmentItems().get(0).getImageUrl(), null);
        assertEquals(shipment.getShipmentItems().get(0).getWeight(), null);
        assertEquals(shipment.getShipmentItems().get(0).getQuantity(), 1, 0.01);
        assertEquals(shipment.getShipmentItems().get(0).getUnitPrice(), 1, 0.01);
        assertEquals(shipment.getShipmentItems().get(0).getWarehouseLocation(), null);
        assertEquals(shipment.getShipmentItems().get(0).getOptions(), null);
        assertEquals(shipment.getShipmentItems().get(0).getProductId(), 7565777);
        assertEquals(shipment.getShipmentItems().get(0).getFulfillmentSku(), null);
        assertEquals(shipment.getLabelData(), null);
        assertEquals(shipment.getFormData(), null);

    }

    @Test
    public void testCreateShipmentLabel() throws IOException, InterruptedException {

        ShipmentLabelPayload shipmentLabelPayload = new ShipmentLabelPayload();
        shipmentLabelPayload.setCarrierCode("fedex");
        shipmentLabelPayload.setServiceCode("fedex_ground");
        shipmentLabelPayload.setPackageCode("package");
        shipmentLabelPayload.setConfirmation("delivery");
        //etc...

        Shipment shipment = api.createShipmentLabel(shipmentLabelPayload);

        assertEquals(shipment.getShipmentId(), 123456789);
        assertEquals(shipment.getOrderId(), 0);//null long is 0
        assertEquals(shipment.getUserId(), null);
        assertEquals(shipment.getOrderNumber(), null);
        assertEquals(shipment.getCreateDate(), "2016-04-03T12:11:36.8630000");
        assertEquals(shipment.getShipDate(), "2016-04-03");
        assertEquals(shipment.getShipmentCost(), 9.06, 0.01);
        assertEquals(shipment.getInsuranceCost(), 0, 0.01);
        assertEquals(shipment.getTrackingNumber(), "782390443992");
        assertEquals(shipment.isReturnLabel(), false);
        assertEquals(shipment.getBatchNumber(), null);
        assertEquals(shipment.getCarrierCode(), "fedex");
        assertEquals(shipment.getServiceCode(), "fedex_ground");
        assertEquals(shipment.getPackageCode(), "package");
        assertEquals(shipment.getConfirmation(), "delivery");
        assertEquals(shipment.getWarehouseId(), 0);//null long is 0
        assertEquals(shipment.isVoided(), false);
        assertEquals(shipment.getVoidDate(), null);
        assertEquals(shipment.isMarketplaceNotified(), false);
        assertEquals(shipment.getNotifyErrorMessage(), null);
        assertEquals(shipment.getShipTo(), null);
        assertEquals(shipment.getWeight(), null);
        assertEquals(shipment.getDimensions(), null);
        assertEquals(shipment.getInsuranceOptions(), null);
        assertEquals(shipment.getAdvancedOptions(), null);
        assertEquals(shipment.getShipmentItems(), null);
        assertEquals(shipment.getLabelData(), "JVBERi0xLjQKJeLjz9MKMiAwIG9iago8PC9MZW5ndGggNjIvRmlsdGVyL0ZsYXRlRGVjb2RlPj5zdHJlYW0KeJwr5HIK4TI2U...");
        assertEquals(shipment.getFormData(), null);

    }

    @Test
    public void testGetRates() throws IOException, InterruptedException {

        RatePayload rate = new RatePayload();
        rate.setCarrierCode("fedex");
        rate.setFromPostalCode("78703");
        rate.setToState("DC");
        rate.setToCountry("US");
        rate.setToPostalCode("20500");
        //etc...

        List<Rate> rates = api.getRates(rate);

        assertEquals(rates.get(0).getServiceName(), "FedEx First Overnight®");
        assertEquals(rates.get(0).getServiceCode(), "fedex_first_overnight");
        assertEquals(rates.get(0).getShipmentCost(), 87.8, 0.01);
        assertEquals(rates.get(0).getOtherCost(), 2.63, 0.001);

        assertEquals(rates.get(1).getServiceName(), "FedEx Priority Overnight®");
        assertEquals(rates.get(1).getServiceCode(), "fedex_priority_overnight");
        assertEquals(rates.get(1).getShipmentCost(), 50.23, 0.01);
        assertEquals(rates.get(1).getOtherCost(), 1.51, 0.001);

    }

    @Test
    public void testVoidLabel() throws IOException, InterruptedException {

        VoidLabelResponse response = api.voidLabel(12345);
        assertEquals(response.isApproved(), true);
        assertEquals(response.getMessage(), "Label voided successfully");

    }

    @Test
    public void testGetStore() throws IOException, InterruptedException {

        Store store = api.getStore(12345);

        assertEquals(store.getStoreId(), 12345);
        assertEquals(store.getStoreName(), "WooCommerce Store");
        assertEquals(store.getMarketplaceId(), 36);
        assertEquals(store.getMarketplaceName(), "WooCommerce");
        assertEquals(store.getAccountName(), null);
        assertEquals(store.getEmail(), null);
        assertEquals(store.getIntegrationUrl(), "http://shipstation-test.wpengine.com");
        assertEquals(store.isActive(), true);
        assertEquals(store.getCompanyName(), "");
        assertEquals(store.getPhone(), "");
        assertEquals(store.getPublicEmail(), "");
        assertEquals(store.getWebsite(), "");
        assertEquals(store.getRefreshDate(), "2014-12-16T17:47:05.457");
        assertEquals(store.getLastRefreshAttempt(), "2014-12-16T09:47:05.457");
        assertEquals(store.getCreateDate(), "2014-11-06T15:21:13.223");
        assertEquals(store.isAutoRefresh(), true);
        assertEquals(store.getStatusMappings().get(0).getOrderStatus(), "awaiting_payment");
        assertEquals(store.getStatusMappings().get(0).getStatusKey(), "Pending");

    }

    @Test
    public void testUpdateStore() throws IOException, InterruptedException {

        Store storePayload = new Store();
        storePayload.setStoreId(12345);
        storePayload.setStoreName("WooCommerce Store");
        //etc...

        Store store = api.updateStore(storePayload);

        assertEquals(store.getStoreId(), 12345);
        assertEquals(store.getStoreName(), "WooCommerce Store");
        assertEquals(store.getMarketplaceId(), 36);
        assertEquals(store.getMarketplaceName(), "WooCommerce");
        assertEquals(store.getAccountName(), null);
        assertEquals(store.getEmail(), null);
        assertEquals(store.getIntegrationUrl(), "http://shipstation-test.wpengine.com");
        assertEquals(store.isActive(), true);
        assertEquals(store.getCompanyName(), "");
        assertEquals(store.getPhone(), "");
        assertEquals(store.getPublicEmail(), "");
        assertEquals(store.getWebsite(), "");
        assertEquals(store.getRefreshDate(), "2014-12-16T17:47:05.457");
        assertEquals(store.getLastRefreshAttempt(), "2014-12-16T09:47:05.457");
        assertEquals(store.getCreateDate(), "2014-11-06T15:21:13.223");
        assertEquals(store.isAutoRefresh(), true);
        assertEquals(store.getStatusMappings().get(0).getOrderStatus(), "awaiting_payment");
        assertEquals(store.getStatusMappings().get(0).getStatusKey(), "Pending");

    }

    @Test
    public void testGetStoreRefreshStatus() throws IOException, InterruptedException {

        StoreRefreshStatusResponse storeRefreshStatusResponse = api.getStoreRefreshStatus(12345);

        assertEquals(storeRefreshStatusResponse.getStoreId(), 12345);
        assertEquals(storeRefreshStatusResponse.getRefreshStatusId(), 2);
        assertEquals(storeRefreshStatusResponse.getRefreshStatus(), "Updating orders");
        assertEquals(storeRefreshStatusResponse.getLastRefreshAttempt(), "8-13-2014");
        assertEquals(storeRefreshStatusResponse.getRefreshDate(), "8-13-2014");

    }


    @Test
    public void testRefreshStore() throws IOException, InterruptedException {

        SuccessResponse response = api.refreshStore(12345);

        assertEquals(response.isSuccess(), true);
        assertEquals(response.getMessage(), "A store refresh has been initiated for Store ID 12345");

    }

    @Test
    public void testListStores() throws IOException, InterruptedException {

        List<Store> stores = api.listStores(false);

        assertEquals(stores.get(0).getStoreId(), 22766);
        assertEquals(stores.get(0).getStoreName(), "ShipStation Manual Store");
        assertEquals(stores.get(0).getMarketplaceId(), 0);
        assertEquals(stores.get(0).getMarketplaceName(), "ShipStation");
        assertEquals(stores.get(0).getAccountName(), null);
        assertEquals(stores.get(0).getEmail(), null);
        assertEquals(stores.get(0).getIntegrationUrl(), null);
        assertEquals(stores.get(0).isActive(), true);
        assertEquals(stores.get(0).getPhone(), "");
        assertEquals(stores.get(0).getPublicEmail(), "testemail@email.com");
        assertEquals(stores.get(0).getWebsite(), "");
        assertEquals(stores.get(0).getRefreshDate(), "2014-12-03T11:46:11.283");
        assertEquals(stores.get(0).getLastRefreshAttempt(), "2014-12-03T11:46:53.433");
        assertEquals(stores.get(0).getCreateDate(), "2014-07-25T11:05:55.307");
        assertEquals(stores.get(0).getModifyDate(), "2014-11-12T08:45:20.55");
        assertEquals(stores.get(0).isAutoRefresh(), false);

    }

    @Test
    public void testListMarketplaces() throws IOException, InterruptedException {

        List<Marketplace> marketplaces = api.listMarketplaces();

        assertEquals(marketplaces.get(0).getName(), "3DCart");
        assertEquals(marketplaces.get(0).getMarketplaceId(), 23);
        assertEquals(marketplaces.get(0).isCanRefresh(), true);
        assertEquals(marketplaces.get(0).isSupportsCustomMappings(), true);
        assertEquals(marketplaces.get(0).isSupportsCustomStatuses(), false);
        assertEquals(marketplaces.get(0).isCanConfirmShipments(), true);

    }

    @Test
    public void testDeactivateStore() throws IOException, InterruptedException {

        SuccessResponse response = api.deactivateStore(12345);

        assertEquals(response.isSuccess(), true);
        assertEquals(response.getMessage(), "The requested store has been reactivated.");

    }

    @Test
    public void testReactivateStore() throws IOException, InterruptedException {

        SuccessResponse response = api.reactivateStore(12345);

        assertEquals(response.isSuccess(), true);
        assertEquals(response.getMessage(), "The requested store has been reactivated.");

    }

    /* Doesnt work correctly with mock api - should return array of users, not a single user */
    @Ignore
    @Test
    public void testListUsers() throws IOException, InterruptedException {

        List<User> users = api.listUsers(true);

        assertEquals(users.get(0).getUserId(), "123456AB-ab12-3c4d-5e67-89f1abc1defa");
    }


    @Test
    public void testGetWarehouse() throws IOException, InterruptedException {

        Warehouse warehouse = api.getWarehouse(12345);

        assertEquals(warehouse.getWarehouseId(), 12345);
        assertEquals(warehouse.getWarehouseName(), "API Ship From Location");
        assertEquals(warehouse.getOriginAddress().getName(), "API Warehouse");
        assertEquals(warehouse.getOriginAddress().getCompany(), "ShipStation");
        assertEquals(warehouse.getOriginAddress().getStreet1(), "2815 Exposition Blvd");
        assertEquals(warehouse.getOriginAddress().getStreet2(), null);
        assertEquals(warehouse.getOriginAddress().getStreet3(), null);
        assertEquals(warehouse.getOriginAddress().getCity(), "Austin");
        assertEquals(warehouse.getOriginAddress().getState(), "TX");
        assertEquals(warehouse.getOriginAddress().getPostalCode(), "78703");
        assertEquals(warehouse.getOriginAddress().getCountry(), "US");
        assertEquals(warehouse.getOriginAddress().getPhone(), "512-555-5555");
        assertEquals(warehouse.getOriginAddress().isResidential(), true);
        assertEquals(warehouse.getOriginAddress().getAddressVerified(), null);

        assertEquals(warehouse.getReturnAddress().getName(), "API Ship From Location");
        assertEquals(warehouse.getReturnAddress().getCompany(), "ShipStation");
        assertEquals(warehouse.getReturnAddress().getStreet1(), "2815 Exposition Blvd");
        assertEquals(warehouse.getReturnAddress().getStreet2(), null);
        assertEquals(warehouse.getReturnAddress().getStreet3(), null);
        assertEquals(warehouse.getReturnAddress().getCity(), "Austin");
        assertEquals(warehouse.getReturnAddress().getState(), "TX");
        assertEquals(warehouse.getReturnAddress().getPostalCode(), "78703");
        assertEquals(warehouse.getReturnAddress().getCountry(), "US");
        assertEquals(warehouse.getReturnAddress().getPhone(), "512-555-5555");
        assertEquals(warehouse.getReturnAddress().isResidential(), false);//null boolean is false
        assertEquals(warehouse.getReturnAddress().getAddressVerified(), null);

        assertEquals(warehouse.getCreateDate(), "2015-07-02T08:38:31.4870000");
        assertEquals(warehouse.isIsDefault(), true);

    }

    @Test
    public void testUpdateWarehouse() throws IOException, InterruptedException {

        Warehouse warehousePayload = new Warehouse();
        warehousePayload.setWarehouseId(12345);
        warehousePayload.setWarehouseName("API Ship From Location");
        Warehouse warehouse = api.updateWarehouse(warehousePayload);

        assertEquals(warehouse.getWarehouseId(), 12345);
        assertEquals(warehouse.getWarehouseName(), "API Ship From Location");
        assertEquals(warehouse.getOriginAddress().getName(), "API Warehouse");
        assertEquals(warehouse.getOriginAddress().getCompany(), "ShipStation");
        assertEquals(warehouse.getOriginAddress().getStreet1(), "2815 Exposition Blvd");
        assertEquals(warehouse.getOriginAddress().getStreet2(), null);
        assertEquals(warehouse.getOriginAddress().getStreet3(), null);
        assertEquals(warehouse.getOriginAddress().getCity(), "Austin");
        assertEquals(warehouse.getOriginAddress().getState(), "TX");
        assertEquals(warehouse.getOriginAddress().getPostalCode(), "78703");
        assertEquals(warehouse.getOriginAddress().getCountry(), "US");
        assertEquals(warehouse.getOriginAddress().getPhone(), "512-555-5555");
        assertEquals(warehouse.getOriginAddress().isResidential(), true);
        assertEquals(warehouse.getOriginAddress().getAddressVerified(), null);

        assertEquals(warehouse.getReturnAddress().getName(), "API Ship From Location");
        assertEquals(warehouse.getReturnAddress().getCompany(), "ShipStation");
        assertEquals(warehouse.getReturnAddress().getStreet1(), "2815 Exposition Blvd");
        assertEquals(warehouse.getReturnAddress().getStreet2(), null);
        assertEquals(warehouse.getReturnAddress().getStreet3(), null);
        assertEquals(warehouse.getReturnAddress().getCity(), "Austin");
        assertEquals(warehouse.getReturnAddress().getState(), "TX");
        assertEquals(warehouse.getReturnAddress().getPostalCode(), "78703");
        assertEquals(warehouse.getReturnAddress().getCountry(), "US");
        assertEquals(warehouse.getReturnAddress().getPhone(), "512-555-5555");
        assertEquals(warehouse.getReturnAddress().isResidential(), false);//null boolean is false
        assertEquals(warehouse.getReturnAddress().getAddressVerified(), null);

        assertEquals(warehouse.getCreateDate(), "2015-07-02T08:38:31.4870000");
        assertEquals(warehouse.isIsDefault(), true);

    }

    @Test
    public void testCreateWarehouse() throws IOException, InterruptedException {

        Warehouse warehousePayload = new Warehouse();
        warehousePayload.setWarehouseId(12345);
        warehousePayload.setWarehouseName("API Ship From Location");
        Warehouse warehouse = api.createWarehouse(warehousePayload);

        assertEquals(warehouse.getWarehouseId(), 12345);
        assertEquals(warehouse.getWarehouseName(), "API Ship From Location");
        assertEquals(warehouse.getOriginAddress().getName(), "API Warehouse");
        assertEquals(warehouse.getOriginAddress().getCompany(), "ShipStation");
        assertEquals(warehouse.getOriginAddress().getStreet1(), "2815 Exposition Blvd");
        assertEquals(warehouse.getOriginAddress().getStreet2(), null);
        assertEquals(warehouse.getOriginAddress().getStreet3(), null);
        assertEquals(warehouse.getOriginAddress().getCity(), "Austin");
        assertEquals(warehouse.getOriginAddress().getState(), "TX");
        assertEquals(warehouse.getOriginAddress().getPostalCode(), "78703");
        assertEquals(warehouse.getOriginAddress().getCountry(), "US");
        assertEquals(warehouse.getOriginAddress().getPhone(), "512-555-5555");
        assertEquals(warehouse.getOriginAddress().isResidential(), true);
        assertEquals(warehouse.getOriginAddress().getAddressVerified(), null);

        assertEquals(warehouse.getReturnAddress().getName(), "API Ship From Location");
        assertEquals(warehouse.getReturnAddress().getCompany(), "ShipStation");
        assertEquals(warehouse.getReturnAddress().getStreet1(), "2815 Exposition Blvd");
        assertEquals(warehouse.getReturnAddress().getStreet2(), null);
        assertEquals(warehouse.getReturnAddress().getStreet3(), null);
        assertEquals(warehouse.getReturnAddress().getCity(), "Austin");
        assertEquals(warehouse.getReturnAddress().getState(), "TX");
        assertEquals(warehouse.getReturnAddress().getPostalCode(), "78703");
        assertEquals(warehouse.getReturnAddress().getCountry(), "US");
        assertEquals(warehouse.getReturnAddress().getPhone(), "512-555-5555");
        assertEquals(warehouse.getReturnAddress().isResidential(), false);//null boolean is false
        assertEquals(warehouse.getReturnAddress().getAddressVerified(), null);

        assertEquals(warehouse.getCreateDate(), "2015-07-02T08:38:31.4870000");
        assertEquals(warehouse.isIsDefault(), true);
    }

    @Test
    public void testListWarehouse() throws IOException, InterruptedException {

        List<Warehouse> warehouses = api.listWarehouses();

        Warehouse warehouse = warehouses.get(1);
        assertEquals(warehouse.getWarehouseId(), 14265);
        assertEquals(warehouse.getWarehouseName(), "Austin");
        assertEquals(warehouse.getOriginAddress().getName(), "Austin");
        assertEquals(warehouse.getOriginAddress().getCompany(), "ShipStation");
        assertEquals(warehouse.getOriginAddress().getStreet1(), "2815 Exposition Blvd");
        assertEquals(warehouse.getOriginAddress().getStreet2(), "");
        assertEquals(warehouse.getOriginAddress().getStreet3(), "");
        assertEquals(warehouse.getOriginAddress().getCity(), "Austin");
        assertEquals(warehouse.getOriginAddress().getState(), "TX");
        assertEquals(warehouse.getOriginAddress().getPostalCode(), "78703");
        assertEquals(warehouse.getOriginAddress().getCountry(), "US");
        assertEquals(warehouse.getOriginAddress().getPhone(), "5124445555");
        assertEquals(warehouse.getOriginAddress().isResidential(), false);
        assertEquals(warehouse.getOriginAddress().getAddressVerified(), null);

        assertEquals(warehouse.getReturnAddress().getName(), "ShipStation");
        assertEquals(warehouse.getReturnAddress().getCompany(), "ShipStation");
        assertEquals(warehouse.getReturnAddress().getStreet1(), "2815 Exposition Blvd");
        assertEquals(warehouse.getReturnAddress().getStreet2(), "");
        assertEquals(warehouse.getReturnAddress().getStreet3(), "");
        assertEquals(warehouse.getReturnAddress().getCity(), "Austin");
        assertEquals(warehouse.getReturnAddress().getState(), "TX");
        assertEquals(warehouse.getReturnAddress().getPostalCode(), "78703");
        assertEquals(warehouse.getReturnAddress().getCountry(), "US");
        assertEquals(warehouse.getReturnAddress().getPhone(), "5124445555");
        assertEquals(warehouse.getReturnAddress().isResidential(), false);
        assertEquals(warehouse.getReturnAddress().getAddressVerified(), null);

        assertEquals(warehouse.getCreateDate(), "2014-05-27T09:54:29.9600000");
        assertEquals(warehouse.isIsDefault(), false);

    }

    /* Doesnt work due to uppercase json keys from api*/
    @Ignore
    @Test
    public void testListWebhooks() throws IOException, InterruptedException {

        /*
         ListWebhooks webhooks = api.listWebhooks();

        assertEquals(webhooks.getWebhooks().get(0).isIsLabelAPIHook(), false);
        assertEquals(webhooks.getWebhooks().get(0).getWebHookID(), 123);
        assertEquals(webhooks.getWebhooks().get(0).getSellerID(), 100000);
        assertEquals(webhooks.getWebhooks().get(0).getHookType(), "ITEM_ORDER_NOTIFY");
        assertEquals(webhooks.getWebhooks().get(0).getMessageFormat(), "Json");
        assertEquals(webhooks.getWebhooks().get(0).getUrl(), "http://example.endpoint/orders");
        assertEquals(webhooks.getWebhooks().get(0).getName(), "My Order Webhook");
        assertEquals(webhooks.getWebhooks().get(0).getBulkCopyBatchID(), null);
        assertEquals(webhooks.getWebhooks().get(0).getBulkCopyBatchID(), null);
        assertEquals(webhooks.getWebhooks().get(0).isIsActive(), null);
        assertEquals(webhooks.getWebhooks().get(0).getWebhookLogs(), null);
        assertEquals(webhooks.getWebhooks().get(0).getSeller(), null);
        assertEquals(webhooks.getWebhooks().get(0).getStore(), null);
*/
    }


    @Test
    public void testSubscribeToWebhook() throws IOException, InterruptedException {

        SubscribeWebhookPayload payload = new SubscribeWebhookPayload();
        payload.setTarget_url("http://someexamplewebhookurl.com/neworder");
        payload.setEvent("ORDER_NOTIFY");
        //etc...

        int id = api.subscribeToWebhook(payload);

        assertEquals(id, 123456);
    }

    @Test
    public void testUnsubscribeToWebhook() throws IOException, InterruptedException {

        api.unsubscribeToWebhook(123456);

    }
}