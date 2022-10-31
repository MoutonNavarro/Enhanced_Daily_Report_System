package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * configure data's DTO model
 */
@Table(name = JpaConst.TABLE_CONF)
@Getter //Automatically create getter about all class fields(Lombok)
@Setter //Automatically create setter about all class fields(Lombok)
@NoArgsConstructor //Automatically create no arguments constructor
@AllArgsConstructor //Automatically create constructor with arguments that has all class fields as arguments
@Entity
public class Configure {
   /**
    * ID (Employee ID)
    */
   @Id
   @Column(name = JpaConst.CONF_COL_ID)
// @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   /**
    * Date Created
    */
   @Column(name = JpaConst.CONF_COL_CREATED_AT, nullable = false)
   private LocalDateTime createdAt;
   /**
    * Date Updated
    */
   @Column(name = JpaConst.CONF_COL_UPDATED_AT, nullable = false)
   private LocalDateTime updatedAt;
   //visual setting
   /**
    * Language
    */
   @Column(name = JpaConst.CONF_COL_LANG, length = 3, nullable = false)
   private String language;

   /**
    * Language of country
    */
   @Column(name = JpaConst.CONF_COL_LANG_COUNTRY, length = 3, nullable = false)
   private String lang_country;

   /**
    * Time zone
    */
   @Column(name = JpaConst.CONF_COL_TIMEZONE, length = 64, nullable = false)
   private String time_zone;

   /**
    * Time zone of area
    */
   @Column(name = JpaConst.CONF_COL_TIMEZONE_AREA, length = 64, nullable = false)
   private String time_area;

   /**
    * Whether is the spring time
    */
   @Column(name = JpaConst.CONF_COL_IS_SPRING_TIME, nullable = false)
   private byte time_is_spring_time;

   /**
    * The color theme
    */
   @Column(name = JpaConst.CONF_COL_COLOR_THEME, length = 16, nullable = false)
   private String color_theme;

   /**
    * Whether is disabled JavaScript
    */
   @Column(name = JpaConst.CONF_COL_DISABLE_JS, nullable = false)
   private boolean disable_js;
   @SuppressWarnings("unused")
   private boolean isDisable_js(){throw new Error("Private method is executed");}
   public boolean getDisable_js() {return disable_js;}

   /**
    * Reserved
    */
   @Column(name = JpaConst.CONF_COL_DISABLE_FLASH, nullable = false)
   private Boolean disable_flash;

   //account setting
   /**
    * color
    */
   @Column(name = JpaConst.CONF_COL_USER_COLOR, length = 32, nullable = false)
   private String user_color;

   /**
    * background-color
    */
   @Column(name = JpaConst.CONF_COL_USER_BG, length = 32, nullable = false)
   private String user_background;

   /**
    * Reserved
    */
   @Column(name = JpaConst.CONF_COL_IS_USER_COLOR_SPECIAL, nullable = false)
   private Boolean user_color_special;

}
