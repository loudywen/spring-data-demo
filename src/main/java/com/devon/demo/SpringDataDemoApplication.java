package com.devon.demo;

import com.devon.demo.properties.ArmoryAuditQueryProperty;
import com.devon.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.HashMap;

@SpringBootApplication
@EnableCassandraRepositories(basePackages = {"com.devon.demo.model"})
public class SpringDataDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemoApplication.class, args);
    }

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CassandraOperations cassandraOperations;

    @Override
    public void run(String... args) throws Exception {
//
//       for(int x = 0; x<10; x++){
//           Random rand = new Random();
//           int randomNum = rand.nextInt((100 - 1) + 1) + 1;
//           Users users = new Users("firstName"+x,"lastName"+x,randomNum);
//           usersRepository.save(users);
//       }

        String cqlStr = "SELECT * From devon_test.armory_audit WHERE system_id=1 AND environment_code=1 " +
                "AND event_date='2017-05-03' AND country_code='UK' AND event_id=11 AND instance_id=1";


        ArmoryAuditQueryProperty armoryAuditQueryProperty = new ArmoryAuditQueryProperty(new HashMap<>());

//        List<ArmoryAudit> list = cassandraOperations.select(cqlStr, ArmoryAudit.class);
//
//        list.forEach( armoryAudit -> System.out.println("==== "+armoryAudit.toString()));

//        Iterable<Users> usersList = usersRepository.findAll();
//        usersList.forEach(user -> System.out.println(user.toString()));
//        SearchCriteria searchCriteria = new SearchCriteria("id", "a80318b3-1bf3-4b47-ae44-a57c0a63b102", "=");
//        UsersSpecification usersSpecification = new UsersSpecification(searchCriteria);
        //List<Users> list = usersRepository.findAll(usersSpecification);

//        Stream<Users> stream = usersRepository.findAllById(UUID.fromString("a80318b3-1bf3-4b47-ae44-a57c0a63b102"));
//        Stream<Users> stream = usersRepository.findAllById(UUID.fromString("a80318b3-1bf3-4b47-ae44-a57c0a63b102"));
//
//        Iterable<Users> stream2 = usersRepository.findAll();
//
//        stream.forEach(user -> System.out.println("==== " + user.toString()));
//        stream2.forEach(user -> System.out.println("?? " + user.toString()));
    }
}