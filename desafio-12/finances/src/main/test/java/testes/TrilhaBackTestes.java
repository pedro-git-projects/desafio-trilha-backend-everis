package testes;

import br.com.finances.entity.Entry;
import br.com.finances.repository.EntryRepository;
import br.com.finances.service.EntryService;
import br.com.finances.service.exception.handler.NoContentException;
import br.com.finances.service.exception.handler.NullEntryException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class TrilhaBackTestes {

    @InjectMocks
    private EntryService entryService;

    @Mock
    private EntryRepository entryRepository;

    @Test
    public void testGetLancamentosRelacionados() throws NullEntryException, NoContentException {
        List<Entry> entries = new ArrayList<>();
        Entry entry = new Entry();
        entry.setDate("14/12/2021");
        entry.setAmount(42.00);
        entry.setPaid(false);
        entryRepository.save(entry);

        Mockito.when(entryRepository.findAll()).thenReturn(entries);
        System.out.println(entries);
        System.out.println(entryService.findAll());
        System.out.println(entryService.getListDTO());
        // Assertions.assertFalse(entryService.getListDTO().isEmpty());
        // Assertions.assertEquals(1, entryService.getLancamentosDependentes("14/12/2021", 42.00,false).size());
    }
}
