package by.fpmi.pharmacy.controllers;

import by.fpmi.pharmacy.model.Basket;
import by.fpmi.pharmacy.model.Medicine;
import by.fpmi.pharmacy.model.User;
import by.fpmi.pharmacy.services.BasketService;
import by.fpmi.pharmacy.services.MedicineService;
import by.fpmi.pharmacy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by annashunko
 */
@RestController
public class BasketController {

    @Autowired
    private BasketService basketService;

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{userId}/basket/add", method = RequestMethod.POST)
    public Basket userAddToBasket(@PathVariable int userId,
                                  @RequestParam(value = "medicine_id") int medicineId) {
        Medicine medicine = medicineService.getById(medicineId);
        Basket basket = basketService.getByUserId(userId);
        User user = userService.getUserById(userId);
        if (medicine != null) {
            if (basket == null) {
                basket = new Basket();
                basket.setIdUser(user);
                basket.addMedicine(medicine);
                basketService.save(basket);
            } else {
                basket.addMedicine(medicine);
                basketService.update(basket);
            }
            return basket;
        }
        return null;
    }

    @RequestMapping(value = "/user/{userId}/basket/remove", method = RequestMethod.POST)
    public Basket userRemoveFromBasket(@PathVariable int userId,
                                  @RequestParam(value = "medicine_id") int medicineId) {
        Medicine medicine = medicineService.getById(medicineId);
        Basket basket = basketService.getByUserId(userId);
        User user = userService.getUserById(userId);
        if (medicine != null) {
            if (basket != null) {
                basket.removeMedicine(medicine);
                basketService.update(basket);
            }
            return basket;
        }
        return null;
    }

}
