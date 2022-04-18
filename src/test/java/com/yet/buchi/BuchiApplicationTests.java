package com.yet.buchi;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.yet.buchi.Services.CustomerManagementService;
import com.yet.buchi.models.Adoption;
import com.yet.buchi.models.Customer;
import com.yet.buchi.models.Pet;
import com.yet.buchi.repository.AdoptionRepository;
import com.yet.buchi.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class BuchiApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private CustomerManagementService customerManagementService;
    @MockBean
    private CustomerRepository customerRepository;
    @MockBean
    private AdoptionRepository adoptionRepository;

    @Test
    public void listCustomerTest(){
        Long id = 25L;
        Long id2 = 20L;

        when(customerRepository.findAll()).thenReturn(Stream.of(new Customer(id,"testperson","09124567898"), new Customer(id2,"testpersontwo","0945454564")).collect(Collectors.toList()));
        assertEquals(2,customerManagementService.listCustomer().size());
    }
    @Test
    public void addCustomer(){
        Long id = 25L;
        Customer customer = new Customer(id,"testTesfa","090000000");

        when(customerRepository.save(customer)).thenReturn(customer);

    }
    @Test
    public void addAdoption(){
        Long id = 25L;

        Pet pet = new Pet(id,"test","test","test","test","testpict",true);
        Customer customer = new Customer(id,"testcustome","00000000");
        Adoption adoption = new Adoption(id,customer,pet,new Date());

        when(adoptionRepository.save(adoption)).thenReturn(adoption);

    }

    @Test
    public void findAdoptionById(){
        Long id = 5L;
        Long customerId = 10L;
        Long petId = 1L;

        Pet pet = new Pet(petId,"test","test","test","test","testpict",true);
        Customer customer = new Customer(customerId,"testcustome","00000000");
        Adoption adoption = new Adoption(id,customer,pet,new Date());

        when(adoptionRepository.findAdoptionById(id)).thenReturn(adoption);

    }



}
