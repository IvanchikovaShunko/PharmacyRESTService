package by.fpmi.pharmacy.controllers;

import by.fpmi.pharmacy.model.Basket;
import by.fpmi.pharmacy.model.Medicine;
import by.fpmi.pharmacy.model.Subscription;
import by.fpmi.pharmacy.model.User;
import by.fpmi.pharmacy.services.MedicineService;
import by.fpmi.pharmacy.services.SubscriptionService;
import by.fpmi.pharmacy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by annashunko
 */
@RestController
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{userId}/subscriptions", method = RequestMethod.GET)
    public ResponseEntity<Subscription> getUserSubscriptions(@PathVariable int userId){
        Subscription subscription = subscriptionService.getByUserId(userId);
        return new ResponseEntity<Subscription>(subscription, HttpStatus.OK);
    }

//    @RequestMapping(value = "/user/{userId}/subscriptions/add", method = RequestMethod.POST)
//    public ResponseEntity<Subscription> userSubscribe(@PathVariable int userId,
//                                                  @RequestParam(value = "medicine_id") int medicineId) {
//        Medicine medicine = medicineService.getById(medicineId);
//        User user = userService.getUserById(userId);
//
//        return new ResponseEntity<Subscription>();
//
//    }
}
