package com.fixmastery.address.dao;

//import com.vendingmachine.address.model.Address;
//import com.vendingmachine.address.service.AddressService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Because I am currently running on Spring, testing here is a bit different - Will research on this more
 */
@ActiveProfiles("test")
@SpringBootTest
public class AddressServiceTests {

//    @Autowired
//    private AddressService service;
//
//    @Autowired
//    private AddressRepository addressBook;
////
//    @BeforeEach
//    public void setUp() {
//        Address[] addressBook = {
//                new Address("Faith", "Averuncus", "123 Lilith Path", "Park Lane", "OM", 54321),
//                new Address("Negi", "Springfield", "321 Shinjuku Drive", "Nakano", "TY", 98765),
//                new Address("Marth", "Ike", "321 Galeforce Drive", "Tiki Town", "FE", 13579)
//        };
//
//        Arrays.stream(addressBook).forEach(address -> service.addOrSaveAddress(address));
//    }
//
//    @AfterEach
//    public void tearDown() {
//        addressBook.deleteAll();
//    }
//
//    @Test
//    public void getAllAddressesAndSizeTest() {
//        int numOfAddresses = service.size();
//        assertEquals(3, numOfAddresses, "It seems to pick up the autowired repo");
//    }
//
//    @Test
//    public void getSingleAndCreateAddressTest() {
//        Address newNeighbor = new Address("Hope", "Averuncus", "321 Lilith Path", "Park Lane", "OM", 54321);
//
//        service.addOrSaveAddress(newNeighbor);
//        Address retrievedAddress = service.getAddress(newNeighbor.getId()).get();
//
//        assertNotNull(retrievedAddress, "There is something here");
//        assertEquals(newNeighbor.getFirstName(), retrievedAddress.getFirstName(), "First name is the same");
//        assertEquals(newNeighbor.getLastName(), retrievedAddress.getLastName(), "Last name the same");
//    }
//
//    @Test
//    public void deleteAddressTest() {
//        Address newNeighbor = new Address("Love", "Averuncus", "987 Lilith Path", "Park Lane", "OM", 54321);
//
//        service.addOrSaveAddress(newNeighbor);
//        Address retrievedAddress = service.getAddress(newNeighbor.getId()).get();
//        service.deleteAddress(retrievedAddress.getId());
//        boolean isTheDeletedAddressFound = service.getAddress(newNeighbor.getId()).isPresent();
//
//        assertFalse(isTheDeletedAddressFound, "It should be gone now");
//    }


}