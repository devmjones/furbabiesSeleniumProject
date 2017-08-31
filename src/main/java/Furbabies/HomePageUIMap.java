package Furbabies;

/**
 * Created by devonjones on 8/26/17.
 */
public class HomePageUIMap {

    // Sign Up
    public static final String firstNameField = "#firstName";
    public static final String lastNameField = "#lastName";
    public static final String emailField = "#email";
    public static final String passwordField = "#password";
    public static final String createBtn = "#createButton";
    public static final String unmaskBtn = ".unmask";
    public static final String cancelBtn = ".//*[@id='cancel']/div/input";


    // Sign In
    public static final String signInBtn = ".login-button";
    public static final String signInPanel = "#signin";
    public static final String emailFieldSignIn = "#email_signin";
    public static final String passwordFieldSignIn = "#password_signin";
    public static final String signInSubmitBtn = "div.dropdown-menu > form#signin > div.form-group > button#signinsubmit";

    public static final String errorMsgTakenEmail = "//strong[contains(text(), 'Signup error: This email is already taken!')]";
    public static final String erroMsgWrongPass = "//strong[contains(text(), 'Sign in error: Please enter a valid password!')]";
}
