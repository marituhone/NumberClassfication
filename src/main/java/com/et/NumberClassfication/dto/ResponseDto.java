package com.et.NumberClassfication.dto;

import java.util.List;

public class ResponseDto {

      private int number;
     private boolean is_prime;
     private   boolean is_perfect;

     private List<String> properties;

     private int digit_sum;

    private   String fun_fact;

      public int getNumber() {
            return number;
      }

      public void setNumber(int number) {
            this.number = number;
      }

      public boolean isIs_prime() {
            return is_prime;
      }

      public void setIs_prime(boolean is_prime) {
            this.is_prime = is_prime;
      }

      public boolean isIs_perfect() {
            return is_perfect;
      }

      public void setIs_perfect(boolean is_perfect) {
            this.is_perfect = is_perfect;
      }

      public List<String> getProperties() {
            return properties;
      }

      public void setProperties(List<String> properties) {
            this.properties = properties;
      }

      public int getDigit_sum() {
            return digit_sum;
      }

      public void setDigit_sum(int digit_sum) {
            this.digit_sum = digit_sum;
      }

      public String getFun_fact() {
            return fun_fact;
      }

      public void setFun_fact(String fun_fact) {
            this.fun_fact = fun_fact;
      }
}
