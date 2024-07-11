package portfolio.project.restaurant_review.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import portfolio.project.restaurant_review.dto.RestaurantDto;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@SuperBuilder
@Table(name="RESTAURANT")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "zipcode")
    private String zipcode;
    @ElementCollection(targetClass = Allergies.class)
    @CollectionTable(name = "RESTAURANT_ALLERGIES", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "allergy")
    @Enumerated(EnumType.STRING)
    private List<Allergies> supportedAllergies;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<DiningReview> reviews;

}

