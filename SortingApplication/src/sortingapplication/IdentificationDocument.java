package sortingapplication;

/**
 * Class: Identification Record Description: It is the description of the
 * official document used by one person for identification in the system
 *
 * @author Wanderley de Souza Alencar (june, 2016)
 */
public class IdentificationDocument {

    //
    // Maximum lenght, in number of decimal digits, of the number of the document
    //
    private final int MAXIMUM_LENGHT_OF_NUMBER = 11;
    private int type;               // Type: 0 - undefined, 1 - National ID number (CPF in Brazil), 2 - Passport
    private long number;
    private int originCountryCode; // Country code where the document was emitted

    /**
     * Method.....: IdentificationDocument Input......: nothing Output.....:
     * nothing Description: Initializes a IdentificationDocument object with
     * standard values Observation:
     */
    public void IdentificationDocument() {
        setType(0);
        setNumber(0);
        setOriginCountryCode(0);
    }

    /**
     * @return the type of the document (0 - undefined, 1 - CPF, 2 - Passport)
     */
    public int getType() {
        return type;
    }

    /**
     * @param paramType the type of the document (0 - undefined, 1 - CPF, 2 -
     * Passport)
     */
    public void setType(int paramType) {
        if ((paramType == 1) || (paramType == 2)) {
            this.type = paramType;
        } else {
            this.type = 0;
        }
    }

    /**
     * @return the number of the document
     */
    public long getNumber() {
        return number;
    }

    /**
     * @param paramNumber the number of the document, between 0 and 99999999999
     */
    public void setNumber(long paramNumber) {
        if ((double) paramNumber < 1e+12) {
            this.number = paramNumber;
        } else {
            this.number = 0;
        }
    }

    /**
     * @return the country code where the document was emitted
     */
    public int getOriginCountryCode() {
        return (originCountryCode);
    }

    /**
     * @param paramOriginCountryCode the country code where the document was
     * emitted
     */
    public void setOriginCountryCode(int paramOriginCountryCode) {
        if ((paramOriginCountryCode > 0) && (paramOriginCountryCode < 10000)) {
            this.originCountryCode = paramOriginCountryCode;
        } else {
            this.originCountryCode = 0;
        }
    }

    /**
     * @return the maximum number of digits for the document number
     */
    public int getMAXIMUM_LENGHT_OF_NUMBER() {
        return MAXIMUM_LENGHT_OF_NUMBER;
    }
}
