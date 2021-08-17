/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_pkg;

/**
 *
 * @author SUPERFERRETERIA
 */

public class DataDB {
    private int idOwner;
    private String owner;
    private String document_type;
    private int document;
    private String contact;
    private String gender;
    
    private int idHospital;
    private String hospital;
    private String address;
    
    private int idPets;
    private String pets;
    private String pet_type;
    private String race;
    
    private int idDoctors;
    private String doctor;
    private String doc_type;
    private int document_doc;
    private int id_hospital;
    
    
    

    public DataDB() {
        this.idOwner = 0;
        this.owner = "";
        
        this.idHospital=0;
        this.hospital="";
        this.address="";
    }

    /**
     * @return the idOwner
     */
    public int getIdOwner() {
        return idOwner;
    }

    /**
     * @param idOwner the idOwner to set
     */
    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the document_type
     */
    public String getDocument_type() {
        return document_type;
    }

    /**
     * @param document_type the document_type to set
     */
    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    /**
     * @return the document
     */
    public int getDocument() {
        return document;
    }

    /**
     * @param document the document to set
     */
    public void setDocument(int document) {
        this.document = document;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the idHospital
     */
    public int getIdHospital() {
        return idHospital;
    }

    /**
     * @param idHospital the idHospital to set
     */
    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    /**
     * @return the hospital
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * @param hospital the hospital to set
     */
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the idPets
     */
    public int getIdPets() {
        return idPets;
    }

    /**
     * @param idPets the idPets to set
     */
    public void setIdPets(int idPets) {
        this.idPets = idPets;
    }

    /**
     * @return the pets
     */
    public String getPets() {
        return pets;
    }

    /**
     * @param pets the pets to set
     */
    public void setPets(String pets) {
        this.pets = pets;
    }

    /**
     * @return the pet_type
     */
    public String getPet_type() {
        return pet_type;
    }

    /**
     * @param pet_type the pet_type to set
     */
    public void setPet_type(String pet_type) {
        this.pet_type = pet_type;
    }

    /**
     * @return the idDoctors
     */
    public int getIdDoctors() {
        return idDoctors;
    }

    /**
     * @param idDoctors the idDoctors to set
     */
    public void setIdDoctors(int idDoctors) {
        this.idDoctors = idDoctors;
    }

    /**
     * @return the doctor
     */
    public String getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    /**
     * @return the doc_type
     */
    public String getDoc_type() {
        return doc_type;
    }

    /**
     * @param doc_type the doc_type to set
     */
    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    /**
     * @return the document_doc
     */
    public int getDocument_doc() {
        return document_doc;
    }

    /**
     * @param document_doc the document_doc to set
     */
    public void setDocument_doc(int document_doc) {
        this.document_doc = document_doc;
    }

    /**
     * @return the id_hospital
     */
    public int getId_hospital() {
        return id_hospital;
    }

    /**
     * @param id_hospital the id_hospital to set
     */
    public void setId_hospital(int id_hospital) {
        this.id_hospital = id_hospital;
    }

    /**
     * @return the race
     */
    public String getRace() {
        return race;
    }

    /**
     * @param race the race to set
     */
    public void setRace(String race) {
        this.race = race;
    }

   
}
