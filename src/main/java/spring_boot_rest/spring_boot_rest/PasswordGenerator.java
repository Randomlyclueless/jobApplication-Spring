package spring_boot_rest.spring_boot_rest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


    public class PasswordGenerator {

        public static void main(String[] args) {

            BCryptPasswordEncoder encoder =
                    new BCryptPasswordEncoder(12);

            String password = encoder.encode("1234");

            System.out.println(password);
        }
    }

