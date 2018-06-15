package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.VaultResponseSupport;

public class MyApp {

   @Autowired
   VaultOperations vaultOperations;

   public void useVault() {

      Secrets secrets = new Secrets();
      secrets.username = "hello";
      secrets.password = "world";

      vaultOperations.write("secret/myapp", secrets);

      VaultResponseSupport<Secrets> response = vaultOperations.read("secret/myapp", Secrets.class);
      System.out.println(response.getData().getUsername());

      vaultOperations.delete("secret/myapp");
   }
}