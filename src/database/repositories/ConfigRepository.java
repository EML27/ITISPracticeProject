package database.repositories;

import database.IConfigSetDB;
import database.IProgramDB;

import java.util.List;

/**
 * Interface's extension for configs
 */
public interface ConfigRepository extends CrudRepository<IProgramDB, IConfigSetDB> {
    List<IProgramDB> findAllPrograms();

    Integer getProgramId(IProgramDB programDB);
}