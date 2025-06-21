package org.example.s32193_2_jaz_kolokwium.logic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class Nbp_app_service {

    private final RestTemplate restTemplate;

    public Nbp_app_service(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> get_data() {
        try{
            return restTemplate.getForEntity("https://api.nbp.pl/api/exchangerates/tables/A/?format=json", String.class);
        }catch(HttpServerErrorException.InternalServerError e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }catch(HttpClientErrorException.NotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (HttpClientErrorException.BadRequest e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> get_currency(String code) {
        try{
            return restTemplate.getForEntity("https://api.nbp.pl/api/exchangerates/rates/A/"+ code +"/?format=json",String.class);
        }catch(HttpServerErrorException.InternalServerError e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }catch(HttpClientErrorException.NotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (HttpClientErrorException.BadRequest e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
