package project1Duotify;

public class RandomPassword {

    static String randomPassword = "";
    static char[] specialCharacters = {'$', '@', '!', '?'};

    public static String generatePassword() {
        randomPassword = "";

        for (int i = 0; i < 8; i++) {
            int num = (10 + (int) (Math.random() * 9000));
            char ch1 = ((char) ('A' + (int) (Math.random() * 26)));
            char ch2 = ((char) ('a' + (int) (Math.random() * 26)));
           // char ch3 = specialCharacters[(int) (Math.random() * specialCharacters.length)];
            randomPassword = "" + num +"" + ch1 + ch2 ;
        }

        System.out.println(randomPassword);

        return randomPassword;
    }
}
