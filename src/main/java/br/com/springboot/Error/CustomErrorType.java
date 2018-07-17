package br.com.springboot.Error;

public class CustomErrorType {

    private String erroMessage;

   public CustomErrorType(String errorMessage ) {
       this.erroMessage = errorMessage;
   }

    public String getErroMessage() {
        return erroMessage;
    }
}
