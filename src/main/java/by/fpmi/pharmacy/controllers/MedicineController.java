package by.fpmi.pharmacy.controllers;

import by.fpmi.pharmacy.model.Medicine;
import by.fpmi.pharmacy.model.User;
import by.fpmi.pharmacy.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by annashunko
 */
@RestController
public class MedicineController {
    public static final String DATE_FORMAT = "MM/dd/yyyy";

    @Autowired
    MedicineService medicineService;

    @RequestMapping(value = "/medicine/{id}", method = RequestMethod.GET)
    public ResponseEntity<Medicine> medicineGet(@PathVariable int id) {
        Medicine medicine = medicineService.getById(id);
        return new ResponseEntity<Medicine>(medicine, HttpStatus.OK);
    }

    @RequestMapping(value = "/medicine/list", method = RequestMethod.GET)
    public ResponseEntity<List<Medicine>> listMedicine() {
        List<Medicine> medicineList = medicineService.listMedicines();
        return new ResponseEntity<>(medicineList, HttpStatus.OK);
    }


    @RequestMapping(value = "/medicine/add", method = RequestMethod.POST)
    public ResponseEntity<Medicine> userAdd(@RequestParam(value = "name") String name,
                                        @RequestParam(value = "about") String about,
                                        @RequestParam(value = "gram_in_one") double gramInOne,
                                        @RequestParam(value = "cost") double cost,
                                        @RequestParam(value = "quantity") int quantity,
                                        @RequestParam(value = "consist") String consist,
                                        @RequestParam(value = "state") String state,
                                        @RequestParam(value = "dosing") String dosing,
                                        @RequestParam(value = "contradictions") String contradictions,
                                        @RequestParam(value = "expiration_date") String expireDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = dateFormat.parse(expireDate);
        Medicine medicine = new Medicine(name, about, gramInOne,cost, quantity, consist, date,
                state, dosing, contradictions, null);
        Medicine savedMedicine  = medicineService.save(medicine);
        return new ResponseEntity<>(savedMedicine, HttpStatus.OK);
    }

    @RequestMapping(value = "/medicine/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Integer> medicineDelete(@PathVariable int id) {
        medicineService.delete(id);
        return new ResponseEntity<>(200, HttpStatus.OK);
    }



}
