package io.pivotal.pal.tracker;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.TimeZone;

@SpringBootApplication
public class PalTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    /*@Bean
    public TimeEntryRepository getTimeEntryRepository(){
        final TimeEntryRepository inMemoryTimeEntryRepository = new InMemoryTimeEntryRepository();
        return inMemoryTimeEntryRepository;
    }*/
   /* @Bean
    public TimeEntryRepository getTimeEntryRepository(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("TRUNCATE time_entries");

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        final JdbcTimeEntryRepository jdbcTimeEntryRepository = new JdbcTimeEntryRepository(dataSource);
        return jdbcTimeEntryRepository;
    }*/
    @Bean
    TimeEntryRepository timeEntryRepository(DataSource dataSource) {
        return new JdbcTimeEntryRepository(dataSource);
    }
}
