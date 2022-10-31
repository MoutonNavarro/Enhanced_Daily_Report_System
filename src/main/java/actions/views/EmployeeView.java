package actions.views;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * View model that handles input value at the screen and output value about employee information
 */
@Getter //Automatically create getter about all class field (Lombok)
@Setter //Automatically create setter about all class field (Lombok)
@NoArgsConstructor //Automatically create no arguments constructor (Lonbok)
@AllArgsConstructor //Automatically create constructor with arguments that has all class field as argument
public class EmployeeView {

   /**
    * id
    */
   private Integer id;

   /**
    * Employee code
    */
   private String code;

   /**
    * Name
    */
   private String name;

   /**
    * Password
    */
   private String password;

   /**
    * Whether has administrator privileges (general: 0, administrator: 1)
    */
   private Integer adminFlag;

   /**
    * Date registered
    */
   private LocalDateTime createdAt;

   /**
    * Date updated
    */
   private LocalDateTime updatedAt;

   /**
    * Whether has been deleted (active: 0, deleted: 1)
    */
   private Integer deleteFlag;
}
