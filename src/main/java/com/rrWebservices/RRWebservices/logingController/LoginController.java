package com.rrWebservices.RRWebservices.logingController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.persistence.EntityNotFoundException;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrWebservices.RRWebservices.Dto.LoginRequest;
import com.rrWebservices.RRWebservices.Dto.LoginRequestModel;
import com.rrWebservices.RRWebservices.Entity.User;
import com.rrWebservices.RRWebservices.Repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("/rr/loginservices/")
public class LoginController {

	@Autowired
	private UserRepository userRepository;
	
	
	 @GetMapping("/hellow")
     public String msg(){
	  	return  "hi web service";
	  }
	

	// @Value("${jwt.secret}")
	String jwtSecret = "snehil";

	// This function generates a new JWT token
	private String generateToken(String username) {
		return Jwts.builder().setSubject(username).signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
	}

	// This function compares the user's password with the hashed password in the
	// database
	private boolean comparePasswords(String password, String hashedPassword) throws Exception {
	
		  String hashedInput = DigestUtils.md5Hex(password); 
		  //System.out.println("----" + );
		  return hashedInput.equals(hashedPassword);
		 

		/*
		 * final MessageDigest md = MessageDigest.getInstance("md5"); final byte[]
		 * digestOfPassword = md.digest("HG58YZ3Cyu" .getBytes("utf-8")); final byte[]
		 * keyBytes = Arrays.copyOf(digestOfPassword, 24); for (int j = 0, k = 16; j <
		 * 8;) { keyBytes[k++] = keyBytes[j++]; }
		 * 
		 * final SecretKey key = new SecretKeySpec(keyBytes, "DESede"); final
		 * IvParameterSpec iv = new IvParameterSpec(new byte[8]); final Cipher decipher
		 * = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		 * decipher.init(Cipher.DECRYPT_MODE, key, iv);
		 * 
		 * // final byte[] encData = new //
		 * sun.misc.BASE64Decoder().decodeBuffer(message); // byte [] pwd =
		 * password.getBytes(); final byte[] encData = new
		 * sun.misc.BASE64Decoder().decodeBuffer(password); final byte[] plainText =
		 * decipher.doFinal(encData); String s = new String(plainText, "UTF-8");
		 * 
		 * byte[] b = new byte[s.length() / 2]; for (int i = 0; i < b.length; i++){ int
		 * index = i * 2; int v = Integer.parseInt(s.substring(index, index + 2), 16);
		 * b[i] = (byte)v; }
		 * 
		 * return b.equals(hashedPassword);
		 */
	}

	// This is your login endpoint
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginRequest request) throws Exception {
		String username = request.getUsername();
		String password = request.getPassword();
		LoginRequestModel loginRequestModel = new LoginRequestModel();
		// Find the user in your database based on their username
		User user = new User();
		try {
			user = userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
		}
		
		String createdDate = user.getCreatedOn();
		LocalDate dateFromDB = LocalDate.parse(createdDate);
		LocalDate currentDate = LocalDate.now();
		
		
		long daysBetween = ChronoUnit.DAYS.between(dateFromDB, currentDate);

		System.out.println("Days between: " + daysBetween);

		// Compare the user's password with the hashed password in the database
		
		if(daysBetween<=90) {
			
			if (!comparePasswords(password, user.getPassword())) {
				loginRequestModel.setError(true);	
			 return new ResponseEntity<>(
				          "Wrong Password", 
				          HttpStatus.BAD_REQUEST);
			}
			else
			{
				String token = generateToken(username);
				loginRequestModel.setUsername(username);
				loginRequestModel.setCreatedOn(LocalDateTime.now());
				loginRequestModel.setRoleId(user.getRoleId());
				loginRequestModel.setToken(token);
				
		        return new ResponseEntity<LoginRequestModel>(loginRequestModel, HttpStatus.OK);
			}
		}else {
			 return new ResponseEntity<>(
			          "Your account status is inactive. Please contact administrator", 
			          HttpStatus.BAD_REQUEST);
		}

	}
	
	


}
