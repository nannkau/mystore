package com.team.mystore.controller;

import com.team.mystore.Command.ProductCommand;
import com.team.mystore.entity.Product;
import com.team.mystore.service.CategoryService;
import com.team.mystore.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class ProductController {

    @Value("${upload.path}")
    private String outdir;

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @RequestMapping(value = "/product/index.html")
    public String index(Model model){
        model.addAttribute("products",productService.findAll());
        return "product/index";
    }

    @RequestMapping(value = "product/add.html")
    public String add(Model model){
        ProductCommand command= new ProductCommand();
        model.addAttribute("categorys",categoryService.findByStatus("1"));
        model.addAttribute("items",command);
        return "product/add";
    }
    @RequestMapping(value = "product/add.html",method = RequestMethod.POST)
    public String add(ProductCommand command, Model model, BindingResult result,HttpServletRequest request) throws IOException {
        if (result.hasErrors()) {
            return "product/add";
        }
        Product product= new Product();
        product=command.getPojo();
        String path = request.getServletContext().getRealPath("/upload/");
        product.setImage(upload(command.getPart(),request,path));
        productService.save(command.getPojo());
        return "redirect:/product/index.html";
    }
    @RequestMapping(value = "/product/edit/{id}")
    public String edit(Model model,@PathVariable("id") Integer id){
        ProductCommand command= new ProductCommand();
        command.setPojo(productService.findById(id));
        model.addAttribute("items",command);
        return "product/edit";
    }

    private static String upload( MultipartFile part,HttpServletRequest request,String path) throws IOException {
        System.out.println("uploadRootPath=" + path);

        File uploadRootDir = new File(path);
        // Tạo thư mục gốc upload nếu nó không tồn tại.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        String fileName = part.getOriginalFilename().replaceAll("\\s", "_");
        File file= new File(path +"/"+ fileName);
        try(InputStream is = part.getInputStream()){
            try(OutputStream os = new FileOutputStream(file)){
                int len = 0;
                byte[] bytes = new byte[1024];
                while ( ( len = is.read(bytes, 0, 1024)) > 0) {
                    os.write(bytes, 0, len);
                }
            }
        }
        return fileName;
    }

}
