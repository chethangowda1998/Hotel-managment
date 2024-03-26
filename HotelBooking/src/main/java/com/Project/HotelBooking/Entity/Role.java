//package com.Project.HotelBooking.Entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Data
//@Table(name = "roles")
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "name")
//    private String Name;
//@ManyToOne
//    @JoinColumn(referencedColumnName = "id")
//    private  User user;
//
//
//}
package com.Project.HotelBooking.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String Name;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")  // Correctly referencing the User entity's primary key
    private User user;
}
