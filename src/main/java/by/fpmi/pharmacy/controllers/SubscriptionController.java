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

import java.util.List;

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
    public ResponseEntity<List<Subscription>> getUserSubscriptions(@PathVariable int userId) {
        List<Subscription> subscriptions = subscriptionService.getUserSubscriptions(userId);
        return new ResponseEntity<List<Subscription>>(subscriptions, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{userId}/subscriptions/add", method = RequestMethod.POST)
    public ResponseEntity<Integer> userSubscribe(@PathVariable int userId,
                                                 @RequestParam(value = "medicine_id") int medicineId,
                                                 @RequestParam(value = "period") String period) {
        Medicine medicine = medicineService.getById(medicineId);
        User user = userService.getUserById(userId);
        Subscription subscription = new Subscription(true, period, medicine, user);
        subscriptionService.save(subscription);
        return new ResponseEntity<Integer>(200, HttpStatus.OK);

    }

    @RequestMapping(value = "/user/{userId}/subscriptions/remove/{id}", method = RequestMethod.POST)
    public ResponseEntity<Integer> userSubscribe(@PathVariable(value = "userId") int userId,
                                                 @PathVariable(value = "id") int id) {
        User user = userService.getUserById(userId);
        Subscription subscription = subscriptionService.getById(id);
        if (subscription != null) {
            subscriptionService.delete(id);
            return new ResponseEntity<Integer>(200, HttpStatus.OK);
        }
        return new ResponseEntity<Integer>(400, HttpStatus.NOT_FOUND);
    }
}
