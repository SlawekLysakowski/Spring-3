package pl.edu.wszib.http2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.http2.service.VocabService;
import pl.edu.wszib.http2.service.exception.NotFoundException;
import pl.edu.wszib.http2.service.model.Filtr;
import pl.edu.wszib.http2.service.model.Produkt;
import pl.edu.wszib.http2.service.model.Vocab;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/vocab")
public class VocabController {

  @Autowired
  private VocabService vocabService;

  @GetMapping
  public String defaultView() {
    return "redirect:/vocab/list";
  }

  @GetMapping("/get")
  public String getVocabView(@RequestParam Integer id, Model model) {
    model.addAttribute("vocab",vocabService.get(id));
    return "get-vocab";
  }

    @GetMapping("/list")
    public String list( Model model) {
      model.addAttribute("vocabs", vocabService.list());  //przekaz list
      return "list-vocab"; //nazwa widoku
  }


  @GetMapping("/create")
  public String createVocabView(Model model) {
    model.addAttribute("newVocab", new Vocab());
    return "create-vocab";
  }

    @PostMapping("/create")
    public String createVocabAction(Vocab vocab, Model model) {
      vocab =  vocabService.create(vocab);
      return "redirect:/vocab/list?id=";
  }


    @GetMapping("/update")
    public String updateVocab(@RequestParam Integer id, Vocab updateVocab, Model model) {
        model.addAttribute("updateVocab", vocabService.get(id));
        return "update-vocab";
    }


  @PostMapping("/update")
  public String updateVocabAction( Vocab vocab, Model model) {
    vocabService.update(vocab);
    return "redirect:/vocab/list";
  }



    @GetMapping("/delete")
    public String deleteVocab(@RequestParam Integer id, Model model) {
        model.addAttribute("vocab", vocabService.get(id));
        return "delete-vocab";
    }
  @PostMapping("/delete")
  public String deleteVocabView(Vocab vocab, Model model) {
    vocabService.delete(vocab.getId());
    return "redirect:/vocab/list";
  }


  @ExceptionHandler(NotFoundException.class)
  public String notFoundView() {
    return "404-vocab";
  }
}
