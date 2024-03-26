//package com.Project.HotelBooking.Entity;
//
//import lombok.*;
//import org.springframework.context.annotation.Role;
//
//import javax.persistence.*;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    private String email;
//
//    private String mobileNumber;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Bookings> bookings;
//
////    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
////    @JoinTable(name = "user_roles",
////            joinColumns = @JoinColumn(name = "user_id", referencedColumnName
////                    = "id"),
////            inverseJoinColumns = @JoinColumn(name = "role_id",
////                    referencedColumnName = "id"))
//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private Set<Role> roles;
//
//
//
//
//
//
//
//}
package com.Project.HotelBooking.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    private String mobileNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Bookings> bookings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Role> roles;  // Correctly referencing your own Role entity
}
