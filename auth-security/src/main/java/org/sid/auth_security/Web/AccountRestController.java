package org.sid.auth_security.Web;

import lombok.Data;
import org.sid.auth_security.Entity.AppRole;
import org.sid.auth_security.Entity.AppUser;
import org.sid.auth_security.Service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }
@GetMapping("/users")
    public List<AppUser> appUsers(){
    return accountService.listUsers();
    }
    @PostMapping
   public AppUser saveUser(@RequestBody AppUser appUser ){
        return accountService.addNewUser(appUser);
    }
    @PostMapping("/roles")
    public AppRole saveRole(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }
    @PostMapping("/addRoleToUser")
    public void addRoleToUser(@RequestBody  RoleUserForm roleUserForm){
         accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRoleName());
    }
}
@Data
class RoleUserForm {
    private String username;
    private String roleName;
}