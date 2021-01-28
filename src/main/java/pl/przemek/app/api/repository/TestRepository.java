package pl.przemek.app.api.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.przemek.app.api.model.TestModel;

@EnableScan
public interface TestRepository extends JpaRepository<TestModel, Long> {
}
