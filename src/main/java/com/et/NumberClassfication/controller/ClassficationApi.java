package com.et.NumberClassfication.controller;


import com.et.NumberClassfication.dto.ErrorResponseDto;
import com.et.NumberClassfication.dto.ResponseDto;
import com.et.NumberClassfication.service.ApiChecking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ClassficationApi {


      @Autowired
      private ApiChecking apiChecking;


      @GetMapping("/classify-number")
      public ResponseEntity<?> classify(@RequestParam String number)
      {

            try {
                  int parsedNumber = Integer.parseInt(number);
                  ResponseDto responseDto=  apiChecking.check(parsedNumber);
                  return ResponseEntity.ok().body(responseDto);

            }
            catch (NumberFormatException e)
            {
                  ErrorResponseDto err = new ErrorResponseDto();
                  err.setError(true);
                  err.setNumber(number);
                  return ResponseEntity.badRequest().body(err);
            }


      }
}
