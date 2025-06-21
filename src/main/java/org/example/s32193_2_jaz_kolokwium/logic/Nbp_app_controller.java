package org.example.s32193_2_jaz_kolokwium.logic;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Nbp_app_controller {

    private final Nbp_app_service nbp_app_service;

    public Nbp_app_controller(Nbp_app_service nbp_app_service) {
        this.nbp_app_service = nbp_app_service;
    }

    @GetMapping("/get_data")
    public ResponseEntity<String> get_data() {
        return ResponseEntity.ok(nbp_app_service.get_data().getBody());
    }

    @GetMapping("/get_currency/{code}")
    public ResponseEntity<String> get_currency(@PathVariable String code) {
        return ResponseEntity.ok(nbp_app_service.get_currency(code)).getBody();
    }


}
