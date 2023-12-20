import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class Praktikum {
    public static void main(String[] args) {
        String password = "!AlojA.*Klopafvk5l0"; //пароль пользователя
        System.out.println(password);
        String[] passwordArr = password.split(""); //массив из пароля пользователя
        System.out.println("Массив из пароля");
        System.out.println(Arrays.toString(passwordArr));
        String passwordSpecialSymbol = ""; //переменная из специальных символов
        for(int i = 33; i < 48; i++){
            passwordSpecialSymbol += "" + (char)i;
        }
        for(int i = 58; i < 65; i++){
            passwordSpecialSymbol += "" + (char)i;
        }
        for(int i = 91; i < 97; i++){
            passwordSpecialSymbol += "" + (char)i;
        }
        for(int i = 123; i < 128; i++){
            passwordSpecialSymbol += "" + (char)i;
        }
        System.out.println("Массив из спецсимволов");
        String[] specialSymbolsArray = passwordSpecialSymbol.split(""); //массив из специальных символов
        System.out.println(Arrays.toString(specialSymbolsArray));
        String passwordUpperCaseLetter = ""; //переменная с верхним регистров
        for(int i = 65; i < 91; i++){
            passwordUpperCaseLetter += "" + (char)i;
        }
        String passwordLowerCaseLetter = "";
        for(int i = 97; i < 123; i++){
            passwordLowerCaseLetter += "" + (char)i;
        }
        System.out.println("Массив верхнего регистра");
        String[] upperCaseArray = passwordUpperCaseLetter.split(""); // массив из символов верхнего регистра
        System.out.println(Arrays.toString(upperCaseArray));
        System.out.println("Массив нижнего регистра");
        String[] lowerCaseArray = passwordLowerCaseLetter.split(""); // массив из символов нижнего регистра
        System.out.println(Arrays.toString(lowerCaseArray));
        boolean verifiedAccept = true;
        if (password.length() < 12) {
            System.out.println("Пароль менее 12 символов");
            verifiedAccept = false;
        }else{
            System.out.println("Пароль соответствует требованиям длины, 12 и более символов.");
        }
        int count = 0;
        while(count != 1) {
            for (int i = 0; i < passwordArr.length; i++) {
                for (int j = 0; j < specialSymbolsArray.length; j++) {
                    if (Objects.equals(passwordArr[i], specialSymbolsArray[j]) && count!=1) {
                        verifiedAccept = true;
                        System.out.println("В пароле есть спец символ (" + passwordArr[i] + ") проверка успешно пройдена.");
                        count = 1;
                    }
                }
            }
        }
        while(count != 0){
            for (int i = 0; i < passwordArr.length; i++) {
                for (int j = 0; j < upperCaseArray.length; j++) {
                    if (Objects.equals(passwordArr[i], upperCaseArray[j]) && count!=0) {
                        verifiedAccept = true;
                        System.out.println("В пароле есть символ верхнего регистра (" + passwordArr[i] + ") проверка успешно пройдена.");
                        count = 0;
                    }
                }
            }
        }
        while(count != 1){
            for (int i = 0; i < passwordArr.length; i++) {
                for (int j = 0; j < lowerCaseArray.length; j++) {
                    if (Objects.equals(passwordArr[i], lowerCaseArray[j]) && count!=1) {
                        verifiedAccept = true;
                        System.out.println("В пароле есть символ верхнего регистра (" + passwordArr[i] + ") проверка успешно пройдена.");
                        count = 1;
                    }
                }
            }
        }
        for(int i = 1; i < passwordArr.length; i++){
            if(Objects.equals(passwordArr[i], passwordArr[i - 1])){
                System.out.println("Есть повторяющиеся символы, (" + passwordArr[i] + passwordArr[i-1] + ") - пароль не прошел проверку");
                verifiedAccept = false;
                break;
            }
        }
        if(verifiedAccept == true){
            System.out.println("Повторяющихся символов не найдено, пароль прошел проверку");
        }
        System.out.println();
        String numbersAll = "";
        for(int i = 48; i < 58; i++){
            numbersAll += "" + (char)i;
        }
        String[] numberArray = numbersAll.split(""); // массив 0 - 9
        String testSequencePass = "";
        String sequenceNumbers = "";
        String sequenceUpperLetters = "";
        String sequenceLowerLetters = "";
        String[] array4SequenceFromPass = new String[passwordArr.length-3];
        String[] array4SequenceNumbers = new String[numberArray.length-3];
        String[] array4UpperCase = new String[upperCaseArray.length-3];
        String[] array4LowerCase = new String[lowerCaseArray.length-3];
        for(int i = 0; i < passwordArr.length - 3; i++){
            for(int j = i; j < i+4; j++){
                testSequencePass+=passwordArr[j];
            }
            array4SequenceFromPass[i] = testSequencePass;
            testSequencePass = "";
        }
        System.out.println("Массив из последовательности 4 символа из пароля ");
        System.out.println(Arrays.toString(array4SequenceFromPass));
        for(int i = 0; i < numberArray.length - 3; i++){
            for(int j = i; j < i+4; j++){
                sequenceNumbers+=numberArray[j];
            }
            array4SequenceNumbers[i] = sequenceNumbers;
            sequenceNumbers = "";
        }
        System.out.println("Массив из последовательности 4 символа из цифр ");
        System.out.println(Arrays.toString(array4SequenceNumbers));
        for(int i = 0; i < upperCaseArray.length - 3; i++){
            for(int j = i; j < i+4; j++){
                sequenceUpperLetters+=upperCaseArray[j];
            }
            array4UpperCase[i] = sequenceUpperLetters;
            sequenceUpperLetters = "";
        }
        System.out.println("Массив из последовательности 4 символа из символов верхнего регистра ");
        System.out.println(Arrays.toString(array4UpperCase));
        for(int i = 0; i < lowerCaseArray.length - 3; i++){
            for(int j = i; j < i+4; j++){
                sequenceLowerLetters+=lowerCaseArray[j];
            }
            array4LowerCase[i] = sequenceLowerLetters;
            sequenceLowerLetters = "";
        }
        System.out.println("Массив из последовательности 4 символа из символов нижнего регистра ");
        System.out.println(Arrays.toString(array4LowerCase));
        System.out.println();
        int detectedSequence = 0;
        while(detectedSequence != 1){
            for (int i = 0; i < array4SequenceFromPass.length; i++) {
                for (int j = 0; j < array4SequenceNumbers.length; j++) {
                    if (Objects.equals(array4SequenceFromPass[i], array4SequenceNumbers[j]) && detectedSequence!=1) {
                        verifiedAccept = false;
                        detectedSequence = 1;
                        System.out.println("В пароле есть последовательность цифр " + array4SequenceFromPass[i] + " пароль не прошел проверку");
                    }
                }
                for (int j = 0; j < array4UpperCase.length; j++) {
                    if (Objects.equals(array4SequenceFromPass[i], array4UpperCase[j]) && detectedSequence!=1) {
                        verifiedAccept = false;
                        detectedSequence = 1;
                        System.out.println("В пароле есть последовательность символов верхнего регистра " + array4SequenceFromPass[i] + " пароль не прошел проверку");
                    }
                }
                for (int j = 0; j < array4LowerCase.length; j++) {
                    if (Objects.equals(array4SequenceFromPass[i], array4LowerCase[j]) && detectedSequence!=1) {
                        verifiedAccept = false;
                        detectedSequence = 1;
                        System.out.println("В пароле есть последовательность символов нижнего регистра " + array4SequenceFromPass[i] + " пароль не прошел проверку");
                    }
                }
            }
            if(detectedSequence == 0){
                detectedSequence = 1;
                System.out.println("Последовательности не обнаружены, пароль прошел проверку");
            }
        }
    }
}
/*
минимум 12 символов
Один спец символ (33 -> 47 (15) || 58 -> 64 (7) || 91 -> 96 (6)|| 123 -> 127 (5)) (33 штуки)
минимум 1 строчная и 1 заглавная (65 - > 90 (26) )(97 - > 122 (26) )
не должен содержать повторов АА 11 ББ abcd 1234 (цифры 48 -> 57)
не должен содержать словарных слов
не должно быть простых паролей Апрель2023! и тд
не должен содержать имена телефоны даты города
 */

