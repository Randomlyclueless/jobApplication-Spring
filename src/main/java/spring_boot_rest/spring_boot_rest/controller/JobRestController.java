package spring_boot_rest.spring_boot_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import spring_boot_rest.spring_boot_rest.model.JobPost;
import spring_boot_rest.spring_boot_rest.model.User;
import spring_boot_rest.spring_boot_rest.service.JobService;
import spring_boot_rest.spring_boot_rest.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @Autowired
    private UserService userService;


    // ================= USER =================

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.saveUser(user);
    }


    // ================= JOBS =================

    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }


    @GetMapping("/jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }


    @PostMapping("/jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {

        service.addJob(jobPost);

        return service.getJob(jobPost.getPostId());
    }


    @GetMapping("/jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(
            @PathVariable("keyword") String keyword) {

        return service.search(keyword);
    }


    @PutMapping("/jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {

        service.updateJob(jobPost);

        return service.getJob(jobPost.getPostId());
    }


    @DeleteMapping("/jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId) {

        service.deleteJob(postId);

        return "Deleted";
    }


    @GetMapping("/load")
    public String loadData() {

        service.load();

        return "success";
    }
}