package com.neosoft.ServerSideValidation.utility;

import com.neosoft.ServerSideValidation.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {
    //    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static boolean isBefore(String expiryBefore, String date) {
        try {
            LocalDate parsedExpiryBefore = LocalDate.parse(expiryBefore, formatter);
            LocalDate comparisonDate = LocalDate.parse(date, formatter);
            return comparisonDate.isBefore(parsedExpiryBefore);
        } catch (DateTimeParseException e) {
            e.printStackTrace(); // Consider logging the error
            return false; // Handle parsing exception accordingly
        }
    }

    public static boolean isBeforeOrEqual(String expiryBeforeOrEqual, String date) {
        try {
            LocalDate parsedExpiryBeforeOrEqual = LocalDate.parse(expiryBeforeOrEqual, formatter);
            LocalDate comparisonDate = LocalDate.parse(date, formatter);
            return !comparisonDate.isAfter(parsedExpiryBeforeOrEqual);
        } catch (DateTimeParseException e) {
            e.printStackTrace(); // Consider logging the error
            return false; // Handle parsing exception accordingly
        }
    }

    public static boolean isAfterOrEqual(String expiryAfterOrEqual, String date) {
        try {
            LocalDate parsedExpiryAfterOrEqual = LocalDate.parse(expiryAfterOrEqual, formatter);
            LocalDate comparisonDate = LocalDate.parse(date, formatter);
            return !comparisonDate.isBefore(parsedExpiryAfterOrEqual);
        } catch (DateTimeParseException e) {
            e.printStackTrace(); // Consider logging the error
            return false; // Handle parsing exception accordingly
        }
    }

    public static boolean isAfter(String date1, String date2) {
        try {
            LocalDate parsedDate1 = LocalDate.parse(date1, formatter);
            LocalDate parsedDate2 = LocalDate.parse(date2, formatter);
            return parsedDate1.isAfter(parsedDate2);
        } catch (DateTimeParseException e) {
            e.printStackTrace(); // Consider logging the error
            return false; // Handle parsing exception accordingly
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto dto = (UserDto) target;

        if (!dto.getName().matches("[A-Za-z]+")) {
            errors.rejectValue("name", "invalid.format", "Name should contain only alphabets");
        }

        if (dto.getUsername().length() < 15) {
            errors.rejectValue("username", "invalid.format", "Username should be at least 15 characters long");
        }

        if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", dto.getEmail())) {
            errors.rejectValue("email", "invalid.format", "Invalid email format");
        }

        if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
            errors.rejectValue("password", "invalid.format", "Password is required");
        }

        if (!dto.isTermsAndCondition()) {
            errors.rejectValue("termsAndCondition", "invalid.format", "Terms and conditions must be accepted");
        }

        // Apply date validations based on your logic
        if (!isAfter(dto.getExpiryAfter(), dto.getDate())) {
            errors.rejectValue("expiryAfter", "invalid.format", "Expiry date should be after"+dto.getDate());
        }

        if (!isAfterOrEqual(dto.getExpiryAfterOrEqual(), dto.getDate())) {
            errors.rejectValue("expiryAfterOrEqual", "invalid.format", "Expiry date should be on or after "+dto.getDate());
        }

        if (!isBefore(dto.getExpiryBefore(), dto.getDate())) {
            errors.rejectValue("expiryBefore", "invalid.format", "Expiry date should be before"+dto.getDate());
        }

        if (!isBeforeOrEqual(dto.getExpiryBeforeOrEqual(), dto.getDate())) {
            errors.rejectValue("expiryBeforeOrEqual", "invalid.format", "Expiry date should be on or before "+dto.getDate());
        }
        //reflation api& or map

//        if (!Pattern.matches("^(?!0\\\\.00)\\\\d{1,3}(,\\\\d{3})*(\\\\.\\\\d\\\\d)?$", dto.getSalary())) {
//            errors.rejectValue("salary", "invalid.format", "Invalid salary format");
//        }

        if (!Pattern.matches("^(19|20)\\d{2}$", dto.getYearOfBirth())) {
            errors.rejectValue("yearOfBirth", "invalid.format", "Invalid year of birth");
        }
    }

}