package org.sid.msorder.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.sid.msorder.Entity.Client;
import org.sid.msorder.Entity.Order;
import org.sid.msorder.Entity.OrderStatus;
import org.sid.msorder.Entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.Collections;

@Component
public class DbInit implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        addSampleData();
    }

    private void addSampleData() {
        Client client1 = new Client();
        client1.setFirstName("Leila");
        client1.setLastName("Bennani");
        client1.setEmail("leila.bennani@axtech.com");
        client1.setCity("Casablanca");
        client1.setRs("123456");
        client1.setRc("Ax Technologies");
        client1.setIce("A123456789");
        em.persist(client1);

        Product product1 = new Product();
        product1.setProductName("Business Connect Fixe ADSL");
        product1.setSubTitle("forfait");
        product1.setSubMention("forfaits");
        product1.setFamilyName("Business Connect Fixe");
        product1.setFamilyCode("Fixe");
        product1.setPrice(BigDecimal.valueOf(1500.00));
        product1.setCommissioningFees(BigDecimal.valueOf(50.00));
        product1.setInstallationFees(BigDecimal.valueOf(100.00));
        product1.setQuantity(10);
        product1.setEngagementPeriod("24 Months");
        em.persist(product1);

        Order order1 = new Order();
        order1.setPaymentMode("DEBIT_CARD");
        order1.setStatus(OrderStatus.COMMANDE_TRAITEE);
        order1.setInstallationAddress("12 Rue Mohamed5, Quartier Habbous");
        order1.setDeliveryAddress("12 Rue Mohamed5, Quartier Habbous");
        order1.setInstallationCity("Casablanca");
        order1.setDeliveryCity("Casablanca");
        order1.setClient(client1);
        order1.setProducts(Collections.singletonList(product1));
        em.persist(order1);


        client1.setOrders(Collections.singletonList(order1));
        em.merge(client1);
    }
}