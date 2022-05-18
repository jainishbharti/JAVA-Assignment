package com.assignment.multipledatabases.controller;

import com.assignment.multipledatabases.entity.tenant1.Book;
import com.assignment.multipledatabases.service.book.BookServiceImpl;
import com.assignment.multipledatabases.service.book.BookServiceImpl2;
import com.assignment.multipledatabases.service.user.UserServiceImpl;
import com.assignment.multipledatabases.service.user.UserServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/database/{tenant_id}")
public class MyController {
    private BookServiceImpl service;
    private BookServiceImpl2 service2;

    private UserServiceImpl userService;
    private UserServiceImpl2 userService2;


    @Autowired
    public MyController(BookServiceImpl service, UserServiceImpl userService, BookServiceImpl2 service2,UserServiceImpl2 userService2 ){
        this.service = service;
        this.userService = userService;
        this.service2 = service2;
        this.userService2 = userService2;
    }

    public MyController() {
    }

    @PostMapping("/addBook")
    public String addBook(@PathVariable("tenant_id") Integer tenant_id, @ModelAttribute("book") Book book){
        if(tenant_id == 1){
            service.saveBook(book);
        } else {
            service2.saveBook(new com.assignment.multipledatabases.entity.tenant2.Book(book.getBookId(), book.getBookName(), book.getAuthor(), book.getGenre()));
        }
        return "redirect:books";

    }

    @GetMapping("/addBookForm")
    public String addBookForm(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "bookForm";
    }

    @GetMapping("/bookUpdateForm/{id}")
    public String updateBook(Model model, @PathVariable("id") Integer id, @PathVariable("tenant_id") Integer tenant_id){
        if(tenant_id == 1){
            model.addAttribute("book", service.getBookById(id));
        } else {
            model.addAttribute("book", service2.getBookById(id));
        }
        return "updateBook";
    }

    @PostMapping("/bookUpdateForm/update")
    public String updateBook(@ModelAttribute("book") Book book, @PathVariable("tenant_id") Integer tenant_id){
        if(tenant_id == 1){
            service.saveBook(book);
        } else {
            service2.saveBook(new com.assignment.multipledatabases.entity.tenant2.Book(book.getBookId(), book.getBookName(), book.getAuthor(), book.getGenre()));
        }
        return "redirect:/database/"+tenant_id+"/books";
    }

    @GetMapping("/users")
    public @ResponseBody List<? extends Object> getUsers(@PathVariable("tenant_id") Integer tenant_id){
        if(tenant_id == 1){
            return userService.getAllUsers();
        }
        return userService2.getAllUsers();
    }

    @GetMapping("/books")
    public String getBooks(@PathVariable("tenant_id") Integer tenant_id , Model model){
        if(tenant_id == 1){
            model.addAttribute("books", service.getAllBooks());
            return "homePage";
        }
        model.addAttribute("books", service2.getAllBooks());
        return "homePage";
    }

    @GetMapping("/book/{id}")
    public @ResponseBody Object getBookById(@PathVariable("id") Integer id, @PathVariable("tenant_id") Integer tenant_id){
        if(tenant_id == 1){
            return service.getBookById(id);
        }
        return service2.getBookById(id);
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id, @PathVariable("tenant_id") Integer tenant_id){
        if(tenant_id == 1){
            service.deleteBookById(id);
        } else {
            service2.deleteBookById(id);
        }
        return "redirect:/database/"+tenant_id+"/books";
    }

}
