package com.blibli.learnspringboot.helper;

import com.blibli.learnspringboot.model.Book;
import com.blibli.learnspringboot.model.Staff;
import com.blibli.learnspringboot.repository.BookRepository;
import com.blibli.learnspringboot.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DatabaseSeeder {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private BookRepository bookRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedStaffTable();
        seedBookTable();
    }

    private void seedStaffTable () {
        staffRepository.save(new Staff("Goldwin Japar", "goldwin.japar@gdn-commerce.com", new Date("1998/02/15"), "Male", 20));
        staffRepository.save(new Staff("Luciana Dian Santami", "luciana.santami@gdn-commerce.com", new Date("1997/04/17"), "Femnale", 21));
        staffRepository.save(new Staff("Misita Pontiasa", "misita.pontiasa@gdn-commerce.com", new Date("1996/01/01"), "Female", 22));
        staffRepository.save(new Staff("Herry Gunawan", "herry.gunawan@gdn-commerce.com", new Date("1998/03/15"), "Male", 20));
    }

    public void seedBookTable () {
        bookRepository.save(new Book("Spring Boot in Action", "Goldwin J. Anjay", "Education and Programming", 99.3));
        bookRepository.save(new Book("Laravel 5.5 Documentation", "Taylor Japar", "Programming", 24.1));
        bookRepository.save(new Book("Chicken Soup for My Self", "Goldwin Golden Ways", "Motivation and Lifestyle", 12.12));
        bookRepository.save(new Book("Dummy Book", "Blibli.com", "E-Commerce", 3.0));
        bookRepository.save(new Book("How to Listen to Your Heart", "Anjay Maliyk", "Love Book", 992.3));
        bookRepository.save(new Book("Medok Language", "Burung dan Ayam", "Language Book", 2.2));
    }
}
