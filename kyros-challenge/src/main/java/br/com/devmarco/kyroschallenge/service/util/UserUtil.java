package br.com.devmarco.kyroschallenge.service.util;

import br.com.devmarco.kyroschallenge.controllers.dtos.UserDTO;
import br.com.devmarco.kyroschallenge.service.exceptions.UserException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUtil {
    public static void testAllUserFields(UserDTO userDTO) throws UserException {
        testEmail(userDTO.getEmail());
        testPassword(userDTO.getPassword());
    }

    private static void testEmail(String email) throws UserException {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        if(isEmailIdValid == false){
            throw new UserException("Email inválido" +
                    "");
        }
    }

    private static void testPassword(String password) throws UserException {
        if (password.length() < 8)
            throw new UserException("A senha deve ter no mínimo 8 caracteres");

        boolean achouNumero = false;
        boolean achouMaiuscula = false;
        boolean achouMinuscula = false;

        for (char c : password.toCharArray()) {
            if (c >= '0' && c <= '9') {
                achouNumero = true;
            } else if (c >= 'A' && c <= 'Z') {
                achouMaiuscula = true;
            } else if (c >= 'a' && c <= 'z') {
                achouMinuscula = true;
            }
        }

        if(achouNumero == false)
            throw new UserException("A senha deve conter algum caractere numérico");
        else if(achouMaiuscula == false)
            throw new UserException("A senha deve conter algum caractere maiúsculo");
        else if(achouMinuscula == false)
            throw new UserException("A senha deve conter algum caractere minúsculo");
    }
}
