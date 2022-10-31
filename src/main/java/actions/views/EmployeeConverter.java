package actions.views;

import java.util.ArrayList;
import java.util.List;

import constants.AttributeConst;
import constants.JpaConst;
import models.Employee;

/**
 * Class that mutual converts the employee data's DTO model and View model
 */
public class EmployeeConverter {
   /**
    * Create DTO model's instance from View model's instance
    * @param ev EmployeeView's instance
    * @return Employee's instance
    */
   public static Employee toModel(EmployeeView ev) {
      return new Employee(ev.getId(), ev.getCode(), ev.getName(),
            ev.getPassword(),
            ev.getAdminFlag() == null ? null
                  : ev.getAdminFlag() == AttributeConst.ROLE_ADMIN.getIntegerValue()
                        ? JpaConst.ROLE_ADMIN : JpaConst.ROLE_GENERAL,
            ev.getCreatedAt(), ev.getUpdatedAt(), ev.getDeleteFlag() == null ? null
                  : ev.getDeleteFlag() == AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
                        ? JpaConst.EMP_DEL_TRUE : JpaConst.EMP_DEL_FALSE);
   }

   /**
    * Create View model's instance from DTO model's instance
    * @param e Employee's instance
    * @return EmployeeView's instance
    */
   public static EmployeeView toView(Employee e) {

      if (e== null) {
         return null;
      }

      return new EmployeeView(
         e.getId(), e.getCode(), e.getName(), e.getPassword(),
         e.getAdminFlag() == null ? null : e.getAdminFlag() == JpaConst.ROLE_ADMIN
               ? AttributeConst.ROLE_ADMIN.getIntegerValue()
               : AttributeConst.ROLE_GENERAL.getIntegerValue(),
         e.getCreatedAt(), e.getUpdatedAt(),
         e.getDeleteFlag() == null ? null : e.getDeleteFlag() == JpaConst.EMP_DEL_TRUE
               ? AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
               : AttributeConst.DEL_FLAG_FALSE.getIntegerValue());
   }

   /**
    * Create View model's list from DTO model's list
    * @param list DTO model's list
    * @return View model's list
    */
   public static List<EmployeeView> toViewList(List<Employee> list){
      List<EmployeeView> evs = new ArrayList<>();

      for (Employee e : list) {
         evs.add(toView(e));
      }
      return evs;
   }

   /**
    * Copy all field's content of View model to DTO model's field
    * @param e DTO model (copy to)
    * @param ev View model (copy from)
    */
   public static void copyViewToModel(Employee e, EmployeeView ev) {
      e.setId(ev.getId()); e.setCode(ev.getCode());   e.setName(ev.getName());
      e.setPassword(ev.getPassword());       e.setAdminFlag(ev.getAdminFlag());
      e.setCreatedAt(ev.getCreatedAt());     e.setUpdatedAt(ev.getUpdatedAt());
      e.setDeleteFlag(ev.getDeleteFlag());

   }
}
