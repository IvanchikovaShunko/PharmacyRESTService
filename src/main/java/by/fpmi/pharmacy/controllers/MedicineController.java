package by.fpmi.pharmacy.controllers;

import by.fpmi.pharmacy.model.Medicine;
import by.fpmi.pharmacy.model.User;
import by.fpmi.pharmacy.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by annashunko
 */
@RestController
public class MedicineController {
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
}
