package com.et.NumberClassfication.service;


import com.et.NumberClassfication.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@Slf4j
public class ApiChecking {
      @Autowired
      private RestTemplate restTemplate;

      public ResponseDto check(int number)
      {

//            String url = "http://numbersapi.com/" + number;
            String url = "http://numbersapi.com/" + number + "/math";
            ResponseDto res = new ResponseDto();
            boolean armstrong = checkArmstrongNumber(number);
            boolean even = checkOddOrEven(number);
            boolean checkPrime  = checkPrime(number);
            boolean checkPerfect = isPerfect(number);
            int sum = digitSum(number);

            if(armstrong && !even)
            {
              res.setProperties(Arrays.asList("armstrong", "odd"));
            } else if (armstrong && even) {
                  res.setProperties(Arrays.asList("armstrong", "even"));
            } else if (even) {
                  res.setProperties(Arrays.asList("even"));
            }
            else
            {
                  res.setProperties(Arrays.asList("odd"));
            }
            ResponseEntity<String> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, String.class);


            res.setIs_perfect(checkPerfect);
            res.setFun_fact(response.getBody().toString());
            res.setNumber(number);
            res.setIs_prime(checkPrime);
            res.setDigit_sum(sum);
            return res;


      }


      public boolean checkArmstrongNumber(int n)
      {
            Integer temp , sum = 0, last=0,digit=0;

            temp = n;
            while(temp >0)
            {
                  temp = temp/10;
                  digit ++;
            }

            temp = n;
            while (temp>0)
            {
                  last = temp % 10;
                  sum += (int) (Math.pow(last,digit));
                  temp = temp/10;
            }
            if(n==sum)
            {

                  return true;
            }
            else
            {
                  return false;
            }

      }

      public boolean checkOddOrEven(int n)
      {
            if(n%2==0)
            {
                  return true;
            }
            else {
                  return false;
            }
      }

      public boolean checkPrime(int n)
      {
            if(n <= 1)
            {
                  return  false;
            }
           for(int i=2; i <= Math.sqrt(n); i++)
                 if(n%i==0)
                    return false;

          return true;
      }
      public  boolean isPerfect(int n)
      {
            int sum = 0;
            int i=1;

            while(i < n/2)
            {
                  if(n%i == 0)
                  {
                        sum += i;
                  }
               i++;
            }
            if(sum == n)
            {
                  return true;
            }
            else
            {
                  return  false;
            }

      }
      public int digitSum(int n)
      {
            int temp,last=0,sum=0;
            temp = n;
            while (temp>0)
            {
                  last = temp % 10;
                  sum += last;
                  temp = temp/10;
            }

            return sum;

      }
}
