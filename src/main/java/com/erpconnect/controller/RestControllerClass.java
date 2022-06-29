package com.erpconnect.controller;

import com.erpconnect.model.*;
import com.erpconnect.repository.AccountRepository;
import com.erpconnect.repository.CustomerRepository;
import com.erpconnect.rsa.RsaUtils;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/customer/v1")
public class RestControllerClass {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/hello")
    public String Hello() {
        return "Hello world";
    }

    @GetMapping("/generatekeypair")
    public String printKeyPair() throws Exception {
        KeyPair keyPair = RsaUtils.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("C:/Users/BangMSI/Desktop/"
                    + "rsaPublicKey"));
            dos.write(publicKey.getEncoded());
            dos.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        try {
            dos = new DataOutputStream(new FileOutputStream("C:/Users/BangMSI/Desktop/"
                    + "rsaPrivateKey"));
            dos.write(privateKey.getEncoded());
            dos.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (dos != null)
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        return "Key generated";
    }

    @GetMapping("/getkey")
    public String GetKeyPair() throws Exception{
        PublicKey publicKey = RsaUtils.getPublicKey("C:/Users/BangMSI/Desktop/rsaPublicKey");
        //PrivateKey privateKey = RsaUtils.getPrivateKey("C:/Users/BangMSI/Desktop/rsaPrivateKey");

        //return RsaUtils.convertPrivateKeyToString(privateKey);
        return RsaUtils.convertPublicKeyToString(publicKey);
    }

    @GetMapping("/encrypt")
    public String EncryptString() throws Exception{
        String string = "Password1";
        PublicKey publicKey = RsaUtils.getPublicKey("C:/Users/BangMSI/Desktop/rsaPublicKey");

        String cypherText = RsaUtils.encrypt(string, publicKey);
        return cypherText;
    }

    //LM+WJcaoOdFsnD/jGJK8cas92XSIEBrYHIyi6TnzUR7xRVnlcNYMIeDBMKaUAEbMnMY5Yz4t1Bybs6i3AaBm8I0CD1An5S+eza54/jTYczjqLR0yevEK+e/283NXHgZKUoFHBh7OV34CTYaUF2yNhYVjmbP5Vzi7i5lg9btMPuO3s41NO1UUd/UiENZreFOPOvV/82Yb7euFkXb9bvlY+rDSG98lfezfi/mrUukiC/A5Qvj+yRVrTk/FnLkx6I3yWqOLuOAaoGZ9ZesRfZCidME+34ISd7f6QoDzEgZ7Rg6D1D3p7lFONnrMDY51K4BJawNcwioOKeRKx/n2NtT/Zw==
    //LM+WJcaoOdFsnD/jGJK8cas92XSIEBrYHIyi6TnzUR7xRVnlcNYMIeDBMKaUAEbMnMY5Yz4t1Bybs6i3AaBm8I0CD1An5S+eza54/jTYczjqLR0yevEK+e/283NXHgZKUoFHBh7OV34CTYaUF2yNhYVjmbP5Vzi7i5lg9btMPuO3s41NO1UUd/UiENZreFOPOvV/82Yb7euFkXb9bvlY+rDSG98lfezfi/mrUukiC/A5Qvj+yRVrTk/FnLkx6I3yWqOLuOAaoGZ9ZesRfZCidME+34ISd7f6QoDzEgZ7Rg6D1D3p7lFONnrMDY51K4BJawNcwioOKeRKx/n2NtT/Zw==

    @PostMapping("/decrypt")
    public String DecryptString(@RequestBody Objects cypherText) throws Exception{
        String cypherText1 = "LM+WJcaoOdFsnD/jGJK8cas92XSIEBrYHIyi6TnzUR7xRVnlcNYMIeDBMKaUAEbMnMY5Yz4t1Bybs6i3AaBm8I0CD1An5S+eza54/jTYczjqLR0yevEK+e/283NXHgZKUoFHBh7OV34CTYaUF2yNhYVjmbP5Vzi7i5lg9btMPuO3s41NO1UUd/UiENZreFOPOvV/82Yb7euFkXb9bvlY+rDSG98lfezfi/mrUukiC/A5Qvj+yRVrTk/FnLkx6I3yWqOLuOAaoGZ9ZesRfZCidME+34ISd7f6QoDzEgZ7Rg6D1D3p7lFONnrMDY51K4BJawNcwioOKeRKx/n2NtT/Zw==";
        //cypherText = URLDecoder.decode(cypherText, "UTF-8");

        //PrivateKey privateKey = RsaUtils.getPrivateKey("C:/Users/BangMSI/Desktop/rsaPrivateKey");
        //String decryptedText = RsaUtils.decrypt(cypherText, privateKey);
        //return decryptedText;
//        if(cypherText.equals(cypherText1)){
//            return "True";
//        } else {
//            return "False";
//        }
        return cypherText.toString();
    }

    @PostMapping("/customer-onboard")
    public String CustomerOnBoard (@RequestBody CustomerRequestModel customerRequestModel) throws Exception {

        //Generate KeyPair for each Customer
        KeyPair keyPair = RsaUtils.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        //After got those keys, we must transform them from binary to String
        String str_pub_key = RsaUtils.convertPublicKeyToString(publicKey);
        String str_private_key = RsaUtils.convertPrivateKeyToString(privateKey);

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCustomer_id(customerRequestModel.getCustomer_id());

        //Generate first random password
        RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder()
                .selectFrom("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray())
                .build();
        String randomPw = pwdGenerator.generate(15);
        customerEntity.setPassword(bCryptPasswordEncoder.encode(randomPw));
        customerEntity.setFirst_password(randomPw);

        customerEntity.setCustomer_name(customerRequestModel.getCustomer_name());
        customerEntity.setCustomer_phone(customerRequestModel.getCustomer_phone());
        customerEntity.setCustomer_address(customerRequestModel.getCustomer_address());

        //Add String - Keypair
        customerEntity.setErpconnect_public_key(str_pub_key);
        customerEntity.setErpconnect_private_key(str_private_key);

        //Customer add their public key themselves
        customerEntity.setCustomer_public_key("");
        customerEntity.setVerified(0);

        customerEntity.setContact_email(customerRequestModel.getContact_email());
        customerEntity.setContact_phone(customerRequestModel.getContact_phone());
        customerEntity.setDocument_path(customerRequestModel.getDocument_path());

        customerRepository.save(customerEntity);

        return "New customer-onboard record has been created successfully.";
    }


    @PostMapping("/customer-register")
    public String CustomerRegister (@RequestBody CustomerRequestModel customerRequestModel) throws Exception {

        Optional<CustomerEntity> customer = customerRepository.findById(customerRequestModel.getCustomer_id());
        CustomerEntity customerEntity = customer.get();

        customerEntity.setCustomer_id(customerRequestModel.getCustomer_id());

        //Password must be Encrypted
        customerEntity.setPassword(bCryptPasswordEncoder.encode(customerRequestModel.getPassword()));
        customerEntity.setFirst_password("Used");

        customerEntity.setCustomer_name(customerRequestModel.getCustomer_name());
        customerEntity.setCustomer_phone(customerRequestModel.getCustomer_phone());
        customerEntity.setCustomer_address(customerRequestModel.getCustomer_address());


        //Customer add their public key themselves
        customerEntity.setCustomer_public_key(customerRequestModel.getCustomer_public_key());
        customerEntity.setVerified(0);

        customerRepository.save(customerEntity);

        return "Customer registration was successful.";
    }

    @PostMapping("/customer-verify")
    public String CustomerVerify(@RequestBody CustomerVerifyRequestModel customerVerifyRequestModel){

        Optional<CustomerEntity> customer = customerRepository.findById(customerVerifyRequestModel.getCustomer_id());
        CustomerEntity customerEntity = customer.get();

        customerEntity.setVerified(1);

        customerRepository.save(customerEntity);
        return "Customer with ID: " + customerVerifyRequestModel.getCustomer_id() + " has been verified!";
    }

    @PostMapping("/add-account")
    public String AddAccount(@RequestBody AddAccountRequestModel addAccountRequestModel){
        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setAccount_id(addAccountRequestModel.getAccount_id());
        accountEntity.setCustomer_id(addAccountRequestModel.getCustomer_id());
        accountEntity.setBank_id(addAccountRequestModel.getBank_id());

        accountRepository.save(accountEntity);

        return "Account: " + addAccountRequestModel.getAccount_id() + " related to Customer: " + addAccountRequestModel.getCustomer_id() + " has been added successfully.";
    }

    @PostMapping("/remove-account")
    public String RemoveAccount(@RequestBody AddAccountRequestModel addAccountRequestModel){

        Optional<AccountEntity> account = accountRepository.findById(addAccountRequestModel.getAccount_id());

        AccountEntity accountEntity = account.get();

        accountRepository.delete(accountEntity);

        return "Account: " + addAccountRequestModel.getAccount_id() + " related to Customer: " + addAccountRequestModel.getCustomer_id() + " has been deleted.";
    }

    @PostMapping("/account-by-customer")
    public List<AccountEntity> AccountByCustomer(@RequestBody CustomerEntity customerEntity){

        List<AccountEntity> accountEntityList = accountRepository.findAllAccountByCustomerId(customerEntity.getCustomer_id());

        return accountEntityList;
    }

}
