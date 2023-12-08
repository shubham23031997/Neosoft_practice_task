package com.neosoft.validation.service;

import com.neosoft.validation.dto.UserDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class UserService {
    public boolean validateUser(UserDto userDto, Map<String, String> rules) {
        for (Map.Entry<String, String> entry : rules.entrySet()) {
            String field = entry.getKey();
            String rule = entry.getValue();
            if (!isValidField(field, rule, userDto))
                return false;
        }
        return true;
    }

    private boolean isValidField(String field, String rule, UserDto userDto) {
        switch (rule) {
            case "required":
                return getValueFromDto(field, userDto) != null && !getValueFromDto(field, userDto).isEmpty();
            case "email":
                return isValidEmail(getValueFromDto(field, userDto));
//            case "alpha":
//                return getValueFromDto(field, userDto).matches("[A-Za-z]+");
//            case "alpha_num":
//                return getValueFromDto(field, userDto).matches("[A-Za-z0-9]+");
//            case "array":
//                // Implement array validation logic
//                return false; // Placeholder - implement your array validation logic
            case "date":
                return isValidDate(getValueFromDto(field, userDto));
            case "digits":
                return getValueFromDto(field, userDto).matches("\\d{" + rule.split(":")[1] + "}");
            case "regex":
                String regexPattern = rule.split(":")[1];
                return Pattern.matches(regexPattern, getValueFromDto(field, userDto));
            case "after":
                return isDateAfter(getValueFromDto(field, userDto), rule.split(":")[1]);
            case "after_or_equal":
                return isDateAfterOrEqual(getValueFromDto(field, userDto), rule.split(":")[1]);
            case "before":
                return isDateBefore(getValueFromDto(field, userDto), rule.split(":")[1]);
            case "before_or_equal":
                return isDateBeforeOrEqual(getValueFromDto(field, userDto), rule.split(":")[1]);
            case "min":
                return Integer.parseInt(getValueFromDto(field, userDto)) >= Integer.parseInt(rule.split(":")[1]);
            default:
                return true;
        }
    }

    private boolean isValidEmail(String value) {
        // Regex pattern to validate email addresses
        String emailRegex = "^(?:[a-zA-Z0-9_+.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(value).matches();
    }

    private Map<String, Object> convertDtoToMap(UserDto userDto) {
        Map<String, Object> userData = new HashMap<>();
        userData.put("name", userDto.getName());
        userData.put("username", userDto.getUsername());
        userData.put("email", userDto.getEmail());
        userData.put("password", userDto.getPassword());
        userData.put("expiryAfter", userDto.getExpiryAfter());
        userData.put("expiryAfterOrEqual", userDto.getExpiryAfterOrEqual());
        userData.put("expiryBefore", userDto.getExpiryBefore());
        userData.put("salary", userDto.getSalary());
        userData.put("date", userDto.getDate());
        userData.put("yearOfBirth", userDto.getYearOfBirth());
        userData.put("expiryAfterOrEqual", userDto.getExpiryBeforeOrEqual());
        userData.put("termsAndCondition", userDto.isTermsAndCondition());
        return userData;
    }

    private boolean isValidSalary(String salary) {
        // Salary validation logic using regex
        return Pattern.matches("^(?!0\\.00)\\d{1,3}(,\\d{3})*(\\.\\d\\d)?$", salary);
    }

    private boolean isValidDate(String date) {
        // Date validation logic using try-catch for parsing
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isDateAfter(String date, String compareTo) {
        // Date comparison logic
        return LocalDate.parse(date).isAfter(LocalDate.parse(compareTo));
    }

    private boolean isDateAfterOrEqual(String date, String compareTo) {
        // Date comparison logic
        return LocalDate.parse(date).isAfter(LocalDate.parse(compareTo)) || LocalDate.parse(date).isEqual(LocalDate.parse(compareTo));
    }

    private boolean isDateBefore(String date, String compareTo) {
        // Date comparison logic
        return LocalDate.parse(date).isBefore(LocalDate.parse(compareTo));
    }

    private boolean isDateBeforeOrEqual(String date, String compareTo) {
        // Date comparison logic
        return LocalDate.parse(date).isBefore(LocalDate.parse(compareTo)) || LocalDate.parse(date).isEqual(LocalDate.parse(compareTo));
    }

    private String getValueFromDto(String field, UserDto userDto) {
        switch (field) {
            case "name":
                return userDto.getName();
            case "username":
                return userDto.getUsername();
            case "email":
                return userDto.getEmail();
            case "password":
                return userDto.getPassword();
            case "termsAndCondition":
                return String.valueOf(userDto.isTermsAndCondition());
            case "expiryAfter":
                return userDto.getExpiryAfter();
            case "expiryAfterOrEqual":
                return userDto.getExpiryAfterOrEqual();
            case "expiryBefore":
                return userDto.getExpiryBefore();
            case "expiryBeforeOrEqual":
                return userDto.getExpiryBeforeOrEqual();
            case "date":
                return userDto.getDate();
            case "salary":
                return userDto.getSalary();
            case "yearOfBirth":
                return userDto.getYearOfBirth();
            default:
                return null;
        }
    }
}