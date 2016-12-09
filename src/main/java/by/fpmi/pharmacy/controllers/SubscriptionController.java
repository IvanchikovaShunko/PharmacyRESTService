package by.fpmi.pharmacy.controllers;

import by.fpmi.pharmacy.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by annashunko
 */
@RestController
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;
}
