package org.bullbet.repository;
import org.bullbet.entity.Team;
import org.bullbet.entity.TransferHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferHistoryRepository extends CrudRepository<TransferHistory, Long> {

}
