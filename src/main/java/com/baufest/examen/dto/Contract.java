package com.baufest.examen.dto;

public class Contract {
    
    private String company;
    
    private String contractNumber;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    @Override
    public String toString() {
        return "Contract [company=" + company + ", contractNumber=" + contractNumber + "]";
    }
    
    
}
