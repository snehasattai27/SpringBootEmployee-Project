package com.gavs.springboot.controller;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.gavs.springboot.model.Employee;
import com.gavs.springboot.model.EmployeeDAO;



@RestController
public class EmployeeService {
    @RequestMapping("/hello")
    public String welcomepage() {
        return ("hello to Spring REST Controller");
    }
    @RequestMapping(value="/findEmployee",method= RequestMethod.GET)
    public Employee homepage(@RequestBody Employee e) {
        EmployeeDAO obj1 = new EmployeeDAO();
        e = obj1.findEmployee(e.getId());
        System.out.println(e.getId()+" "+e.getName()+" "+e.getPosition());
        
        return e;
    }
    
    public int removeEmployee(@RequestBody Employee e) {
        EmployeeDAO obj1 = new EmployeeDAO();
        
        obj1.deleteEmployee(e.getId());
        System.out.println("Deleted");
        return 0;
    }

    @RequestMapping(value="/updateEmployee",method= RequestMethod.PUT)
    public Employee modifyEmployee(@RequestBody Employee e) {
    	
    	EmployeeDAO obj1 = new EmployeeDAO();
    	System.out.println(e.getName()+" "+e.getId());
        e = obj1.updateEmployee(e.getName(),e.getId());
        System.out.println(e.getId()+" "+e.getName());
    	return e;
    } 
}