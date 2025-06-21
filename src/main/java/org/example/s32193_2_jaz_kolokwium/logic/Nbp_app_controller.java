package org.example.s32193_2_jaz_kolokwium.logic;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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


    @Tag(name = "get danych BP")
    @Operation(
            summary = "wysyla zapytanie do serwisu, ktory potem przekazuje je dalej do api NBP"
    )
    @ApiResponses(value = {


            @ApiResponse(responseCode = "404", description = "not found exception, aplikacja dziala zgodnie z zalozeniami, ale nie znalazla danych"),
            @ApiResponse(responseCode = "200", description = "aplikacja dziala zgodnie z zalozeniami"),
            @ApiResponse(responseCode = "502", description = "bad gateway, blad po stronie serwera, aplikacja nie dziala zgodnie z zalozeniami"),
            @ApiResponse(responseCode = "400", description = "bad request, blad po stronie clienta, aplikacja dziala zgodnie z zalozeniami")

    }
    )
    @GetMapping("/get_data")
    public ResponseEntity<String> get_data() {
        return ResponseEntity.ok(nbp_app_service.get_data().getBody());
    }


    @Tag(name = "pobranie danych dla konkretnej waluty")
    @Operation(
            summary = "wysyla zapytanie do serwisu, ktory potem przekazuje je dalej do api NBP"
    )
    @ApiResponses(value = {


            @ApiResponse(responseCode = "404", description = "not found exception, aplikacja dziala zgodnie z zalozeniami, ale nie znalazla danych"),
            @ApiResponse(responseCode = "200", description = "aplikacja dziala zgodnie z zalozeniami"),
            @ApiResponse(responseCode = "502", description = "bad gateway, blad po stronie serwera, aplikacja nie dziala zgodnie z zalozeniami"),
            @ApiResponse(responseCode = "400", description = "bad request, blad po stronie clienta, aplikacja dziala zgodnie z zalozeniami")

    }
    )
    @GetMapping("/get_currency/{code}")
    public ResponseEntity<String> get_currency(@PathVariable String code) {
        return ResponseEntity.ok(nbp_app_service.get_currency(code)).getBody();
    }


}
