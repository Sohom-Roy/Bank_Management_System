
package SignUp;

import java.io.File;
import java.util.Date;

public class SignupData {

    // =========================================
    // PAGE 1: PERSONAL DETAILS
    // =========================================

    public String name;
    public String fatherName;
    public Date dateOfBirth;
    public String gender;
    public String email;
    public String maritalStatus;

    public String address;
    public String city;
    public String district;
    public String postalCode;
    public String state;

    // =========================================
    // PAGE 2: ADDITIONAL DETAILS
    // =========================================

    public String religion;
    public String category;
    public String annualIncome;
    public String education;
    public String occupation;

    public String panNumber;
    public String aadhaarNumber;

    public boolean seniorCitizen;

    // =========================================
    // PAGE 3: ACCOUNT DETAILS
    // =========================================

    public String accountType;
    public String initialDeposit;

    public boolean atmCard;
    public boolean internetBanking;
    public boolean mobileBanking;
    public boolean smsAlert;
    public boolean chequeBook;

    // =========================================
    // PAGE 3: NOMINEE DETAILS
    // =========================================

    public String nomineeName;
    public String nomineeRelation;
    public Date nomineeDob;
    public String nomineeAddress;

    // =========================================
    // PAGE 4: DOCUMENTS
    // =========================================

    public File panFile;
    public File aadhaarFile;
    public File photographFile;
    public File signatureFile;

    public boolean declarationAccepted;

    // =========================================
    // APPLICATION DETAILS
    // =========================================

    public long formNumber;

    public SignupData(long formNumber) {
        this.formNumber = formNumber;
    }
}
