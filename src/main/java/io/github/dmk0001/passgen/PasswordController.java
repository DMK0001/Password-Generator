package io.github.dmk0001.passgen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordController {

    @GetMapping("/")
    public String showForm(){
        return "form";
    }

    @PostMapping("/generate")
    public String generatePassword(
            @RequestParam() int length,
            @RequestParam LetterType letterType,
            @RequestParam(required = false, defaultValue = "false") boolean numbers,
            @RequestParam(required = false, defaultValue = "false") boolean specialCharacters,
            Model model){
        try {
            PasswordGenerator passwordGenerator = new PasswordGenerator(length, letterType, numbers, specialCharacters);
            String password = passwordGenerator.generate();
            model.addAttribute("password", password);
            model.addAttribute("length", length);
            model.addAttribute("letterType", letterType.toString());
            model.addAttribute("numbers", numbers);
            model.addAttribute("specialCharacters", specialCharacters);
        }
        catch (PasswordException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "form";
    }
}