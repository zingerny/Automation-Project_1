package project2WebOrder;
import com.github.javafaker.Faker;

public class RandomGenerator {

public static String generateFakeFirstName(){

            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            return firstName;

        }

        public static String generateFakeFullName(){
    Faker faker = new Faker();
    String fullName = faker.name().fullName();

            return fullName;

        }

        public static String generateFakeStreet(){
    Faker fakeStr= new Faker();
 String fakeStreetName =  fakeStr.address().streetName();
 String address= fakeStr.address().buildingNumber()+ " "+fakeStr.address().streetName();
    return address;
        }

        public static String generateFakeCity(){
    Faker fakeCity = new Faker();
    String city = fakeCity.address().city();
    return city;
        }

        public static String generateFakeZipCode(){
    Faker fakeZip = new Faker();
    String zipCode = fakeZip.address().zipCode();
   zipCode= zipCode.substring(0,5);
    return zipCode;
        }

        public static String generateFakeState(){
    Faker fakeState = new Faker();
    String state = fakeState.address().state();
    return state;
        }

public static String generateCreditCard(){
    Faker fakeCardNum = new Faker();
    String creditCardNum = fakeCardNum.business().creditCardNumber();
creditCardNum = creditCardNum.replace("-", "");
    return creditCardNum;

}


public static String generateExpDate(){
    Faker fakeExp = new Faker();
  String expDate =   fakeExp.business().creditCardExpiry();
  return  expDate;

}

    }
