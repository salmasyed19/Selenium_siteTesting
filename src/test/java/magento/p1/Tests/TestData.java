package magento.p1.Tests;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "registrationData")
    public static Object[][] registrationData() {
        return new Object[][] {
            // Positive test cases
        	{"syed","salma","mittu@29.example.com","Syedmittu#19","Syedmittu#19",true},
        	{"syed","rathee","mittu2396@example.com","Syedmittu#19","Syedmittu#19",true},
        	{"syed","uriya","mittu@4576example.com","Syedmittu#19","Syedmittu#19",true},
       
            // Negative test cases
            {"Bilal", "Qasim", "bilal", "$%^bilal56", "$%^bilal56", false}, // invalid email
            {"Rania", "Rashid", "rania.rashid@gmail.com", "qwerty", "WRONG", false} // mismatched confirm password
        };
    }

    @DataProvider(name = "signInData")
    public static Object[][] signInData() {
        return new Object[][]{
            // Positive test cases
        	{"mittu21@example.com","Syedmittu#19",true},
        	{"mittu23@example.com","Syedmittu#19",true},
        	{"mittu45@example.com","Syedmittu#19",true},
            {"mittu6@example.com","Syedmittu#19",true},
            // Negative test cases
            {"bilal.qasim@gmail.com", "$%^bilal56", false}, // incorrect password
            {"invalid.email", "password", false} // invalid email format
        };
    }

    @DataProvider(name = "changePasswordData")
    public static Object[][] changePasswordData() {
        return new Object[][]{
            // Positive test cases
 
        	{"mittu21@example.com","Salmasyed#19","Salmasyed#19","Syedmittu#19","Syedmittu#19",true},
        	{"mittu23@example.com","Salmasyed#19","Salmasyed#19","Syedmittu#19","Syedmittu#19",true},//differentuser
        	{"mittu45@example.com","Salmasyed#19","Salmasyed#19","Syedmittu#19","Syedmittu#19",true}

        	 
            // mismatched new password
        };
    }
    @DataProvider(name = "addressData")
    public static Object[][] addressData() {
        return new Object[][]{
            {"salma8@example.com","salmaMittu#19","syed", "salma", "ABC Company", "1234567890", "123 Main St", "Anytown", "Texas", "99501", "United States",true},
            {"mittu@457example.com","Syedmittu#19","syed", "salma", "ABd Company", "1234067890", "123 St", "Anytown", "Texas", "   ", "United States",false},
            {"salma88@example.com","salmaMittu#19","syed", "salma", "ABC Company", "1234567890", "123 Main ", "Anytown", "Alaska", "  ", "United States",false},//zipblank
            {"mittu63@example.com","salmaMittu#19","syed", "salma", "ABC Company", "1234567890", "123 Main", "Anytown", "Alaska", " 4567 ", "United States",true},
            {"salma8@example.com","salmaMittu#19","syed", "salma", "ABC Company", "1234567890", "123 Main St", "Anytown", "Texas", "99501", "United States",true}
            
        };
    }
    
   
        @DataProvider(name = "productData")
        public static Object[][] productData() {
            return new Object[][]{
                {"salma8@example.com", "salmaMittu#19", "Selene Yoga Hoodie", "168", "57"},
                {"salma88@example.com", "salmaMittu#19", "Cassius Sparring Tank", "167", "50"},
                {"mittu63@example.com", "salmaMittu#19", "Zeppelin Yoga Pant", "176", "53"}
            };
        }
}


 