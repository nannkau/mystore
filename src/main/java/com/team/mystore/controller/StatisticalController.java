package com.team.mystore.controller;

import com.team.mystore.dto.ThongKeNhanVien;
import com.team.mystore.entity.Employee;
import com.team.mystore.entity.Invoice;
import com.team.mystore.service.EmployeeService;
import com.team.mystore.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller

public class StatisticalController  {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/statistical")
    public String chart(Model model){
        List<Invoice> invoiceList =invoiceService.findAll();
        Map<Integer,List<Invoice>> listInvoiceByMonth = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        int tongdt =0;
        for(int i=1;i<=12;i++){
            List<Invoice> temp = new ArrayList<>();
            int dt =0;
            for(Invoice invoice :invoiceList){
                if(invoice.getCreateDate().getMonth()+1 ==i){
                    temp.add(invoice);
                    dt += invoice.getPriceTotal();
                }
            }
            arr.add(dt);
            tongdt +=dt;
            listInvoiceByMonth.put(i,temp);
        }
        model.addAttribute("tdt",tongdt);
        model.addAttribute("dt",arr);
        model.addAttribute("listInvoiceByMonth",listInvoiceByMonth);
        return "Chart/doanhthu";
    }
    @RequestMapping(value = "/statistical/detail/month/{month}")
    public String detail(Model model, @PathVariable int month){
        List<Invoice> invoiceList =invoiceService.findAll();
        List<Invoice> result = new ArrayList<>();
        int dt = 0;
        for(Invoice invoice :invoiceList){
            if(invoice.getCreateDate().getMonth()+1 ==month){
                result.add(invoice);
                dt += invoice.getPriceTotal();
            }
        }
        model.addAttribute("listInvoiceByMonth",result);
        model.addAttribute("dt",dt);
        model.addAttribute("month",month);

        return "Chart/detail";
    }
    @RequestMapping(value = "/statistical/employee")
    public String thongkenhanvien(Model model, HttpServletRequest request){
        String month = request.getParameter("month");
        Date date= new Date();
        int m=0;
        if(month ==null ){
             m =date.getMonth()+1;
        }else{
            m=Integer.valueOf(month);
        }

        List<Employee> employees = employeeService.findAll();
        List<Integer> doanhthu = new ArrayList<>();
        for (Employee e:employees) {
            int temp =0;
            List<Invoice> invoices = new ArrayList<>();
            for(Invoice invoice:e.getInvoices()){
                if(m==-1){
                    temp +=invoice.getPriceTotal();
                    invoices.add(invoice);
                }else{
                    if((invoice.getCreateDate().getMonth() +1) == m){
                        temp +=invoice.getPriceTotal();
                        invoices.add(invoice);
                    }
                }

            }
            e.setInvoices(invoices);
            doanhthu.add(temp);
        }
        List<Integer> thangs = new ArrayList<>();
        for(int i=1;i<=new Date().getMonth()+1;i++){
            thangs.add(i);
        }
        ThongKeNhanVien thongKeNhanVien =new ThongKeNhanVien();
        thongKeNhanVien.setEmployees(employees);
        thongKeNhanVien.setMonth(m);
        model.addAttribute("thongkenhanvien",thongKeNhanVien);
        model.addAttribute("thangs",thangs);
        model.addAttribute("dt",doanhthu);
        return "Chart/doanhthutheonhanvien";
    }
    @RequestMapping(value = "/statistical/employee/detail")
    public String  detailEmployee(Model model, HttpServletRequest request){
        String idEm= request.getParameter("id");
        String month= request.getParameter("m");
        Employee employee =employeeService.finEmployeeById(Integer.valueOf(idEm));
        if(Integer.valueOf(month) >=1 && Integer.valueOf(month) <=12 ) {
            List<Invoice> invoiceList =new ArrayList<>();
            for(Invoice invoice :employee.getInvoices()) {
                if(invoice.getCreateDate().getMonth()+1 == Integer.valueOf(month)){
                    invoiceList.add(invoice);
                }
            }
            employee.setInvoices(invoiceList);
            model.addAttribute("em",employee);

        }else{
            model.addAttribute("em",employee);
        }
        int tt =0;
        for(Invoice invoice :employee.getInvoices()){
            tt +=invoice.getPriceTotal();
        }
        model.addAttribute("tt",tt);
        String mo="";
        if(Integer.valueOf( month )==-1){
            mo = "năm nay:";
        }else{
            mo="tháng "+month;
        }
        model.addAttribute("month",mo);




        return "Chart/detailEmployee";
    }


}
