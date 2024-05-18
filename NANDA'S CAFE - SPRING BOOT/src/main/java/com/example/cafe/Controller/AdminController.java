package com.example.cafe.Controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cafe.Entity.Admin;
import com.example.cafe.Service.AdminService;


@RestController
@RequestMapping("/api/admins")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.findAll();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") int id) {
        Optional<Admin> admin = adminService.findById(id);
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body("Admin registered successfully");
    }

    @PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Admin adminData)
	{
		Admin admin = adminService.findByUsername(adminData.getAdminName());

		if (admin.getAdminPassword().equals(adminData.getAdminPassword())) {
			Admin sendadmin = new Admin();
			sendadmin.setAdminId(admin.getAdminId());
			sendadmin.setAdminName(admin.getAdminName());
			sendadmin.setAdminContact(admin.getAdminContact());
			sendadmin.setAdminName(admin.getAdminName());		
			return ResponseEntity.ok(sendadmin);
		} else {
	
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}

    @PutMapping("/update")
    public ResponseEntity<String> updateAdmin(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
        return ResponseEntity.ok("Admin updated successfully");
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteAdminById(@PathVariable("id") int id) {
//        adminService.deleteById(id);
//        return ResponseEntity.ok("Admin deleted successfully");
//    }
}
