package idusw.sb.b202312407.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity     // data-jpa
@Getter     // lombok
@Setter     // lombok
public class MemberEntity {
    @Id
    private Long id;

}
