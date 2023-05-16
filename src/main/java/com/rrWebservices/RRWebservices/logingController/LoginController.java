
package com.rrWebservices.RRWebservices.logingController;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rrWebservices.RRWebservices.Dto.ErrorMsg;
import com.rrWebservices.RRWebservices.Dto.LoginRequest;
import com.rrWebservices.RRWebservices.Dto.LoginRequestModel;
import com.rrWebservices.RRWebservices.EntitySfsmdb.MstAccountValidate;
import com.rrWebservices.RRWebservices.EntitySfsmdb.MstAccounts;
import com.rrWebservices.RRWebservices.EntitySldb.TbTerminalDisplayMaster;
import com.rrWebservices.RRWebservices.RepoDB.MstAccntsValidateRepository;
import com.rrWebservices.RRWebservices.RepoDB.MstAccountsRepository;
import com.rrWebservices.RRWebservices.RepoDB2.DisplayMasterRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("/rr/Webservices")
public class LoginController {

	@Autowired
	private MstAccountsRepository mstAccountsRepository;
	
	@Autowired
	private DisplayMasterRepository displayMasterRepository;
	
	@Autowired
	private MstAccntsValidateRepository mstAccntsValidateRepository;
	

	// This function compares the user's password with the hashed password in the
	// database
	private boolean comparePasswords(String password, String hashedPassword) throws Exception {
		 
		  String message = password;
			final MessageDigest md = MessageDigest.getInstance("md5");
	        final byte[] digestOfPassword = md.digest("HG58YZ3Cyu"
	                        .getBytes("utf-8"));
	        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
	        for (int j = 0, k = 16; j < 8;) {
	                keyBytes[k++] = keyBytes[j++];
	        }

	        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
	        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
	        final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

	        final byte[] plainTextBytes = message.getBytes("utf-8");
	        final byte[] cipherText = cipher.doFinal(plainTextBytes);
	        
	        
	        StringBuffer sb = new StringBuffer(cipherText.length * 2);
	        for (int i = 0; i < cipherText.length; i++){
	          int v = cipherText[i] & 0xff;
	          if (v < 16) {
	            sb.append('0');
	          }
	          sb.append(Integer.toHexString(v));
	        }
	       String pwd =  sb.toString().toUpperCase();
			  //System.out.println("----" + );
			  return pwd.equals(hashedPassword);
	        
	}

	// This is your login endpoint
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginRequest request, HttpServletRequest rqst) throws Exception {
		String username = request.getUsername();
		String password = request.getPassword();
		LoginRequestModel loginRequestModel = new LoginRequestModel();
	


		// Decode the payload section
//		String[] chunks = token.split("\\.");
//		Algorithm algo = Algorithm.HMAC256(secret);
//
//		// Create a JWT verifier by requiring the algorithm and issuer claim
//		JWTVerifier verifier = JWT.require(algorithm)
//		    .withIssuer("myself")
//		    .build();
//
//		// Parse and verify the token
//		DecodedJWT jwt = verifier.verify(token);
//
//		// Get the username and IP address or any other claim
//		String user1 = jwt.getClaim("username").asString();
//		String ip = jwt.getClaim("ip").asString();
//		System.out.println("username " + user1);
//		System.out.println("ip " + ip);
		
		
		MstAccounts mstaccounts = new MstAccounts();
		try {
			mstaccounts = mstAccountsRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
		}
		
		MstAccountValidate mstAccountValidate = new MstAccountValidate();
		try {
			mstAccountValidate = mstAccntsValidateRepository.findById(mstaccounts.getAccntId()).orElse(null);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
		}
		
		System.out.println("mstaccount validate " + mstAccountValidate);
		
		ErrorMsg errorMsg = new ErrorMsg();
		
		Date currentDate = new Date();
        long diffInMilliseconds = (mstAccountValidate.getLoginDt()).getTime() - currentDate.getTime();
        long daysBetween = TimeUnit.MILLISECONDS.toDays(diffInMilliseconds);

		System.out.println("Days between: " + daysBetween);
		
    		if(daysBetween<=90) {
    	        
    			if (!comparePasswords(password, mstaccounts.getPassword())) {
    				loginRequestModel.setError(true);	
    				String msg = "Wrong Password";
    				errorMsg.setMsg(msg);
    			 return new ResponseEntity<>(
    					 errorMsg, 
    				          HttpStatus.BAD_REQUEST);
    			}
    			else
    			{
    		        String ipAdd = rqst.getHeader("X-Forwarded-For");
    		        String[] ipAddresses = ipAdd.split(",");
    		        String ipAddress = ipAddresses[0].trim();
    		        
    				
    				TbTerminalDisplayMaster displayMaster = new TbTerminalDisplayMaster();
    				try {
    				displayMaster = displayMasterRepository.findByterminalLineId("ndls9");
    				}catch (EntityNotFoundException e) { 
    					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
    				}
    		       System.out.println("ipadress " + ipAddress);
    		       System.out.println("ipadress db " + displayMaster.getTerminalIp());
    		       System.out.println("true?" + displayMaster.getTerminalIp());
    		       

    				String secret = "RETIRINGROOM";
    				// Create an HMAC algorithm instance with the secret key
    				Algorithm algorithm = Algorithm.HMAC256(secret);

    				// Create a JWT token by signing the payload with the algorithm
    				String token = JWT.create()
    				    .withIssuer("myself") // set the issuer claim
    				    //.withExpiresAt(new Date(System.currentTimeMillis() + 60 * 1000)) // set the expiration time claim
    				    .withIssuedAt(new Date()) // set the issued at time claim
    				    .withClaim("username", username) // custom claim for username
    				    .withClaim("ip", ipAddress) // custom claim for IP address
    				    .withClaim("role", mstaccounts.getRoleId())
    				    .sign(algorithm); // sign the token with the algorithm
    		       
    				if(mstaccounts.getRoleId()!= 25) {
    					if(ipAddress.equals(displayMaster.getTerminalIp())) {
    	    				loginRequestModel.setUsername(username);
    	    				loginRequestModel.setCreatedOn(mstaccounts.getCreatedOn());
    	    				loginRequestModel.setRoleId(mstaccounts.getRoleId());
    	    				loginRequestModel.setToken(token);
    	    				return new ResponseEntity<LoginRequestModel>(loginRequestModel, HttpStatus.OK);
    					}else {
    						String msg ="You are Not Authorized to Login from this Location";
    						errorMsg.setMsg(msg);
    						return new ResponseEntity<>(
    	    				          errorMsg, 
    	    				          HttpStatus.BAD_REQUEST);
    					}
    				}else {
	    				loginRequestModel.setUsername(username);
	    				loginRequestModel.setCreatedOn(mstaccounts.getCreatedOn());
	    				loginRequestModel.setRoleId(mstaccounts.getRoleId());
	    				loginRequestModel.setToken(token);
	    				return new ResponseEntity<LoginRequestModel>(loginRequestModel, HttpStatus.OK);
    				}
    		        
    			}
            	
    		}else {
    			mstAccountValidate.setAccntStatus("N");
    			mstAccntsValidateRepository.save(mstAccountValidate);
    			String msg =  "Your Password has expired, contact administrator";
    			errorMsg.setMsg(msg);
    			 return new ResponseEntity<>(
    					 errorMsg, 
    			          HttpStatus.BAD_REQUEST);
    		}


	}
}