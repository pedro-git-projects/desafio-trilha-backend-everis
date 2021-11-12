package br.com.financas.controller;

import br.com.financas.service.CategoryService;
import br.com.financas.service.EntryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/chart")
public class ChartController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private EntryService entryService;

    @Autowired
    private ModelMapper modelMapper;


}
