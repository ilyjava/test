package ru.ref.client;

import java.io.Serializable;

public class ContactTable implements Serializable {

    public int[] idArray;
    public String[] nameArray;
    public String[] addressArray;
    public String[] phoneArray;

    public ContactTable(){

    }

    public int[] getIdArray() {
        return this.idArray;
    }

    public String[] getNameArray() {
        return this.nameArray;
    }

    public String[] getAddressArray() {
        return this.addressArray;
    }

    public String[] getPhoneArray() {
        return this.phoneArray;
    }
    public void setIdArray(int[] idArray){

        this.idArray = new int[idArray.length];

        for(int i = 0; i < idArray.length; i++){
            this.idArray[i] = idArray[i];
        }
    }
    public void setNameArray(String[] nameArray){

        this.nameArray = new String[nameArray.length];

        for(int i = 0; i < nameArray.length; i++){
            this.nameArray[i] = nameArray[i];
        }
    }
    public void setAddressArray(String[] addressArray){

        this.addressArray = new String[addressArray.length];

        for(int i = 0; i < addressArray.length; i++){
            this.addressArray[i] = addressArray[i];
        }
    }
    public void setPhoneArray(String[] phoneArray){

        this.phoneArray = new String[phoneArray.length];

        for(int i = 0; i < phoneArray.length; i++){
            this.phoneArray[i] = phoneArray[i];
        }
    }
}
