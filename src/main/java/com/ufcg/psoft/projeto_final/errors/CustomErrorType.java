package com.ufcg.psoft.projeto_final.errors;

    public class CustomErrorType {

        private String errorMessage;

        public CustomErrorType(String errorMessage){
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

    }