package com.gongdel.chpater1.repository;

import com.gongdel.domain.Reader;
import com.gongdel.repository.ReaderRepository;
import com.gongdel.repository.ReadingListRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReaderRepositoryTest {

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    ReadingListRepository readingListRepository;

    @Test
    public void readerTest() {
        String username="craig";
       Reader reader = readerRepository.getOne(username);
        assertThat(reader.getUsername(), is("craig"));
    }
}
