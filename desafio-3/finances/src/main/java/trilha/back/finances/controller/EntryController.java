package trilha.back.finances.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import trilha.back.finances.models.Entry;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/entry")
@Api(tags = "Entries")
public class EntryController {

    //List<Entry>

    @ApiOperation(value = "Post entry")
    @PostMapping
    public Entry postEntry(@RequestBody Entry entryBody) {
        return entryBody;
    }

    @ApiOperation(value = "Get entry")
    @GetMapping
    public List getEntry() {
        List<Entry> entryList = new ArrayList<>();
        entryList.add(new Entry(123456, 1337, "Notebook", "Notebook da firma", "Eletrônicos", "1", "2021/10/27", true));
        entryList.add(new Entry(234567, 4521, "Exame Demissional", "Exame para demissão da empresa", "Exame", "3", "2020/10/26", false));

       Collections.sort(entryList, (entry1, entry2) -> {
            String entry1StringDate = entry1.getDate();
            String entry2StringDate = entry2.getDate();
            String[] entry1SplitDate = entry1StringDate.split("/");
            String[] entry2SplitDate = entry2StringDate.split("/");
            LocalDate entry1LocalDate = LocalDate.of((Integer.parseInt(entry1SplitDate[0])), Integer.parseInt(entry1SplitDate[1]), Integer.parseInt(entry1SplitDate[2] ));
            LocalDate entry2LocalDate = LocalDate.of((Integer.parseInt(entry2SplitDate[0])), Integer.parseInt(entry2SplitDate[1]), Integer.parseInt(entry2SplitDate[2] ));
            if (entry1LocalDate.isBefore(entry2LocalDate)) {
                return -1;
            } if (entry2LocalDate.isBefore(entry1LocalDate)) {
                return 1;
            } else {
                return 0;
            }
        });

        return  entryList;

    }
}

