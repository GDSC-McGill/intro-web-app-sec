package gdsc.apisec.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/admin-data")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public String admin() {
        return "this is a admin endpoint";
    }


    @GetMapping("/data")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_MEMBER')")
    public String authenticated() {
        return "this is a authenticated endpoint";
    }
}
