package com.apex.shipstation;

import com.apex.shipstation.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Base64;
import java.util.List;


public class API {

    private String apiBaseURL;
    private String apiKey;
    private String apiSecret;
    private ObjectMapper mapper;

    public API(String BaseURL, String key, String secret) {
        apiBaseURL = BaseURL;
        apiKey = key;
        apiSecret = secret;
        mapper = new ObjectMapper();
    }

    private boolean checkRateLimit(Response response) throws InterruptedException {

        if (response.getStatus() == 429) {

            // http://docs.shipstation.apiary.io/#introduction/shipstation-api-requirements/api-rate-limits
            long sec = 40;// default reset time 40 seconds

            // parse header that defines how long to wait
            if (response.getHeaders().containsKey("X-Rate-Limit-Reset")) {
                sec = Long.parseLong((String) response.getHeaders().get("X-Rate-Limit-Reset").get(0));
            }
            System.out.println("ShipStation API got (429)- Sleeping for " + (sec + 1) + " seconds");

            Thread.sleep((sec + 1) * 1000); // sleep

            return true; // wait occurred - retry request!
        }
        return false; // no wait - continue!
    }

    private Response POST(String api_url, Entity payload) throws InterruptedException {

        // init
        boolean retry = true;
        Response response = null;

        do {

            // auth
            String auth = apiKey + ":" + apiSecret;
            String authB64 = Base64.getEncoder().encodeToString(auth.getBytes());

            // HTTP request
            Client client = ClientBuilder.newClient();
            response = client.target(api_url).request(MediaType.APPLICATION_JSON_TYPE)
                    .header("Authorization", "Basic " + authB64).post(payload);

            // check if we need to wait
            if (response != null) {
                retry = checkRateLimit(response);
            }

        } while (retry);// retry if we hit a rate limit

        return response;
    }

    private Response GET(String api_url) throws InterruptedException {

        // init
        boolean retry = true;
        Response response = null;

        do {

            // auth
            String auth = apiKey + ":" + apiSecret;
            String authB64 = Base64.getEncoder().encodeToString(auth.getBytes());

            // HTTP request
            Client client = ClientBuilder.newClient();
            response = client.target(api_url).request(MediaType.TEXT_PLAIN_TYPE)
                    .header("Authorization", "Basic " + authB64).get();

            // check if we need to wait
            if (response != null) {
                retry = checkRateLimit(response);
            }

        } while (retry);// retry if we hit a rate limit

        return response;
    }

    private Response DELETE(String api_url) throws InterruptedException {

        // init
        boolean retry = true;
        Response response = null;

        do {

            // auth
            String auth = apiKey + ":" + apiSecret;
            String authB64 = Base64.getEncoder().encodeToString(auth.getBytes());

            // HTTP request
            Client client = ClientBuilder.newClient();
            response = client.target(api_url).request(MediaType.APPLICATION_JSON_TYPE)
                    .header("Authorization", "Basic " + authB64).delete();

            // check if we need to wait
            if (response != null) {
                retry = checkRateLimit(response);
            }

        } while (retry);// retry if we hit a rate limit

        return response;
    }

    public List<Tag> listTags() throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/accounts/listtags");
        return mapper.readValue(res.readEntity(String.class), new TypeReference<List<Tag>>() {
        });
    }

    public List<Carrier> listCarriers() throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/carriers");
        return mapper.readValue(res.readEntity(String.class), new TypeReference<List<Carrier>>() {
        });
    }

    public Carrier getCarrier(String carrierCode) throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/carriers/getcarrier?carrierCode=" + carrierCode);
        return mapper.readValue(res.readEntity(String.class), Carrier.class);
    }

    public Carrier addFunds(Fund fund) throws IOException, InterruptedException, JsonProcessingException {
        String JSON = mapper.writeValueAsString(fund);
        Entity<String> payload = Entity.json(JSON);
        Response res = POST(apiBaseURL + "/carriers/addfunds", payload);
        return mapper.readValue(res.readEntity(String.class), Carrier.class);
    }

    /*
        public List<Package> listPackages(String carrierCode) throws IOException, InterruptedException {

            Response res = GET(apiBaseURL + "/carriers/listpackages?carrierCode=" + carrierCode);
            return mapper.readValue(res.readEntity(String.class), new TypeReference<List<Package>>() {
            });

        }
    */
    public List<Service> listServices(String carrierCode) throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/carriers/listservices?carrierCode=" + carrierCode);
        return mapper.readValue(res.readEntity(String.class), new TypeReference<List<Service>>() {
        });
    }

    public Customer getCustomer(String customerId) throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/customers/" + customerId);
        return mapper.readValue(res.readEntity(String.class), Customer.class);
    }

    public ListCustomers listCustomers() throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/customers");
        return mapper.readValue(res.readEntity(String.class), ListCustomers.class);
    }

    public ListFulfillments listFulfillments() throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/fulfillments");
        return mapper.readValue(res.readEntity(String.class), ListFulfillments.class);
    }

    public ListFulfillments listFulfillments(String query) throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/fulfillments?" + query);
        return mapper.readValue(res.readEntity(String.class), ListFulfillments.class);
    }

    public Order getOrder(String orderId) throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/orders/" + orderId);
        return mapper.readValue(res.readEntity(String.class), Order.class);
    }

    public SuccessResponse deleteOrder(String orderId) throws IOException, InterruptedException {
        Response res = DELETE(apiBaseURL + "/orders/" + orderId);
        return mapper.readValue(res.readEntity(String.class), SuccessResponse.class);
    }

    public SuccessResponse addTagToOrder(Tag tag) throws IOException, InterruptedException {
        String JSON = mapper.writeValueAsString(tag);
        Entity<String> payload = Entity.json(JSON);
        Response res = POST(apiBaseURL + "/orders/addtag", payload);
        return mapper.readValue(res.readEntity(String.class), SuccessResponse.class);
    }

    public SuccessResponse assignUserToOrder(UserToOrderPayload assignusertoorder) throws IOException, InterruptedException {
        String JSON = mapper.writeValueAsString(assignusertoorder);
        Entity<String> payload = Entity.json(JSON);
        Response res = POST(apiBaseURL + "/orders/assignuser", payload);
        return mapper.readValue(res.readEntity(String.class), SuccessResponse.class);
    }

    public Label createLabelForOrder(LabelForOrderPayload payload) throws IOException, InterruptedException {
        String JSON = mapper.writeValueAsString(payload);
        Entity<String> payload = Entity.json(JSON);
        Response res = POST(apiBaseURL + "/orders/createlabelfororder", payload);
        return mapper.readValue(res.readEntity(String.class), Label.class);
    }

    public Order createOrder(Order order) throws IOException, InterruptedException {
        String JSON = mapper.writeValueAsString(order);
        Entity<String> payload = Entity.json(JSON);
        Response res = POST(apiBaseURL + "/orders/createorder", payload);
        return mapper.readValue(res.readEntity(String.class), Order.class);
    }

    public BuilkOrdersResponse createOrders(List<Order> orders) throws IOException, InterruptedException {
        String JSON = mapper.writeValueAsString(orders);
        Entity<String> payload = Entity.json(JSON);
        Response res = POST(apiBaseURL + "/orders/createorders", payload);
        return mapper.readValue(res.readEntity(String.class), BuilkOrdersResponse.class);
    }

    private SuccessResponse holdOrderUntil(HoldUntilOrder order) throws IOException, InterruptedException {
        String JSON = mapper.writeValueAsString(order);
        Entity<String> payload = Entity.json(JSON);
        Response res = POST(apiBaseURL + "/orders/holduntil", payload);
        return mapper.readValue(res.readEntity(String.class), SuccessResponse.class);
    }

    public ListOrders listOrders() throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/orders");
        return mapper.readValue(res.readEntity(String.class), ListOrders.class);
    }

    public ListOrders listOrders(String query) throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/orders?" + query);
        return mapper.readValue(res.readEntity(String.class), ListOrders.class);
    }

    public ListOrders listOrdersByTag(String query) throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/orders/listbytag?" + query);
        return mapper.readValue(res.readEntity(String.class), ListOrders.class);
    }

    public OrderAsShippedResponse markAnOrderAsShipped(OrderAsShippedPayload payload) throws IOException, InterruptedException {
        String JSON = mapper.writeValueAsString(payload);
        Entity<String> payload = Entity.json(JSON);
        Response res = POST(apiBaseURL + "/orders/markasshipped", payload);
        return mapper.readValue(res.readEntity(String.class), OrderAsShippedResponse.class);
    }

    public Tag removeTagFromOrder(Tag tag) throws IOException, InterruptedException {
        String JSON = mapper.writeValueAsString(tag);
        Entity<String> payload = Entity.json(JSON);
        Response res = POST(apiBaseURL + "/orders/removetag", payload);
        return mapper.readValue(res.readEntity(String.class), Tag.class);
    }

    public SuccessResponse restoreOrderFromOnHold(long orderId) throws IOException, InterruptedException {
        Entity payload = Entity.json("{ 'orderId':" + orderId + "}");
        Response res = POST(apiBaseURL + "/orders/restorefromhold", payload);
        return mapper.readValue(res.readEntity(String.class), SuccessResponse.class);
    }

    public SuccessResponse unassignUserFromOrder(List<String> orderIds) throws IOException, InterruptedException {
        Entity payload = Entity.json("{ 'orderIds':" + String.join(",", orderIds) + "}");
        Response res = POST(apiBaseURL + "/orders/removetag", payload);
        return mapper.readValue(res.readEntity(String.class), Tag.class);
    }

    public Product getProduct(long productId) throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/products/" + productId);
        return mapper.readValue(res.readEntity(String.class), Product.class);
    }

    public SuccessResponse updateProduct(Product product) throws IOException, InterruptedException {
        String JSON = mapper.writeValueAsString(product);
        Entity<String> payload = Entity.json(JSON);
        Response res = POST(apiBaseURL + "products/" + product.getProductId(), payload);
        return mapper.readValue(res.readEntity(String.class), SuccessResponse.class);
    }

    public ListProducts listProducts() throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/products");
        return mapper.readValue(res.readEntity(String.class), ListProducts.class);
    }

    public ListProducts listProducts(String query) throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/products?" + query);
        return mapper.readValue(res.readEntity(String.class), ListProducts.class);
    }

    public ListShipments listShipments() throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/shipments");
        return mapper.readValue(res.readEntity(String.class), ListShipments.class);
    }

    public ListShipments listShipments(String query) throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/shipments?" + query);
        return mapper.readValue(res.readEntity(String.class), ListShipments.class);
    }

    public ShipmentLabel createShipmentLabel(ShipmentLabelPayload payload) throws IOException, InterruptedException{
        String JSON = mapper.writeValueAsString(payload);
        Entity<String> payload = Entity.json(JSON);
        Response res = POST(apiBaseURL + "/shipments/createlabel", payload);
        return mapper.readValue(res.readEntity(String.class), Rate.class);
    }


    public Rate getRates(RatePayload rate) throws IOException, InterruptedException {
        String JSON = mapper.writeValueAsString(rate);
        Entity<String> payload = Entity.json(JSON);
        Response res = POST(apiBaseURL + "/shipments/getrates", payload);
        return mapper.readValue(res.readEntity(String.class), Rate.class);
    }

    public SuccessResponse voidLabel(long shipmentId) throws IOException, InterruptedException {
        Entity payload = Entity.json("{ 'shipmentId':" + shipmentId + "}");
        Response res = POST(apiBaseURL + "/shipments/voidlabel", payload);
        return mapper.readValue(res.readEntity(String.class), SuccessResponse.class);
    }

    public Store getStore(long storeId) throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "/stores/" + storeId);
        return mapper.readValue(res.readEntity(String.class), ListShipments.class);
    }


    updateStore() {

    }

    public StoreRefreshStatusResponse getStoreRefreshStatus(long storeId) throws IOException, InterruptedException {
        Response res = GET(apiBaseURL + "stores/getrefreshstatus?storeId=" + storeId);
        return mapper.readValue(res.readEntity(String.class), StoreRefreshStatusResponse.class);
    }
    public SuccessResponse refresStore(long storeId) throws IOException, InterruptedException {
        Entity payload = Entity.json("{ ''storeId'':" + storeId + "}");
        Response res = POST(apiBaseURL + "/stores/refreshstore", payload);
        return mapper.readValue(res.readEntity(String.class), SuccessResponse.class);
    }

    listStores() {

    }

    listMarketplaces() {

    }

    deactivateStore() {

    }

    reactivateStoer() {

    }


    listUsers() {

    }


    getWarehouse() {

    }

    updateWarehouse() {

    }

    createWarehouse() {

    }

    listWarehouses() {

    }

    listWebhooks() {

    }

    subscribeToWebhook() {

    }

    unsubscribeToWebhook() {

    }