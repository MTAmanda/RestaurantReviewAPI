package portfolio.project.restaurant_review.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name="RESTAURANT")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME")
    private String name;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="CITY")
    private String city;
    @Column(name="STATE")
    private String state;
    @Column(name="zipcode")
    private String zipcode;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<DiningReview> reviews;

}

