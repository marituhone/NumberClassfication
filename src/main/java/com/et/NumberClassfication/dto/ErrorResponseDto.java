package com.et.NumberClassfication.dto;
public class ErrorResponseDto {


       private String number;
      private boolean error;


      public String getNumber() {
            return number;
      }

      public void setNumber(String number) {
            this.number = number;
      }

      public boolean isError() {
            return error;
      }

      public void setError(boolean error) {
            this.error = error;
      }

      @Override
      public String toString() {
            return "ErrorResponseDto{" +
                    "number='" + number + '\'' +
                    ", error=" + error +
                    '}';
      }
}
