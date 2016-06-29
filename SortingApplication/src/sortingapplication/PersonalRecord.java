/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingapplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class: Personal Record Description: It is the registered set of information
 * about a person.
 *
 * @author Wanderley de Souza Alencar (june, 2016)
 */
public class PersonalRecord {

    private final int TINY_SIZE = 1;
    private final int SHORT_SIZE = 3;
    private final int MEDIUM_SIZE = 50;
    private final int LONG_SIZE = 140;

    private IdentificationDocument personalDocument;           // The official document used for identification of the person
    private String completeName;               // Complete name, no abbreviatons. Maximum lenght: MEDIUM_SIZE
    private String genre;                      // Genre: M for male, F for female ou * for others. Maximum lenght: TINY_SIZE
    private Date dateOfBirth;                // Date of birth
    private int nationalityCode;            // Country code where the person was born. 
    private int citizenshipCode;            // Country code of which the person is a citizen.
    private String bloodType;                  // What is the type of blood: A+, B-, AB-, O+, ... Maximum lenght: SHORT_SIZE
    private boolean isDisabledPerson;           // Is a disabled person? 
    private String disabledDescription;        // Yes: describes disability.
    private String observation;                // Any observation. Maximum lenght: MEDIUM_SIZE    

    /**
     * Method.....: PersonalRecord Input......: nothing Output.....: nothing
     * Description: Initializes a PersonalRecord object Observation:
     */
    public void PersonalRecord() {
        setPersonalDocument(new IdentificationDocument());
        setCompleteName("");
        setGenre("*");
        setDateOfBirth(new Date());
        setNationalityCode(0);
        setCitizenshipCode(0);
        setBloodType("");
        setIsDisabledPerson(false);
        setDisabledDescription("");
        setObservation("");
    }

    /**
     * @return the official document used for identification of the person
     */
    public IdentificationDocument getPersonalDocument() {
        return personalDocument;
    }

    /**
     * @param paramPersonalDocument the official document used for
     * identification of the person
     */
    public void setPersonalDocument(IdentificationDocument paramPersonalDocument) {
        this.personalDocument = paramPersonalDocument;
    }

    /**
     * @return the complete name of the person
     */
    public String getCompleteName() {
        return completeName;
    }

    /**
     * @param paramCompleteName the complete name of the person (no
     * abbreviations)
     */
    public void setCompleteName(String paramCompleteName) {
        if (paramCompleteName.length() <= MEDIUM_SIZE) {
            this.completeName = paramCompleteName;
        } else {
            this.completeName = paramCompleteName.substring(0, MEDIUM_SIZE);
        }
    }

    /**
     * @return the genre of the person (M - male, F - female, * - not declared)
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param paramGenre the genre of the person (M - male, F - female, * - not
     * declared)
     */
    public void setGenre(String paramGenre) {
        if ("MF*".contains(paramGenre)) {
            this.genre = paramGenre;
        } else {
            this.genre = "";
        }
    }

    /**
     * @return the date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param paramDateOfBirth the date of birth
     */
    public void setDateOfBirth(Date paramDateOfBirth) {
        this.dateOfBirth = paramDateOfBirth;
    }

    /**
     * @return the nationality (country code where the person was born)
     */
    public int getNationalityCode() {
        return nationalityCode;
    }

    /**
     * @param paramNationalityCode the nationality (country code where the
     * person was born)
     */
    public void setNationalityCode(int paramNationalityCode) {
        if ((paramNationalityCode > -1) && (paramNationalityCode < 10000)) {
            this.nationalityCode = paramNationalityCode;
        } else {
            this.nationalityCode = 0;
        }
    }

    /**
     * @return the citizenship (country code of which the person is a citizen)
     */
    public int getCitizenshipCode() {
        return citizenshipCode;
    }

    /**
     * @param paramCitizenshipCode the citizenship (country code of which the
     * person is a citizen)
     */
    public void setCitizenshipCode(int paramCitizenshipCode) {
        if ((paramCitizenshipCode > -1) && (paramCitizenshipCode < 10000)) {
            this.citizenshipCode = paramCitizenshipCode;
        } else {
            this.citizenshipCode = 0;
        }
    }

    /**
     * @return the blood type (A+, A-, B+, B-, O+, O-, AB+ or AB-)
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * @param paramBloodType the blood type (A+, A-, B+, B-, O+, O-, AB+ or AB-)
     */
    public void setBloodType(String paramBloodType) {
        if ("A+A-B+B-O+O-AB+AB-".contains(paramBloodType.toUpperCase())) {
            this.bloodType = paramBloodType;
        } else {
            this.bloodType = "";
        }
    }

    /**
     * @return Is a disable person (any physical or mental problem)?
     */
    public boolean getIsDisabledPerson() {
        return isDisabledPerson;
    }

    /**
     * @param paramIsDisabledPerson Is a disable person (any physical or mental
     * problem)
     */
    public void setIsDisabledPerson(boolean paramIsDisabledPerson) {
        this.isDisabledPerson = paramIsDisabledPerson;
        if (!(this.isDisabledPerson)) {
            this.disabledDescription = "";
        }
    }

    /**
     * @return the disability description
     */
    public String getDisabledDescription() {
        return disabledDescription;
    }

    /**
     * @param paramDisabledDescription the disability description
     */
    public void setDisabledDescription(String paramDisabledDescription) {
        if (this.isDisabledPerson) {
            this.disabledDescription = paramDisabledDescription;
        } else {
            this.disabledDescription = "-";
        }
    }

    /**
     * @return any observation registered
     */
    public String getObservation() {
        return observation;
    }

    /**
     * @param paramObservation any observation
     */
    public void setObservation(String paramObservation) {
        this.observation = paramObservation;
    }

    /**
     * Method.....: print Input......: nothing Output.....: nothing Description:
     * print the record fields, one field by line. Observation:
     */
    public void print() {

        String auxiliaryDate;
        SimpleDateFormat date;

        System.out.println("================================================================");
        switch (this.getPersonalDocument().getType()) {
            case 1:
                System.out.println("Document type.........: " + "CPF");
                break;
            case 2:
                System.out.println("Document type.........: " + "Passport");
                break;
            default:
                System.out.println("Document type.........: " + "Unknown");
        }
        date = new SimpleDateFormat("dd/MM/yyyy");
        auxiliaryDate = date.format(this.dateOfBirth);
        System.out.println("Document number.......: " + this.getPersonalDocument().getNumber());
        System.out.println("Document country......: " + this.getPersonalDocument().getOriginCountryCode());
        System.out.println();
        System.out.println("Complete name.........: " + this.completeName);
        System.out.println("Genre.................: " + this.genre);
        System.out.println("Birth date............: " + auxiliaryDate);
        System.out.println("Birth country.........: " + this.nationalityCode);
        System.out.println("Citizenship country...: " + this.citizenshipCode);
        System.out.println("Blood type............: " + this.bloodType);
        if (this.isDisabledPerson) {
            System.out.println("Is a disabled person..: " + "YES");
            if (!(this.disabledDescription).isEmpty()) {
                System.out.println("Disabled description..: " + this.disabledDescription);
            }
        } else {
            System.out.println("Is a disabled person..: " + "NO");
        }

        if (!(this.observation.isEmpty())) {
            System.out.println("Observation...........: " + this.observation);
        } else {
            System.out.println("Observation...........: " + "NO");
        }
        System.out.println("================================================================");
        System.out.println();
    }

    /**
     * Method.....: formatDate Input......: paramStringDate - a string with a
     * date expression Output.....: the correspondent date data type or null (if
     * an error occurs) Description: Convert a string (with a date expression)
     * to a date type Observation:
     */
    /**
     * @param paramStringDate String that represents a date (dd/MM/yyyy)
     * @return A Date object or NULL
     * @throws Exception, if the string is incorrect
     */
    public Date formatDate(String paramStringDate) throws Exception {

        Date auxiliaryDate;

        if (paramStringDate == null || paramStringDate.equals("")) {
            return (null);
        } else {
            auxiliaryDate = null;
            try {
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                auxiliaryDate = (java.util.Date) formatter.parse(paramStringDate);
            } catch (ParseException e) {
                throw e;
            }
            return (auxiliaryDate);
        }
    }

}
