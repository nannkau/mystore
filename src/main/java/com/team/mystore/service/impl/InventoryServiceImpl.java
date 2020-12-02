package com.team.mystore.service.impl;

import com.team.mystore.dto.InventoryDTO;
import com.team.mystore.dto.ListInventory;
import com.team.mystore.dto.inventoryItem;
import com.team.mystore.entity.Employee;
import com.team.mystore.entity.Product;
import com.team.mystore.entity.Recevie;
import com.team.mystore.entity.RecevieDetail;
import com.team.mystore.repository.EmployeeRepository;
import com.team.mystore.repository.InventoryRepository;
import com.team.mystore.repository.ProductRepository;
import com.team.mystore.repository.RecevieRepository;
import com.team.mystore.service.InventoryService;
import com.team.mystore.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private  EmployeeRepository employeeRepository;
    @Autowired

    private  ProductRepository productRepository;
    @Autowired
    private RecevieRepository recevieRepository;
    @Override
    public List<Recevie> findAll() {
        return inventoryRepository.findAllOderByCreatDate();
    }

    @Override
    public List<Recevie> findByDate(ListInventory searchRecevie) {
        if (searchRecevie.getFormDate() != null && searchRecevie.getToDate() == null) {
            return inventoryRepository.findByDate(searchRecevie.getFormDate(), DateUtils.date2String(new Date(), "yyyy-mm-dd"));
        } else {

            if (searchRecevie.getFormDate() != null && searchRecevie.getToDate() != null) {
                List<Recevie> list = inventoryRepository.findByDate(searchRecevie.getFormDate(), searchRecevie.getFormDate());
                return inventoryRepository.findByDate(searchRecevie.getFormDate(), searchRecevie.getToDate());
            }
            return inventoryRepository.findAll();
        }

    }

    @Override
    public Recevie findRecevieById(int id) {
        return inventoryRepository.getOne(id);
    }

    @Override
    public void addRecevie(InventoryDTO inventoryDTOS, Authentication authentication) {
        Employee employee= employeeRepository.findEmployeeByUserName(authentication.getName()).get(0);
        Recevie recevie =new Recevie();
        recevie.setEmployee(employee);
        recevie.setCreatDate(inventoryDTOS.getRecevie().getCreatDate());
        List<RecevieDetail> recevieDetails =new ArrayList<>();
        int totalPrice =0;
        for (inventoryItem inventoryItem: inventoryDTOS.getInventoryItems()) {
            if(inventoryItem.getSoLuong() >0) {
                Product product= productRepository.findById(inventoryItem.getProduct_id()).get();
                product.setAmountTotal(product.getAmountTotal()+inventoryItem.getSoLuong());
                product.setPrice(inventoryItem.getPrice());
                productRepository.save(product);
                RecevieDetail recevieDetail = new RecevieDetail();
                recevieDetail.setAmountTotal(inventoryItem.getSoLuong());
                recevieDetail.setProduct(product);
                recevieDetail.setRecevie(recevie);
                recevieDetail.setPrice(inventoryItem.getPrice());
                totalPrice +=inventoryItem.getPrice()*inventoryItem.getSoLuong();
                recevieDetails.add(recevieDetail);
            }
        }
        recevie.setRecevieDetails(recevieDetails);
        recevie.setPriceTotal(totalPrice);
        recevieRepository.save(recevie);



    }

    @Override
    public void edit(Recevie recevie) {
        Recevie n_Recevie = recevieRepository.getOne(recevie.getReceiveId());
        int tongtien =0;
        for(int i =0 ;i<recevie.getRecevieDetails().size();i++){
            Product product= productRepository.findById(n_Recevie.getRecevieDetails().get(i).getProduct().getProductId()).get();
            product.setAmountTotal(product.getAmountTotal()- n_Recevie.getRecevieDetails().get(i).getAmountTotal()+recevie.getRecevieDetails().get(i).getAmountTotal());
            productRepository.save(product);
            n_Recevie.getRecevieDetails().get(i).setAmountTotal(recevie.getRecevieDetails().get(i).getAmountTotal());
            n_Recevie.getRecevieDetails().get(i).setPrice(recevie.getRecevieDetails().get(i).getPrice());
            tongtien += recevie.getRecevieDetails().get(i).getAmountTotal() * recevie.getRecevieDetails().get(i).getPrice();

        }
        n_Recevie.setPriceTotal(tongtien);

        recevieRepository.save(n_Recevie);


    }
}
